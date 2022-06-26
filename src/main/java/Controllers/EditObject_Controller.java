package Controllers;

import MainClasses.Global;
import Utils.Space_object;
import Utils.Vector2;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class EditObject_Controller {

    @FXML
    private TextField tf_radius;

    @FXML
    private TextField tf_weight;

    @FXML
    private TextField tf_vectorX;

    @FXML
    private TextField tf_vectorY;

    @FXML
    private ColorPicker color_picker;

    @FXML
    private void done_press() {
        float radius = Float.parseFloat(tf_radius.getText());
        float weight = Float.parseFloat(tf_weight.getText());

        float x = Float.parseFloat(tf_vectorX.getText());
        float y = Float.parseFloat(tf_vectorY.getText());
        Vector2 move_dir = new Vector2(x,y);

        Color color = color_picker.getValue();

        Global.aux_object = new Space_object(radius,weight,color,move_dir);
        Controller.edit_window.close();
    }
}
