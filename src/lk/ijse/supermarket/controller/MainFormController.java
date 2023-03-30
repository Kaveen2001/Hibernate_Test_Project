package lk.ijse.supermarket.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.supermarket.util.Navigation;
import lk.ijse.supermarket.util.Route;

import java.io.IOException;

public class MainFormController {
    public AnchorPane MainFormContext;
    public AnchorPane SplashScreenContext;
    public Button btnWelcome;

    public void btnWelcomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.SPLASHSCREEN,SplashScreenContext);
    }
}
