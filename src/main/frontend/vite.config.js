import { defineConfig } from 'vite';
import path from 'path';
import { sync as glob } from 'glob';
import fs from 'fs';

// Custom plugin to copy vendor files without processing them
const copyVendorFiles = () => ({
  name: 'copy-vendor-files',
  generateBundle() {
    // Create the vendor directory if it doesn't exist
    const vendorDir = '../webapp/resources/js/vendor';
    fs.mkdirSync(vendorDir, { recursive: true });

    // Copy Foundation and its dependencies
    const vendorFiles = [
      ['jquery/dist/jquery.min.js', 'jquery.min.js'],
      ['what-input/dist/what-input.min.js', 'what-input.min.js'],
      ['foundation-sites/dist/js/foundation.min.js', 'foundation.min.js']
    ];

    // Copy each file
    vendorFiles.forEach(([src, dest]) => {
      const srcPath = `node_modules/${src}`;
      const destPath = `${vendorDir}/${dest}`;
      fs.writeFileSync(destPath, fs.readFileSync(srcPath));
      console.log(`Copied ${srcPath} to ${destPath}`);
    });
  }
});

// Find all SCSS files in the styles directory and create input entries, excluding partials (files starting with _)
const scssEntries = glob('./src/styles/**/*.scss')
  .filter(file => !path.basename(file).startsWith('_'))
  .reduce((entries, file) => {
    // Get the relative path from the styles directory without extension
    const name = path.relative('./src/styles', file).replace('.scss', '');
    entries[name] = path.resolve(__dirname, file);
    return entries;
  }, {});

export default defineConfig({
  // Base public path when served in production
  base: '/resources/',

  // Add our custom plugin to copy vendor files
  plugins: [
    copyVendorFiles()
  ],

  // CSS configuration
  css: {
    devSourcemap: true,
    preprocessorOptions: {
      scss: {
        // Add node_modules to the import paths
        loadPaths: [
          path.resolve(__dirname, 'node_modules/foundation-sites/scss'),
          path.resolve(__dirname, 'node_modules/bootstrap/scss')
        ],
        // Completely suppress all Sass warnings
        quietDeps: true,
        silent: true,
        logger: { warn: () => {} }
      }
    }
  },

  // Build configuration
  build: {
    // Output directory (relative to project root)
    outDir: '../webapp/resources',

    // Don't empty the outDir on build to avoid permission issues
    emptyOutDir: false,

    // Don't generate manifest.json since we're using fixed filenames
    manifest: false,

    // Configure rollup options
    rollupOptions: {
      input: {
        // Regular JS/HTML entries
        main: path.resolve(__dirname, 'index.html'),

        // Add all SCSS files as entries
        ...scssEntries
      },
      output: {
        // Use fixed filenames without hashes for predictable paths
        entryFileNames: 'js/[name].js',
        chunkFileNames: 'js/[name].js',
        assetFileNames: (info) => {
          // For CSS files from SCSS entries, preserve the nested structure
          if (info.fileName?.endsWith('.css')) {
            const originalFileName = (info.originalFileNames || [])[0];

            // If this is from a nested SCSS file in the styles directory
            if (originalFileName?.includes('/styles/')) {
              const parts = originalFileName.split('/styles/');
              if (parts.length > 1 && parts[1].includes('/')) {
                return `assets/${parts[1].replace('.scss', '')}.css`;
              }
            }

            // For non-nested files or fallback
            return `assets/${path.basename(info.fileName, '.css')}.css`;
          }

          // For other assets
          return 'assets/[name].[ext]';
        }
      }
    }
  },

  // Server configuration for development
  server: {
    // Configure proxy for API requests during development
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
      }
    }
  }
});
