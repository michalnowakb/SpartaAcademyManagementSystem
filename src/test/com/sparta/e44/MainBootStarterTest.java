package com.sparta.e44;
import com.sparta.e44.entities.TrainerEntity;
import com.sparta.e44.entities.state.Gender;
import com.sparta.e44.services.TrainerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class MainBootStarterTest {

    @InjectMocks
    MainBootStarter mainBootStarter = new MainBootStarter();
    @Mock
    TrainerService trainerService;
    @Mock
    TrainerEntity firstTrainer;
    @Before
    public void setup(){
        firstTrainer =
                new TrainerEntity ("Mike","McDonald", LocalDate.parse("2007-12-03"),
                        "md@gmail.com","073112339891", Gender.MALE,LocalDate.parse("2019-11-11"),
                        "Java","N/A");
    }

    @Test
    public void testAdd(){
        trainerService.addTrainer(firstTrainer);
//        verify(trainerService).addTrainer(firstTrainer);
//        Assert.assertEquals(firstTrainer.getTrainerId(),trainerService.getById(1).getTrainerId());
        Assert.assertEquals("Mike",firstTrainer.getFirstName());
    }
}