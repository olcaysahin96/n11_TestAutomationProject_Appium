import BaseClass.n11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends n11
{
    /*
    * TestCase1. Login
    * TestCase2. Password alanının boş bırakılarak devam edilmesi
    * TestCase3. Samsung arama yapmak ve onaylamak
    * TestCase4. samsung ürününü favorilere eklemek ve onaylamak
    * TestCase5. Favorilere git ve eklediğin ürünü favorilerden kaldır
    * TestCase6. Bildirim ayarlarına git ve mağaza soru cevap, güncelleme ayarlarını kapat
    */
    @Test
    public void TestCase1()
    {
        driver.findElement(By.xpath(closePopup)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menu)));
        driver.findElement(By.xpath(menu)).click();
        driver.findElement(By.xpath(login)).click();
        driver.findElement(By.id(loginEmail)).sendKeys(email);
        driver.findElement(By.id(loginPassword)).sendKeys(password);
        driver.findElement(By.id(loginBtn)).click();
        tearDown();
    }
    @Test
    public void TestCase2()
    {
        driver.findElement(By.xpath(closePopup)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menu)));
        driver.findElement(By.xpath(menu)).click();
        driver.findElement(By.xpath(login)).click();
        driver.findElement(By.id(loginEmail)).sendKeys(email);
        WebElement NullPassword = driver.findElement(By.id(loginPassword));
        NullPassword.sendKeys(" ");
        driver.findElement(By.id(loginBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(forgetPassword)));
        WebElement texts = driver.findElement(By.id(forgetPassword));
        Assert.assertEquals(texts.getText(),"Şifremi Unuttum");
        tearDown();
    }
    @Test
    public void TestCase3()
    {
        driver.findElement(By.xpath(closePopup)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menu)));
        driver.findElement(By.xpath(menu)).click();
        driver.findElement(By.xpath(login)).click();
        driver.findElement(By.id(loginEmail)).sendKeys(email);
        driver.findElement(By.id(loginPassword)).sendKeys(password);
        driver.findElement(By.id(loginBtn)).click();
        driver.findElement(By.id(searchBox)).click();
        WebElement searchSamsung = driver.findElement(By.id(clearableEdit));
        searchSamsung.sendKeys("samsung");
        driver.findElement(By.xpath(samsung)).click();
        driver.findElement(By.id(closeImage)).click();
        WebElement texts = driver.findElement(By.xpath(samsung_text));
        Assert.assertEquals(texts.getText(), "samsung");
        tearDown();
    }

    @Test
    public void TestCase4()
    {
        driver.findElement(By.xpath(closePopup)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menu)));
        driver.findElement(By.xpath(menu)).click();
        driver.findElement(By.xpath(login)).click();
        driver.findElement(By.id(loginEmail)).sendKeys(email);
        driver.findElement(By.id(loginPassword)).sendKeys(password);
        driver.findElement(By.id(loginBtn)).click();
        driver.findElement(By.id(searchBox)).click();
        WebElement searchSamsung = driver.findElement(By.id(clearableEdit));
        searchSamsung.sendKeys("samsung");
        driver.findElement(By.xpath(samsung)).click();
        driver.findElement(By.id(closeImage)).click();
        driver.findElement(By.xpath(third_product_samsung)).click();
        driver.findElement(By.id(closeImage)).click();
        driver.findElement(By.id(addFavorite)).click();
        WebElement texts = driver.findElement(By.id(addFavoriteInfo));
        Assert.assertEquals(texts.getText() , "Ürün favorilerinize eklendi.");
        tearDown();
    }
    @Test
    public void TestCase5()
    {
        driver.findElement(By.xpath(closePopup)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menu)));
        driver.findElement(By.xpath(menu)).click();
        driver.findElement(By.xpath(login)).click();
        driver.findElement(By.id(loginEmail)).sendKeys(email);
        driver.findElement(By.id(loginPassword)).sendKeys(password);
        driver.findElement(By.id(loginBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menu)));
        driver.findElement(By.xpath(menu)).click();
        driver.findElement(By.id(menu_item_mail)).click();
        driver.findElement(By.xpath(menuFavorite)).click();
        driver.findElement(By.id(myFavorite)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(product_delete_menu)));
        driver.findElement(By.xpath(product_delete_menu)).click();
        driver.findElement(By.xpath(product_delete)).click();
        driver.findElement(By.id(dialog_button_yes)).click();
        System.out.println("Ürün favori listenizden kaldırılmıştır.");
        tearDown();
    }
    @Test
    public void TestCase6()
    {
        driver.findElement(By.xpath(closePopup)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menu)));
        driver.findElement(By.xpath(menu)).click();
        driver.findElement(By.xpath(login)).click();
        driver.findElement(By.id(loginEmail)).sendKeys(email);
        driver.findElement(By.id(loginPassword)).sendKeys(password);
        driver.findElement(By.id(loginBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menu)));
        driver.findElement(By.xpath(menu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(notification_settings)));
        driver.findElement(By.xpath(notification_settings)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(notification_question_answer)));
        driver.findElement(By.xpath(notification_question_answer)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(notification_orders)));
        driver.findElement(By.xpath(notification_orders)).click();
        tearDown();
    }
}
