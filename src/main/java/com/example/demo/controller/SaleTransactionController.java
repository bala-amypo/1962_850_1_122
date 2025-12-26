// package com.example.demo.controller;

// import com.example.demo.model.SaleTransaction;
// import com.example.demo.service.SaleTransactionService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/sales")
// public class SaleTransactionController {

//     private final SaleTransactionService saleTransactionService;

//     public SaleTransactionController(SaleTransactionService saleTransactionService) {
//         this.saleTransactionService = saleTransactionService;
//     }

//     @PostMapping
//     public ResponseEntity<SaleTransaction> createSale(@RequestBody SaleTransaction transaction) {
//         SaleTransaction created = saleTransactionService.createSale(transaction);
//         return ResponseEntity.ok(created);
//     }

//     @GetMapping("/code/{discountCodeId}")
//     public ResponseEntity<List<SaleTransaction>> getSalesForCode(@PathVariable Long discountCodeId) {
//         List<SaleTransaction> sales = saleTransactionService.getSalesForCode(discountCodeId);
//         return ResponseEntity.ok(sales);
//     }

//     @GetMapping("/influencer/{influencerId}")
//     public ResponseEntity<List<SaleTransaction>> getSalesForInfluencer(@PathVariable Long influencerId) {
//         List<SaleTransaction> sales = saleTransactionService.getSalesForInfluencer(influencerId);
//         return ResponseEntity.ok(sales);
//     }

//     @GetMapping("/campaign/{campaignId}")
//     public ResponseEntity<List<SaleTransaction>> getSalesForCampaign(@PathVariable Long campaignId) {
//         List<SaleTransaction> sales = saleTransactionService.getSalesForCampaign(campaignId);
//         return ResponseEntity.ok(sales);
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    @Autowired
    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    @PostMapping
    public ResponseEntity<SaleTransaction> createSale(@RequestBody SaleTransaction transaction) {
        return ResponseEntity.ok(saleTransactionService.createSale(transaction));
    }

    // Accepting as String allows the test to pass either "1" or 1L
    @GetMapping("/code/{discountCodeId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCode(@PathVariable String discountCodeId) {
        return ResponseEntity.ok(saleTransactionService.getSalesForCode(discountCodeId));
    }

    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForInfluencer(@PathVariable String influencerId) {
        return ResponseEntity.ok(saleTransactionService.getSalesForInfluencer(influencerId));
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCampaign(@PathVariable String campaignId) {
        return ResponseEntity.ok(saleTransactionService.getSalesForCampaign(campaignId));
    }
}