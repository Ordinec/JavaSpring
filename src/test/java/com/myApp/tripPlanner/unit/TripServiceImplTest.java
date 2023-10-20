package com.myApp.tripPlanner.unit;

import com.myApp.tripPlanner.core.dto.TripDTO;
import com.myApp.tripPlanner.core.dto.WaypointDTO;
import com.myApp.tripPlanner.core.entities.Trip;
import com.myApp.tripPlanner.core.entities.Waypoint;
import com.myApp.tripPlanner.core.repository.TripRepository;
import com.myApp.tripPlanner.core.utils.TripMapper;
import com.myApp.tripPlanner.services.TripServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class TripServiceImplTest {
    @Mock
    private TripRepository tripRepository;
    @Spy
    private TripMapper tripMapper;
    @InjectMocks
    private TripServiceImpl tripService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        Trip trip = new Trip();
        Waypoint waypoint1 = new Waypoint();
        waypoint1.setId(2L);
        waypoint1.setName("SomeTestName");
        waypoint1.setTrip(trip);
        waypoint1.setCoordinates("23");

        trip.setId(1L);
        trip.setName("Test");
        trip.setWaypoints(List.of(waypoint1));

        TripDTO tripDTO = new TripDTO();
        WaypointDTO waypoint1DTO = new WaypointDTO();
        waypoint1DTO.setId(2L);
        waypoint1DTO.setName("SomeTestName");
        waypoint1DTO.setTripDTO(tripDTO);
        waypoint1DTO.setCoordinates("23");
        tripDTO.setId(1L);
        tripDTO.setName("Test");
        tripDTO.setWaypoints(List.of(waypoint1DTO));

        // if UserMapper will be Mock
        when(tripMapper.toDTO(any(Trip.class))).thenReturn(tripDTO);
        when(tripMapper.toEntity(any(TripDTO.class))).thenReturn(trip);
        when(tripRepository.save(any())).thenReturn(trip);

        TripDTO resultDTO = tripService.add(tripDTO);

        verify(tripRepository, times(1)).save(any(Trip.class));
        assertEquals(1L, resultDTO.getId());

        verify(tripMapper, times(1)).toEntity(tripDTO);
        verify(tripMapper, times(1)).toDTO(trip);
    }

    @Test
    public void testGetTrip() {
        Trip trip = new Trip();
        Waypoint waypoint1 = new Waypoint();
        waypoint1.setId(2L);
        waypoint1.setName("SomeTestName");
        waypoint1.setTrip(trip);
        waypoint1.setCoordinates("23");

        trip.setId(1L);
        trip.setName("Test");
        trip.setWaypoints(List.of(waypoint1));

        TripDTO tripDTO = new TripDTO();
        WaypointDTO waypoint1DTO = new WaypointDTO();
        waypoint1DTO.setId(2L);
        waypoint1DTO.setName("SomeTestName");
        waypoint1DTO.setTripDTO(tripDTO);
        waypoint1DTO.setCoordinates("23");
        tripDTO.setId(1L);
        tripDTO.setName("Test");
        tripDTO.setWaypoints(List.of(waypoint1DTO));


        //if UserMapper will be Mock
        when(tripMapper.toDTO(any(Trip.class))).thenReturn(tripDTO);
        when(tripMapper.toEntity(any(TripDTO.class))).thenReturn(trip);
        given(tripRepository.findById(1L)).willReturn(trip);

        verify(tripMapper, times(1)).toDTO(trip);
    }
}
