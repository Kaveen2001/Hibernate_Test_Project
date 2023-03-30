package lk.ijse.supermarket.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Navigation {

    public static void navigate(Route route, AnchorPane pane) throws IOException {
        switch (route){
            case CUSTOMER:setStage("CustomerManage",pane);break;
            case ITEM:setStage("ItemManage",pane);break;
            case ORDER_DETAILS:setStage("OrderDetailsManage",pane);break;
            case PLACE_ORDER:setStage("PlaceOrder",pane);break;
            case DASHBOARD:setStage("DashBoard",pane);break;
            case WELCOME:setStage("Main",pane);break;
            case SPLASHSCREEN:setStage("SplashScreen",pane);break;
        }
    }

    private static void setStage(String url, AnchorPane pane) throws IOException {
        String u = "/view/"+url+"form.fxml";
        Parent load = FXMLLoader.load(Navigation.class.getResource(u));
        pane.getChildren().clear();
        pane.getChildren().add(load);
    }
}
