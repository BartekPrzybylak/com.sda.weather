import com.sda.weather.location.Location;
import com.sda.weather.location.LocationRepository;

public class ArtificialLocationRepository implements LocationRepository {
    @Override
    public Location save(Location location) {
        location.setId(1L);
        return location;
    }
}
