/**
 * Career Details - Charts and pagination for details page
 */
$(document).ready(() => {
    initCharts();
    initPagination();

    function initCharts() {
        createChart('skills-radar-chart', window.skillsChartData);
        createChart('knowledge-radar-chart', window.knowledgeChartData);
    }

    function createChart(canvasId, chartData) {
        const canvas = $('#' + canvasId);
        
        if (!canvas.length || !chartData?.chartConfig?.datasets?.length) {
            return;
        }

        const { labels, datasets } = chartData.chartConfig;
        
        new Chart(canvas[0], {
            type: 'radar',
            data: {
                labels,
                datasets: datasets.map(dataset => ({
                    ...dataset,
                    data: dataset.normalizedData || dataset.data,
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
                        ticks: { stepSize: 0.2, display: false },
                        pointLabels: { font: { size: 12, weight: 'bold' } }
                    }
                },
                plugins: {
                    legend: { position: 'bottom' },
                    tooltip: {
                        callbacks: {
                            label: (context) => {
                                const originalValue = context.dataset.originalData?.[context.dataIndex] || 'N/A';
                                return `${context.dataset.label}: ${originalValue}`;
                            }
                        }
                    }
                }
            }
        });
    }

    function initPagination() {
        const items = $('.program-item');
        const prevBtn = $('#prevBtn');
        const nextBtn = $('#nextBtn');
        const pageInfo = $('#pageInfo');
        
        if (!items.length) return;
        
        const itemsPerPage = 4;
        const totalPages = Math.ceil(items.length / itemsPerPage);
        let currentPage = 1;
        
        const showPage = (page) => {
            const start = (page - 1) * itemsPerPage;
            const end = start + itemsPerPage;
            
            items.hide().slice(start, end).show();
            pageInfo.text(`Page ${page} of ${totalPages}`);
            prevBtn.prop('disabled', page === 1);
            nextBtn.prop('disabled', page === totalPages);
        };
        
        showPage(1);
        
        nextBtn.on('click', () => {
            if (currentPage < totalPages) {
                showPage(++currentPage);
            }
        });
        
        prevBtn.on('click', () => {
            if (currentPage > 1) {
                showPage(--currentPage);
            }
        });
    }
}); 