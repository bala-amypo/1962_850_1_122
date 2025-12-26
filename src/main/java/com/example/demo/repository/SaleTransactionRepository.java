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

// package com.example.demo.repository;

// import com.example.demo.model.SaleTransaction;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {

//     // Overloaded methods for Long (Supports standard tests like line 34)
//     List<SaleTransaction> findByDiscountCodeId(Long discountCodeId);
//     List<SaleTransaction> findByDiscountCodeInfluencerId(Long influencerId);
//     List<SaleTransaction> findByDiscountCodeCampaignId(Long campaignId);

//     // Overloaded methods for String (Supports tests at lines 416-417)
//     List<SaleTransaction> findByDiscountCodeId(String discountCodeId);
//     List<SaleTransaction> findByDiscountCodeInfluencerId(String influencerId);
//     List<SaleTransaction> findByDiscountCodeCampaignId(String campaignId);
// }

package com.example.demo.repository;

import com.example.demo.model.SaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {
}
