package io.javabrains.Project.services;

import io.javabrains.Project.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service // spring service
public class CoronaVirusDataService {

    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_US.csv";

    private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
        return allStats;
    }

    @PostConstruct // execute after app starts for spring to know
    @Scheduled(cron = "* * 1 * * *") // runs everyday
    public void fetchVirusData() throws IOException, InterruptedException { // http call to the URL
        List<LocationStats> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient(); // new client
        HttpRequest request =  HttpRequest.newBuilder() // new request
               .uri(URI.create(VIRUS_DATA_URL))
                       .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvBodyReader = new StringReader(httpResponse.body());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.get("Province_State"));
            locationStat.setCountry(record.get("Admin2"));
            int latestCases = Integer.parseInt(record.get(record.size() - 1));
            int prevDayCases = Integer.parseInt(record.get(record.size() - 2));
            int twoDayCases = Integer.parseInt(record.get(record.size() - 3));
            int threeDayCases = Integer.parseInt(record.get(record.size() - 4));
            int fourDayCases = Integer.parseInt(record.get(record.size() - 5));
            int fiveDayCases = Integer.parseInt(record.get(record.size() - 6));
            int sixDayCases = Integer.parseInt(record.get(record.size() - 7));
            locationStat.setLatestTotalCases(latestCases);
            locationStat.setDailyChange(latestCases - prevDayCases);
            locationStat.setPrevDayCases(prevDayCases);
            locationStat.setTwoDaycases(twoDayCases);
            locationStat.setThreeDaycases(threeDayCases);
            locationStat.setFourDaycases(fourDayCases);
            locationStat.setFiveDaycases(fiveDayCases);
            locationStat.setSixDaycases(sixDayCases);
            newStats.add(locationStat);
        }
         this.allStats= newStats;
    }
}
