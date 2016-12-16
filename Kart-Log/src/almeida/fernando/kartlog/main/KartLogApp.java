package almeida.fernando.kartlog.main;

import java.util.Map;

import almeida.fernando.kartlog.model.KartDriver;
import almeida.fernando.kartlog.model.KartRace;
import almeida.fernando.kartlog.reader.KartLogReader;

public class KartLogApp {

    public static void main(String[] args) {
	KartLogReader reader = new KartLogReader();
	Map<Integer, KartDriver> raceLog = reader.read("corrida.log");
	
	KartDriver winner = KartRace.getWinner(raceLog);
	
    }

}
