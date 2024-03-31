package com.pma.salarycalculator.using;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HolidayConfiguration {

    private static final Set<LocalDate> HOLIDAYS = new HashSet<>();

    static {
        try {
            String json = new String(Files.readAllBytes(Paths.get("src/main/resources/holidays.json")));
            Holiday[] holidays = new ObjectMapper().readValue(json, Holiday[].class);
            for (Holiday holiday : holidays) {
                HOLIDAYS.add(LocalDate.parse(holiday.getDate()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static boolean isHoliday(LocalDate date) {
        return HOLIDAYS.contains(date);
    }


    private static class Holiday {
        private String date;
        private String name;

        public void setDate(String date) {
            this.date = date;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public String getName() {
            return name;
        }

    }
}


