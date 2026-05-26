package andrusca.vitali;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class TechnologyTest {
    // private static final Logger logger = LoggerFactory.getLogger(TechnologyTest.class);

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
       objectMapper = new ObjectMapper();
    }


    @Test
    void whenWriteToJsonThenOk() {
        // Technology technology = new Technology("MyJakarta", "Java EE Technology");
        Technology technology = Technology.builder()
                .techName("MyJakarta")
                .technologyDescription("Java EE Technology")
                .build();
        try {
            String writeToJson = objectMapper.writeValueAsString(technology);
            System.out.println(technology);
            assertTrue(writeToJson.contains("\"techName\":\"MyJakarta\""));
            assertTrue(writeToJson.contains("\"technologyDescription\":\"Java EE Technology"));
        } catch (JsonProcessingException e) {
            log.info(e.getMessage());
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