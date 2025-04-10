package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Publication {
    private static final Random rand = new Random();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");

    public static String generate() {
        int stationId = rand.nextInt(Config.MAX_STATION_ID);
        String city = Config.CITY_VALUES.get(rand.nextInt(Config.CITY_VALUES.size()));
        int temp = rand.nextInt(Config.MAX_TEMP); // 0–49
        double rain = Math.round((Config.RAIN_MIN + rand.nextDouble() * (Config.RAIN_MAX - Config.RAIN_MIN)) * 10.0) / 10.0;
        int wind = rand.nextInt(Config.MAX_WIND); // 0–149
        String direction = Config.DIRECTION_VALUES.get(rand.nextInt(Config.DIRECTION_VALUES.size()));
        LocalDate date = LocalDate.now().minusDays(rand.nextInt(Config.DAYS_DIFF));
        return String.format("{(stationid,%d);(city,\"%s\");(temp,%d);(rain,%.1f);(wind,%d);(direction,\"%s\");(date,%s)}",
                stationId, city, temp, rain, wind, direction, date.format(formatter));
    }
}

