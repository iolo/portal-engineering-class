package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class HomeControllerTest {
	HomeController homeController;
	
	@Test
	public void testAction() {
		homeController = new HomeController();
		String returnViewName =  homeController.action();
		assertThat(returnViewName, is("/login"));
	}
}
