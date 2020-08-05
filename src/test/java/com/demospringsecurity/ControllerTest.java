package com.demospringsecurity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.demospringsecurity.controller.MyTestController;
import com.demospringsecurity.controller.MyTestControllerImpl;
import com.demospringsecurity.service.TestService;

//@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTest {
	//@Autowired
	//private MyTestController myTestController;
	private MyTestController myTestController = new MyTestControllerImpl();
	private TestService testService = mock(TestService.class);

	@Before
	public void setup() {
		ReflectionTestUtils.setField(myTestController, "testService", testService);
	}

	@Test
	public void testGetNotification() {
		List<String> nots=Arrays.asList("N1","N2","N3");
		when(testService.getNotification()).thenReturn(nots);
		List<String> outFromService = myTestController.getNotification();
		assertNotNull(outFromService);
		assertEquals(3,outFromService.size());
		assertEquals("N2",outFromService.get(1));
	}
}
