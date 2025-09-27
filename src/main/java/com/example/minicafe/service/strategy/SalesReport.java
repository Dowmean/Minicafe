package com.example.minicafe.service.strategy;

import java.time.LocalDate;

public class SalesReport {
    private int total;
    private LocalDate startDate;
    private LocalDate endDate;

    public SalesReport(int total, LocalDate startDate, LocalDate endDate) {
        this.total = total;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getTotal() {
        return total;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
