package student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ScoreFileReader extends ScoreAbstractReader {
    private File file;

    public ScoreFileReader(File file) {
        this.setFile(file);
    }

    public InputStream getInputStream() throws FileNotFoundException {
        return new FileInputStream(this.getFile());
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
