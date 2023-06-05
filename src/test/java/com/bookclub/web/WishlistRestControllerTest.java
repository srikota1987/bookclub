package com.bookclub.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;



import com.bookclub.SampleApplication;
import com.bookclub.model.WishlistItem;
import com.bookclub.security.SecurityConfig;
import com.bookclub.service.dao.WishlistDao;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleApplication.class)
@AutoConfigureMockMvc(addFilters=false)
@Import(SecurityConfig.class)
public class WishlistRestControllerTest {
 
	@Autowired
	protected MockMvc mvc;
	   
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@MockBean
	WishlistDao wishlistDao;
	
	@MockBean
	Authentication authentication;


	
	@Test
	
	public void getWishList() throws Exception {
	 //  mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   String uri = "/wishlist/1364697429";
	   
	   WishlistItem item1 = new WishlistItem("7548965", "Widget Name");
	
       doReturn(item1).when(wishlistDao).find("1364697429");
	   
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	  
	   
	  
	}
	
	@Test
	
	public void showWishList() throws Exception {
	 
	   String uri = "/wishlist";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	  
	}
	
	
	
	
} 
  

