package Utils;

import MainClasses.Global;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Space_object {
    private float radius;
    private float weight;
    private Color color;
    private Vector2 move_dir;
    private Circle object;

    private Vector2 gravity_vect;

    public Space_object(float radius, float weight, Color color, Vector2 move_dir, Circle object) {
        this.radius = radius;
        this.weight = weight;
        this.color = color;
        this.move_dir = move_dir;
        this.object = object;
    }
    public Space_object(float radius, float weight, Color color, Vector2 move_dir) {
        this.radius = radius;
        this.weight = weight;
        this.color = color;
        this.move_dir = move_dir;
    }
    public Space_object(float radius, float weight, Color color) {
        this.radius = radius;
        this.weight = weight;
        this.color = color;
    }
    public Space_object(float radius, float weight) {
        this.radius = radius;
        this.weight = weight;
    }
    public Space_object(float radius) {
        this.radius = radius;
    }
    public Space_object() {
    }

    public float getRadius() {
        return radius;
    }
    public void setRadius(float radius) {
        this.radius = radius;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Vector2 getMove_dir() {
        return move_dir;
    }
    public void setMove_dir(Vector2 move_dir) {
        this.move_dir = move_dir;
    }

    public void setObject(double x,double y) {
        object = new Circle();
        object.setCenterX(x);
        object.setCenterY(y);

        object.setRadius(radius);
        object.setFill(color);
    }
    public Circle getObject() {
        return object;
    }

    public void setGravity_vect() {
        gravity_vect = new Vector2(0,0);
        for (Space_object obj : Global.objects_list) {
            if (obj != this) {
                double distanceX = obj.getObject().getCenterX() - this.getObject().getCenterX();
                double distanceY = obj.getObject().getCenterY() - this.getObject().getCenterY();

                Vector2 result = new Vector2();
                // micsoram vectorul pana marimea de 0-1;
                if (Math.abs(distanceX) > Math.abs(distanceY)) {
                    result.x = (float) distanceX / Math.abs((float) distanceX);
                    result.y = (float) distanceY / Math.abs((float) distanceX);
                } else {
                    result.x = (float) distanceX / Math.abs((float) distanceY);
                    result.y = (float) distanceY / Math.abs((float) distanceY);
                }

                gravity_vect = Vector2.sum(gravity_vect, result);
            }
        }

        gravity_vect.div(weight);
        move_dir = Vector2.sum(gravity_vect,move_dir);
    }
}
