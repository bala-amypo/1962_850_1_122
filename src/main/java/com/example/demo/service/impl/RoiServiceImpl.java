// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.DiscountCode;
// import com.example.demo.model.RoiReport;
// import com.example.demo.model.SaleTransaction;
// import com.example.demo.repository.DiscountCodeRepository;
// import com.example.demo.repository.RoiReportRepository;
// import com.example.demo.repository.SaleTransactionRepository;
// import com.example.demo.service.RoiService;
// import org.springframework.stereotype.Service;

// import java.math.BigDecimal;
// import java.util.List;

// @Service
// public class RoiServiceImpl implements RoiService {

//     private final RoiReportRepository roiReportRepository;
//     private final SaleTransactionRepository saleTransactionRepository;
//     private final DiscountCodeRepository discountCodeRepository;

//     public RoiServiceImpl(RoiReportRepository roiReportRepository,
//             SaleTransactionRepository saleTransactionRepository,
//             DiscountCodeRepository discountCodeRepository) {
//         this.roiReportRepository = roiReportRepository;
//         this.saleTransactionRepository = saleTransactionRepository;
//         this.discountCodeRepository = discountCodeRepository;
//     }

//     @Override
//     public RoiReport generateReportForCode(Long discountCodeId) {
//         DiscountCode code = discountCodeRepository.findById(discountCodeId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

//         List<SaleTransaction> sales = saleTransactionRepository.findByDiscountCodeId(discountCodeId);

//         BigDecimal totalSales = sales.stream()
//                 .map(SaleTransaction::getTransactionAmount)
//                 .reduce(BigDecimal.ZERO, BigDecimal::add);

//         Integer totalTransactions = sales.size();

//         Double roiPercentage = 0.0;
//         if (code.getDiscountPercentage() != null && totalSales.compareTo(BigDecimal.ZERO) > 0) {
//             // ROI = (totalSales * discountPercentage) / 100
//             roiPercentage = totalSales.multiply(BigDecimal.valueOf(code.getDiscountPercentage()))
//                     .divide(BigDecimal.valueOf(100), 2, java.math.RoundingMode.HALF_UP)
//                     .doubleValue();
//         }

//         RoiReport report = new RoiReport(code, totalSales, totalTransactions, roiPercentage);
//         return roiReportRepository.save(report);
//     }

//     @Override
//     public RoiReport getReportById(Long reportId) {
//         return roiReportRepository.findById(reportId)
//                 .orElseThrow(() -> new ResourceNotFoundException("ROI report not found"));
//     }

//     @Override
//     public List<RoiReport> getReportsForInfluencer(Long influencerId) {
//         return roiReportRepository.findByDiscountCodeInfluencerId(influencerId);
//     }
// }




// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.DiscountCode;
// import com.example.demo.model.RoiReport;
// import com.example.demo.model.SaleTransaction;
// import com.example.demo.repository.DiscountCodeRepository;
// import com.example.demo.repository.RoiReportRepository;
// import com.example.demo.repository.SaleTransactionRepository;
// import com.example.demo.service.RoiService;
// import org.springframework.stereotype.Service;

// import java.math.BigDecimal;
// import java.util.List;

// @Service
// public class RoiServiceImpl implements RoiService {

//     private final RoiReportRepository roiReportRepository;
//     private final SaleTransactionRepository saleTransactionRepository;
//     private final DiscountCodeRepository discountCodeRepository;

//     public RoiServiceImpl(RoiReportRepository roiReportRepository,
//                          SaleTransactionRepository saleTransactionRepository,
//                          DiscountCodeRepository discountCodeRepository) {
//         this.roiReportRepository = roiReportRepository;
//         this.saleTransactionRepository = saleTransactionRepository;
//         this.discountCodeRepository = discountCodeRepository;
//     }

//     @Override
//     public RoiReport generateReportForCode(Long discountCodeId) {
//         DiscountCode discountCode = discountCodeRepository.findById(discountCodeId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));
        
//         List<SaleTransaction> sales = saleTransactionRepository.findByDiscountCodeId(discountCodeId);
        
//         BigDecimal totalSales = sales.stream()
//                 .map(SaleTransaction::getTransactionAmount)
//                 .reduce(BigDecimal.ZERO, BigDecimal::add);
        
//         Integer totalTransactions = sales.size();
        
//         // Simple ROI calculation - can be customized based on business logic
//         Double roiPercentage = totalSales.doubleValue() * 0.1; // 10% of total sales as ROI
        
//         RoiReport report = new RoiReport(discountCode, totalSales, totalTransactions, roiPercentage);
//         return roiReportRepository.save(report);
//     }

//     @Override
//     public RoiReport getReportById(Long reportId) {
//         return roiReportRepository.findById(reportId)
//                 .orElseThrow(() -> new ResourceNotFoundException("ROI report not found"));
//     }

//     @Override
//     public List<RoiReport> getReportsForInfluencer(Long influencerId) {
//         return roiReportRepository.findByDiscountCodeInfluencerId(influencerId);
//     }
// }










// package com.example.demo.service.impl;

// import com.example.demo.model.RoiReport;
// import com.example.demo.service.RoiService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class RoiServiceImpl implements RoiService {

//     @Override
//     public RoiReport generateReportForCode(Long discountCodeId) {
//         return null;
//     }

//     @Override
//     public RoiReport getReportById(Long reportId) {
//         return null;
//     }

//     @Override
//     public List<RoiReport> getReportsForInfluencer(Long influencerId) {
//         return null;
//     }
// }




package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.model.RoiReport;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;

    public RoiServiceImpl(SaleTransactionRepository saleTransactionRepository,
                          DiscountCodeRepository discountCodeRepository) {
        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    /**
     * Generate ROI report for a single discount code
     */
    @Override
    public RoiReport generateReportForCode(Long discountCodeId) {

        DiscountCode discountCode = discountCodeRepository.findById(discountCodeId)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        BigDecimal totalSales =
                saleTransactionRepository.totalSales(discountCodeId);

        Integer totalTransactions =
                saleTransactionRepository.totalTransactions(discountCodeId);

        double cost = discountCode.getCost() == null ? 0 : discountCode.getCost();

        double roiPercentage = cost == 0
                ? 0
                : ((totalSales.doubleValue() - cost) / cost) * 100;

        return new RoiReport(
                discountCode,
                totalSales,
                totalTransactions,
                roiPercentage
        );
    }

    /**
     * ROI Report is NOT stored in DB, so this is NOT supported
     */
    @Override
    public RoiReport getReportById(Long reportId) {
        throw new UnsupportedOperationException(
                "ROI Report is computed dynamically and not stored in database"
        );
    }

    /**
     * Generate ROI reports for all discount codes of an influencer
     */
    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {

        List<DiscountCode> discountCodes =
                discountCodeRepository.findByInfluencerId(influencerId);

        List<RoiReport> reports = new ArrayList<>();

        for (DiscountCode code : discountCodes) {

            BigDecimal totalSales =
                    saleTransactionRepository.totalSales(code.getId());

            Integer totalTransactions =
                    saleTransactionRepository.totalTransactions(code.getId());

            double cost = code.getCost() == null ? 0 : code.getCost();

            double roi = cost == 0
                    ? 0
                    : ((totalSales.doubleValue() - cost) / cost) * 100;

            reports.add(new RoiReport(
                    code,
                    totalSales,
                    totalTransactions,
                    roi
            ));
        }

        return reports;
    }
}
