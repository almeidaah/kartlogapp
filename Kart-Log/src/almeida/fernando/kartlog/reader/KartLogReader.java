package almeida.fernando.kartlog.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import almeida.fernando.kartlog.model.KartDriver;
import almeida.fernando.kartlog.model.LapEntry;

/**
 * KartLogReader - Responsible for reading a data file.
 */
public class KartLogReader {

    public KartLogReader(String fileName) {

	try {

	    Files.readAllLines(Paths.get(fileName)).forEach(line -> {
		List<String> lstColumns = Arrays.asList(line.split("\\s+"));

		Object[] columns = lstColumns.toArray();

		LapEntry lap = new LapEntry();

		LocalTime hour = LocalTime.parse((CharSequence) columns[0]);
		lap.setHour(hour);

		lap.setDriverName(String.valueOf(columns[3]));

		Integer lapNumber = new Integer((String) columns[4]);
		lap.setLapNumber(lapNumber);
		
		/*
		 * Here want to get Time in Minutes(m:ss.sss) but donf find an Java8 implementation for that
		 */
		
		
		Integer id = new Integer((String) columns[1]);
		KartDriver driver = new KartDriver(id);

		String avgSpeed = ((String)columns[6]).replace(",", ".");
		lap.setAvgSpeed(new Double(avgSpeed));

	    });
	} catch (NumberFormatException | IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
