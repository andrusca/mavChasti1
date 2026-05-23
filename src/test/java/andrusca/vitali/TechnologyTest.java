package andrusca.vitali;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TechnologyTest {
    private static final Logger logger = LoggerFactory.getLogger(TechnologyTest.class);

    ObjectMapper objectMapper;
    @BeforeEach
    void setUp(){
       objectMapper = new ObjectMapper();
    }


    @Test
    void whenWriteToJsonThenOk() {
        Technology technology = new Technology("MyJakarta", "Java EE Technology");
        try {
            String writeToJson = objectMapper.writeValueAsString(technology);
            logger.info(writeToJson);
            assertTrue(writeToJson.contains("\"techName\":\"MyJakarta\""));
            assertTrue(writeToJson.contains("\"technologyDescription\":\"Java EE Technology"));
        } catch (JsonProcessingException e) {
            logger.info(e.getMessage());

        }

    }
    @Test
    void whenReadFromJsonThenOk() {
        String jsonTechnology = """
                {
                    "techName" : "%s",
                    "technologyDescription" : "%s"
                }
                
                """.formatted("Test Read", "Test Read Description");
        try {
            Technology technology = objectMapper.readValue(jsonTechnology, Technology.class);
            assertEquals("Test Read",technology.getTechName() );
            assertEquals("Test Read Description",technology.getTechnologyDescription() );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}