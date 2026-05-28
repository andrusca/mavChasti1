package andrusca.vitali;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;

/**
 * Class for
 *
 * @author Vitalie
 * <p>
 * on 22.05.2026
 */

@Data
@ToString
@Builder
@Slf4j
public class Technology {

    private String techName;
    private String technologyDescription;
    private ObjectMapper objectMapper = new ObjectMapper();

    private Path createPathFromString(String path) {
        return Path.of(path);
    }



    MyJakarta readFromJson(String technology) {
        String jsonTechnology = """
                {
                    "techName" : "%s",
                    "technologyDescription" : "%s"
                }
                """.formatted("test read ", "test read description");

        MyJakarta myJakarta = null;
        try {
            Technology technologyDeserialized = objectMapper.readValue(jsonTechnology, Technology.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return  myJakarta;
    }


}


