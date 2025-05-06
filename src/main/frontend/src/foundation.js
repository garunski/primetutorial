// Import Foundation JS
import $ from 'jquery';
import 'what-input';
import Foundation from 'foundation-sites';

// Make Foundation available globally
window.$ = $;
window.jQuery = $;
window.Foundation = Foundation;

// Initialize Foundation
document.addEventListener('DOMContentLoaded', () => {
  $(document).foundation();
  console.log('Foundation JS initialized');
});

// Export Foundation for use in other files
export default Foundation;
