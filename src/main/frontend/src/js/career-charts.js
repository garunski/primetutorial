/**
 * Career Charts - Chart.js implementation for CareerZone
 * This file contains the code for creating and managing radar charts for skills and knowledge areas
 */

// Initialize charts when the DOM is fully loaded
document.addEventListener('DOMContentLoaded', function() {
  try {
    console.log("Career Charts: Initializing charts (updated version)");

    // Debug DOM elements
    const skillsRadarChartCanvas = document.getElementById('skills-radar-chart');
    console.log("Skills radar chart canvas found:", !!skillsRadarChartCanvas);

    const skillsDataElement = document.getElementById('skills-data');
    console.log("Skills data element found:", !!skillsDataElement);

    const knowledgeRadarChartCanvas = document.getElementById('knowledge-radar-chart');
    console.log("Knowledge radar chart canvas found:", !!knowledgeRadarChartCanvas);

    const knowledgeDataElement = document.getElementById('knowledge-data');
    console.log("Knowledge data element found:", !!knowledgeDataElement);

    const workContextBarChartCanvas = document.getElementById('work-context-bar-chart');
    console.log("Work context bar chart canvas found:", !!workContextBarChartCanvas);

    const workContextDataElement = document.getElementById('work-context-data');
    console.log("Work context data element found:", !!workContextDataElement);

    const workStylesBarChartCanvas = document.getElementById('work-styles-bar-chart');
    console.log("Work styles bar chart canvas found:", !!workStylesBarChartCanvas);

    const workStylesDataElement = document.getElementById('work-styles-data');
    console.log("Work styles data element found:", !!workStylesDataElement);

    // Initialize charts
    initializeSkillsRadarChart();
    initializeKnowledgeRadarChart();
    initializeWorkContextBarChart();
    initializeWorkStylesBarChart();

    console.log("Career Charts: Charts initialized successfully");
  } catch (error) {
    console.error("Career Charts: Error initializing charts:", error);
  }
});

/**
 * Initialize the skills radar chart
 */
function initializeSkillsRadarChart() {
  try {
    // Get the radar chart canvas element
    const radarChartCanvas = document.getElementById('skills-radar-chart');
    if (!radarChartCanvas) {
      console.warn("Career Charts: Skills radar chart canvas not found");
      return;
    }

    // Get and parse the chart configuration
    const skillsDataElement = document.getElementById('skills-data');
    if (!skillsDataElement) {
      console.warn("Career Charts: Skills data element not found");
      return;
    }

    let chartConfig;
    try {
      const data = JSON.parse(skillsDataElement.textContent);
      if (!data.chartConfig || !data.chartConfig.datasets || !Array.isArray(data.chartConfig.datasets)) {
        console.error("Career Charts: Invalid chart configuration format");
        return;
      }
      chartConfig = data.chartConfig;
    } catch (error) {
      console.error("Career Charts: Error parsing chart configuration:", error);
      return;
    }

    // Create the radar chart with the provided configuration
    new Chart(radarChartCanvas, {
      type: 'radar',
      data: {
        labels: chartConfig.labels,
        datasets: chartConfig.datasets.map(dataset => ({
          ...dataset,
          data: dataset.normalizedData, // Use pre-normalized data
          originalData: dataset.data // Keep original data for tooltips
        }))
      },
      options: {
        ...chartConfig.options,
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: {
            position: 'bottom'
          },
          tooltip: {
            callbacks: {
              label: function(context) {
                const dataset = context.dataset;
                const index = context.dataIndex;
                const originalValue = dataset.originalData[index];
                const maxValue = dataset.maxValue;
                return `${dataset.label}: ${originalValue}`;
              }
            }
          }
        }
      }
    });

  } catch (error) {
    console.error("Career Charts: Error initializing skills radar chart:", error);
  }
}

/**
 * Initialize the knowledge radar chart
 */
function initializeKnowledgeRadarChart() {
  try {
    // Get the radar chart canvas element
    const radarChartCanvas = document.getElementById('knowledge-radar-chart');
    if (!radarChartCanvas) {
      console.log("Career Charts: Knowledge radar chart canvas not found on page");
      return;
    }

    // Get and parse the knowledge chart configuration
    const knowledgeDataElement = document.getElementById('knowledge-data');
    if (!knowledgeDataElement) {
      console.log("Career Charts: Knowledge data element not found on page");
      return;
    }

    let chartConfig;
    try {
      const data = JSON.parse(knowledgeDataElement.textContent);
      if (!data.chartConfig || !data.chartConfig.datasets || !Array.isArray(data.chartConfig.datasets)) {
        console.error("Career Charts: Invalid knowledge chart configuration format");
        return;
      }
      chartConfig = data.chartConfig;
      console.log(`Career Charts: Found knowledge chart configuration with ${chartConfig.labels.length} knowledge areas`);
    } catch (error) {
      console.error("Career Charts: Error parsing knowledge chart configuration:", error);
      return;
    }

    // Create the radar chart with the provided configuration
    new Chart(radarChartCanvas, {
      type: 'radar',
      data: {
        labels: chartConfig.labels,
        datasets: chartConfig.datasets.map(dataset => ({
          ...dataset,
          data: dataset.normalizedData, // Use pre-normalized data
          originalData: dataset.data // Keep original data for tooltips
        }))
      },
      options: {
        ...chartConfig.options,
        responsive: true,
        maintainAspectRatio: false,
        scales: {
          r: {
            min: 0,
            max: 1, // Normalized scale from 0 to 1
            ticks: {
              stepSize: 0.2,
              display: false // Hide tick labels as per original config
            },
            pointLabels: {
              font: {
                size: 12,
                weight: 'bold'
              }
            }
          }
        },
        plugins: {
          legend: {
            position: 'bottom'
          },
          tooltip: {
            callbacks: {
              label: function(context) {
                // Use the original values for tooltips
                const dataset = context.dataset;
                const index = context.dataIndex;
                const originalValue = dataset.originalData[index];
                return `${dataset.label}: ${originalValue}`;
              }
            }
          }
        }
      }
    });

    console.log("Career Charts: Created knowledge radar chart successfully");
  } catch (error) {
    console.error("Career Charts: Error initializing knowledge radar chart:", error);
  }
}

/**
 * Initialize the work context bar chart
 */
function initializeWorkContextBarChart() {
  try {
    // Get the bar chart canvas element
    const barChartCanvas = document.getElementById('work-context-bar-chart');
    if (!barChartCanvas) {
      console.log("Career Charts: Work context bar chart canvas not found on page");
      return;
    }

    // Get and parse the work context chart configuration
    const workContextDataElement = document.getElementById('work-context-data');
    if (!workContextDataElement) {
      console.log("Career Charts: Work context data element not found on page");
      return;
    }

    let chartConfig;
    try {
      const data = JSON.parse(workContextDataElement.textContent);
      if (!data.chartConfig || !data.chartConfig.datasets || !Array.isArray(data.chartConfig.datasets)) {
        console.error("Career Charts: Invalid work context chart configuration format");
        return;
      }
      chartConfig = data.chartConfig;
      console.log(`Career Charts: Found work context chart configuration with ${chartConfig.labels.length} work context factors`);
    } catch (error) {
      console.error("Career Charts: Error parsing work context chart configuration:", error);
      return;
    }

    // Process chart configuration and convert function strings to actual functions
    const processedOptions = { ...chartConfig.options };
    if (processedOptions.plugins && processedOptions.plugins.tooltip && processedOptions.plugins.tooltip.callbacks) {
      const callbacks = processedOptions.plugins.tooltip.callbacks;
      Object.keys(callbacks).forEach(key => {
        if (typeof callbacks[key] === 'string' && callbacks[key].startsWith('function')) {
          try {
            callbacks[key] = eval('(' + callbacks[key] + ')');
          } catch (e) {
            console.warn(`Could not convert tooltip callback ${key} to function:`, e);
          }
        }
      });
    }

    // Create the bar chart with the processed configuration
    new Chart(barChartCanvas, {
      type: chartConfig.type,
      data: {
        labels: chartConfig.labels,
        datasets: chartConfig.datasets
      },
      options: processedOptions
    });

    console.log("Career Charts: Created work context bar chart successfully");
  } catch (error) {
    console.error("Career Charts: Error initializing work context bar chart:", error);
  }
}

/**
 * Initialize the work styles bar chart
 */
function initializeWorkStylesBarChart() {
  try {
    // Get the bar chart canvas element
    const barChartCanvas = document.getElementById('work-styles-bar-chart');
    if (!barChartCanvas) {
      console.log("Career Charts: Work styles bar chart canvas not found on page");
      return;
    }

    // Get and parse the work styles chart configuration
    const workStylesDataElement = document.getElementById('work-styles-data');
    if (!workStylesDataElement) {
      console.log("Career Charts: Work styles data element not found on page");
      return;
    }

    let chartConfig;
    try {
      const data = JSON.parse(workStylesDataElement.textContent);
      if (!data.chartConfig || !data.chartConfig.datasets || !Array.isArray(data.chartConfig.datasets)) {
        console.error("Career Charts: Invalid work styles chart configuration format");
        return;
      }
      chartConfig = data.chartConfig;
      console.log(`Career Charts: Found work styles chart configuration with ${chartConfig.labels.length} work style factors`);
    } catch (error) {
      console.error("Career Charts: Error parsing work styles chart configuration:", error);
      return;
    }

    // Process chart configuration and convert function strings to actual functions
    const processedOptions = { ...chartConfig.options };
    if (processedOptions.plugins && processedOptions.plugins.tooltip && processedOptions.plugins.tooltip.callbacks) {
      const callbacks = processedOptions.plugins.tooltip.callbacks;
      Object.keys(callbacks).forEach(key => {
        if (typeof callbacks[key] === 'string' && callbacks[key].startsWith('function')) {
          try {
            callbacks[key] = eval('(' + callbacks[key] + ')');
          } catch (e) {
            console.warn(`Could not convert tooltip callback ${key} to function:`, e);
          }
        }
      });
    }

    // Create the bar chart with the processed configuration
    new Chart(barChartCanvas, {
      type: chartConfig.type,
      data: {
        labels: chartConfig.labels,
        datasets: chartConfig.datasets
      },
      options: processedOptions
    });

    console.log("Career Charts: Created work styles bar chart successfully");
  } catch (error) {
    console.error("Career Charts: Error initializing work styles bar chart:", error);
  }
}

/**
 * Initialize polar charts for knowledge areas (legacy function - deprecated)
 * This function is kept for backward compatibility but is no longer used
 */
function initializeKnowledgeCharts() {
  console.warn("Career Charts: initializeKnowledgeCharts is deprecated. Using dynamic JSON-based approach instead.");
}
