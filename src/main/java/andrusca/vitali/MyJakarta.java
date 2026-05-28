package andrusca.vitali;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class for
 *
 * @author Vitalie
 * <p>
 * on 22.05.2026
 */
@Slf4j
@Data

@AllArgsConstructor
@RequiredArgsConstructor

public class MyJakarta {

    private long version;
    private String description;
    private List <Technology> techList;
    private static final String PATH_TO_FILE = "output.txt";
    private ObjectMapper objectMapper = new ObjectMapper();

    private Path createPathFromString(String path) {
        return Path.of(path);
    }

    void writeToJson(String path) {
        Path targetFileToWrite = Paths.get(path);
        try {
            Files.createDirectories(targetFileToWrite.getParent());
            Files.createFile(targetFileToWrite);
            Technology technology = Technology.builder()
                    .techName("2.0.NewTechName")
                    .technologyDescription("2.0.NewDescription")
                    .build();
            String jsonData = objectMapper.writeValueAsString(technology);
            Files.writeString(targetFileToWrite, jsonData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {


    }


    Technology readFromJson(String jsonPath) throws IOException {
        Technology technology = objectMapper.readValue(Paths.get(jsonPath).toFile(), Technology.class);
        return technology;



    }


    void updateTechnology(Technology technology) {

    }


}



