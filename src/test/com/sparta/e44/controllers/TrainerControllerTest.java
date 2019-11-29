package com.sparta.e44.controllers;

import com.sparta.e44.MainBootStarter;
import com.sparta.e44.entities.TrainerEntity;
import com.sparta.e44.repositories.TrainerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
//@ContextConfiguration(classes ={ TrainerController.class })
//@ContextConfiguration("/SpringConfig.xml")
public class TrainerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TrainerRepository trainerRepository;

    @InjectMocks
    private TrainerController trainerController;

    @Before
    public void setUp() {
        mockMvc= MockMvcBuilders.standaloneSetup(trainerController)
                .build();
    }

    @Test
    public void testAddTrainer() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get(("/trainer/addTrainer"))
        )
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.);

    }

    @Test
    public void testGetTrainer() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get(("/trainer/getTrainer/1"))
        )
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.);

    }
}