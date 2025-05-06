// Import Bootstrap JS components
import * as bootstrap from 'bootstrap';

// Export Bootstrap components for use in other files
export default bootstrap;

// Initialize Bootstrap tooltips
document.addEventListener('DOMContentLoaded', () => {
  // Initialize tooltips
  const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
  tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl);
  });

  // Initialize popovers
  const popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'));
  popoverTriggerList.map(function (popoverTriggerEl) {
    return new bootstrap.Popover(popoverTriggerEl);
  });

  // Initialize toasts
  const toastElList = [].slice.call(document.querySelectorAll('.toast'));
  toastElList.map(function (toastEl) {
    return new bootstrap.Toast(toastEl);
  });

  console.log('Bootstrap JS components initialized');
});
