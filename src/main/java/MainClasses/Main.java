package MainClasses;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("MainScene.fxml"));
        AnchorPane root = loader.load();

        Global.root = root;

        Scene scene = new Scene(root,1200,700);
        stage.setResizable(true);
        stage.setTitle("Physics Simulator");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            Global.physics_thread.close();
            Platform.exit();
        });

        Global.physics_thread.start();
        Global.physics_thread.setPause(true);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
