package locators;

import org.openqa.selenium.By;

public class LocatorList{
    // Заголовок Yandex
    By  headerLogoYandex = By.className("Header_LogoYandex__3TSOI");

    // Заголовок LogoScooter   Header_LogoScooter__3lsAR
    By  headerLogoScooter = By.className("Header_LogoScooter__3lsAR");

    // Кнопка Заказать (верхняя)
    By topRegisterButton = By.className("div.Header_Nav__AGCXC button.Button_Button__ra12g");

    // Кнопка Заказать (нижняя)
    By ultraBigRegisterButton = By.className("Button_Button__ra12g Button_UltraBig__UU3Lp");

    // Кнопка Статус Заказа
    By orderStatusButton = By.className("Header_Link__1TAG7");


}
