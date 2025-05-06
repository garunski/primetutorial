import { defineConfig } from 'vite';
import path from 'path';
import { viteStaticCopy } from 'vite-plugin-static-copy';

export default defineConfig({
  // Base public path when served in production
  base: '/resources/',
  
  // Static files that don't need processing
  publicDir: 'public',
  
  // Configure path aliases
  resolve: {
    alias: {
      '@images': path.resolve(__dirname, 'src/images'),
      '@styles': path.resolve(__dirname, 'src/styles')
    }
  },
  
  // Add plugins
  plugins: [
    // Copy vendor files that shouldn't be processed
    viteStaticCopy({
      targets: [
        { 
          src: 'node_modules/jquery/dist/jquery.min.js',
          dest: 'js/vendor' 
        },
        { 
          src: 'node_modules/what-input/dist/what-input.min.js',
          dest: 'js/vendor' 
        },
        { 
          src: 'node_modules/foundation-sites/dist/js/foundation.min.js',
          dest: 'js/vendor' 
        }
      ]
    })
  ],
  
  // CSS configuration
  css: {
    devSourcemap: true,
    preprocessorOptions: {
      scss: {
        // Add node_modules to the import paths
        includePaths: [
          'node_modules/foundation-sites/scss',
          'node_modules/bootstrap/scss'
        ],
        // Suppress warnings
        quietDeps: true
      }
    }
  },
  
  // Build configuration
  build: {
    // Output directory (relative to project root)
    outDir: '../webapp/resources',
    
    // Don't empty the outDir on build
    emptyOutDir: false,
    
    // Configure rollup options
    rollupOptions: {
      input: {
        // Main entry point
        main: path.resolve(__dirname, 'index.html'),
        
        // Add specific style entry points if needed
        // styles: path.resolve(__dirname, 'src/styles/main.scss')
      },
      output: {
        // Use fixed filenames without hashes
        entryFileNames: 'js/[name].js',
        chunkFileNames: 'js/[name].js',
        assetFileNames: (info) => {
          if (info.name.endsWith('.css')) {
            return 'assets/[name].css';
          }
          if (info.name.match(/\.(png|jpe?g|gif|svg|webp)$/)) {
            return 'assets/images/[name].[ext]';
          }
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
