package almeida.fernando.kartlog.model;

import java.time.Duration;
import java.time.LocalTime;

/**
 * @author almeida A class that represents a Driver lap entry
 */
public class LapEntry {
	
	private LocalTime hour;
	private Long driverNumber;
	private String driverName;
	private Integer lapNumber;
	private Duration lapTime;
	private Double avgSpeed;

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public Long getDriverNumber() {
		return driverNumber;
	}

	public void setDriverNumber(Long driverNumber) {
		this.driverNumber = driverNumber;
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

	public Duration getLapTime() {
		return lapTime;
	}

	public void setLapTime(Duration lapTime) {
		this.lapTime = lapTime;
	}

	public Double getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(Double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

}
