package andrusca.vitali;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Path;
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
    private static final String  pathFileStructure = "output.txt";

    public static void main(String[] args) {
        Technology technology = new Technology("real technology", "developing stuff");
        try {
            technology.writeToJson(pathFileStructure);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }


}
