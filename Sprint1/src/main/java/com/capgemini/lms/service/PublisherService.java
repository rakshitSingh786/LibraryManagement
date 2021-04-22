package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.Publishers;

public interface PublisherService {
	public Publishers addPublisher(Publishers publisher);
	public Publishers updatePublisherDetails(Publishers publisher);
	public void removePublisher(int publisherId);
	public List<Publishers> viewPublishersList();
	public Publishers viewPublisherById(int id);
}
