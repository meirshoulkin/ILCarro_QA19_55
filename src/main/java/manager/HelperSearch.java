package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodDays(dateFrom, dateTo);
    }
    public void fillSearchFormDatePickerDays(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodDaysDatePicker(dateFrom, dateTo);
    }

    private void selectPeriodDays(String dateFrom, String dateTo) {
        click(By.id("dates"));
        type(By.id("dates"), dateFrom + " - " + dateTo);
        pause(3000);
    }
    private void selectPeriodDaysDatePicker(String dateForm, String dateTo){
        //date  7/10/2023
        //index 0  1   2
        String[]  startDate = dateForm.split("/");
        String[]  endDate = dateTo.split("/");
        click(By.id("dates"));
         //click(By.xpath("//div[.=' " + startDate[1] + " ']"));
       // click(By.xpath("//div[.=' " + endDate[1] + " ']"));
       // click(By.xpath("//div[.='']"));
  //      type(By.id("dates"), dateForm + " - " + dateTo);
        String locatorStartDate = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEndDate = String.format("//div[.=' %s ']", endDate[1]);
        click(By.xpath(locatorStartDate));
        click(By.xpath(locatorEndDate));
        pause(3000);
    }
    private void fillCity(String city) {
        type(By.id("city"), city);
        pause(3000);
        click(By.cssSelector("div.pac-item"));
        pause(3000);
    }
    public void submitForm(){
        wd.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public void fillSearchFormDatePickerMonths(String city, String dateFrom, String dateTo) {
        fillCity(city);
        selectPeriodMonthsDatePicker(dateFrom, dateTo);
    }

    public void fillSearchFormDatePickerYears(String city, String dateFrom, String dateTo) {
        fillCity(city);
        selectPeriodYearsDatePicker(dateFrom, dateTo);
    }

    private void selectPeriodYearsDatePicker(String dateFrom, String dateTo) {
        String[]  startDate = dateFrom.split("/");
        String[]  endDate = dateTo.split("/");
        click(By.id("dates"));
        click(By.xpath("//div[.=' " + startDate[1] + " ']"));
        pause(5000);
        click(By.xpath("//button[@aria-label='Choose month and year']"));
        pause(5000);
        click(By.xpath("//div[normalize-space()='2024']"));
        pause(3000);
        click(By.xpath("//div[normalize-space()='FEB']"));
        click(By.xpath("//div[.=' " + endDate[1] + " ']"));
    }

    private void selectPeriodMonthsDatePicker(String dateFrom, String dateTo){
        String[]  startDate = dateFrom.split("/");
        String[]  endDate = dateTo.split("/");
        click(By.id("dates"));
        click(By.xpath("//div[.=' " + startDate[1] + " ']"));
        int n = Integer.parseInt(endDate[0])-Integer.parseInt(startDate[0]);
        while (n>0){
            click(By.xpath("//button[@aria-label='Next month']"));
            n = n - 1;
        }
        click(By.xpath("//div[.=' " + endDate[1] + " ']"));

    }
}
