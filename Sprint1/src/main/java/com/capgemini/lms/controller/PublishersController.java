package com.capgemini.lms.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capgemini.lms.entities.Publishers;

import com.capgemini.lms.exception.PublisherNotFoundException;
import com.capgemini.lms.service.PublisherService;

@RestController
@RequestMapping("/publisher")
public class PublishersController {

	
	@Autowired
	PublisherService publisherService;
	
	
	
	@GetMapping(value="/all",produces="application/json")
	public  ResponseEntity<List<Publishers>> getAllPublishers(){
		return new ResponseEntity<List<Publishers>> (publisherService.viewPublishersList(),HttpStatus.OK);
	}

	@GetMapping(value="/{publisherId}",produces="application/json")
	public ResponseEntity<Publishers> getPublisherById(@PathVariable("publisherId") int publisherId){
		
		Optional<Publishers> p= publisherService.viewPublisherById(publisherId);
		if(p.isPresent())	
			return new ResponseEntity<Publishers>(publisherService.viewPublisherById(publisherId).get(),HttpStatus.OK);
		else
			throw new PublisherNotFoundException("No publisher found with given value "+ publisherId);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> addPublishers(@RequestBody Publishers publishers){
		publisherService.addPublisher(publishers);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}

	@PutMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> modifyPublishers(@RequestBody Publishers publisher){
		Optional<Publishers> p= publisherService.updatePublisherDetails(publisher);
		if(p.isPresent())
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		else
			throw new PublisherNotFoundException("No publisher found with given value "+ publisher);
	}
	
	@DeleteMapping(value="/{publisherId}")
	public ResponseEntity<HttpStatus> deletePublisher(@PathVariable("publisherId")int publisherId)
	{
//		try
//		{
//			publisherService.removePublisher(publisherId);;
//			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//		}	
//		catch(Exception e)
//		{	
//			throw new PublisherNotFoundException("No publisher found with given value "+ publisherId);
//		}
		Optional<Publisher> p= (Optional)publisherService.viewPublisherById(publisherId);
		if(p.isPresent())
		{
			publisherService.removePublisher(publisherId);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else
			throw new PublisherNotFoundException("No publisher found with given value "+publisherId);
		
	}
}
