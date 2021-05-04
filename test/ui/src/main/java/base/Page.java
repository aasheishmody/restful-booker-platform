package base;

import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    public Page(){
        PageFactory.initElements(SharedDriver.getDriver(), this);
    }
}
