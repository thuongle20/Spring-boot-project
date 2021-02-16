package com.mongodb;

import org.springframework.data.annotation.Id;
import org.joda.time.DateTime;

public class Tour {

  @Id
  public String id;

  public String tourName;
  public String destAddress;
  public DateTime startDate; 
  
  public Tour(){}

  public Tour(String tourName, String destAddress,DateTime startDate) {
    this.tourName = tourName;
    this.destAddress = destAddress;
	this.startDate=startDate;
  }

  @Override
  public String toString() {
    return String.format(
        "Tour[id=%s, tourName='%s', To='%s', Date='%s']",
        id, tourName, destAddress, startDate);
  }

}