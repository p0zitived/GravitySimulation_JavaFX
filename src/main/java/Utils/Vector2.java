package Utils;

public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Vector2() {
    }

    public static Vector2 sum(Vector2 v1 , Vector2 v2) {
        return new Vector2(v1.x + v2.x,v1.y + v2.y);
    }
    public void div(double a) {
        x /= a;
        y /= a;
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
