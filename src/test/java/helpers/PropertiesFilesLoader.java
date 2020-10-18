package helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import constants.*;

public class PropertiesFilesLoader {


    public static PropertiesFilesLoader singleInstance;
    private static String file_path;
    public static Properties properties;
    private static InputStream fileInput;

    public synchronized static PropertiesFilesLoader getSingleInstance()
    {
        if (singleInstance == null)
            singleInstance = new PropertiesFilesLoader();
        return singleInstance;
    }

    // this method load the properties-file
    public synchronized Properties loadPropertiesFile(String filename) throws ClassNotFoundException {
        //MyLogger.logger.se.setLevel(Level.DEBUG);
        try { // return the properties-file as InputStream
            if(!filename.equals(""))
            {

                file_path = Constants.PROPERTIES_FILE_FOLDER + "/" + filename;  //"/" +
                //file_path = filename;
            }
            //file should be in resource-folder
            fileInput = getClass().getResourceAsStream(file_path);

            properties = new Properties();
            if (fileInput == null) {
                MyLogger.logger.error("properties-file " + file_path + " could not be loaded");

                //throw new FileNotFoundException();
            } else {
                MyLogger.logger.info("success loading properties-file " + file_path);
            }
            // loading properties-file
            properties.load(fileInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*catch (IOException e) {
            e.printStackTrace();
        }*/
        return properties;
    }

    // return a property by the key
    public String getPropertyByKey(String propertyKey) {
        //Properties proP = null; // = loadPropertiesFile();

        MyLogger.logger.info("getting property with following key..." + propertyKey);
        if (properties == null) {
            MyLogger.logger.info("properties is null............");
        } else {
            MyLogger.logger.info(" found corresponding property " + properties.getProperty(propertyKey));
        }
        return properties.getProperty(propertyKey);
    }
}
