package com.sda.weather.location;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String country;
    private String region;
    private long longitude;
    private long latitude;

    public Location(String city, String country, String region, long longitude, long latitude) {
        this.city = city;
        this.country = country;
        this.region = region;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
