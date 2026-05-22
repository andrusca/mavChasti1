package andrusca.vitali;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Class for
 *
 * @author Vitalie
 * <p>
 * on 22.05.2026
 */

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Technology {
    private static final Logger logger = LoggerFactory.getLogger(Technology.class);

    private String techName;
    private String technologyDescription;

    Path createPathFromString(String path) {
        return Path.of(path);
    }



    void writeToJson(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Technology technology = new Technology("test technology", "test technologyDescription");
        String serializedTechnologyObject = objectMapper.writeValueAsString(technology);
        Path location = Files.createFile(createPathFromString(path));
        Files.writeString(location,serializedTechnologyObject );




        Path file = createPathFromString(path);

        Files.createFile(file);


    }

    MyJakarta readFromJson(Technology technology) {
        return new MyJakarta();

    }

    void updateTechnology(Technology technology) {

    }


}
