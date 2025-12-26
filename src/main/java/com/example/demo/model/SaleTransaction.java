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

//     private BigDecimal transactionAmount;
//     private Timestamp transactionDate;
    
//     // Internal storage remains String to accommodate lines 416-417
//     private String customerId; 

//     public SaleTransaction() {
//     }

//     public SaleTransaction(DiscountCode discountCode, BigDecimal transactionAmount, Timestamp transactionDate,
//             String customerId) {
//         this.discountCode = discountCode;
//         this.transactionAmount = transactionAmount;
//         this.transactionDate = transactionDate;
//         this.customerId = customerId;
//     }

//     public SaleTransaction(DiscountCode discountCode, BigDecimal transactionAmount, Timestamp transactionDate,
//             Long customerId) {
//         this.discountCode = discountCode;
//         this.transactionAmount = transactionAmount;
//         this.transactionDate = transactionDate;
//         this.customerId = (customerId == null) ? null : String.valueOf(customerId);
//     }

//     // Standard getters and setters for other fields...
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public DiscountCode getDiscountCode() { return discountCode; }
//     public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
//     public BigDecimal getTransactionAmount() { return transactionAmount; }
//     public void setTransactionAmount(BigDecimal transactionAmount) { this.transactionAmount = transactionAmount; }
//     public Timestamp getTransactionDate() { return transactionDate; }
//     public void setTransactionDate(Timestamp transactionDate) { this.transactionDate = transactionDate; }

//     /**
//      * FIX FOR LINE 196:
//      * If the test expects a Long return type at line 196, 
//      * but the field is a String, you must return a Long here.
//      */
//     public Long getCustomerId() {
//         return (customerId == null) ? null : Long.valueOf(customerId);
//     }

//     // Setter for String (Supports lines 416, 417)
//     public void setCustomerId(String customerId) {
//         this.customerId = customerId;
//     }

//     // Overloaded Setter for Long (Supports lines 195, 196, 362, etc.)
//     public void setCustomerId(Long customerId) {
//         this.customerId = (customerId == null) ? null : String.valueOf(customerId);
//     }
// }


package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;
@Data @Entity
public class SaleTransaction {
    @Id @GeneratedValue private Long id;
    private BigDecimal transactionAmount;
    private Timestamp transactionDate;
    private Long customerId;
    @ManyToOne private DiscountCode discountCode;
}
