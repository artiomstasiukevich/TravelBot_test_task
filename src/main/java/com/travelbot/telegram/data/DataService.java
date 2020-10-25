package com.travelbot.telegram.data;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataService implements DataInterface {
    private static final Map<String, City> COUNTRY_REPOSITORY_MAP = new HashMap<>();

    public DataService() {
    }

    @Override
    public void create(City inform) {
        ;
        COUNTRY_REPOSITORY_MAP.put(inform.getName(), inform);
    }

    @Override
    public String read(String city) {
        return COUNTRY_REPOSITORY_MAP.get(city).getInfo();
    }

    @Override
    public boolean update(String name, City city) {
        if (COUNTRY_REPOSITORY_MAP.containsKey(name) &&
                name.equals(city.getName())) {
            COUNTRY_REPOSITORY_MAP.put(city.getName(), city);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String countryName) {
        return COUNTRY_REPOSITORY_MAP.remove(countryName) != null;
    }
}