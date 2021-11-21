package com.organization.mvcproject.app.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.organization.mvcproject.controller.HomeController;

@SpringJUnitConfig(classes = com.organization.mvcproject.config.MGLWebApplicationInitializer.class )
@WebAppConfiguration
@TestInstance(Lifecycle.PER_CLASS)
class MGLPageControllerTest {
	
	private MockMvc mockMvc;

	@BeforeAll
	public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
	}
	
	
	@Test
	void testGetIndexPageReportsOKStatus() throws Exception {
		this.mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}
			
	@Test
	 void reviewCreatePagePathReportsOKStatus() throws Exception {
		fail("Test not yet implemented.");

	}
	
	@Test
	void reviewDetailPagePathReportsOkStatus() throws Exception {
		fail("Test not yet implemented.");
	}
	
	@Test
	 void gamesPagePathReportsOKStatus() throws Exception {
		fail("Test not yet implemented.");
	}
}
