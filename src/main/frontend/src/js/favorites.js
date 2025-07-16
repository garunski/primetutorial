/**
 * Favorites JavaScript - REST-based add and remove functions
 */

$(document).ready(function() {
    // Add to favorites
    function addFavorite(jobId, $btn) {
        $.ajax({
            url: '/favorites/add/' + jobId,
            type: 'POST',
            contentType: 'application/json',
            success: function(response) {
                if (response.success) {
                    $btn.removeClass('btn-outline-secondary add-favorite-btn')
                        .addClass('btn-outline-danger remove-favorite-btn')
                        .html('<i class="bi bi-heart-fill me-1"></i>Remove');
                } else {
                    console.error('Failed to add favorite:', response.error);
                }
            },
            error: function(xhr, status, error) {
                console.error('Error adding favorite:', error);
            }
        });
    }

    // Remove from favorites
    function removeFavorite(jobId, $btn) {
        $.ajax({
            url: '/favorites/remove/' + jobId,
            type: 'DELETE',
            contentType: 'application/json',
            success: function(response) {
                if (response.success) {
                    $btn.removeClass('btn-outline-danger remove-favorite-btn')
                        .addClass('btn-outline-secondary add-favorite-btn')
                        .html('<i class="bi bi-heart me-1"></i>Save');
                } else {
                    console.error('Failed to remove favorite:', response.error);
                }
            },
            error: function(xhr, status, error) {
                console.error('Error removing favorite:', error);
            }
        });
    }

    // Event delegation for favorite buttons
    $(document).on('click', '.add-favorite-btn', function() {
        var jobId = $(this).data('job-id');
        addFavorite(jobId, $(this));
    });

    $(document).on('click', '.remove-favorite-btn', function() {
        var jobId = $(this).data('job-id');
        removeFavorite(jobId, $(this));
    });
});
