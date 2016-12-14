package almeida.fernando.kartlog.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import almeida.fernando.kartlog.model.KartDriver;
import almeida.fernando.kartlog.model.KartRace;
import almeida.fernando.kartlog.model.LapEntry;

/**
 * KartLogReader - Responsible for reading a data file.
 */
public class KartLogReader {

	public KartLogReader(String fileName) {
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
		    
		    //If want to print the list
		    //  stream.forEach(System.out::println);

		    KartRace kartRace = new KartRace();
		    
		    //Reading all lines and split into Object
		    for(String line : Files.readAllLines(Paths.get(fileName))){
			
			List<String> columns2 = Arrays.asList(line.split("\\s+"));
			
			Object[] columns = columns2.toArray();
			System.out.println(columns[0]);
			
			LapEntry lap = new LapEntry();

			LocalTime hour = LocalTime.parse((CharSequence) columns[0]);
			lap.setHour(hour);
			
			KartDriver driver = new KartDriver((Integer)columns[1]);
			
			lap.setDriverName(String.valueOf(columns[3]));
			lap.setLapNumber((Integer)columns[4]);
			
			//Duration lap
			//lap.setLapTime(Duration.of);
			//Duration.of((Long)columns[5], TemporalUnit)colu
			Duration dur = Duration.ofMinutes((Long)columns[5]);
			System.out.println(dur);
			

			
			
			//lap.setLapTime();
			
			System.out.println(columns2);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
