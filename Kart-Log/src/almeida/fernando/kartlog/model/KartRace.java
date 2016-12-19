package almeida.fernando.kartlog.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class KartRace {

	public static List<KartDriver> getResults(Map<Integer, KartDriver> raceLog) {

		List<KartDriver> drivers = new ArrayList<KartDriver>(raceLog.values());

		Comparator<KartDriver> raceTimeComparator = (KartDriver o1, KartDriver o2) -> o1.getRaceTotalTime()
				.compareTo(o2.getRaceTotalTime());

		Collections.sort(drivers, raceTimeComparator);
		return drivers;
	}
}
