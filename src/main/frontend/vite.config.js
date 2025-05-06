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
        ...scssEntries
      },
      output: {
        // Use fixed filenames without hashes for predictable paths
        entryFileNames: 'js/[name].js',
        chunkFileNames: 'js/[name].js',
        assetFileNames: ({ fileName }) => {
          if (fileName && fileName.endsWith('.css')) {
            // Extract the base name without extension
            const baseName = fileName.split('.')[0];

            // Check if this is from a nested SCSS file
            for (const entryName in scssEntries) {
              if (baseName === entryName) {
                // This is a direct match, use the entry name which includes the path
                return `assets/${entryName}.css`;
              }
            }

            // For non-nested files or fallback
            return `assets/${baseName}.css`;
          }

          // Other assets go to their respective directories
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
