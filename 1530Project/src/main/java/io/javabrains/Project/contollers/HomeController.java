package io.javabrains.Project.contollers;

import io.javabrains.Project.models.LocationStats;
import io.javabrains.Project.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int prevReportedCases = allStats.stream().mapToInt(stat -> stat.getPrevDayCases()).sum();
        int twoDaysReportedCases = allStats.stream().mapToInt(stat -> stat.getTwoDaycases()).sum();
        int threeReportedCases = allStats.stream().mapToInt(stat -> stat.getThreeDaycases()).sum();
        int fourReportedCases = allStats.stream().mapToInt(stat -> stat.getFourDaycases()).sum();
        int fiveReportedCases = allStats.stream().mapToInt(stat -> stat.getFiveDaycases()).sum();
        int sixReportedCases = allStats.stream().mapToInt(stat -> stat.getSixDaycases()).sum();
        Object[] seven_day_cases = allStats.stream().map(stat -> stat.getSeverDayCases()).toArray();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDailyChange()).sum();
        //int previousDay = allStats.stream().mapToInt()
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        model.addAttribute("sevenDays",seven_day_cases);
        model.addAttribute("previousDay",prevReportedCases);
        model.addAttribute("twoDay",twoDaysReportedCases);
        model.addAttribute("threeDay",threeReportedCases);
        model.addAttribute("fourDay",fourReportedCases);
        model.addAttribute("fiveDay",fiveReportedCases);
        model.addAttribute("sixDay",sixReportedCases);
        return "home";
    }
}
