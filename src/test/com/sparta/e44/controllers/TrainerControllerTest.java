package com.sparta.e44.controllers;

import com.sparta.e44.MainBootStarter;
import com.sparta.e44.entities.TrainerEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes ={ MainBootStarter.class })
//@ContextConfiguration(locations={"/SpringConfig.xml"})
public class TrainerControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private TrainerController trainerController;

    @Before
    public void setUp() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(trainerController)
                .build();
    }

    @Test
    public void testAddTrainer() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get(("/trainer/addTrainer/{id}"))
        )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().;

    }
}