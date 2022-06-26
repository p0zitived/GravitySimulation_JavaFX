package Utils;

public class Formulas {
    public static double distance(Space_object o1 , Space_object o2) {
        double distanceX = o2.getObject().getCenterX() - o1.getObject().getCenterX();
        double distanceY = o2.getObject().getCenterY() - o1.getObject().getCenterY();
        double distance = Math.sqrt(Math.abs(distanceX) + Math.abs(distanceY));

        return distance;
    }
    public static double gravity_force(Space_object o1 , Space_object o2) {
        double distance = distance(o1,o2);

        double F = 0.000000667*((o1.getWeight()*o1.getWeight())/(distance*distance));
        return F;
    }
}
