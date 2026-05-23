package andrusca.vitali;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Class for
 *
 * @author Vitalie
 * <p>
 * on 22.05.2026
 */

@Data
@RequiredArgsConstructor

public class Technology {
    private static final Logger logger = LoggerFactory.getLogger(Technology.class);

    private String techName;
    private String technologyDescription;
    private ObjectMapper objectMapper;

    public Technology(String testTechnology, String testTechnologyDescription) {

    }

    Path createPathFromString(String path) {
        return Path.of(path);
    }



    void writeToJson(String path) throws IOException {
        objectMapper = new ObjectMapper();

        Technology technology = new Technology("test technology", "test technologyDescription");
        String serializedTechnologyObject = objectMapper.writeValueAsString(technology);
        Path location = Files.createFile(createPathFromString(path));
        Files.writeString(location,serializedTechnologyObject );
        Path file = createPathFromString(path);
        Files.createFile(file);

    }

    MyJakarta readFromJson(String technology) {

        objectMapper = new ObjectMapper();
        String jsonTechnology = """
                {
                    "techName" : "%s",
                    "technologyDescription" : "%s"
                }
                """.formatted("test read ", "test read description");
        MyJakarta myJakarta;
        try {
            Technology technologyDeserialized = objectMapper.readValue(jsonTechnology, Technology.class);
             myJakarta = new MyJakarta(1, "test",List.of(technologyDeserialized));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return  myJakarta;


    }

    void updateTechnology(Technology technology) {

    }


}
