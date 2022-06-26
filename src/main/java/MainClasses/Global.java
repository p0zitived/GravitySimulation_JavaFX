package MainClasses;

import Utils.PhysicsCalculation;
import Utils.Space_object;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Global {
    public static AnchorPane root;
    public static PhysicsCalculation physics_thread = new PhysicsCalculation();
    public static ArrayList<Space_object> objects_list = new ArrayList<>();
    public static Space_object aux_object; // object for transfer data from EditObject_controller to Controllers.Controller
}
