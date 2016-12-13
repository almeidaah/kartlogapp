package almeida.fernando.kartlog.model;

import java.util.ArrayList;

/**
 * @author fernando.almeida
 * A class that represents a Kart Driver
 */
public class KartDriver {
	
	private ArrayList<LapEntry> driverLaps;

	public ArrayList<LapEntry> getDriverLaps() {
		return driverLaps;
	}

	public void setDriverLaps(ArrayList<LapEntry> driverLaps) {
		this.driverLaps = driverLaps;
	}
	
	
}
