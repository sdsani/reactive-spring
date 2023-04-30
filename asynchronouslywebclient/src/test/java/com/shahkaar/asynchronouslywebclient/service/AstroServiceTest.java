package com.shahkaar.asynchronouslywebclient.service;

import com.shahkaar.asynchronouslywebclient.json.AstroResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroServiceTest {

    @Autowired
    AstroService service;

    @Test
    void getAstroResponseAsync() {
        AstroResponse response = service.getPeopleInSpaceData()
                .block(Duration.ofSeconds(2));

        assertNotNull(response);
        assertEquals("success", response.message());
        assertTrue(response.number() >= 0);
        assertEquals(response.number(), response.people().size());
        System.out.println(response);
    }

    @Test
    void getAstroResponseAsyncStepVerifier() {
        service.getPeopleInSpaceData()
                .as(StepVerifier::create)
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals("success", response.message());
                    assertTrue(response.number() >= 0);
                    assertEquals(response.number(), response.people().size());
                    System.out.println(response);
                })
                .verifyComplete();
    }
}