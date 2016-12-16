package almeida.fernando.kartlog.model;

import java.util.ArrayList;

/**
 * @author fernando.almeida
 * A class that represents a Kart Driver
 */
public class KartDriver{
	
    	private Integer id;
	private ArrayList<LapEntry> driverLaps;

	public KartDriver(Integer id) {
	    super();
	    this.id = id;
	    driverLaps = new ArrayList<>();
	}

	public ArrayList<LapEntry> getDriverLaps() {
		return driverLaps;
	}

	public void setDriverLaps(ArrayList<LapEntry> driverLaps) {
		this.driverLaps = driverLaps;
	}

	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if(obj instanceof KartDriver){
		return this.id.equals(((KartDriver) obj).id);
	    }
	    return false;
	}
	
}
