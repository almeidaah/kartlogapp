package almeida.fernando.kartlog.model;

import java.util.ArrayList;
import java.util.List;

public class KartRace {

    private static List<KartDriver> drivers;
    
    public KartRace() {
	drivers = new ArrayList<KartDriver>();
    }
    
    public List<KartDriver> getDrivers() {
	return drivers;
    }
}
