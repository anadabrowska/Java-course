package geometry;

public class Straight{
    public final double a,b,c;

    public Straight(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static boolean parallel(Straight s1, Straight s2){
        return ((s1.a*s2.b)-(s2.a*s1.b) == 0);
    }

    public static boolean perpendicular(Straight s1, Straight s2){
        return ((s1.a*s2.a)+(s1.b*s2.b) == 0);
    }

    public static Straight move(Straight s, Vector v){
        //nachylenie sie nie zmienia
        //gdy nie na przecieica z osią y
        double y,x;
        if(s.b == 0){
            x = -s.c/s.a + v.dx;
            return new Straight(s.a, s.b, -s.a*x);
        }
        Point p;
        y = -s.c/s.b;
        x = 0;
        p = new Point(x,y);
        p.move(v);
        return new Straight(s.a,s.b,-s.a*p.getX() - s.b*p.getY());
         
    }

    public static Point cross_point(Straight s1,Straight s2){
        if(parallel(s1, s2)){
            throw new IllegalArgumentException("Lines are parallel");
        }else{
            double x = (s1.c*s2.b-s2.c*s1.b)/(s2.a*s1.b-s1.a*s2.b);
            double y = (-s1.a*x - s1.c)/s1.b;
            return new Point(x,y);
        }
    }
}