package almeida.fernando.kartlog.main;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import almeida.fernando.kartlog.model.KartDriver;
import almeida.fernando.kartlog.model.KartRace;
import almeida.fernando.kartlog.model.LapEntry;
import almeida.fernando.kartlog.reader.KartLogReader;

public class KartLogApp {

    public static void main(String[] args) {
	KartLogReader reader = new KartLogReader();
	Map<Integer, KartDriver> raceLog = reader.read("corrida.log");
	
	List<KartDriver> result= KartRace.getResults(raceLog);
	
	for( int i = 1 ; i <= result.size(); i++){
		
		KartDriver driver = result.get(i-1);
		System.out.println( "Position : " + (i) + " - Driver : " +  driver.getName() + " - Total Time (In Seconds) : " + driver.getRaceTotalTime());
		System.out.println("Completed Laps : " + driver.getDriverLaps().size());
		
		LapEntry bestDriverLap = driver.getBestLap();
		Long bestTimeLap = TimeUnit.MILLISECONDS.toSeconds(bestDriverLap.getLapTime());
		System.out.println("Best LAP : " + bestDriverLap.getLapNumber()  + " -  Time (In Seconds) : " +  bestTimeLap);

		DecimalFormat df = new DecimalFormat("#.00"); 
		System.out.println("Driver AVG Speed : " + df.format(driver.getRaceAvgSpeed()));
		
		
		
	}
	
    }

}
