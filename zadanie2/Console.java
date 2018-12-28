import java.util.Scanner;

public class Console{

    private Scanner s;

    public Console(){
        s = new Scanner(System.in);
    }

    public int readInt(){
        return s.nextInt();
    }

    public double readDouble(){
        return s.nextDouble();
    }

    public void clear(){
        System.out.print("\033[H\033[2J");
    }

    public void pause(){
        s.nextLine();
        s.nextLine();
    }
}