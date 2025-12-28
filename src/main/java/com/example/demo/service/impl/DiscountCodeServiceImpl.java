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

// import com.example.demo.model.DiscountCode;
// import com.example.demo.service.DiscountCodeService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class DiscountCodeServiceImpl implements DiscountCodeService {

//     @Override
//     public DiscountCode getDiscountCodeById(Long id) {
//         return null;
//     }

//     @Override
//     public DiscountCode updateDiscountCode(Long id, DiscountCode updated) {
//         return null;
//     }

//     @Override
//     public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
//         return null;
//     }

//     @Override
//     public List<DiscountCode> getCodesForCampaign(Long campaignId) {
//         return null;
//     }
// }











package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;
    private final InfluencerRepository influencerRepository;
    private final CampaignRepository campaignRepository;

    public DiscountCodeServiceImpl(
            DiscountCodeRepository discountCodeRepository,
            InfluencerRepository influencerRepository,
            CampaignRepository campaignRepository) {
        this.discountCodeRepository = discountCodeRepository;
        this.influencerRepository = influencerRepository;
        this.campaignRepository = campaignRepository;
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode discountCode) {
        DiscountCode existing = discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        existing.setCodeValue(discountCode.getCodeValue());
        existing.setDiscountPercentage(discountCode.getDiscountPercentage());

        return discountCodeRepository.save(existing);
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        Influencer influencer = influencerRepository.findById(influencerId)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return discountCodeRepository.findByInfluencer(influencer);
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return discountCodeRepository.findByCampaign(campaign);
    }
}
