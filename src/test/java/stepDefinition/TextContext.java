package stepDefinition;

import fileReader.FileReaderManager;
import fileReader.PropertyFileReader;
import pageObjectManager.PageObjectManager;
import webDriverManager.WebDriverManager;

public class TextContext {
    private PageObjectManager pageObjectManager;
    private WebDriverManager webDriverManager;
    private FileReaderManager fileReaderManager;

    public TextContext(){
        fileReaderManager = FileReaderManager.getFileReaderManager();
        webDriverManager = WebDriverManager.getWebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.createDriver(fileReaderManager.getPropertyFileReader().getProperty("browser")));
    }


    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

    public WebDriverManager getWebDriverManager(){
        return webDriverManager;
    }

    public FileReaderManager getFileReaderManager(){
        return fileReaderManager;
    }
}
