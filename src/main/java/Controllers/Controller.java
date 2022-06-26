package Controllers;

import Enums.Mode;
import MainClasses.Global;
import Utils.Space_object;
import Utils.Vector2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public static Stage edit_window = new Stage();
    private Mode selected_mode = Mode.none;

    @FXML
    private AnchorPane base_pane;
    @FXML
    private Button bt_start;
    @FXML
    private Label page_title;
    @FXML
    private Button bt_add;
    @FXML
    private Label mode_text;
    @FXML
    private Label speed;

    @FXML
    private void add() {
        selected_mode = Mode.add_object;
        mode_text.setText("Mode: " + "Add");

        // ================ open menu ==================
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("EditObject.fxml"));
        try {
            AnchorPane root = loader.load();
            Scene scene = new Scene(root,365,400);

            edit_window.setScene(scene);
            edit_window.setTitle("Set and Edit object");
            edit_window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void mouse_on_base(MouseEvent event) {
        if (selected_mode == Mode.add_object) {
            Global.aux_object.setObject(event.getX(),event.getY()); // seteaza cercul , se poate si manual dar mam gandit ca asa e mai frumos
            Global.root.getChildren().add(Global.aux_object.getObject());

            float radius = Global.aux_object.getRadius();
            float weight = Global.aux_object.getWeight();
            Color color = Global.aux_object.getColor();
            Vector2 move_dir = Global.aux_object.getMove_dir();
            Circle obj = Global.aux_object.getObject();

            // adaugare in lista
            Global.objects_list.add(new Space_object(radius,weight,color,move_dir,obj));
        }
    }
    @FXML
    void start() {
        if (bt_start.getText().equals("Start")) {
            Global.physics_thread.setPause(false);
            selected_mode = Mode.start;

            mode_text.setText("Mode: Start");
            bt_start.setText("Stop");
        } else {
            Global.physics_thread.setPause(true);
            selected_mode = Mode.none;

            mode_text.setText("Mode: ");
            bt_start.setText("Start");
        }
    }
    @FXML
    void set_speed_add() {
        Global.physics_thread.setFps(Global.physics_thread.getFps()+10);
        speed.setText("Speed: " + Global.physics_thread.getFps());
    }
    @FXML
    void set_speed_down() {
        if (Global.physics_thread.getFps() > 10) {
            Global.physics_thread.setFps(Global.physics_thread.getFps() - 10);
            speed.setText("Speed: " + Global.physics_thread.getFps());
        }
    }
}
