package com.enciu.rohighwaypulse.service;

import com.enciu.rohighwaypulse.dto.HighwayPreviewDTO;
import com.enciu.rohighwaypulse.dto.HighwayScheduleDTO;
import com.enciu.rohighwaypulse.module.Highway;
import com.enciu.rohighwaypulse.repository.HighwayRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class HighwayServiceImpl implements HighwayService {
    @Autowired
    private HighwayRepository highwayRepository;

    @Override
    public List<HighwayPreviewDTO> getHighwaysPreviews() {
        List<Highway> highways = highwayRepository.findAll();
        return highways
                .stream()
                .map(highway -> new HighwayPreviewDTO(
                        highway.getName(),
                        highway.getLength(),
                        highway.getStartCity(),
                        highway.getEndCity()))
                .toList();
    }

    @Override
    public Highway getHighway(String name) {
        return highwayRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Map<Integer, List<HighwayScheduleDTO>> fetchCalendar() {
        Map<Integer, List<HighwayScheduleDTO>> result = new HashMap<>();
        try {
            Document doc = Jsoup.connect("https://www.130km.ro/calendar.html").get();
            Elements tables = doc.select("table[width=540]");
            Elements rows = tables.select("tr");
            Integer currentYear = null;

            for (Element row : rows) {
                Elements cols = row.select("td");
                Element yearCell = cols.first();
                if (yearCell != null) {
                    try {
                        currentYear = Integer.parseInt(yearCell.text().trim());

                    } catch (NumberFormatException e) {
                        currentYear = null;
                    }
                }
                if (currentYear != null && cols.size() > 2) {
                    Element segmentCell = cols.get(1);
                    String segment = segmentCell.text().trim();
                    double lungimeKm = parseLungime(cols.get(3).text());

                    HighwayScheduleDTO dto = new HighwayScheduleDTO(segment, lungimeKm, currentYear);
                    result.computeIfAbsent(currentYear, k -> new ArrayList<>()).add(dto);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private double parseLungime(String text) {
        try {
            return Double.parseDouble(text.replace("km", "").replace(",", ".").trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
