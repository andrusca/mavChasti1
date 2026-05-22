package andrusca.vitali;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
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


    void writeToJson(String path) {

        Path pathToJsonFile = Path.of(path);


        /*logger.info("Created POJO :  %s ", technology);
        Technology technology = new Technology("MyJakarta", "Java EE Technology");*/

/*        Gson gson = new Gson();*/

   /*     try {
            gson.toJson(technology, new FileWriter(pathToJsonFile.toFile()));
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
*/

    }

    MyJakarta readFromJson(Technology technology) {
        return new MyJakarta();

    }

    void updateTechnology(Technology technology) {

    }


}
