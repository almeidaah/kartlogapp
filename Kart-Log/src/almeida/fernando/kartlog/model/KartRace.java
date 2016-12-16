package almeida.fernando.kartlog.model;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class KartRace {


    public static KartDriver getWinner(Map<Integer, KartDriver> raceLog){
	
	//KartDriver winner = null;
	Long winnerSeconds = Long.MAX_VALUE;
	
	raceLog.forEach( (id, driver) ->{
	    Long totalDriverTime = driver.getDriverLaps().parallelStream().mapToLong(LapEntry::getLapTime).sum();

	    long totalLapSeconds = TimeUnit.MILLISECONDS.toSeconds(totalDriverTime);

	    System.out.println("Driver : " + driver.getId() + " TOTAL RACETIME IN SECONDS :" + totalLapSeconds);
	    
	    if(totalLapSeconds < winnerSeconds){
		//setting winner to external variable has a problem with java stream
		//winner = driver;
	    }
	    
	});
	
	return null;
    }
}
