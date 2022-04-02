package location;

import lombok.Data;

@Data
public class LocationDTO {
    private Long id;
    private String city;
    private String region;
    private String Country;
    private Long latitude;
    private Long longitude;
}
