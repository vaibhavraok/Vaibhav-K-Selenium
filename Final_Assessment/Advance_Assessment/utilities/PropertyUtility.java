package Assessments.LastDayTask2.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
    public static String getData(String key) throws IOException {
        FileInputStream file=new FileInputStream("src/test/java/Assessments/LastDayTask2/resources/common_data.properties");
        Properties properties=new Properties();
        properties.load(file);
        String data=properties.getProperty(key);
        return key;
    }
}
