package interfaces.WordPress.AdminUI;

public class AdminSideMenuUI {
    public static final String MENU_BY_NAME =
            "xpath=//ul[@id='adminmenu']//div[@class='wp-menu-name' and text()='%s']/parent::a";
    public static final String SUB_MENU_BY_NAME =
            "xpath=//ul[@id='adminmenu']//div[@class='wp-menu-name' and text()='%s']" +
                    "/ancestor::li//ul[@class='wp-submenu']//a[text()='%s']";
}
