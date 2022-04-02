import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.location.Location;
import com.sda.weather.location.LocationRepository;

import com.sda.weather.location.LocationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LocationServiceTest {


    LocationService locationService;

    @BeforeEach
    void preparation() {

        LocationRepository locationRepository = new ArtificialLocationRepository();
        ObjectMapper objectMapper = new ObjectMapper();
        locationService = new LocationService(locationRepository, objectMapper);
    }

    @Test
    void createLocationWhenAllInputDataIsCorrect() {
        //when
        Location expectedResult = locationService.createLocation("FakeCity", "FakeCountry", "FakeRegion", 6, 8);
        //then
        assertThat(expectedResult.getId()).isNotNull();
        assertThat(expectedResult.getCity()).isEqualTo("FakeCity");
        assertThat(expectedResult.getCountry()).isEqualTo("FakeCountry");
        assertThat(expectedResult.getRegion()).isEqualTo("FakeRegion");
        assertThat(expectedResult.getLatitude()).isEqualTo(8L);
        assertThat(expectedResult.getLongitude()).isEqualTo(6L);

    }
}
