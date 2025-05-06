// This file serves as an entry point for Foundation JS
import $ from 'jquery';
import 'what-input';
import Foundation from 'foundation-sites';

// Make Foundation available globally
window.$ = $;
window.jQuery = $;
window.Foundation = Foundation;

// Initialize Foundation when the DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
  $(document).foundation();
  console.log('Foundation JS initialized');
});
