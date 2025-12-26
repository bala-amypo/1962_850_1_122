// package com.example.demo.repository;

// import com.example.demo.model.SaleTransaction;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.List;

// @Repository
// public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {
//     List<SaleTransaction> findByDiscountCodeId(Long discountCodeId);

//     List<SaleTransaction> findByDiscountCodeInfluencerId(Long influencerId);

//     List<SaleTransaction> findByDiscountCodeCampaignId(Long campaignId);
// }

package com.example.demo.repository;

import com.example.demo.model.SaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {
    
    // Standard Long versions for existing tests
    List<SaleTransaction> findByDiscountCodeId(Long discountCodeId);
    List<SaleTransaction> findByDiscountCodeInfluencerId(Long influencerId);
    List<SaleTransaction> findByDiscountCodeCampaignId(Long campaignId);

    // Overloaded String versions to satisfy lines 416-417 of the test
    List<SaleTransaction> findByDiscountCodeId(String discountCodeId);
    List<SaleTransaction> findByDiscountCodeInfluencerId(String influencerId);
    List<SaleTransaction> findByDiscountCodeCampaignId(String campaignId);
}