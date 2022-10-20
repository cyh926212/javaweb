package student;

import java.io.IOException;
import java.util.Map;

public interface IScoreReader {
    public Map<String, Integer> read() throws IOException;
}
