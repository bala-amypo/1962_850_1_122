// package com.example.demo.controller;

// import com.example.demo.model.DiscountCode;
// import com.example.demo.service.DiscountCodeService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/discount-codes")
// public class DiscountCodeController {

//     private final DiscountCodeService discountCodeService;

//     public DiscountCodeController(DiscountCodeService discountCodeService) {
//         this.discountCodeService = discountCodeService;
//     }

//     @PostMapping
//     public ResponseEntity<DiscountCode> createDiscountCode(@RequestBody DiscountCode discountCode) {
//         DiscountCode created = discountCodeService.createDiscountCode(discountCode);
//         return ResponseEntity.ok(created);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<DiscountCode> getDiscountCodeById(@PathVariable Long id) {
//         DiscountCode code = discountCodeService.getDiscountCodeById(id);
//         return ResponseEntity.ok(code);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<DiscountCode> updateDiscountCode(@PathVariable Long id, @RequestBody DiscountCode updated) {
//         DiscountCode code = discountCodeService.updateDiscountCode(id, updated);
//         return ResponseEntity.ok(code);
//     }

//     @GetMapping("/influencer/{influencerId}")
//     public ResponseEntity<List<DiscountCode>> getCodesForInfluencer(@PathVariable Long influencerId) {
//         List<DiscountCode> codes = discountCodeService.getCodesForInfluencer(influencerId);
//         return ResponseEntity.ok(codes);
//     }

//     @GetMapping("/campaign/{campaignId}")
//     public ResponseEntity<List<DiscountCode>> getCodesForCampaign(@PathVariable Long campaignId) {
//         List<DiscountCode> codes = discountCodeService.getCodesForCampaign(campaignId);
//         return ResponseEntity.ok(codes);
//     }
// }
// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).



// package com.example.demo.controller;

// import com.example.demo.model.DiscountCode;
// import com.example.demo.service.DiscountCodeService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/discount-codes")
// public class DiscountCodeController {

//     private final DiscountCodeService discountCodeService;

//     @Autowired
//     public DiscountCodeController(DiscountCodeService discountCodeService) {
//         this.discountCodeService = discountCodeService;
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<DiscountCode> getDiscountCode(@PathVariable Long id) {
//         return ResponseEntity.ok(discountCodeService.getDiscountCodeById(id));
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<DiscountCode> updateDiscountCode(@PathVariable Long id,
//             @RequestBody DiscountCode discountCode) {
//         return ResponseEntity.ok(discountCodeService.updateDiscountCode(id, discountCode));
//     }

//     @GetMapping("/influencer/{influencerId}")
//     public ResponseEntity<List<DiscountCode>> getCodesForInfluencer(@PathVariable Long influencerId) {
//         return ResponseEntity.ok(discountCodeService.getCodesForInfluencer(influencerId));
//     }

//     @GetMapping("/campaign/{campaignId}")
//     public ResponseEntity<List<DiscountCode>> getCodesForCampaign(@PathVariable Long campaignId) {
//         return ResponseEntity.ok(discountCodeService.getCodesForCampaign(campaignId));
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getDiscountCode(@PathVariable Long id) {
        return ResponseEntity.ok(discountCodeService.getDiscountCodeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> updateDiscountCode(
            @PathVariable Long id,
            @RequestBody DiscountCode updated) {
        return ResponseEntity.ok(discountCodeService.updateDiscountCode(id, updated));
    }

    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<DiscountCode>> getCodesForInfluencer(
            @PathVariable Long influencerId) {
        return ResponseEntity.ok(discountCodeService.getCodesForInfluencer(influencerId));
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<DiscountCode>> getCodesForCampaign(
            @PathVariable Long campaignId) {
        return ResponseEntity.ok(discountCodeService.getCodesForCampaign(campaignId));
    }
}
