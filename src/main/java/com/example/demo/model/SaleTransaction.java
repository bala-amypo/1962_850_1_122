// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.math.BigDecimal;
// import java.sql.Timestamp;

// @Entity
// @Table(name = "sale_transactions")
// public class SaleTransaction {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "discount_code_id")
//     private DiscountCode discountCode;

//     @Column(nullable = false)
//     private BigDecimal transactionAmount;

//     @Column(nullable = false)
//     private Timestamp transactionDate;

//     @Column(nullable = false)
//     private Long customerId;

//     public SaleTransaction() {
//     }

//     public SaleTransaction(DiscountCode discountCode, BigDecimal transactionAmount,
//             Timestamp transactionDate, Long customerId) {
//         this.discountCode = discountCode;
//         this.transactionAmount = transactionAmount;
//         this.transactionDate = transactionDate;
//         this.customerId = customerId;
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

//     public BigDecimal getTransactionAmount() {
//         return transactionAmount;
//     }

//     public void setTransactionAmount(BigDecimal transactionAmount) {
//         this.transactionAmount = transactionAmount;
//     }

//     public Timestamp getTransactionDate() {
//         return transactionDate;
//     }

//     public void setTransactionDate(Timestamp transactionDate) {
//         this.transactionDate = transactionDate;
//     }

//     public Long getCustomerId() {
//         return customerId;
//     }

//     public void setCustomerId(Long customerId) {
//         this.customerId = customerId;
//     } }
// 
//
package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "sale_transactions")
public class SaleTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discount_code_id")
    private DiscountCode discountCode;

    private BigDecimal transactionAmount;
    private Timestamp transactionDate;
    
    // 1. Change this field from Long to String
    private String customerId; 

    public SaleTransaction() {
    }

    // 2. Update the constructor to accept String customerId
    public SaleTransaction(DiscountCode discountCode, BigDecimal transactionAmount, Timestamp transactionDate,
            String customerId) {
        this.discountCode = discountCode;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.customerId = customerId;
    }

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

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    // 3. Update Getter return type to String
    public String getCustomerId() {
        return customerId;
    }

    // 4. Update Setter parameter type to String
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}