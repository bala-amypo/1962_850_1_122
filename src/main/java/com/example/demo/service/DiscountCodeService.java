// package com.example.demo.service;

// import com.example.demo.model.DiscountCode;
// import java.util.List;

// public interface DiscountCodeService {
//     DiscountCode createDiscountCode(DiscountCode discountCode);

//     DiscountCode getDiscountCodeById(Long id);

//     DiscountCode updateDiscountCode(Long id, DiscountCode updated);

//     List<DiscountCode> getCodesForInfluencer(Long influencerId);

//     List<DiscountCode> getCodesForCampaign(Long campaignId);
// }


// package com.example.demo.service;

// import com.example.demo.model.DiscountCode;
// import java.util.List;

// public interface DiscountCodeService {
//     DiscountCode getDiscountCodeById(Long id);

//     DiscountCode updateDiscountCode(Long id, DiscountCode updated);

//     List<DiscountCode> getCodesForInfluencer(Long influencerId);

//     List<DiscountCode> getCodesForCampaign(Long campaignId);
// }

package com.example.demo.service;
import com.example.demo.model.DiscountCode;
import java.util.List;

public interface DiscountCodeService {
    DiscountCode createDiscountCode(DiscountCode code);
    DiscountCode updateDiscountCode(Long id, DiscountCode code);
    DiscountCode getDiscountCodeById(Long id);
    List<DiscountCode> getCodesForInfluencer(Long influencerId);
    List<DiscountCode> getCodesForCampaign(Long campaignId);
}

