package servicio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Spy;

import modelo.Player;

/**
 * Test del ServicesDuel.
 * @author Florencia
 */
public class ServicesDuelTest {

	@Spy
	private ServicesDuel service = new ServicesDuel();
	
	@Test
	public void compareQualityTestCaseA() {
		int result = service.compareQuality(250, 250);
		
		assertEquals(0, result);			
	}
	@Test
	public void compareQualityTestCaseB() {
		int result = service.compareQuality(200, 150);
		
		assertEquals(1, result);		
	}
	@Test
	public void compareQualityTestCaseC() {
		int result = service.compareQuality(20, 80);
		
		assertEquals(2, result);		
	}
	
	@Test
	public void compareScoreTestCaseA() {
		Player player1 = new Player();
		Player player2 = new Player();
		player1.setScore(0);
		player2.setScore(0);
		int result = service.compareScore(player1, player2);
		
		assertEquals(0, result);		
	}	
	@Test
	public void compareScoreTestCaseB() {
		Player player1 = new Player();
		Player player2 = new Player();
		player1.setScore(2);
		player2.setScore(1);
		int result = service.compareScore(player1, player2);
		
		assertEquals(1, result);		
	}	
	@Test
	public void compareScoreTestCaseC() {
		Player player1 = new Player();
		Player player2 = new Player();
		player1.setScore(1);
		player2.setScore(2);
		int result = service.compareScore(player1, player2);
		
		assertEquals(2, result);		
	}
}
