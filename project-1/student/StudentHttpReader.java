package student;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class StudentHttpReader extends StudentAbstractReader {
    private URL url;

    public StudentHttpReader(URL url) {
        this.setUrl(url);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection connection = this.getUrl().openConnection();
        InputStream inputStream = connection.getInputStream();
        return inputStream;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

}
