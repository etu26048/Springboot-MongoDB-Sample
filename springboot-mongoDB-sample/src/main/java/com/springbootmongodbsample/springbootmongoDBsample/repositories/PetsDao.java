package com.springbootmongodbsample.springbootmongoDBsample.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.springbootmongodbsample.springbootmongoDBsample.model.Pets;

public interface PetsDao extends MongoRepository<Pets, String> {

	Pets findById(ObjectId id);
}
