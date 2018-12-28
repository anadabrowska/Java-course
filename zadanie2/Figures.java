import geometry.*;

public class Figures{

    private static boolean running = true;
    private static Console console;

    public static void main(String[] args){
        console = new Console();
        while(running){
            menu();
        }
    }

    private static void menu(){
        console.clear();
        System.out.println("Menu:");
        System.out.println("1.  Stwórz punkt");
        System.out.println("2.  Stwórz odcinek");
        System.out.println("3.  Stwórz trójkąt");
        System.out.println("4.  Przesuń o wektor");
        System.out.println("5.  Obróć względem punktu o kąt");
        System.out.println("6.  Odbij względem prostej");
        System.out.println("7.  Złóż dwa wektory");
        System.out.println("8.  Przesuń prostą o wektor");
        System.out.println("9.  Sprawdź równoległość prostych");
        System.out.println("10. Sprawdź prostopadłość prostych");
        System.out.println("11. Wyznacz punkt przecięcia prostych");
        System.out.println("12. Wyjście");

        int option = console.readInt();
        Point p1, p2, p3;
        geometry.Vector v1, v2, v3;
        Straight s1,s2;

        switch(option){
        case 1:
            try{
                readPoint(0);
                System.out.println("Poprawnie utworzono punkt!");
            }catch(Exception e){
                e.printStackTrace();
            }

            console.pause();
            break;
        case 2:
            try{
                p1 = readPoint(1);
                p2 = readPoint(2);
                new Section(p1, p2);
                System.out.println("Poprawnie utworzono odcinek!");
            }catch(Exception e){
                e.printStackTrace();
            }
            
            console.pause();
            break;
        case 3:
            try{
                p1 = readPoint(1);
                p2 = readPoint(2);
                p3 = readPoint(3);
                new Triangle(p1,p2,p3);
                System.out.println("Poprawnie utworzono trójkąt!");
            }catch(Exception e){
                e.printStackTrace();
            }

            console.pause();
            break;
        case 4:
            submenu(0);
            break;
        case 5:
            submenu(1);
            break;
        case 6:
            submenu(2);
            break;
        case 7:
            try{
                v1 = readVector(1);
                v2 = readVector(2);
                v3 = geometry.Vector.composing(v1, v2);
                System.out.println("Otrzymany wektor: ["+v3.dx+", "+v3.dy+"]");
            }catch(Exception e){
                e.printStackTrace();
            }

            console.pause();
            break;
        case 8:
            try{
                s1 = readStraight(0);
                v1 = readVector(0);
                s2 = Straight.move(s1, v1);
                System.out.print("Przesunięta prosta: ");
                System.out.println("(" + s2.a + ")x + (" + s2.b + ")y + (" + s2.c + ")");
            }catch(Exception e){
                e.printStackTrace();
            }

            console.pause();
            break;
        case 9:
            try{
                s1 = readStraight(1);
                s2 = readStraight(2);
                System.out.println(Straight.parallel(s1, s2));
            }catch(Exception e){
                e.printStackTrace();
            }

            console.pause();
            break;
        case 10:
            try{
                s1 = readStraight(1);
                s2 = readStraight(2);
                System.out.println(Straight.perpendicular(s1, s2));
            }catch(Exception e){
                e.printStackTrace();
            }

            console.pause();
            break;
        case 11:
            try{
                s1 = readStraight(1);
                s2 = readStraight(2);
                p1 = Straight.cross_point(s1, s2);
                System.out.println("Punkt przecięcia: ["+p1.getX()+", "+p1.getY()+"]");
            }catch(Exception e){
                e.printStackTrace();
            }
            console.pause();
            break;
        case 12:
            running = false;
            break;
        }
    }

    private static void submenu(int mode){
        console.clear();
        if(mode == 0)
            System.out.println("Przesuwanie o wektor:");
        else if(mode == 1)
            System.out.println("Obrót względem punktu o kąt:");
        else if(mode == 2)
            System.out.println("Odbicie względem prostej:");

        System.out.println("1. Punkt");
        System.out.println("2. Odcinek");
        System.out.println("3. Trójkąt");

        int option = console.readInt();
        Point p1, p2, p3, p4;
        geometry.Vector v1;
        Section s1;
        Straight st1;
        Triangle t1;
        double angle;

        switch(option){
        case 1:
            if(mode == 0){
                try{
                    p1 = readPoint(0);
                    v1 = readVector(0);
                    p1.move(v1);

                    System.out.println("Przesunięto na pozycję: ["+p1.getX()+", "+p1.getY()+"]");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(mode == 1){
                try{
                    p1 = readPoint(1);
                    p2 = readPoint(2);
                    System.out.print("Podaj kąt: ");
                    angle = console.readDouble();
                    p1.rotation(p2, angle);
                    System.out.println("Obrócono na pozycję: ["+p1.getX()+", "+p1.getY()+"]");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(mode == 2){
                try{
                    p1 = readPoint(0);
                    st1 = readStraight(0);
                    p1.reflection(st1);
                    System.out.println("Odbito na pozycję: ["+p1.getX()+", "+p1.getY()+"]");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            console.pause();
            break;
        case 2:
            if(mode == 0){
                try{
                    p1 = readPoint(1);
                    p2 = readPoint(2);
                    s1 = new Section(p1, p2);
                    v1 = readVector(0);
                    s1.move(v1);
                    System.out.println("Przesunięto na pozycje: ["+s1.getA().getX()+", "+s1.getA().getY()+"] ["+s1.getB().getX()+", "+s1.getB().getY()+"]");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(mode == 1){
                try{
                    p1 = readPoint(1);
                    p2 = readPoint(2);
                    s1 = new Section(p1, p2);
                    p3 = readPoint(0);
                    System.out.print("Podaj kąt: ");
                    angle = console.readDouble();
                    s1.rotation(p3, angle);
                    System.out.println("Obrócono na pozycje: ["+s1.getA().getX()+", "+s1.getA().getY()+"] ["+s1.getB().getX()+", "+s1.getB().getY()+"]");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(mode == 2){
                try{
                    p1 = readPoint(1);
                    p2 = readPoint(2);
                    s1 = new Section(p1,p2);
                    st1 = readStraight(0);
                    s1.reflection(st1);
                    System.out.println("Odbito na pozycje: ["+s1.getA().getX()+", "+s1.getA().getY()+"] ["+s1.getB().getX()+", "+s1.getB().getY()+"]");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            console.pause();
            break;
        case 3:
            if(mode == 0){
                try{
                    p1 = readPoint(1);
                    p2 = readPoint(2);
                    p3 = readPoint(3);
                    v1 = readVector(0);
                    t1 = new Triangle(p1,p2,p3);
                    t1.move(v1);
                    System.out.println("Przesunięto na pozycję: ["+t1.getA().getX()+", "+t1.getA().getY()+"] ["+t1.getB().getX()+", "+t1.getB().getY()+"] ["+t1.getC().getX()+", "+t1.getC().getY()+"]");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(mode == 1){
                try{
                    p1 = readPoint(1);
                    p2 = readPoint(2);
                    p3 = readPoint(3);
                    t1 = new Triangle(p1, p2, p3);
                    p4 = readPoint(0);
                    System.out.print("Podaj kąt: ");
                    angle = console.readDouble();
                    t1.rotation(p4, angle);
                    System.out.println("Obrócono na pozycję: ["+t1.getA().getX()+", "+t1.getA().getY()+"] ["+t1.getB().getX()+", "+t1.getB().getY()+"] ["+t1.getC().getX()+", "+t1.getC().getY()+"]");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(mode == 2){
                try{
                    p1 = readPoint(1);
                    p2 = readPoint(2);
                    p3 = readPoint(3);
                    t1 = new Triangle(p1, p2, p3);
                    st1 = readStraight(0);
                    t1.reflection(st1);
                    System.out.println("Odbito na pozycję: ["+t1.getA().getX()+", "+t1.getA().getY()+"] ["+t1.getB().getX()+", "+t1.getB().getY()+"] ["+t1.getC().getX()+", "+t1.getC().getY()+"]");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            console.pause();
            break;
        }
    }

    private static Point readPoint(int id){
        if(id == 0)
            System.out.println("Punkt:");
        else
            System.out.println("Punkt "+id+":"); 

        System.out.print("Podaj x: ");
        double x = console.readDouble();
        System.out.print("Podaj y: ");
        double y = console.readDouble();

        return new Point(x, y);
    }

    private static geometry.Vector readVector(int id){
        if(id == 0)
            System.out.println("Wektor:");
        else
            System.out.println("Wektor "+id+":");
        
        System.out.print("Podaj dx: ");
        double x = console.readDouble();
        System.out.print("Podaj dy: ");
        double y = console.readDouble();

        return new geometry.Vector(x, y);
    }

    private static Straight readStraight(int id){
        if(id == 0)
            System.out.println("Prosta:");
        else
            System.out.println("Prosta "+id+":");

        System.out.print("Podaj A: ");
        double A = console.readDouble();
        System.out.print("Podaj B: ");
        double B = console.readDouble();
        System.out.print("Podaj C: ");
        double C = console.readDouble();

        return new Straight(A,B,C);
    }
}