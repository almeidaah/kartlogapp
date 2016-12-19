package almeida.fernando.kartlog.main;

import java.util.List;
import java.util.Map;

import almeida.fernando.kartlog.model.KartDriver;
import almeida.fernando.kartlog.model.KartRace;
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
		

	}
	
    }

}
