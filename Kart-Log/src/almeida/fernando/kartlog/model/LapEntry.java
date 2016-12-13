package almeida.fernando.kartlog.model;

import java.time.LocalDateTime;

/**
 * @author almeida A class that represents a Driver lap entry
 */
public class LapEntry {
	
	private LocalDateTime hour;
	private Long driverNumber;
	private String driverName;
	private Integer lapNumber;
	private LocalDateTime lapTime;
	private Double avgVelocity;

	public LocalDateTime getHour() {
		return hour;
	}

	public void setHour(LocalDateTime hour) {
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

	public LocalDateTime getLapTime() {
		return lapTime;
	}

	public void setLapTime(LocalDateTime lapTime) {
		this.lapTime = lapTime;
	}

	public Double getAvgVelocity() {
		return avgVelocity;
	}

	public void setAvgVelocity(Double avgVelocity) {
		this.avgVelocity = avgVelocity;
	}

}
