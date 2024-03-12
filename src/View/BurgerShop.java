package View;

import Controller.ShopController;

public class BurgerShop {

    ShopController controller = new ShopController();

    public void home() {
        new IFdashboard(controller).setVisible(true);
    }
}