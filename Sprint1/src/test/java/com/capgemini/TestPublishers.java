package com.capgemini;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.lms.dao.PublisherDao;
import com.capgemini.lms.entities.Publishers;

import com.capgemini.lms.service.PublisherService;

/******************************************************************************************************************
 * @author Rakshit Singh
 * Description: This is the JUNIT class for Publishers module. 
 * Created Date: 26 April, 2021 
 * Version : v1.1.0
 *****************************************************************************************************************/

@SpringBootTest
class TestPublishers {
		
	@Autowired
	PublisherService publisherService;

	@Autowired
	PublisherDao publisherDao;

	@Test
	void testAddPublishers() {
		Publishers p=new Publishers(1000, "Varthur",	"Marathalli",	"Bangalore",	"2981323",	"lpm@xyz.com",	561100, "River", "Karnataka");
		assertEquals("Bangalore",publisherService.addPublisher(p).getCity());
	}
	
	
	
	@Test
	void testUpdatePublisher() {
		Publishers p2= publisherDao.findById(103).get();
		p2.setPincode(560032);;
		publisherService.updatePublisherDetails(p2);
		assertEquals(560032,publisherService.viewPublisherById(103).get().getPincode());	
	}
	
	
	@Test
	void testGetAllPublishers() {
		List<Publishers> p3=publisherService.viewPublishersList();
	
		List< Publishers> expectedPublishers= new ArrayList<Publishers>();
		expectedPublishers.add(publisherDao.findById(103).get());
		expectedPublishers.add(publisherDao.findById(92).get());
//		expectedBooksOrders.add(booksOrderDao.findById(78).get());
		expectedPublishers.add(publisherDao.findById(101).get());
		expectedPublishers.add(publisherDao.findById(102).get());
		
		assertArrayEquals(expectedPublishers.toArray(),p3.toArray());
	}
	
	@Test
	void testGetPublisher() {
		Publishers p4=publisherService.viewPublisherById(103).get();		
		assertEquals("Earth",p4.getPublisherName());
	}
	
	
}
