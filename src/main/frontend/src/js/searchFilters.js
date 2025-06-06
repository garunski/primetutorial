/**
 * Search Filters JavaScript functionality
 *
 * This file contains the jQuery functions for handling search filters
 * in the occupation search page.
 */

/**
 * Initialize dropdown values from URL parameters on page load
 */
$(document).ready(function() {
    console.log("Search filters initialization started");

    // Get current URL parameters
    var url = new URL(window.location.href);
    var params = new URLSearchParams(url.search);

    // Set education dropdown value if present in URL
    var educationValue = params.get('education');
    if (educationValue) {
        $('#educationSelect').val(educationValue);
        console.log("Set education value:", educationValue);
    }

    // Set sort by dropdown value if present in URL
    var sortValue = params.get('sort');
    if (sortValue) {
        $('#sortBySelect').val(sortValue);
        console.log("Set sort by value:", sortValue);
    }

    // Set salary dropdown value if present in URL
    var salaryValue = params.get('salary');
    if (salaryValue) {
        $('#salarySelect').val(salaryValue);
        console.log("Set salary value:", salaryValue);
    }

    // Set checkbox values if present in URL
    var checkboxParams = [
        'artsHumanities', 'businessInfoSystems', 'engineeringTech', 'healthServices',
        'architectureEngineering', 'computerMathematical', 'healthcarePractitioners', 'lifeSocialScience',
        'brightOutlook', 'greenJobs', 'apprenticeship'
    ];

    $.each(checkboxParams, function(_, param) {
        if (params.get(param) === 'true') {
            $('#' + param).prop('checked', true);
            console.log("Set checkbox:", param);
        }
    });

    // Initialize career path links to use our link builder
    initializeCareerPathLinks();

    console.log("Search filters initialization completed");
});

/**
 * Apply a filter and update the URL
 * @param {string} paramName - The name of the parameter to update
 * @param {string|boolean} paramValue - The value to set
 */
function applyFilter(paramName, paramValue) {
    // Get current URL and parameters
    var url = new URL(window.location.href);
    var params = new URLSearchParams(url.search);

    // Update or remove the parameter based on value
    if (paramValue === "" || paramValue === false) {
        params.delete(paramName);
    } else {
        params.set(paramName, paramValue);
    }

    // Build the new URL
    var newUrl = url.origin + url.pathname;
    var paramString = params.toString();
    if (paramString) {
        newUrl += "?" + paramString;
    }

    // Navigate to the new URL
    window.location.href = newUrl;
}

/**
 * Handle career path links while preserving other filter values
 * @param {Event} event - The click event
 * @param {string} clusterValue - The cluster value
 * @param {string|null} pathwayValue - The pathway value
 */
function handleCareerPathLink(event, clusterValue, pathwayValue) {
    event.preventDefault();

    // Get current URL and parameters
    var url = new URL(window.location.href);
    var params = new URLSearchParams(url.search);

    // Note: We're already preserving all parameters by using the current URL's params

    // Update cluster and pathway parameters
    if (clusterValue) {
        params.set('cluster', clusterValue);

        // If only cluster is clicked (no pathway), clear any existing pathway
        if (!pathwayValue) {
            params.delete('pathway');
        }
    }

    if (pathwayValue) {
        params.set('pathway', pathwayValue);
    }

    // Build the new URL
    var newUrl = url.origin + url.pathname;
    var paramString = params.toString();
    if (paramString) {
        newUrl += "?" + paramString;
    }

    // Navigate to the new URL
    window.location.href = newUrl;
}

/**
 * Initialize event listeners for career path links
 */
function initializeCareerPathLinks() {
    // Add click handlers to cluster links
    $('.career-cluster-link').each(function() {
        $(this).on('click', function(event) {
            var clusterValue = $(this).data('cluster');
            handleCareerPathLink(event, clusterValue, null);
        });
    });

    // Add click handlers to pathway links
    $('.pathway-link').each(function() {
        $(this).on('click', function(event) {
            var href = $(this).attr('href');
            var urlParams = new URLSearchParams(href.split('?')[1]);
            var clusterValue = urlParams.get('cluster');
            var pathwayValue = urlParams.get('pathway');
            handleCareerPathLink(event, clusterValue, pathwayValue);
        });
    });
}

// Explicitly expose functions to the global scope
window.applyFilter = applyFilter;
window.handleCareerPathLink = handleCareerPathLink;
window.initializeCareerPathLinks = initializeCareerPathLinks;