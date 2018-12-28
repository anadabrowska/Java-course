package geometry;

public class Vector{
    public final double dx,dy;

    public Vector(double dx, double dy){
        this.dx = dx;
        this.dy = dy;
    }

    public static Vector composing(Vector v1, Vector v2){
        return new Vector(v1.dx+v2.dx, v1.dy+v2.dy);
    }
}