package com.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TourRepos extends MongoRepository<Tour, String> {

  public Tour findBytourName(String tourName);
  public List<Tour> findBydestAddress(String destAddress);

}