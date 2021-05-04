package base;

import org.openqa.selenium.support.PageFactory;

public class Page {

    public <TPage extends Page> TPage GetInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(SharedDriver.getDriver(), pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
