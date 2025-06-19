/**
 * Career Charts - Chart.js implementation for CareerZone
 * Handles skills and knowledge radar charts
 */

$(document).ready(function() {
  initializeCharts();
});

/**
 * Initialize all charts that exist on the page
 */
function initializeCharts() {
  try {
    initializeRadarChart('skills-radar-chart', 'skills-data');
    initializeRadarChart('knowledge-radar-chart', 'knowledge-data');
  } catch (error) {
    console.error("Error initializing charts:", error);
  }
}

/**
 * Generic function to initialize a radar chart
 */
function initializeRadarChart(canvasId, dataId) {
  const canvas = $('#' + canvasId);
  const dataElement = $('#' + dataId);
  
  if (!canvas.length || !dataElement.length) {
    return; // Skip if chart elements don't exist
  }

  try {
    const chartConfig = JSON.parse(dataElement.text()).chartConfig;
    
    if (!chartConfig?.datasets?.length) {
      console.error(`Invalid chart configuration for ${canvasId}`);
      return;
    }

    new Chart(canvas[0], {
      type: 'radar',
      data: {
        labels: chartConfig.labels,
        datasets: chartConfig.datasets.map(dataset => ({
          ...dataset,
          data: dataset.normalizedData,
          originalData: dataset.data
        }))
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
          r: {
            min: 0,
            max: 1,
            ticks: {
              stepSize: 0.2,
              display: false
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
                const originalValue = context.dataset.originalData[context.dataIndex];
                return `${context.dataset.label}: ${originalValue}`;
              }
            }
          }
        }
      }
    });
  } catch (error) {
    console.error(`Error creating ${canvasId}:`, error);
  }
}
