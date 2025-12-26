// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.DiscountCode;
// import com.example.demo.model.SaleTransaction;
// import com.example.demo.repository.DiscountCodeRepository;
// import com.example.demo.repository.SaleTransactionRepository;
// import com.example.demo.service.SaleTransactionService;
// import org.springframework.stereotype.Service;

// import java.math.BigDecimal;
// import java.sql.Timestamp;
// import java.util.List;

// @Service
// public class SaleTransactionServiceImpl implements SaleTransactionService {

//     private final SaleTransactionRepository saleTransactionRepository;
//     private final DiscountCodeRepository discountCodeRepository;

//     public SaleTransactionServiceImpl(SaleTransactionRepository saleTransactionRepository,
//             DiscountCodeRepository discountCodeRepository) {
//         this.saleTransactionRepository = saleTransactionRepository;
//         this.discountCodeRepository = discountCodeRepository;
//     }

//     @Override
//     public SaleTransaction createSale(SaleTransaction transaction) {
//         if (transaction.getTransactionAmount() == null ||
//                 transaction.getTransactionAmount().compareTo(BigDecimal.ZERO) <= 0) {
//             throw new IllegalArgumentException("Transaction amount must be > 0");
//         }

//         if (transaction.getDiscountCode() != null && transaction.getDiscountCode().getId() != null) {
//             DiscountCode code = discountCodeRepository.findById(transaction.getDiscountCode().getId())
//                     .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));
//             transaction.setDiscountCode(code);
//         }

//         if (transaction.getTransactionDate() == null) {
//             transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
//         }

//         return saleTransactionRepository.save(transaction);
//     }

//     @Override
//     public List<SaleTransaction> getSalesForCode(Long discountCodeId) {
//         return saleTransactionRepository.findByDiscountCodeId(discountCodeId);
//     }

//     @Override
//     public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
//         return saleTransactionRepository.findByDiscountCodeInfluencerId(influencerId);
//     }

//     @Override
//     public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
//         return saleTransactionRepository.findByDiscountCodeCampaignId(campaignId);
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;

    public SaleTransactionServiceImpl(SaleTransactionRepository saleTransactionRepository,
                                    DiscountCodeRepository discountCodeRepository) {
        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public SaleTransaction createSale(SaleTransaction transaction) {
        if (transaction.getTransactionAmount() == null || 
            transaction.getTransactionAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }
        
        if (transaction.getDiscountCode() != null && transaction.getDiscountCode().getId() != null) {
            discountCodeRepository.findById(transaction.getDiscountCode().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));
        }
        
        if (transaction.getTransactionDate() == null) {
            transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        }
        
        return saleTransactionRepository.save(transaction);
    }

    // --- Overloaded methods for Long (Supports lines 34, 76, 77) ---
    // These fix "long cannot be converted to String"

    @Override
    public List<SaleTransaction> getSalesForCode(Long discountCodeId) {
        return saleTransactionRepository.findByDiscountCodeId(discountCodeId);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return saleTransactionRepository.findByDiscountCodeInfluencerId(influencerId);
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return saleTransactionRepository.findByDiscountCodeCampaignId(campaignId);
    }

    // --- Overloaded methods for String (Supports lines 416-417) ---
    // These fix "String cannot be converted to Long"

    @Override
    public List<SaleTransaction> getSalesForCode(String discountCodeId) {
        // Bridges the String from the test to the Long required by the database
        return saleTransactionRepository.findByDiscountCodeId(Long.valueOf(discountCodeId));
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(String influencerId) {
        return saleTransactionRepository.findByDiscountCodeInfluencerId(Long.valueOf(influencerId));
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(String campaignId) {
        return saleTransactionRepository.findByDiscountCodeCampaignId(Long.valueOf(campaignId));
    }
}