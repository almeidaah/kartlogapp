package almeida.fernando.kartlog.model;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.concurrent.TimeUnit;

/**
 * @author fernando.almeida A class that represents a Kart Driver
 */
public class KartDriver {

	private Integer id;
	private String name;

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
		if (obj instanceof KartDriver) {
			return this.id.equals(((KartDriver) obj).id);
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String driverName) {
		this.name = driverName;
	}

	public Long getRaceTotalTime() {
		Long totalDriverTime = this.getDriverLaps().parallelStream().mapToLong(LapEntry::getLapTime).sum();
		return TimeUnit.MILLISECONDS.toSeconds(totalDriverTime);
	}

	public LapEntry getBestLap() {

		LapEntry bestDriverLap = null;
		Long bestTime = Long.MAX_VALUE;

		for (LapEntry lap : this.getDriverLaps()) {
			Long lapTime = TimeUnit.MILLISECONDS.toSeconds(lap.getLapTime());
			if (lapTime < bestTime) {
				bestDriverLap = lap;
				bestTime = lapTime;
			}
		}

		return bestDriverLap;
	}

	public Double getRaceAvgSpeed() {
		OptionalDouble optDouble = this.getDriverLaps().parallelStream().mapToDouble(LapEntry::getAvgSpeed).average();
		return optDouble.getAsDouble();
	}

}
