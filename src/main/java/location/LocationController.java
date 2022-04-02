package location;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationController {
    private final ObjectMapper objectMapper;
    private final LocationService entryService;

    public LocationController(ObjectMapper objectMapper, LocationService entryService) {
        this.objectMapper = objectMapper;
        this.entryService = entryService;
    }

    public String createLocation(String requestBody) {
        return requestBody;
    }
}
