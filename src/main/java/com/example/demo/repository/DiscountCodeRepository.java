// package com.example.demo.repository;

// import com.example.demo.model.DiscountCode;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.List;

// @Repository
// public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {
//     List<DiscountCode> findByInfluencerId(Long influencerId);

//     List<DiscountCode> findByCampaignId(Long campaignId);
// }

package com.example.demo.repository;

import com.example.demo.model.DiscountCode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {
    List<DiscountCode> findByInfluencerId(Long influencerId);

    List<DiscountCode> findByCampaignId(Long campaignId);
}
