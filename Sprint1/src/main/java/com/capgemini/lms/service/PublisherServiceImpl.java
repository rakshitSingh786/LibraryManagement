package com.capgemini.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.dao.PublisherDao;
import com.capgemini.lms.entities.Publishers;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	PublisherDao publisherdao;
	
	
	@Override
	public Publishers addPublisher(Publishers publisher) {
		publisherdao.save(publisher);
		return publisher;
	}

	@Override
	public Publishers updatePublisherDetails(Publishers publisher) {
		publisherdao.save(publisher);
		return publisher;
	}

	@Override
	public void removePublisher(int publisherId) {
		publisherdao.deleteById(publisherId);
	}

	@Override
	public List<Publishers> viewPublishersList() {
		return publisherdao.findAll();
	}

	@Override
	public Publishers viewPublisherById(int id) {
		return publisherdao.findById(id).get();
	}

}
