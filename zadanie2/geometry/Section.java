package geometry;

public class Section{
    private Point a, b;

    public Section(Point a, Point b){
        if(a.getX() == b.getX() && a.getY() == b.getY()){
            throw new IllegalArgumentException("The same point!");
        }
        else{
            this.a = a;
            this.b = b;
        }
    }

    public Point getA(){
        return a;
    }

    public Point getB(){
        return b;
    }

    public void move(Vector v1){
        a.move(v1);
        b.move(v1);
    }

    public void rotation(Point p, double angle){
        a.rotation(p, angle);
        b.rotation(p, angle);
    }

    public void reflection(Straight s){
        a.reflection(s);
        b.reflection(s);
    }
    
}
