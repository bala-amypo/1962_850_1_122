// package com.example.demo.service;

// import com.example.demo.model.RoiReport;
// import java.util.List;

// public interface RoiService {
//     RoiReport generateReportForCode(Long discountCodeId);

//     RoiReport getReportById(Long reportId);

//     List<RoiReport> getReportsForInfluencer(Long influencerId);
// }

// package com.example.demo.service;

// import com.example.demo.model.RoiReport;
// import java.util.List;

// public interface RoiService {
//     RoiReport generateReportForCode(Long discountCodeId);

//     RoiReport getReportById(Long reportId);

//     List<RoiReport> getReportsForInfluencer(Long influencerId);
// }


package com.example.demo.service;
import com.example.demo.model.RoiReport;
import java.util.List;

public interface RoiService {
    RoiReport generateRoiReport(Long discountCodeId);
    List<RoiReport> getReportsForInfluencer(Long influencerId);
}
