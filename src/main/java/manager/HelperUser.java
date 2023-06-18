package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void submitLogin(){
        click(By.xpath("//a[.=' Log in ']"));
    }
    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void clickSubmit(){
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[normalize-space()='Logout']"), "Login or Password incorrect");
    }

    public void logout(){
        click(By.xpath("//a[normalize-space()='Logout']"));
    }
}


