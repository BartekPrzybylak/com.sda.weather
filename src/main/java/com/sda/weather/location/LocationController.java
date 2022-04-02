package com.sda.weather.location;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationController {

    private final ObjectMapper objectMapper;
    private final LocationService locationService;

    public LocationController(ObjectMapper objectMapper, LocationService locationService) {
        this.objectMapper = objectMapper;
        this.locationService = locationService;
    }


    public String createLocation(String json) {
        try {
            LocationDTO requestBody = objectMapper.readValue(json, LocationDTO.class);
            String city = requestBody.getCity();
            String region = requestBody.getRegion();
            String country = requestBody.getCountry();
            Long latitude = requestBody.getLatitude();
            Long longitude = requestBody.getLongitude();

            Location savedLocation = locationService.createLocation(city, country, region, latitude, longitude);

            LocationDTO locationDTO = mapToLocationDTO(savedLocation);
            String serializedLocationDTO = objectMapper.writeValueAsString(locationDTO);

            return serializedLocationDTO;

        } catch (JsonProcessingException e) {
           return String.format("error: %s", e.getMessage());
        }
    }

    private LocationDTO mapToLocationDTO(Location savedLocation) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(savedLocation.getId());
        locationDTO.setCity(savedLocation.getCity());
        locationDTO.setLongitude(savedLocation.getLongitude());
        locationDTO.setLatitude(savedLocation.getLatitude());
        locationDTO.setRegion(savedLocation.getRegion());
        locationDTO.setCountry(savedLocation.getCountry());
        return locationDTO;
    }

}
