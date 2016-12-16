package almeida.fernando.kartlog.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import almeida.fernando.kartlog.model.KartDriver;
import almeida.fernando.kartlog.model.LapEntry;

/**
 * KartLogReader - Responsible for reading a data file.
 */
public class KartLogReader {

    private  Map<Integer, KartDriver> raceLog;

    public KartLogReader() {
	   raceLog = new HashMap<>();
    }
    
    public Map<Integer, KartDriver> read(String fileName){

	try {

	    Files.readAllLines(Paths.get(fileName)).forEach(line -> {

		List<String> lstColumns = Arrays.asList(line.split("\\s+"));

		Object[] columns = lstColumns.toArray();

		LapEntry lapEntry = new LapEntry();

		LocalTime hour = LocalTime.parse((CharSequence) columns[0]);
		lapEntry.setHour(hour);

		lapEntry.setDriverName(String.valueOf(columns[3]));

		Integer lapNumber = new Integer((String) columns[4]);
		lapEntry.setLapNumber(lapNumber);

		SimpleDateFormat sdf = new SimpleDateFormat("m:ss.SSS");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date lapTime = null;
		try {
		    lapTime = sdf.parse((String) columns[5]);
		} catch (Exception e) {
		} finally {
		    lapEntry.setLapTime(lapTime.getTime());
		}

		Integer id = new Integer((String) columns[1]);
		KartDriver driver = new KartDriver(id);

		String avgSpeed = ((String) columns[6]).replace(",", ".");
		lapEntry.setAvgSpeed(new Double(avgSpeed));

		if (!raceLog.containsKey(driver.getId())) {
		    driver.getDriverLaps().add(lapEntry);
		    raceLog.put(driver.getId(), driver);
		    //System.out.println("DRIVER : " + driver.getId() + " NAME : " + lapEntry.getDriverName() + " --- ADD");
		
		} else {
		    KartDriver onMapDriver = raceLog.get(driver.getId());
		    onMapDriver.getDriverLaps().add(lapEntry);
		    raceLog.put(onMapDriver.getId() ,onMapDriver);
		    //System.out.println("DRIVER : " + driver.getId() + " NAME : " + lapEntry.getDriverName() + " --- UPDATE");
		}
	    });
	    
	    return raceLog;

	} catch (NumberFormatException | IOException e) {
	    e.printStackTrace();
	}
	
	return null;

    }

}
