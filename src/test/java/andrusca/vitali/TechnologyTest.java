package andrusca.vitali;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class TechnologyTest {
    private  ObjectMapper objectMapper;

    private static final String FILE_NAME =
            "D:/All-Projects/vitaliProject/jsonTechnology.json";


    @BeforeEach
    void setUp(){
       objectMapper = new ObjectMapper();
    }


    @Test
    void whenReadFromJsonThenOk() {
        String jsonTechnology = """
                {
                    "techName" : "%s",
                    "technologyDescription" : "%s"
                }
                
                """.formatted("Test Read", """
                Test Read Description""");
        try {
            Technology technology = objectMapper.readValue(jsonTechnology, Technology.class);
            assertEquals("Test Read",technology.getTechName() );
            assertEquals("Test Read Description",technology.getTechnologyDescription() );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void whenSerializinTecnnology_thenCorrectJsonGenerated() {
        MyJakarta myJakarta = new MyJakarta();
        myJakarta.writeToJson(FILE_NAME);

    }

    @Test
    void testFileCreation() throws IOException {
        Path newFilePath = Paths.get(FILE_NAME);
        Files.createDirectories(newFilePath.getParent());
        System.out.println(newFilePath.getFileName().toString());


    }





}