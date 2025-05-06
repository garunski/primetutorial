import { defineConfig } from 'vite';
import { resolve } from 'path';
import * as globModule from 'glob';
import path from 'path';
const glob = globModule.sync;

// Find all SCSS files in the styles directory, excluding partials (files starting with _)
const scssFiles = glob('./src/styles/**/*.scss').filter(file => !file.split('/').pop().startsWith('_'));

// Create input entries for each SCSS file
const scssEntries = {};
scssFiles.forEach(file => {
  // Get the relative path from the styles directory
  const relativePath = path.relative('./src/styles', file);
  // Use the path without extension as the entry name
  const name = relativePath.replace('.scss', '');
  scssEntries[name] = resolve(__dirname, file);
});

// Add vendor JS files as entry points
const vendorEntries = {
  'jquery.min': resolve(__dirname, 'node_modules/jquery/dist/jquery.min.js'),
  'what-input.min': resolve(__dirname, 'node_modules/what-input/dist/what-input.min.js'),
  'foundation.min': resolve(__dirname, 'node_modules/foundation-sites/dist/js/foundation.min.js')
};

export default defineConfig({
  // Base public path when served in production
  base: '/resources/',

  // CSS configuration
  css: {
    devSourcemap: true,
    preprocessorOptions: {
      scss: {
        // Add node_modules to the import paths
        loadPaths: [
          resolve(__dirname, 'node_modules/foundation-sites/scss'),
          resolve(__dirname, 'node_modules/bootstrap/scss')
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
        main: resolve(__dirname, 'index.html'),

        // Add all SCSS files as entries
        ...scssEntries,

        // Add vendor JS files
        ...vendorEntries
      },
      output: {
        // Use fixed filenames without hashes for predictable paths
        entryFileNames: 'js/[name].js',
        chunkFileNames: 'js/[name].js',
        assetFileNames: (info) => {
          // For CSS files from SCSS entries, preserve the nested structure
          if (info.fileName && info.fileName.endsWith('.css')) {
            // Get the original file names (using the non-deprecated property)
            const originalFileNames = info.originalFileNames || [];

            // Check if we have original file names to work with
            if (originalFileNames.length > 0) {
              // Get the first original file name
              const originalFileName = originalFileNames[0];

              // Check if this is from a nested SCSS file
              if (originalFileName && originalFileName.includes('/styles/')) {
                // Extract the path relative to the styles directory
                const relativePath = originalFileName.split('/styles/')[1];
                if (relativePath && relativePath.includes('/')) {
                  // This is a nested file, preserve the structure
                  const pathWithoutExt = relativePath.replace('.scss', '');
                  return `assets/${pathWithoutExt}.css`;
                }
              }
            }

            // For non-nested files or fallback
            const baseName = path.basename(info.fileName, '.css');
            return `assets/${baseName}.css`;
          }

          // For other assets, use the default pattern
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
