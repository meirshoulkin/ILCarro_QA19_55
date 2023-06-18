package tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

        @Test
        public void loginPositive(){

                app.getUser().submitLogin();
                app.getUser().fillLoginRegistrationForm("maxmayzel@gmail.com","Rfrnec7_*");
                app.getUser().clickSubmit();
                app.getUser().pause(3000);
                Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class='dialog-container']//h2"), "Login or Password incorrect"));

        }
}
