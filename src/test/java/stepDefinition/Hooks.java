package stepDefinition;

import io.cucumber.java.*;
import io.cucumber.java.an.E;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    private static  TextContext textContext;
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private final String screenShotDirectory = System.getProperty("user.dir").concat(File.separator).concat("src").concat(File.separator).concat("testArtifacts").concat(File.separator).concat("screenShots");


    public Hooks(TextContext textContext){
        this.textContext = textContext;
    }

    @Before
    public void scenarioSetUp(Scenario scenario){
       logger.info("test set up method");
       logger.info(scenario.getName());
    }

    @After
    public void scenarioTearDown(Scenario scenario){
        if(scenario.isFailed()){
            try {
                scenario.attach(getWebScreenshotInByteArray(), "image/png", "screenshot is attached");
            }catch (Exception e){
                logger.error(e.getMessage());
            }
        }
    }

    public byte[] getWebScreenshotInByteArray() {
        byte[] fileContent = new byte[0];
        try {
            // Capture screenshot and save it to a file
            File src = ((TakesScreenshot) textContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenShotDirectory  + getDateTime() + ".png");
            FileUtils.copyFile(src, destFile);

            // Read file content into byte array
            fileContent = FileUtils.readFileToByteArray(destFile);
        } catch (IOException e) {
            logger.error(String.valueOf(e));
        }
        return fileContent;
    }

    protected String getDateTime() {
        return (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
    }
}
