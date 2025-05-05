import { defineConfig } from 'vite';
import { resolve } from 'path';

export default defineConfig({
  // Base public path when served in production
  base: '/assets/',
  
  // Build configuration
  build: {
    // Output directory (relative to project root)
    outDir: '../webapp/assets',
    
    // Empty the outDir on build
    emptyOutDir: true,
    
    // Generate manifest.json in outDir
    manifest: true,
    
    // Configure rollup options
    rollupOptions: {
      input: {
        main: resolve(__dirname, 'index.html'),
      },
      output: {
        // Ensure assets are placed in the assets directory
        entryFileNames: 'js/[name]-[hash].js',
        chunkFileNames: 'js/[name]-[hash].js',
        assetFileNames: 'css/[name]-[hash].[ext]'
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
