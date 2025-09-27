document.addEventListener("DOMContentLoaded", function () {
    const canvas = document.getElementById("salesChart");
    const daily   = parseInt(canvas.dataset.daily)   || 0;
    const weekly  = parseInt(canvas.dataset.weekly)  || 0;
    const monthly = parseInt(canvas.dataset.monthly) || 0;

    const ctx = canvas.getContext("2d");
    new Chart(ctx, {
        type: "bar",
        data: {
            labels: ["รายวัน", "รายสัปดาห์", "รายเดือน"],
            datasets: [{
                label: "ยอดขาย (บาท)",
                data: [daily, weekly, monthly],
                backgroundColor: ["#4CAF50", "#2196F3", "#FFC107"]
            }]
        },
        options: { responsive: true }
    });
});
