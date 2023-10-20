package com.myApp.tripPlanner.unit;

import com.myApp.tripPlanner.core.dto.WaypointDTO;
import com.myApp.tripPlanner.core.entities.Waypoint;
import com.myApp.tripPlanner.core.repository.WaypointRepository;
import com.myApp.tripPlanner.core.utils.WaypointMapper;
import com.myApp.tripPlanner.services.WaypointServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class WaypointServiceImplTest {
    @Mock
    private WaypointRepository waypointRepository;
    @Spy
    private WaypointMapper waypointMapper;
    @InjectMocks
    private WaypointServiceImpl waypointService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateWaypoint() {
        Waypoint waypoint = new Waypoint();
        waypoint.setId(1L);
        waypoint.setCoordinates("Test");
        waypoint.setName("TestWaypoint");

        WaypointDTO waypointDTO = new WaypointDTO();
        waypointDTO.setId(1L);
        waypointDTO.setCoordinates("Test");
        waypointDTO.setName("TestWaypoint");

        // if UserMapper will be Mock
        when(waypointMapper.toDTO(any(Waypoint.class))).thenReturn(waypointDTO);
        when(waypointMapper.toEntity(any(WaypointDTO.class))).thenReturn(waypoint);
        when(waypointRepository.save(any())).thenReturn(waypoint);

        WaypointDTO resultDTO = waypointService.add(waypointDTO);

        verify(waypointRepository, times(1)).save(any(Waypoint.class));
        assertEquals(1L, resultDTO.getId());

        verify(waypointMapper, times(1)).toEntity(waypointDTO);
        verify(waypointMapper, times(1)).toDTO(waypoint);
    }

    @Test
    public void testGetUser() {
        Waypoint waypoint = new Waypoint();
        waypoint.setId(1L);
        waypoint.setCoordinates("Test");
        waypoint.setName("TestWaypoint");

        WaypointDTO waypointDTO = new WaypointDTO();
        waypointDTO.setId(1L);
        waypointDTO.setCoordinates("Test");
        waypointDTO.setName("TestWaypoint");

        //if UserMapper will be Mock
        when(waypointMapper.toDTO(any(Waypoint.class))).thenReturn(waypointDTO);
        when(waypointMapper.toEntity(any(WaypointDTO.class))).thenReturn(waypoint);
        given(waypointRepository.findById(1L)).willReturn(waypoint);

        verify(waypointMapper, times(1)).toDTO(waypoint);
    }
}
