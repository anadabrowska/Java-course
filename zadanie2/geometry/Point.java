package geometry;

public class Point{
    private double x,y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void move(Vector v1){
        x += v1.dx;
        y += v1.dy;
    }

    public void rotation(Point p, double angle){
        x = (x-p.getX()) * Math.cos(angle) - (y-p.getY())*Math.sin(angle) + p.getX();
        y = (x-p.getX()) * Math.sin(angle) + (y-p.getY())*Math.cos(angle) + p.getY();
    }

    public void reflection (Straight s){
        if(s.b == 0){
            this.y = ((-s.c/s.a)-this.y)+(-s.c/s.a);
        }
        else if(s.a == 0){
            this.x = ((-s.c/s.b)-this.x)+(-s.c/s.b);
        }
        else{
            double a1,b1,a2,b2,x,y;
            //prosta prostopadla
            a1 = (-s.a / s.b);
            a2 = -1/a1;
            b1 = -s.c / s.b;
            b2 = -a2*this.x + this.y;
            //punkt przeciecia
            x = (b2-b1)/(a1-a2);
            y = a1*x + b1;
            //srodek odcinka
            this.x = 2*x - this.x;
            this.y = 2*y - this.y;
        }
    }
}

