package com.demospringsecurity;

import com.demospringsecurity.controller.MyTestController;
import com.demospringsecurity.service.TestService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

public class ControllerTest {
	private MyTestController myTestController;
	private TestService testService = mock(TestService.class);

	@Before
	public void setup() {

	}

	@Test
	public void testGetNotification() {
		List<String> nots=Arrays.asList("N1","N2","N3");
		when(testService.getNotification()).thenReturn(nots);
		List<String> outFromService = testService.getNotification();
		assertNotNull(outFromService);
		assertEquals(3,outFromService.size());
		assertEquals("N2",outFromService.get(1));
	}
}
