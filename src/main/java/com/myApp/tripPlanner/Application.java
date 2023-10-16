package com.myApp.tripPlanner;

import com.myApp.tripPlanner.services.TripsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		SpringApplication.run(Application.class, args);
        TripsService tripsService = TripsService.class.newInstance();
        System.out.println(tripsService.getTripWaypoints());
	}

}
