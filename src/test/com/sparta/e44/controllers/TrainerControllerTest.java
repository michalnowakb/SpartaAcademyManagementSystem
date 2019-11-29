package com.sparta.e44.controllers;

import com.sparta.e44.MainBootStarter;
import com.sparta.e44.entities.TrainerEntity;
import com.sparta.e44.entities.state.Gender;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)

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

        TrainerEntity newTrainerEntity = new TrainerEntity("Mike", "McDonald", LocalDate.parse("2007-12-03"),
                "md@gmail.com", "073112339891", Gender.MALE, LocalDate.parse("2019-11-11"),
                new ArrayList(), "N/A");
        mockMvc.perform(
                MockMvcRequestBuilders.post("/trainer/addTrainer")
                        .flashAttr("trainer",newTrainerEntity)
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