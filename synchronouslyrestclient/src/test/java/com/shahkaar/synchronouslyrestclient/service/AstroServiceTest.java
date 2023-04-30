package com.shahkaar.synchronouslyrestclient.service;

import com.shahkaar.synchronouslyrestclient.json.AstroResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroServiceTest {
	
	@Autowired
	private AstroService service;
	
	@Test
    void getPeopleInSpace() {
        String people = service.getPeopleInSpace();
        assertNotNull(people);
        assertTrue(people.contains("people"));
        System.out.println(people);
    }

    @Test
    void getPeopleInSpaceData() {
        AstroResponse response = service.getPeopleInSpaceData();
        assertNotNull(response);
        assertEquals("success", response.message());
        assertTrue(response.number() > 0);
        assertTrue(response.people().size() > 0);
        System.out.println(response);
    }
}
