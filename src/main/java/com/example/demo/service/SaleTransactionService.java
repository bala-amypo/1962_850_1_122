// package com.example.demo.service;

// import com.example.demo.model.SaleTransaction;
// import java.util.List;

// public interface SaleTransactionService {
//     SaleTransaction createSale(SaleTransaction transaction);

//     List<SaleTransaction> getSalesForCode(Long discountCodeId);

//     List<SaleTransaction> getSalesForInfluencer(Long influencerId);

//     List<SaleTransaction> getSalesForCampaign(Long campaignId);
// }
package com.example.demo.service;

import com.example.demo.model.SaleTransaction;
import java.util.List;

public interface SaleTransactionService {
    SaleTransaction createSale(SaleTransaction transaction);

    // Changed from Long to String to match test expectations
    List<SaleTransaction> getSalesForCode(String discountCodeId);

    // Changed from Long to String to match test expectations
    List<SaleTransaction> getSalesForInfluencer(String influencerId);

    // Changed from Long to String to match test expectations
    List<SaleTransaction> getSalesForCampaign(String campaignId);
}