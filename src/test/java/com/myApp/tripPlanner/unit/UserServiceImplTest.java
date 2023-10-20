package com.myApp.tripPlanner.unit;

import com.myApp.tripPlanner.core.dto.UserDTO;
import com.myApp.tripPlanner.core.entities.User;
import com.myApp.tripPlanner.core.repository.UserRepository;
import com.myApp.tripPlanner.core.utils.UserMapper;
import com.myApp.tripPlanner.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Spy
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail("Test");
        user.setName("Serhii");

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setEmail("Test");
        userDTO.setName("Serhii");

        // if UserMapper will be Mock
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);
        when(userMapper.toEntity(any(UserDTO.class))).thenReturn(user);
        when(userRepository.save(any())).thenReturn(user);

        UserDTO resultDTO = userMapper.toDTO(userService.add(userMapper.toEntity(userDTO)));

        verify(userRepository, times(1)).save(any(User.class));
        assertEquals(1L, resultDTO.getId());

        verify(userMapper, times(1)).toEntity(userDTO);
        verify(userMapper, times(1)).toDTO(user);
    }

    @Test
    public void testGetUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail("Test");
        user.setName("Serhii");

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setEmail("Test");
        userDTO.setName("Serhii");

        //if UserMapper will be Mock
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);
        when(userMapper.toEntity(any(UserDTO.class))).thenReturn(user);
        given(userRepository.findById(1L)).willReturn(Optional.of(user));

        verify(userMapper, times(1)).toDTO(user);
    }
}
