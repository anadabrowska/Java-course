package geometry;

public class Triangle{
    private Point a,b,c;

    public Triangle(Point a, Point b, Point c){
        double ab,ac,bc;
        ab = Math.sqrt(Math.pow(b.getX()-a.getX(),2)+Math.pow(b.getY()-a.getY(),2));
        ac = Math.sqrt(Math.pow(c.getX()-a.getX(),2)+Math.pow(c.getY()-a.getY(),2));
        bc = Math.sqrt(Math.pow(c.getX()-b.getX(),2)+Math.pow(c.getY()-b.getY(),2));
        
        if(ab+ac <= bc || ab+bc <= ac || bc+ac <= ab){
            throw new IllegalArgumentException("Can't buid a triangle! Wrong points");
        }else{
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public Point getA(){
        return a;
    }

    public Point getB(){
        return b;
    }

    public Point getC(){
        return c;
    }

    public void move(Vector v1){
        a.move(v1);
        b.move(v1);
        c.move(v1);
    }

    public void rotation(Point p, double angle){
        a.rotation(p, angle);
        b.rotation(p, angle);
        c.rotation(p, angle);
    }

    public void reflection(Straight s){
        a.reflection(s);
        b.reflection(s);
        c.reflection(s);
    }
}