import structures.*;
import java.util.Scanner;

public class Tester{
    private static Scanner s;
    private static  boolean running = true;
    private static Collection[] col;

    public static void main(String[] args){
        s = new Scanner(System.in);

        col = new Collection[2];
        clear();
        System.out.print("Podaj rozmiar tablicy statycznej: ");
        col[0] = new CollectionOnTable(s.nextInt());
        col[1] = new CollectionOnDynamicTable();

        while(running){
            menu();
        }
    }


    private static void menu(){
        clear();
        System.out.println("Menu:"+col[0].howMany());
        System.out.println("1.  Dodaj parę do tablicy ");
        System.out.println("2.  Wyszukaj parę z określonym kluczem");
        System.out.println("3.  Zwróć wartość związaną z kluczem");
        System.out.println("4.  Zaktualizuj lub wstaw do zbioru nową parę");
        System.out.println("5.  Usuń wszystkie pary ze zbioru");
        System.out.println("6.  Sprawdź ile par jest przechowywanych w zbiorze");
        System.out.println("7.  Wyjście");

        try{
            int input = s.nextInt();
            if(input==7){
                running = false;
                return;
            }
            int choice = choiceDynamic();

            switch(input){
            case 1:
                col[choice].insert(new Pair(getKey(), getVal()));
                System.out.println("Dodano element!");
                break;
            case 2:
                System.out.println("Znaleziono parę: " +
                                   col[choice].search(getKey()).toString());
                break;
            case 3:
                System.out.println("Wartość związana z kluczem to: " + 
                                   col[choice].read(getKey()));
                break;
            case 4:
                col[choice].set(new Pair(getKey(), getVal()));
                System.out.println("Zaktualizowano tablicę!");
                break;
            case 5:
                col[choice].clear();
                System.out.println("Wyczyszczono tablicę!");
                break;
            case 6:
                System.out.println("Ilość elementów w zbiorze: " + 
                                   col[choice].howMany());
                break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        pause();
    }

    public static String getKey(){
        System.out.print("Podaj klucz: ");
        return s.next();
    }

    public static double getVal(){
        System.out.print("Podaj wartość: ");
        return s.nextDouble();
    }

    public static int choiceDynamic(){
        System.out.println("1. Tablica statyczna");
        System.out.println("2. Tablica dynamiczna");
        return s.nextInt() == 1 ? 0 : 1;
    }

    public static void clear(){
        System.out.print("\033[H\033[2J");
    }

    public static void pause(){
        s.nextLine();
        s.nextLine();
    }
}