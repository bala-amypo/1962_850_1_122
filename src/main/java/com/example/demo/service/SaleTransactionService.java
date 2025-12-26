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

    // Overloaded methods for Long (to satisfy existing test cases)
    List<SaleTransaction> getSalesForCode(Long discountCodeId);
    List<SaleTransaction> getSalesForInfluencer(Long influencerId);
    List<SaleTransaction> getSalesForCampaign(Long campaignId);

    // Overloaded methods for String (to satisfy tests at lines 416-417)
    List<SaleTransaction> getSalesForCode(String discountCodeId);
    List<SaleTransaction> getSalesForInfluencer(String influencerId);
    List<SaleTransaction> getSalesForCampaign(String campaignId);
}