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
    private MyJakarta myJakarta ;


    @BeforeEach
    void setUp(){
       objectMapper = new ObjectMapper();
       myJakarta = new MyJakarta();

    }


    @Test
    void whenReadFromJsonThenOk() {
        try {
            Technology technology = myJakarta.readFromJson(FILE_NAME);
            assertEquals("2.0.NewTechName",technology.getTechName());
            assertEquals("2.0.NewDescription", technology.getTechnologyDescription());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    void whenSerializinTecnnology_thenCorrectJsonGenerated() {
        MyJakarta myJakarta = new MyJakarta();
        myJakarta.writeToJson(FILE_NAME);
        assertTrue(Files.exists(Path.of(FILE_NAME)));

    }

    @Test
    void testFileCreation() throws IOException {
        Path newFilePath = Paths.get(FILE_NAME);
        Files.createDirectories(newFilePath.getParent());
        System.out.println(newFilePath.getFileName().toString());


    }





}