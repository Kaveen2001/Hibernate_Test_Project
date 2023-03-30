package lk.ijse.supermarket.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SplashScreenFormController {
    public AnchorPane MainSplashScreen;
    public AnchorPane SplashScreenContext;


    public void ManageCustomerOnAction(ActionEvent actionEvent) {
        SplashScreenContext.getChildren().clear();
        try {
            Parent load = FXMLLoader.load(getClass().getResource("../view/CustomerManageForm.fxml"));
            SplashScreenContext.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ManageItemOnAction(ActionEvent actionEvent) {
        SplashScreenContext.getChildren().clear();
        try {
            Parent load = FXMLLoader.load(getClass().getResource("../view/ItemManageForm.fxml"));
            SplashScreenContext.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ManageOrderOnAction(ActionEvent actionEvent) {
        SplashScreenContext.getChildren().clear();
        try {
            Parent load = FXMLLoader.load(getClass().getResource("../view/OrderDetailsManageForm.fxml"));
            SplashScreenContext.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PlaceOrderOnAction(ActionEvent actionEvent) {
        SplashScreenContext.getChildren().clear();
        try {
            Parent load = FXMLLoader.load(getClass().getResource("../view/PlaceOrderForm.fxml"));
            SplashScreenContext.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
