/**
 * Career Programs Pagination Handler
 */
$(document).ready(function() {
    const ITEMS_PER_PAGE = 4;
    const items = $('.program-item');
    const prevBtn = $('#prevBtn');
    const nextBtn = $('#nextBtn');
    const pageInfo = $('#pageInfo');
    
    if (items.length === 0) return;
    
    const totalPages = Math.ceil(items.length / ITEMS_PER_PAGE);
    let currentPage = 1;
    
    const showPage = (page) => {
        const start = (page - 1) * ITEMS_PER_PAGE;
        const end = start + ITEMS_PER_PAGE;
        
        items.hide().slice(start, end).show();
        
        // Update controls
        pageInfo.text(`Page ${page} of ${totalPages}`);
        prevBtn.prop('disabled', page === 1);
        nextBtn.prop('disabled', page === totalPages);
    };
    
    // Initialize
    showPage(currentPage);
    
    // Bind events directly with lambdas
    nextBtn.on('click', () => currentPage < totalPages && showPage(++currentPage));
    prevBtn.on('click', () => currentPage > 1 && showPage(--currentPage));
}); 