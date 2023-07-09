package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged()) app.getUser().logout();
    }

    @Test(groups = {"sanityGroup", "regressionGroup"})
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("john" + i + "@mail.com")
                .withPassword("$Asdf1234");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitForm();
        logger.info("Registration test starts with data:" + user.getEmail()
        + "&" + user.getPassword()
        );
        Assert.assertTrue(app.getUser().isRegistered());
    }


    @Test
    public void registrationNegativeWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("john" + i + "@mail.com")
                .withPassword("Asdf1234");

        app.getUser().openRegistrationForm();
        logger.info("Method openRegistrationForm() invoked:");
        app.getUser().fillRegistrationForm(user);
        logger.info("Method illRegistrationForm() invoked:");
        app.getUser().submitForm();
        logger.info("Method submitForm() invoked:");
        logger.info("Method openRegistrationForm() invoked:" + user.getEmail()
                + "&" + user.getPassword()
        );
//        Assert.assertTrue(app.getUser().isRegistered());

    }

    @AfterMethod(alwaysRun = true)
    public void postCondition(){
        app.getUser().clickOkButton();
    }
//    @AfterMethod(alwaysRun = true)
//    public void tearDown(){
//
//    }
}
