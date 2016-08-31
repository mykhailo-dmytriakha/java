package com.mdmytriaha;

import com.mdmytriaha.controllet.UserController;
import com.mdmytriaha.model.User;
import com.mdmytriaha.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getById_getUser_correctUser() {
        User newUser = new User();
        newUser.setId(1);
        newUser.setName("Smith");
        newUser.setPassword("qwerty");
        when(userRepository.findOne(1L)).thenReturn(newUser);

        User user = userController.getById(1L);

        verify(userRepository).findOne(1L);

        assertThat(user.getId(), is(1L));
        assertThat(user.getName(), is("Smith"));
        assertThat(user.getPassword(), is("qwerty"));
    }
}
