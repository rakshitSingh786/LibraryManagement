package com.capgemini.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Publishers;
import com.capgemini.lms.exception.PublisherNotFoundException;

/*********************************************************************************************************
 * @author      Rakshit Singh
 * Description : This is the DAO class for Publishers
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *********************************************************************************************************/

@Repository
public interface PublisherDao extends JpaRepository<Publishers, Integer>{
}
