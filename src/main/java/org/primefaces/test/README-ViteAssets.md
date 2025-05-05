# Vite Integration with Fixed Filenames and SASS Support

This document explains how the Vite integration is set up in this project to use fixed filenames for easier inclusion in JSF templates and SASS for styling.

## Overview

The project uses Vite to build frontend assets (JavaScript, CSS, etc.) and outputs them with fixed filenames for easy inclusion in JSF templates. It also includes SASS support for more maintainable styling.

## Configuration

The Vite configuration in `src/main/frontend/vite.config.js` is set up to:

1. Output files to `src/main/webapp/resources/`
2. Use fixed filenames without content hashes:
   - Main JavaScript file: `js/main.js`
   - Main CSS file: `css/main.css`
   - Other assets: `assets/[name].[ext]`

```javascript
export default defineConfig({
  base: '/resources/',
  build: {
    outDir: '../webapp/resources',
    emptyOutDir: true,
    manifest: false,
    rollupOptions: {
      input: {
        main: resolve(__dirname, 'index.html'),
      },
      output: {
        entryFileNames: 'js/main.js',
        chunkFileNames: 'js/[name].js',
        assetFileNames: (assetInfo) => {
          if (assetInfo.name.endsWith('.css')) {
            return 'css/main.css';
          }
          return 'assets/[name].[ext]';
        }
      }
    }
  },
  // ...
});
```

## Usage in Templates

With fixed filenames, you can include the Vite assets in your JSF templates like this:

```xml
<!-- Include Vite-built CSS -->
<link rel="stylesheet" href="#{request.contextPath}/resources/css/main.css" />

<!-- Include Vite-built JavaScript -->
<script type="module" src="#{request.contextPath}/resources/js/main.js"></script>
```

## Development Workflow

1. Run Vite in watch mode: `cd src/main/frontend && npm run watch`
2. Run the Java application: `mvn jetty:run`
3. Or use the combined script: `./dev.sh`

## Considerations

### Pros of Fixed Filenames

- Simple to include in templates
- No need for complex manifest parsing
- Predictable paths

### Cons of Fixed Filenames

- No automatic cache busting
- Browsers might cache old versions of files

### Cache Busting Options

If cache busting becomes necessary, consider:

1. Adding a query parameter with a version or timestamp
2. Implementing a simple filter to add cache-busting parameters
3. Switching back to content hashes with a manifest reader

## SASS Support

The project includes SASS support for more maintainable styling. The SASS files are organized as follows:

```
src/main/frontend/src/styles/
├── main.scss                 # Main entry point for styles
├── components/               # Component-specific styles
│   └── _buttons.scss         # Button styles
├── layout/                   # Layout styles
│   └── _layout.scss          # Layout structure
└── utils/                    # Utilities
    ├── _variables.scss       # Variables (colors, spacing, etc.)
    └── _mixins.scss          # Mixins and functions
```

### Using SASS

1. Import the main SASS file in your JavaScript:

```javascript
import './styles/main.scss'
```

2. Create new SASS files in the appropriate directories
3. Import them in the main.scss file:

```scss
// Import utilities
@import './utils/variables';
@import './utils/mixins';

// Import layout
@import './layout/layout';

// Import components
@import './components/buttons';
// Add your new components here
```

## Multiple Entry Points

If you need multiple entry points, you can add them to the Vite configuration:

```javascript
input: {
  main: resolve(__dirname, 'index.html'),
  admin: resolve(__dirname, 'admin.html'),
  // ...
}
```

And then reference them in your templates:

```xml
<script type="module" src="#{request.contextPath}/assets/js/admin.js"></script>
```
