package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(System.getProperty("user.dir") + File.separator + "src" +
                File.separator + "test" + File.separator + "resources" + File.separator + "configfiles" +
                File.separator + "config.properties");
        Properties pr = new Properties();
        pr.load(fr);

    }
}
