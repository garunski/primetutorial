# Frontend Asset Build System

This directory contains the frontend asset build system for the CareerZone application, built with **Vite** and configured to work with a Java web application using JSF/PrimeFaces.

## Overview

The build system is designed to:
- Compile SCSS files to CSS with nested directory structure preservation
- Bundle JavaScript modules
- Copy vendor libraries (jQuery, Foundation, Chart.js)
- Handle image assets with nested folder structure
- Output assets to the Java webapp's resources directory for deployment

## Project Structure

```
src/main/frontend/
├── src/
│   ├── js/                    # JavaScript source files
│   │   ├── components/        # Reusable JS components
│   │   ├── favorites.js       # Favorites functionality
│   │   ├── careerDetails.js   # Career details page logic
│   │   └── searchFilters.js   # Search and filter functionality
│   ├── styles/                # SCSS source files
│   │   ├── _variables.scss    # Shared SCSS variables
│   │   ├── bootstrap-custom.scss  # Custom Bootstrap styles
│   │   └── occupations/       # Page-specific styles
│   │       ├── details.scss   # Career details page styles
│   │       └── search.scss    # Search page styles
│   └── images/                # Image assets (if any)
├── public/                    # Static assets
├── node_modules/              # NPM dependencies
├── package.json               # NPM configuration
├── vite.config.js            # Vite build configuration
└── README.md                 # This file
```

## Build Output Structure

Assets are built to `../webapp/resources/` with the following structure:

```
webapp/resources/
├── js/
│   ├── vendor/               # Third-party libraries
│   │   ├── jquery.min.js
│   │   ├── what-input.min.js
│   │   ├── foundation.min.js
│   │   └── chart.umd.js
│   ├── favorites.js          # Compiled JS files
│   ├── careerDetails.js
│   └── searchFilters.js
├── assets/
│   ├── bootstrap-custom.css  # Compiled CSS files
│   ├── details.css          # Page-specific styles
│   ├── search.css
│   └── images/              # Image assets (preserved structure)
└── css/                     # Legacy CSS files (if any)
```

## Key Features

### 1. Multi-Entry Point Build
- **SCSS Files**: Automatically discovers all `.scss` files in `src/styles/` (excluding partials starting with `_`)
- **JavaScript Files**: Automatically discovers all `.js` files in `src/js/`
- **Nested Structure**: Preserves directory structure in output paths

### 2. Vendor Library Management
The build system automatically copies essential vendor libraries:
- **jQuery** (3.7.1) - DOM manipulation
- **Foundation Sites** (6.9.0) - CSS framework
- **What Input** - Accessibility enhancement
- **Chart.js** (4.4.9) - Data visualization

### 3. SCSS Processing
- **Foundation Integration**: Includes Foundation SCSS paths for imports
- **Bootstrap Integration**: Includes Bootstrap SCSS paths for custom theming
- **Variable Support**: Shared variables in `_variables.scss`
- **Nested Output**: Preserves folder structure in compiled CSS paths

### 4. Image Asset Handling
- **Nested Structure**: Recursively copies images maintaining folder hierarchy
- **CSS Alias**: `@images` alias in SCSS files resolves to `/resources/assets/images/`
- **Automatic Copying**: Images are copied during build process

### 5. Development Features
- **Source Maps**: Enabled for CSS debugging
- **Watch Mode**: Continuous rebuilding with `npm run watch`
- **Proxy Configuration**: API requests proxied to `localhost:8080` during development

## Available Scripts

```bash
# Development
npm run dev          # Start Vite dev server
npm run watch        # Build and watch for changes

# Production
npm run build        # Build all assets for production
npm run preview      # Preview production build

# Maintenance
npm run clean        # Clean build output directory
```

## Build Configuration Details

### Entry Points
The build system automatically discovers entry points:

**SCSS Files** (from `src/styles/`):
- `bootstrap-custom.scss` → `assets/bootstrap-custom.css`
- `occupations/details.scss` → `assets/occupations/details.css`
- `occupations/search.scss` → `assets/occupations/search.css`

**JavaScript Files** (from `src/js/`):
- `favorites.js` → `js/favorites.js`
- `careerDetails.js` → `js/careerDetails.js`
- `searchFilters.js` → `js/searchFilters.js`

### Output Configuration
- **Base Path**: `/resources/` (matches Java webapp context)
- **Fixed Filenames**: No hashing for predictable paths
- **Nested Structure**: Preserves directory hierarchy
- **No Manifest**: Disabled for simpler integration

### Custom Plugins

#### 1. Vendor File Copy Plugin
Copies essential vendor libraries to `js/vendor/`:
```javascript
const vendorFiles = [
  ['jquery/dist/jquery.min.js', 'jquery.min.js'],
  ['what-input/dist/what-input.min.js', 'what-input.min.js'],
  ['foundation-sites/dist/js/foundation.min.js', 'foundation.min.js'],
  ['chart.js/dist/chart.umd.js', 'chart.umd.js']
];
```

#### 2. Nested Images Plugin
Recursively copies images maintaining folder structure:
- Source: `src/images/`
- Destination: `assets/images/`
- Preserves nested directories

#### 3. Image Alias Plugin
Transforms `@images` aliases in CSS:
```scss
// In SCSS files
background-image: url('@images/icons/arrow.svg');

// Compiled to
background-image: url('/resources/assets/images/icons/arrow.svg');
```

## Integration with Java Webapp

### Template Integration
The Java webapp template (`template.xhtml`) references built assets:

```xml
<!-- Vendor JS -->
<script src="#{request.contextPath}/resources/js/vendor/jquery.min.js"></script>
<script src="#{request.contextPath}/resources/js/vendor/foundation.min.js"></script>

<!-- Custom CSS -->
<link rel="stylesheet" href="#{request.contextPath}/resources/assets/bootstrap-custom.css" />
```

### Build Process Integration
The build system integrates with the Maven build process:
- Assets are built to `src/main/webapp/resources/`
- Included in WAR file during Maven packaging
- Available at runtime via `/resources/` context path

## Development Workflow

1. **Setup**: Run `npm install` to install dependencies
2. **Development**: Use `npm run watch` for continuous building
3. **Testing**: Use `npm run dev` for development server with hot reload
4. **Production**: Use `npm run build` before deploying

## Dependencies

### Core Build Tools
- **Vite** (6.3.5) - Build tool and dev server
- **Sass** (1.87.0) - SCSS compilation
- **Glob** (11.0.2) - File pattern matching

### UI Frameworks
- **Foundation Sites** (6.9.0) - Primary CSS framework
- **Bootstrap** (5.3.3) - Secondary CSS framework for components
- **Bootstrap Icons** (1.13.1) - Icon library

### JavaScript Libraries
- **jQuery** (3.7.1) - DOM manipulation
- **Chart.js** (4.4.9) - Data visualization
- **Font Awesome** (4.7.0) - Icon library

## Troubleshooting

### Common Issues

1. **Permission Errors**: The build system uses `emptyOutDir: false` to avoid permission issues
2. **Missing Images**: Ensure images are in `src/images/` directory
3. **SCSS Import Errors**: Check that Foundation/Bootstrap paths are correctly configured
4. **Vendor Files Missing**: Verify all vendor libraries are installed via npm

### Build Output Issues
- Check that output directory `../webapp/resources/` exists and is writable
- Verify that all entry points are being discovered correctly
- Ensure no file naming conflicts in output paths

## Tutorial: Adding New Assets

This section explains the process of adding new SCSS and JavaScript files to the build system.

### Adding a New SCSS File

To add a new SCSS file, you'll need to create it in the appropriate directory under `src/styles/`. The build system automatically discovers all SCSS files in this directory (excluding partial files that start with an underscore).

For organization, consider placing your files in subdirectories:
- `src/styles/components/` for reusable component styles
- `src/styles/pages/` for page-specific styles  
- `src/styles/shared/` for utility and shared styles

Once you create your SCSS file, you can import the shared variables from `_variables.scss` and write your styles using the existing Foundation and Bootstrap variables. When you run the build process, your file will be automatically compiled to CSS and placed in the corresponding directory under `webapp/resources/assets/`, preserving the nested folder structure.

### Adding a New JavaScript File

JavaScript files should be created in the `src/js/` directory. Similar to SCSS files, you can organize them in subdirectories like `components/`, `pages/`, or `utils/` for better organization.

The build system will automatically discover your JavaScript file and compile it to the corresponding location under `webapp/resources/js/`. You can write modern ES6 JavaScript with classes and modules, and the build system will handle the compilation and bundling.

### Integrating Assets into JSF Pages

After building your assets, you need to include them in your JSF pages. For individual pages, you can add the compiled CSS and JavaScript files using the `ui:define` sections in your XHTML template.

In the `head` section, you'll reference your compiled CSS file using the path `/resources/assets/` followed by the relative path from the styles directory. In the `page-scripts` section, you'll reference your compiled JavaScript file using the path `/resources/js/` followed by the relative path from the js directory.

For components that will be used across multiple pages, you can add them to the main template file (`template.xhtml`) so they're available globally throughout the application.

### Development Workflow

During development, you can use the watch mode (`npm run watch`) to automatically rebuild your assets whenever you make changes to your source files. This allows you to see your changes immediately without manually running the build command each time.

The build system preserves the directory structure from your source files, so if you create a file at `src/styles/components/userProfile.scss`, it will be compiled to `webapp/resources/assets/components/userProfile.css`. This makes it easy to organize your assets and maintain a clear structure.

### File Naming and Organization

Use consistent naming conventions: kebab-case for SCSS files (like `user-profile.scss`) and camelCase for JavaScript files (like `userProfile.js`). This helps maintain consistency across the codebase and makes it easier for other developers to understand the file structure.

Remember that the build system automatically handles the discovery and compilation of your files, so you don't need to manually configure entry points or worry about build order - just create your files in the appropriate directories and the system will take care of the rest.

## Notes

- The build system is designed for a Java web application context
- Assets are served from `/resources/` path in production
- No asset hashing is used for simpler integration with JSF templates
- The system preserves nested directory structures for organized asset management 