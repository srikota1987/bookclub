package com.bookclub.web;

import static org.junit.Assert.assertNotNull;



import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.bookclub.SampleApplication;
import com.bookclub.model.Book;
import com.bookclub.security.SecurityConfig;
import com.bookclub.service.impl.RestBookDao;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleApplication.class)
@AutoConfigureMockMvc(addFilters=false)
@Import(SecurityConfig.class)

public class RestBookDaoTest {
	
	@InjectMocks
	protected RestBookDao restBookDao;
	
	
	
	
	
	@Test
	public void find() throws Exception {

		
		Book result = restBookDao.find("9780593099322");
	   

	   assertNotNull(result.getIsbn());
	   assertNotNull(result.getNumOfPages());
	   assertNotNull(result.getTitle());
	  
	}
	
	@Test
	public void list() throws Exception {

		
		List<Book> result = restBookDao.list();
	   

	   assertNotNull(result.size());
	  
	}
}
