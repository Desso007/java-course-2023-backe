package edu.java.bot;

import edu.java.bot.CommandController;
import edu.java.bot.configuration.ApplicationConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CommandControllerTest {

    @Mock
    private ApplicationConfig applicationConfig;

    @InjectMocks
    private CommandController commandController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListCommandWithEmptyList() {
        List<String> trackedLinks = new ArrayList<>();
        when(applicationConfig.getTrackedLinks()).thenReturn(trackedLinks);

        String expectedResponse = "Список отслеживаемых ссылок пуст";
        String actualResponse = commandController.listCommand();

        assertEquals(expectedResponse, actualResponse);
    }


}
