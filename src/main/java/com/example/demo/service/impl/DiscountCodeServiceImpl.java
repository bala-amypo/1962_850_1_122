// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.DiscountCode;
// import com.example.demo.repository.DiscountCodeRepository;
// import com.example.demo.service.DiscountCodeService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class DiscountCodeServiceImpl implements DiscountCodeService {

//     private final DiscountCodeRepository discountCodeRepository;

//     public DiscountCodeServiceImpl(DiscountCodeRepository discountCodeRepository) {
//         this.discountCodeRepository = discountCodeRepository;
//     }

//     @Override
//     public DiscountCode createDiscountCode(DiscountCode discountCode) {
//         if (discountCode.getDiscountPercentage() != null) {
//             if (discountCode.getDiscountPercentage() < 0 || discountCode.getDiscountPercentage() > 100) {
//                 throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
//             }
//         }
//         return discountCodeRepository.save(discountCode);
//     }

//     @Override
//     public DiscountCode getDiscountCodeById(Long id) {
//         return discountCodeRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));
//     }

//     @Override
//     public DiscountCode updateDiscountCode(Long id, DiscountCode updated) {
//         DiscountCode existing = discountCodeRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

//         if (updated.getDiscountPercentage() != null) {
//             if (updated.getDiscountPercentage() < 0 || updated.getDiscountPercentage() > 100) {
//                 throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
//             }
//             existing.setDiscountPercentage(updated.getDiscountPercentage());
//         }

//         if (updated.getCodeValue() != null) {
//             existing.setCodeValue(updated.getCodeValue());
//         }

//         if (updated.getInfluencer() != null) {
//             existing.setInfluencer(updated.getInfluencer());
//         }

//         if (updated.getCampaign() != null) {
//             existing.setCampaign(updated.getCampaign());
//         }

//         return discountCodeRepository.save(existing);
//     }

//     @Override
//     public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
//         return discountCodeRepository.findByInfluencerId(influencerId);
//     }

//     @Override
//     public List<DiscountCode> getCodesForCampaign(Long campaignId) {
//         return discountCodeRepository.findByCampaignId(campaignId);
//     }
// }


// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.DiscountCode;
// import com.example.demo.repository.DiscountCodeRepository;
// import com.example.demo.service.DiscountCodeService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class DiscountCodeServiceImpl implements DiscountCodeService {

//     private final DiscountCodeRepository discountCodeRepository;

//     public DiscountCodeServiceImpl(DiscountCodeRepository discountCodeRepository) {
//         this.discountCodeRepository = discountCodeRepository;
//     }

//     @Override
//     public DiscountCode getDiscountCodeById(Long id) {
//         return discountCodeRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Not found"));
//     }

//     @Override
//     public DiscountCode updateDiscountCode(Long id, DiscountCode updated) {
//         DiscountCode existing = discountCodeRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Not found"));
        
//         if (updated.getDiscountPercentage() != null && 
//             (updated.getDiscountPercentage() < 0 || updated.getDiscountPercentage() > 100)) {
//             throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
//         }
        
//         existing.setCodeValue(updated.getCodeValue());
//         existing.setDiscountPercentage(updated.getDiscountPercentage());
        
//         return discountCodeRepository.save(existing);
//     }

//     @Override
//     public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
//         return discountCodeRepository.findByInfluencerId(influencerId);
//     }

//     @Override
//     public List<DiscountCode> getCodesForCampaign(Long campaignId) {
//         return discountCodeRepository.findByCampaignId(campaignId);
//     }
// }




package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return null;
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode updated) {
        return null;
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return null;
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return null;
    }
}
