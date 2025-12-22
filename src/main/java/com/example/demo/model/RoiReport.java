package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "roi_reports")
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discount_code_id")
    private DiscountCode discountCode;

    @Column(nullable = false)
    private BigDecimal totalSales;

    @Column(nullable = false)
    private Integer totalTransactions;

    @Column(nullable = false)
    private Double roiPercentage;

    public RoiReport() {
    }

    public RoiReport(DiscountCode discountCode, BigDecimal totalSales,
            Integer totalTransactions, Double roiPercentage) {
        this.discountCode = discountCode;
        this.totalSales = totalSales;
        this.totalTransactions = totalTransactions;
        this.roiPercentage = roiPercentage;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public Integer getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(Integer totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public Double getRoiPercentage() {
        return roiPercentage;
    }

    public void setRoiPercentage(Double roiPercentage) {
        this.roiPercentage = roiPercentage;
    }
}
