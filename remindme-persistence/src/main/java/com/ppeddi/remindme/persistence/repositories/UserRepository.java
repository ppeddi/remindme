/**
 * 
 */
package com.ppeddi.remindme.persistence.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ppeddi.remindme.persistence.dto.UserDTO;

/**
 * @author ppeddi
 * 
 */
public interface UserRepository extends MongoRepository<UserDTO, String> {

}
