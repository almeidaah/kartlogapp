package almeida.fernando.kartlog.tests;

import java.text.DecimalFormat;
import java.util.Map;

import org.junit.Test;

import almeida.fernando.kartlog.model.KartDriver;
import almeida.fernando.kartlog.reader.KartLogReader;
import junit.framework.TestCase;

public class KartLogTests extends TestCase {
	
	KartLogReader reader = new KartLogReader();
	Map<Integer, KartDriver> raceLog;
	
	@Override
	protected void setUp() throws Exception {
		raceLog = reader.read("corrida_test.log");
	}
	
	//F.MASSA NAME
	@Test
	public void testName(){
		KartDriver driver = raceLog.get(38);
		assertEquals("F.MASSA" , driver.getName());
	}
	
	//RAIKKONEN AVG SPEED
	@Test
	public void testAvgSpeed(){
		KartDriver driver = raceLog.get(2);
		DecimalFormat df = new DecimalFormat("#.00"); 
		
		assertEquals("43,63", df.format(driver.getRaceAvgSpeed()));
	}
	
	//VETTEL BEST LAP
	@Test
	public void testBestLap(){
		KartDriver driver = raceLog.get(11);
		assertEquals(new Integer(3) , driver.getBestLap().getLapNumber());
	}
	
	@Override
	protected void tearDown() throws Exception {
		raceLog = null;
	}

}
