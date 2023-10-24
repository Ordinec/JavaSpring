package com.myApp.tripPlanner.services;

import com.myApp.tripPlanner.core.dto.WaypointDTO;
import com.myApp.tripPlanner.core.entities.Waypoint;
import com.myApp.tripPlanner.core.repository.WaypointRepository;
import com.myApp.tripPlanner.core.utils.WaypointMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WaypointServiceImpl implements WaypointService {
    private final WaypointMapper waypointMapper;
    private final WaypointRepository waypointRepository;

    public WaypointServiceImpl(WaypointRepository waypointRepository, WaypointMapper waypointMapper) {
        this.waypointRepository = waypointRepository;
        this.waypointMapper = waypointMapper;
    }

    @Transactional
    @Override
    public WaypointDTO add(WaypointDTO waypointDTO) {
        Waypoint waypoint = waypointMapper.toEntity(waypointDTO);
        waypoint = waypointRepository.save(waypoint);
        return waypointMapper.toDTO(waypoint);
    }

    @Transactional
    @Override
    public WaypointDTO getById(long id) {
        Waypoint waypoint = waypointRepository.findById(id);
        return waypointMapper.toDTO(waypoint);
    }

    @Transactional
    @Override
    public void remove(WaypointDTO waypointDTO) {
        Waypoint waypoint = waypointMapper.toEntity(waypointDTO);
        waypointRepository.delete(waypoint);
    }

    @Transactional
    @Override
    public void remove(long id) {
        Waypoint waypoint = waypointRepository.findById(id);
        waypointRepository.delete(waypoint);
    }
}
