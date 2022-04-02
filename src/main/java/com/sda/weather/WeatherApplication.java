package com.sda.weather;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class WeatherApplication {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

//        ObjectMapper objectMapper = new ObjectMapper();
//        LocationRepository locationRepository = new LocationRepositoryImpl(sessionFactory);
//        EntryService entryService = new EntryService(entryRepository, objectMapper);
//        EntryController entryController = new EntryController(objectMapper, entryService);
        UserInterface userInterface = new UserInterface(entryController);

        UserInterface.run();
    }
}

/**
 *         ObjectMapper objectMapper = new ObjectMapper();
 *         LocationService locationService = new LocationService();
 *         LocationController locationController = new LocationController(objectMapper, locationService);
 *         UserInterface userInterface = new UserInterface(locationController);
 *         userInterface.run();
 */