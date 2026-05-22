package andrusca.vitali;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

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
public class MyJakarta {

    private long version;
    private String description;
    private List <Technology> techList;


}
