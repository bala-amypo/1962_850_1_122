// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.math.BigDecimal;

// @Entity
// @Table(name = "roi_reports")
// public class RoiReport {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "discount_code_id")
//     private DiscountCode discountCode;

//     @Column(nullable = false)
//     private BigDecimal totalSales;

//     @Column(nullable = false)
//     private Integer totalTransactions;

//     @Column(nullable = false)
//     private Double roiPercentage;

//     public RoiReport() {
//     }

//     public RoiReport(DiscountCode discountCode, BigDecimal totalSales,
//             Integer totalTransactions, Double roiPercentage) {
//         this.discountCode = discountCode;
//         this.totalSales = totalSales;
//         this.totalTransactions = totalTransactions;
//         this.roiPercentage = roiPercentage;
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public DiscountCode getDiscountCode() {
//         return discountCode;
//     }

//     public void setDiscountCode(DiscountCode discountCode) {
//         this.discountCode = discountCode;
//     }

//     public BigDecimal getTotalSales() {
//         return totalSales;
//     }

//     public void setTotalSales(BigDecimal totalSales) {
//         this.totalSales = totalSales;
//     }

//     public Integer getTotalTransactions() {
//         return totalTransactions;
//     }

//     public void setTotalTransactions(Integer totalTransactions) {
//         this.totalTransactions = totalTransactions;
//     }

//     public Double getRoiPercentage() {
//         return roiPercentage;
//     }

//     public void setRoiPercentage(Double roiPercentage) {
//         this.roiPercentage = roiPercentage;
//     } }
// 








// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.math.BigDecimal;

// @Entity
// @Table(name = "roi_reports")
// public class RoiReport {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "discount_code_id")
//     private DiscountCode discountCode;

//     private BigDecimal totalSales;
//     private Integer totalTransactions;
//     private Double roiPercentage;

//     public RoiReport() {
//     }

//     public RoiReport(DiscountCode discountCode, BigDecimal totalSales, Integer totalTransactions,
//             Double roiPercentage) {
//         this.discountCode = discountCode;
//         this.totalSales = totalSales;
//         this.totalTransactions = totalTransactions;
//         this.roiPercentage = roiPercentage;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public DiscountCode getDiscountCode() {
//         return discountCode;
//     }

//     public void setDiscountCode(DiscountCode discountCode) {
//         this.discountCode = discountCode;
//     }

//     public BigDecimal getTotalSales() {
//         return totalSales;
//     }

//     public void setTotalSales(BigDecimal totalSales) {
//         this.totalSales = totalSales;
//     }

//     public Integer getTotalTransactions() {
//         return totalTransactions;
//     }

//     public void setTotalTransactions(Integer totalTransactions) {
//         this.totalTransactions = totalTransactions;
//     }

//     public Double getRoiPercentage() {
//         return roiPercentage;
//     }

//     public void setRoiPercentage(Double roiPercentage) {
//         this.roiPercentage = roiPercentage;
//     }
// }




package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "roi_reports")
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalSales;

    private int totalTransactions;

    private double roiPercentage;

    @ManyToOne
    @JoinColumn(name = "discount_code_id")
    private DiscountCode discountCode;

    // Default constructor
    public RoiReport() {}

    //  Parameterized constructor
    public RoiReport(Long id, BigDecimal totalSales,
                     int totalTransactions,
                     double roiPercentage,
                     DiscountCode discountCode) {
        this.id = id;
        this.totalSales = totalSales;
        this.totalTransactions = totalTransactions;
        this.roiPercentage = roiPercentage;
        this.discountCode = discountCode;
    }

    //  Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getTotalSales() { return totalSales; }
    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public int getTotalTransactions() { return totalTransactions; }
    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public double getRoiPercentage() { return roiPercentage; }
    public void setRoiPercentage(double roiPercentage) {
        this.roiPercentage = roiPercentage;
    }

    public DiscountCode getDiscountCode() { return discountCode; }
    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }
}
