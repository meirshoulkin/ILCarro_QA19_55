package tests;

import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (app.getUser().isLogged()) app.getUser().logout();
    }

    @Test
    public void loginPositive() {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("asd@fgh.com", "$Asdf1234");
        app.getUser().submitForm();
//        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }


    @Test(groups = {"smokeGroup", "sanityGroup", "regressionGroup"})
    public void loginPositiveUser() {
        User user = new User().withEmail("asd@fgh.com").withPassword("$Asdf1234");
//        user.setName("John");
//        user.setLastName("Silver");

        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm("asd@fgh.com", "$Asdf1234");
//        app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
//        app.getUser().pause(5000);
//        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test(dataProvider = "userModelListDTO", dataProviderClass = ProviderData.class)
    public void loginPositiveUserDTO(User user) {
        //User user = new User().withEmail("asd@fgh.com").withPassword("$Asdf1234");
        logger.info("User:" + user.toString() + "is provided");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();

    }

    @Test
    public void loginNegativeUserWrongEmail() {
        User user = new User().withEmail("asdfgh.com").withPassword("$Asdf1234");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
        // app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isLoggedWrongEmail());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        app.getUser().clickOkButton();
    }
}
