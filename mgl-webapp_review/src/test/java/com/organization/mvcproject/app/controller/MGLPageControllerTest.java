package com.organization.mvcproject.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.organization.mvcproject.app.config.MvcConfiguration;

//TODO: figure out how to execute after launch? and remove Ignore
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MvcConfiguration.class)
@WebAppConfiguration
@TestInstance(Lifecycle.PER_CLASS)
class MGLPageControllerTest {
	
	@InjectMocks
	private MGLPageController mglPageController;
	
	@Mock
	private MockMvc mockMvc;
	private AutoCloseable closeable; 

	private static String port;
	
	@BeforeAll
	public void setup() {
		port = System.getProperty("servlet.port", "8081");
		
		// Process mock annotations
       closeable =  MockitoAnnotations.openMocks(this);
        
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(new MGLPageController()).build();
	}
	
	@AfterAll
	public void closeService() throws Exception {
		closeable.close();
	}
	
	@Test
	void testGetIndexPage() throws Exception {
		this.mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}

	@Test
	void homePageBasePathReportsOKStatus() throws IOException {
		HttpURLConnection connection = (HttpURLConnection)new URL("http://localhost:" + port).openConnection();
		{
			connection.connect();
			assertEquals(200, connection.getResponseCode());
		}
	}
	
	@Test
	 void reviewPagePathReportsOKStatus() throws IOException {
		HttpURLConnection connection = (HttpURLConnection)new URL("http://localhost:" + port + "/review" ).openConnection();
		{
			connection.connect();
			assertEquals(200, connection.getResponseCode());
		}
	}
	
	@Test
	 void gamesPagePathReportsOKStatus() throws IOException {
		HttpURLConnection connection = (HttpURLConnection)new URL("http://localhost:" + port + "/games" ).openConnection();
		{
			connection.connect();
			assertEquals(200, connection.getResponseCode());
		}
	}
}
