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

/*********************************************************************************************************************
 * @author Rakshit Singh
 * Description: This is the rest controller class for Publishers. 
 * Created Date: 23 April, 2021 
 * Version : v1.0.0
 ********************************************************************************************************************/


@RestController
@RequestMapping("/publisher")
public class PublishersController {

	
	@Autowired
	PublisherService publisherService;
	
	/*****************************************************************************************
	 * Method      : getAllPublishers
	 * @return       List of Publishers
	 * Description : This method fetches List of all publishers 
	 * @getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ****************************************************************************************/
	
	
	@GetMapping(value="/all",produces="application/json")
	public  ResponseEntity<List<Publishers>> getAllPublishers(){
		return new ResponseEntity<List<Publishers>> (publisherService.viewPublishersList(),HttpStatus.OK);
	}

	
	/*****************************************************************************************
	 * Method      : getPublisherById       
	 * @param      : publisher Id
	 * @return       Publishers object
	 * Description : This method fetches a Publisher based on the publisher id.
	 * @getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ****************************************************************************************/
	
	
	@GetMapping(value="/{publisherId}",produces="application/json")
	public ResponseEntity<Publishers> getPublisherById(@PathVariable("publisherId") int publisherId){
		
		Optional<Publishers> p= publisherService.viewPublisherById(publisherId);
		if(p.isPresent())	
			return new ResponseEntity<Publishers>(publisherService.viewPublisherById(publisherId).get(),HttpStatus.OK);
		else
			throw new PublisherNotFoundException("No publisher found with given value "+ publisherId);
	}
	
	
	
	/*****************************************************************************************
	 * Method      : addPublishers     
	 * @param        Publishers 
	 * @return       Response Entity of Object type
	 * Description : This method adds the Publisher details to the database
	 * @Postmapping : Post mapping requests a body from the user
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ****************************************************************************************/
	
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> addPublishers(@RequestBody Publishers publishers){
		publisherService.addPublisher(publishers);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}

	
	/******************************************************************************************
	* Method      : modifyPublishers
	* @param        Publisher
	* @return       Response Entity of Object type
	* Description : This method modifies the Publisher details
	* @PutMapping annotation  is used for mapping HTTP PUT requests onto specific handler methods.
	******************************************************************************************/
	
	
	@PutMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> modifyPublishers(@RequestBody Publishers publisher){
		Optional<Publishers> p= publisherService.updatePublisherDetails(publisher);
		if(p.isPresent())
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		else
			throw new PublisherNotFoundException("No publisher found with given value "+ publisher);
	}
	
	
	/*****************************************************************************
	* Method      : deletePublisher
	* @param        Publisher Id
	* @return       Response Entity of Object type
	* Description : This method deletes the Publisher based on id.
	* @deletemapping: @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods.
	******************************************************************************/
	
	
	@DeleteMapping(value="/{publisherId}")
	public ResponseEntity<HttpStatus> deletePublisher(@PathVariable("publisherId")int publisherId)
	{
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
