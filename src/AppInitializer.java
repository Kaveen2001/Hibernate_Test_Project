import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
       /* Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        transaction.commit();
        session.close();*/

        try {
            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("lk/ijse/supermarket/view/MainForm.fxml"))));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
