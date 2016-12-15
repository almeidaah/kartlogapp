package almeida.fernando.kartlog.main;

import almeida.fernando.kartlog.model.KartRace;
import almeida.fernando.kartlog.reader.KartLogReader;

public class KartLogApp {

	public static void main(String[] args) {
	    	
	    	KartRace race = new KartRace();
		KartLogReader reader = new KartLogReader(race.getDrivers(), "corrida.log");
	}

}
