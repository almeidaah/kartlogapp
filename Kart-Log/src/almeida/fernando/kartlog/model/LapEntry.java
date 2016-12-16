package almeida.fernando.kartlog.model;

import java.time.LocalTime;

/**
 * @author almeida A class that represents a Driver lap entry
 */
public class LapEntry {
	
	private LocalTime hour;
	private String driverName;
	private Integer lapNumber;
	private Long lapTime;
	private Double avgSpeed;

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Integer getLapNumber() {
		return lapNumber;
	}

	public void setLapNumber(Integer lapNumber) {
		this.lapNumber = lapNumber;
	}

	public Long getLapTime() {
		return lapTime;
	}

	public void setLapTime(Long lapTime) {
		this.lapTime = lapTime;
	}

	public Double getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(Double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

}
