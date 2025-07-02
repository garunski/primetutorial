/**
 * Career Charts - Chart.js implementation for CareerZone
 * Handles skills and knowledge radar charts
 */

$(document).ready(() => {
  const initChart = (canvasId, chartData) => {
    const canvas = $('#' + canvasId);

    if (!canvas.length || !chartData?.chartConfig?.datasets?.length) {
      console.log(`Chart elements not found or invalid: ${canvasId}`);
      return;
    }

    try {
      const { labels, datasets } = chartData.chartConfig;

      new Chart(canvas[0], {
        type: 'radar',
        data: {
          labels,
          datasets: datasets.map(dataset => ({
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
                label: (context) => {
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
  };

  // Initialize charts
  try {
    initChart('skills-radar-chart', window.skillsChartData);
    initChart('knowledge-radar-chart', window.knowledgeChartData);
  } catch (error) {
    console.error("Error initializing charts:", error);
  }
});
