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

    const knowledgeDataElements = document.querySelectorAll('#knowledge-data .knowledge-data');
    console.log("Knowledge data elements found:", knowledgeDataElements.length);

    // Initialize charts
    initializeSkillsRadarChart();
    initializeKnowledgeRadarChart();

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
      console.log("Career Charts: Skills radar chart canvas not found on page");
      return;
    }

    // Get the skills data from the JSON script tag
    const skillsDataElement = document.getElementById('skills-data');
    if (!skillsDataElement) {
      console.log("Career Charts: Skills data element not found on page");
      return;
    }

    // Parse the JSON data
    let skillsData;
    try {
      skillsData = JSON.parse(skillsDataElement.textContent);
    } catch (error) {
      console.error("Career Charts: Error parsing skills JSON data:", error);
      return;
    }

    if (!skillsData.skills || !Array.isArray(skillsData.skills)) {
      console.error("Career Charts: Invalid skills data format");
      return;
    }

    console.log(`Career Charts: Found ${skillsData.skills.length} skills in JSON data`);

    // Function to normalize values to a 0-1 scale
    function normalizeValue(value, maxValue) {
      return value / maxValue;
    }

    // Extract the data for the chart
    const skillNames = [];
    const importanceValues = [];
    const levelValues = [];
    const normalizedImportanceValues = [];
    const normalizedLevelValues = [];

    // Maximum values for each scale
    const MAX_IMPORTANCE = 5;
    const MAX_LEVEL = 7;

    skillsData.skills.forEach((skill, index) => {
      try {
        const name = skill.name;
        const importance = parseFloat(skill.importance) || 0;
        const level = parseFloat(skill.level) || 0;

        // Store original values for tooltips
        skillNames.push(name);
        importanceValues.push(importance);
        levelValues.push(level);

        // Store normalized values for the chart (0-1 scale)
        normalizedImportanceValues.push(normalizeValue(importance, MAX_IMPORTANCE));
        normalizedLevelValues.push(normalizeValue(level, MAX_LEVEL));

        console.log(`Career Charts: Processed skill ${name} with importance ${importance}/${MAX_IMPORTANCE} (normalized: ${normalizeValue(importance, MAX_IMPORTANCE).toFixed(2)}) and level ${level}/${MAX_LEVEL} (normalized: ${normalizeValue(level, MAX_LEVEL).toFixed(2)})`);
      } catch (error) {
        console.error(`Career Charts: Error processing skill data element ${index}:`, error);
      }
    });

    // Create the radar chart
    new Chart(radarChartCanvas, {
      type: 'radar',
      data: {
        labels: skillNames,
        datasets: [
          {
            label: 'Importance (out of 5)',
            data: normalizedImportanceValues,
            backgroundColor: 'rgba(11, 93, 102, 0.2)',
            borderColor: 'rgba(11, 93, 102, 1)',
            borderWidth: 2,
            pointBackgroundColor: 'rgba(11, 93, 102, 1)',
            pointBorderColor: '#fff',
            pointHoverBackgroundColor: '#fff',
            pointHoverBorderColor: 'rgba(11, 93, 102, 1)',
            // Store original values for tooltips
            originalData: importanceValues,
            maxValue: MAX_IMPORTANCE
          },
          {
            label: 'Level (out of 7)',
            data: normalizedLevelValues,
            backgroundColor: 'rgba(31, 41, 55, 0.2)',
            borderColor: 'rgba(31, 41, 55, 1)',
            borderWidth: 2,
            pointBackgroundColor: 'rgba(31, 41, 55, 1)',
            pointBorderColor: '#fff',
            pointHoverBackgroundColor: '#fff',
            pointHoverBorderColor: 'rgba(31, 41, 55, 1)',
            // Store original values for tooltips
            originalData: levelValues,
            maxValue: MAX_LEVEL
          }
        ]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
          r: {
            min: 0,
            max: 1, // Normalized scale from 0 to 1
            ticks: {
              stepSize: 0.2,
              callback: function(value) {
                // Display percentages on the scale
                return Math.round(value * 100) + '%';
              }
            },
            pointLabels: {
              font: {
                size: 14,
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
                const datasetLabel = context.dataset.label || '';
                const index = context.dataIndex;
                const originalValue = context.dataset.originalData[index];
                const maxValue = context.dataset.maxValue;

                return `${datasetLabel}: ${originalValue}/${maxValue} (${Math.round(context.raw * 100)}%)`;
              }
            }
          }
        }
      }
    });

    console.log("Career Charts: Created skills radar chart");
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

    // Get the knowledge data from the hidden data elements
    const knowledgeDataElements = document.querySelectorAll('#knowledge-data .knowledge-data');
    if (knowledgeDataElements.length === 0) {
      console.log("Career Charts: No knowledge data found on page");
      return;
    }

    console.log(`Career Charts: Found ${knowledgeDataElements.length} knowledge data elements`);

    // Function to normalize values to a 0-1 scale
    function normalizeValue(value, maxValue) {
      return value / maxValue;
    }

    // Extract the data for the chart
    const knowledgeNames = [];
    const importanceValues = [];
    const levelValues = [];
    const normalizedImportanceValues = [];
    const normalizedLevelValues = [];

    // Maximum values for each scale
    const MAX_IMPORTANCE = 5;
    const MAX_LEVEL = 7;

    knowledgeDataElements.forEach((element, index) => {
      try {
        const name = element.getAttribute('data-name');
        const importance = parseFloat(element.getAttribute('data-importance')) || 0;
        const level = parseFloat(element.getAttribute('data-level')) || 0;

        // Store original values for tooltips
        knowledgeNames.push(name);
        importanceValues.push(importance);
        levelValues.push(level);

        // Store normalized values for the chart (0-1 scale)
        normalizedImportanceValues.push(normalizeValue(importance, MAX_IMPORTANCE));
        normalizedLevelValues.push(normalizeValue(level, MAX_LEVEL));

        console.log(`Career Charts: Processed knowledge ${name} with importance ${importance}/${MAX_IMPORTANCE} (normalized: ${normalizeValue(importance, MAX_IMPORTANCE).toFixed(2)}) and level ${level}/${MAX_LEVEL} (normalized: ${normalizeValue(level, MAX_LEVEL).toFixed(2)})`);
      } catch (error) {
        console.error(`Career Charts: Error processing knowledge data element ${index}:`, error);
      }
    });

    // Create the radar chart
    new Chart(radarChartCanvas, {
      type: 'radar',
      data: {
        labels: knowledgeNames,
        datasets: [
          {
            label: 'Importance (out of 5)',
            data: normalizedImportanceValues,
            backgroundColor: 'rgba(11, 93, 102, 0.2)',
            borderColor: 'rgba(11, 93, 102, 1)',
            borderWidth: 2,
            pointBackgroundColor: 'rgba(11, 93, 102, 1)',
            pointBorderColor: '#fff',
            pointHoverBackgroundColor: '#fff',
            pointHoverBorderColor: 'rgba(11, 93, 102, 1)',
            // Store original values for tooltips
            originalData: importanceValues,
            maxValue: MAX_IMPORTANCE
          },
          {
            label: 'Level (out of 7)',
            data: normalizedLevelValues,
            backgroundColor: 'rgba(31, 41, 55, 0.2)',
            borderColor: 'rgba(31, 41, 55, 1)',
            borderWidth: 2,
            pointBackgroundColor: 'rgba(31, 41, 55, 1)',
            pointBorderColor: '#fff',
            pointHoverBackgroundColor: '#fff',
            pointHoverBorderColor: 'rgba(31, 41, 55, 1)',
            // Store original values for tooltips
            originalData: levelValues,
            maxValue: MAX_LEVEL
          }
        ]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
          r: {
            min: 0,
            max: 1, // Normalized scale from 0 to 1
            ticks: {
              stepSize: 0.2,
              callback: function(value) {
                // Display percentages on the scale
                return Math.round(value * 100) + '%';
              }
            },
            pointLabels: {
              font: {
                size: 14,
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
                const datasetLabel = context.dataset.label || '';
                const index = context.dataIndex;
                const originalValue = context.dataset.originalData[index];
                const maxValue = context.dataset.maxValue;

                return `${datasetLabel}: ${originalValue}/${maxValue} (${Math.round(context.raw * 100)}%)`;
              }
            }
          }
        }
      }
    });

    console.log("Career Charts: Created knowledge radar chart");
  } catch (error) {
    console.error("Career Charts: Error initializing knowledge radar chart:", error);
  }
}

/**
 * Initialize polar charts for knowledge areas (legacy function)
 */
function initializeKnowledgeCharts() {
  try {
    // Get all knowledge card elements
    const knowledgeCards = document.querySelectorAll('.knowledge-card');
    console.log(`Career Charts: Found ${knowledgeCards.length} knowledge cards`);

    if (knowledgeCards.length === 0) {
      console.log("Career Charts: No knowledge cards found on page");
      return;
    }

    // Process each knowledge card
    knowledgeCards.forEach((card, index) => {
      try {
        // Get knowledge info element
        const knowledgeHeading = card.querySelector('.knowledge-header h4');
        if (!knowledgeHeading) {
          console.warn(`Career Charts: Knowledge heading not found in card ${index}`);
          return;
        }

        const knowledgeName = knowledgeHeading.textContent;

        // Get knowledge meter values
        const importanceValueElement = card.querySelector('.knowledge-meter-value:first-of-type');
        const levelValueElement = card.querySelector('.knowledge-meter-value:last-of-type');

        if (!importanceValueElement || !levelValueElement) {
          console.warn(`Career Charts: Knowledge meter values not found for ${knowledgeName}`);
          return;
        }

        const importanceValue = parseFloat(importanceValueElement.textContent) || 0;
        const levelValue = parseFloat(levelValueElement.textContent) || 0;

        console.log(`Career Charts: Processing knowledge ${knowledgeName} with importance ${importanceValue} and level ${levelValue}`);

        // Create a canvas element for the chart
        const chartContainer = document.createElement('div');
        chartContainer.className = 'knowledge-chart-container';
        const canvas = document.createElement('canvas');
        canvas.id = `knowledge-chart-${index}`;
        chartContainer.appendChild(canvas);

        // Replace the old knowledge meters with the new chart container
        const oldKnowledgeMeters = card.querySelector('.knowledge-meters');
        if (!oldKnowledgeMeters) {
          console.warn(`Career Charts: Knowledge meters element not found for ${knowledgeName}`);
          return;
        }

        oldKnowledgeMeters.parentNode.replaceChild(chartContainer, oldKnowledgeMeters);

        // Create the chart
        new Chart(canvas, {
          type: 'radar',
          data: {
            labels: ['Importance', 'Level'],
            datasets: [{
              label: knowledgeName,
              data: [importanceValue, levelValue],
              backgroundColor: 'rgba(11, 93, 102, 0.2)',
              borderColor: 'rgba(11, 93, 102, 1)',
              borderWidth: 2,
              pointBackgroundColor: 'rgba(11, 93, 102, 1)',
              pointBorderColor: '#fff',
              pointHoverBackgroundColor: '#fff',
              pointHoverBorderColor: 'rgba(11, 93, 102, 1)'
            }]
          },
          options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
              r: {
                min: 0,
                max: 7,
                ticks: {
                  stepSize: 1
                },
                pointLabels: {
                  font: {
                    size: 14,
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
                    const label = context.dataset.label || '';
                    const value = context.raw || 0;
                    return `${label}: ${value}`;
                  }
                }
              }
            }
          }
        });

        console.log(`Career Charts: Created chart for knowledge ${knowledgeName}`);
      } catch (error) {
        console.error(`Career Charts: Error processing knowledge card ${index}:`, error);
      }
    });
  } catch (error) {
    console.error("Career Charts: Error initializing knowledge charts:", error);
  }
}
