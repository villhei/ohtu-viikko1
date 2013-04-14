
package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    private static void printHeader(String text) {
        String deco = "############";
        System.out.println(deco + " " + text + " " + deco);
    }
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8080");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );

        // Wrong pass
        printHeader("Wrong password");

        driver.get("http://localhost:8080");
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println("==");

        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("foo");
        element = driver.findElement(By.name("login"));
        element.submit();

        System.out.println("==");
        System.out.println( driver.getPageSource() );

        // Non-existant user
        printHeader("Non-existant user");

        driver.get("http://localhost:8080");
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println("==");

        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("erkko");
        element = driver.findElement(By.name("password"));
        element.sendKeys("foo");
        element = driver.findElement(By.name("login"));
        element.submit();

        System.out.println("==");
        System.out.println( driver.getPageSource() );

        // New user
        printHeader("New user");

        driver.get("http://localhost:8080");
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("register new user"));
        element.click();

        System.out.println("==");

        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("erkko");
        element = driver.findElement(By.name("password"));
        element.sendKeys("foobar1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("foobar1");
        element = driver.findElement(By.name("add"));
        element.submit();

        System.out.println("==");
        System.out.println( driver.getPageSource() );

        // Erkko's login
        printHeader("login with new user");

        driver.get("http://localhost:8080");
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println("==");

        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("erkko");
        element = driver.findElement(By.name("password"));
        element.sendKeys("foobar1");
        element = driver.findElement(By.name("login"));
        element.submit();

        System.out.println("==");
        System.out.println( driver.getPageSource() );

    }
}
