package com.capgemini.lms.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.lms.entities.Publishers;

public interface PublisherService {
	public Publishers addPublisher(Publishers publisher);
	public Optional<Publishers> updatePublisherDetails(Publishers publisher);
	public void removePublisher(int publisherId);
	public List<Publishers> viewPublishersList();
	public Optional<Publishers> viewPublisherById(int id);
}
