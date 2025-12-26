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

    // 1. PRIMARY METHODS (Supports lines 34, 38, 76, 77, 78 using Long/long)
    // These satisfy the "long cannot be converted to String" errors
    List<SaleTransaction> getSalesForCode(Long discountCodeId);
    List<SaleTransaction> getSalesForInfluencer(Long influencerId);
    List<SaleTransaction> getSalesForCampaign(Long campaignId);

    // 2. OVERLOADED METHODS (Supports lines 416-417 using String)
    // These satisfy the "String cannot be converted to Long" errors
    List<SaleTransaction> getSalesForCode(String discountCodeId);
    List<SaleTransaction> getSalesForInfluencer(String influencerId);
    List<SaleTransaction> getSalesForCampaign(String campaignId);
}