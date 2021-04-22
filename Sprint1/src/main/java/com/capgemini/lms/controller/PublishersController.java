package com.capgemini.lms.controller;

import java.util.List;

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
		return new ResponseEntity<Publishers>(publisherService.viewPublisherById(publisherId),HttpStatus.OK);
	}
	
@PostMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> addPublishers(@RequestBody Publishers publishers){
		publisherService.addPublisher(publishers);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}

@PutMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> modifyPublishers(@RequestBody Publishers publisher){
		publisherService.updatePublisherDetails(publisher);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);	
	}
	
@DeleteMapping(value="/{publisherId}")
	public ResponseEntity<HttpStatus> deletePublisher(@PathVariable("publisherId")int publisherId)
	{
		publisherService.removePublisher(publisherId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
