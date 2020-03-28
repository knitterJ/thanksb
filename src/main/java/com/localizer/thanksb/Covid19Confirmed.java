package com.localizer.thanksb;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class Covid19Confirmed {

    private static final String COVID_CONFIRMED_URL =
            "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    private DataRepo dataRepo;

    public Covid19Confirmed(DataRepo dataRepo) {
        this.dataRepo = dataRepo;

    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String values = restTemplate.getForObject(COVID_CONFIRMED_URL, String.class);
        System.out.println(values);

        StringReader stringReader = new StringReader(values);
        CSVParser parse = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);

//        List<Point> points = new ArrayList<>();

        for (CSVRecord strings: parse){
            double lat = Double.parseDouble(strings.get("Lat"));
            double lon = Double.parseDouble(strings.get("Long"));
            String text = strings.get("3/15/20");
            dataRepo.addPoint(new Point(lat,lon, text));
//            points.add(new Point(lat,lon, text));
        }
//        points.forEach(System.out::println);



//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(COVID_CONFIRMED_URL)).build();
//
//        HttpResponse<String> request =  httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//        System.out.println(request.body());


    }

}
