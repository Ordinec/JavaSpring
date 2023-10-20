package com.myApp.tripPlanner.services;

import com.myApp.tripPlanner.core.dto.TripDTO;
import com.myApp.tripPlanner.core.dto.WaypointDTO;
import com.myApp.tripPlanner.core.entities.Trip;
import com.myApp.tripPlanner.core.entities.User;
import com.myApp.tripPlanner.core.repository.TripRepository;
import com.myApp.tripPlanner.core.utils.TripMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    private TripMapper tripMapper;
    private TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
    }

    @Transactional
    @Override
    public List<WaypointDTO> getTripWaypoints(long id) {
        Trip trip = tripRepository.findById(id);
        return tripMapper.toDTO(trip).getWaypoints();
    }

    @Transactional
    @Override
    public String getTripName(long id) {
        Trip trip = tripRepository.findById(id);
        return tripMapper.toDTO(trip).getName();
    }

    @Transactional
    @Override
    public long getTripId(String name) {
        Trip trip = tripRepository.findByName(name);
        return tripMapper.toDTO(trip).getId();
    }

    @Transactional
    @Override
    public TripDTO add(TripDTO tripDTO) {
        Trip trip = tripMapper.toEntity(tripDTO);
        trip = tripRepository.save(trip);
        return tripMapper.toDTO(trip);
    }

    @Transactional
    @Override
    public void remove(TripDTO tripDTO) {
        Trip trip = tripMapper.toEntity(tripDTO);
        tripRepository.delete(trip);
    }

    @Transactional
    @Override
    public void remove(long id) {
        Trip trip = tripRepository.findById(id);
        tripRepository.delete(trip);
    }

    @Transactional
    @Override
    public TripDTO getTrip(long id) {
        Trip trip = tripRepository.findById(id);
        return tripMapper.toDTO(trip);
    }
}
