package com.sda.weather.location;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class LocationService {

    private final LocationRepository locationRepository;
    private final ObjectMapper objectMapper;

    public LocationService(LocationRepository locationRepository, ObjectMapper objectMapper) {
        this.locationRepository = locationRepository;
        this.objectMapper = objectMapper;
    }

    public Location createLocation(String city, String country, String region, long longitude, long latitude) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("city cannot be null");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("country cannot be null");
        }
        if (region == null || region.isBlank()) {
            throw new IllegalArgumentException("region cannot be null");
        }
        if (longitude < 0 || longitude > 180) {
            throw new IllegalArgumentException("longitude must be between 0 and 180");
        }
        if (latitude < 0 || latitude > 180) {
            throw new IllegalArgumentException("latitude must be between 0 and 180");
        }

        Location location = new Location(city, country, region, longitude, latitude);

        Location savedLocation = locationRepository.save(location);
        return savedLocation;
    }

//    public List<Location> getLocations() {
//        locationRepository.findAll()
//        return List<Location>;
//    }
    //todo
}
