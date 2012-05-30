package kr.ac.jejuuniv.test;

import kr.ac.jejuuniv.service.TwittService;
import kr.ac.jejuuniv.service.TwittServiceImplement;

import org.junit.Test;

public class WriteServiceTest {
	TwittService writeService;
	
	@Test
	public void WriteTwiitTest() {
		writeService = new TwittServiceImplement();
		writeService.createTwiit("ID", "TWIIT");
		
		
	}
}
