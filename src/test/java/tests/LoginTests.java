package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

        @BeforeMethod
        public void precondition(){
                if(app.getUser().isLogged()) app.getUser().logout();
        }

        @Test
        public void loginPositive(){
                app.getUser().openLoginForm();
                app.getUser().fillLoginForm("asd@fgh.com", "$Asdf1234");
                app.getUser().submitForm();
//        app.getUser().pause(5000);
//        Assert.assertTrue(app.getUser().isLoggedSuccess());
        }


        @Test
        public void loginPositiveUser(){
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

        @Test
        public void loginNegativeUserWrongEmail(){
                User user = new User().withEmail("asdfgh.com").withPassword("$Asdf1234");
                app.getUser().openLoginForm();
                app.getUser().fillLoginForm(user);
                //app.getUser().submitForm();
                app.getUser().pause(5000);
                Assert.assertTrue(app.getUser().isLoggedWrongEmail());
        }

        @AfterMethod
        public void postCondition(){
               // app.getUser().clickOkButton();
        }
}
