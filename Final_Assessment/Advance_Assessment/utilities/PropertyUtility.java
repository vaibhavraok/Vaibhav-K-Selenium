package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {

    public static String getData(String key) throws IOException {

        FileInputStream fis = new FileInputStream("./src/test/resources/DDT/common_data_OHRM.properties");

        Properties p = new Properties();

        p.load(fis);

        String value = p.getProperty(key);

        fis.close();

        return value;
    }
}
