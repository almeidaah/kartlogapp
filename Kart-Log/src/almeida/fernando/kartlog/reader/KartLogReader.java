package almeida.fernando.kartlog.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import almeida.fernando.kartlog.model.KartDriver;
import almeida.fernando.kartlog.model.LapEntry;

/**
 * KartLogReader - Responsible for reading a data file.
 */
public class KartLogReader {

    public KartLogReader(List<KartDriver> drivers, String fileName) {

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
		
		SimpleDateFormat sdf = new SimpleDateFormat("m:ss.SSS");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date lapTime = null;
		try {
		    lapTime = sdf.parse((String)columns[5]);
		} catch (Exception e) {
		}finally {
		    lap.setLapTime(lapTime.getTime());
		}
		        
		Integer id = new Integer((String) columns[1]);
		KartDriver driver = new KartDriver(id);

		String avgSpeed = ((String)columns[6]).replace(",", ".");
		lap.setAvgSpeed(new Double(avgSpeed));
		
		//KartDriver d = drivers.get(driver.getId());
		driver.getDriverLaps().add(lap);
		drivers.add(driver);
		
//		if(drivers.contains(driver)){
//		    driver.getDriverLaps().add(lap);
//		}else{
//		    drivers.add(driver);
//		}
		

	    });
	    
		drivers.stream().forEach(d -> System.out.println("ID : " + d.getId()));

	} catch (NumberFormatException | IOException e) {
	    e.printStackTrace();
	}

    }

}
