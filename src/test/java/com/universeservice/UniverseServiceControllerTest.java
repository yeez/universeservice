package com.universeservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.universeservice.domain.entity.UniverseEvent;
import com.universeservice.domain.repository.UniverseEventRepository;
import com.universeservice.service.UniverseService;
import com.universeservice.web.UniverseServiceController;

@RunWith(SpringRunner.class)
@WebMvcTest(UniverseServiceController.class)
@EnableJpaRepositories(basePackageClasses=UniverseEventRepository.class)
public class UniverseServiceControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private UniverseService universeService;
	
	private List <UniverseEvent> mockUniverseEventList;

	@Before
    public void setUp() throws Exception {
		
		// setup mock variables
		UniverseEvent event1 = new UniverseEvent(new Integer(9999),"MOCK EVENT NAME 1", "MOCK EVENT TYPE 1", new Double(99999999), 
					new Double(9999), null);
		UniverseEvent event2 = new UniverseEvent(new Integer(8888),"MOCK EVENT NAME 2", "MOCK EVENT TYPE 2", new Double(88888888), 
				new Double(8888), null);
		mockUniverseEventList = new ArrayList<UniverseEvent>();
		mockUniverseEventList.add(event1);
		mockUniverseEventList.add(event2);
    }

    @Test
    public void testPing() throws Exception {
    	Mockito.when(universeService.returnPingTestValue()).thenReturn(mockUniverseEventList);
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/ping").accept(MediaType.APPLICATION_JSON);
    	
    	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    	
    	String expected = "[{id:9999,"
    			+ "eventName:MOCK EVENT NAME 1,"
    			+ "eventType:MOCK EVENT TYPE 1,"
    			+ "eventDistance:99999999,"
    			+ "eventMass:9999,"
    			+ "discoveryDate:null},"
    			+ "{id:8888,"
    			+ "eventName:MOCK EVENT NAME 2,"
    			+ "eventType:MOCK EVENT TYPE 2,"
    			+ "eventDistance:88888888,"
    			+ "eventMass:8888,"
    			+ "discoveryDate:null}]";
    	
    	System.out.println(result.getResponse());
    	
    	JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}
