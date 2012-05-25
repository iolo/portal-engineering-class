package kr.ac.jejuuniv.test;

import kr.ac.jejuuniv.service.WriteService;
import kr.ac.jejuuniv.service.WriteServiceImplement;

import org.junit.Test;

public class WriteServiceTest {
	WriteService writeService;
	
	@Test
	public void WriteTwiitTest() {
		writeService = new WriteServiceImplement();
		writeService.createTwiit("ID", "TWIIT");
		
		
	}
}
