package com.capgemini.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Publishers;
import com.capgemini.lms.exception.PublisherNotFoundException;


@Repository
public interface PublisherDao extends JpaRepository<Publishers, Integer>{
//	public int addPublisher(Publishers publisher);
//	public int updatePublisherDetails(Publishers publisher) throws PublisherNotFoundException;
//	public int removePublisher(int publisherId) throws PublisherNotFoundException;
//	public List<Publishers> viewPublishersList();
//	public Publishers viewPublisherById(int id) throws PublisherNotFoundException;
}
