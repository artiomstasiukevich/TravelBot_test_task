package com.travelbot.telegram.data;

interface DataInterface {
    void create(City city);
    String read(String countryName);
    boolean update(String name, City city);
    public boolean delete(String countryName);
}
