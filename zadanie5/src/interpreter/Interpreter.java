package interpreter;

import tools.*;

import java.io.*;
import java.util.Scanner;

public class Interpreter {

    private Scanner s;



    public Interpreter(){
        s = new Scanner(System.in);
        start();
    }

    public void start(){
        FileWriter writer = null;
        try {
            writer = new FileWriter("calc.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            String input = s.nextLine();
            String[] cmd = input.split(" ",2);
            if(cmd[0].equals("calc")){
                try {
                    writer.write(cmd[1]);
                    writer.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(new Expression(cmd[1], Variable.variables).calculate());
                } catch (ExceptionONP exceptionONP) {
                    exceptionONP.printStackTrace();
                }
            }else if(cmd[0].equals("clear")){
                if(cmd.length == 1){
                    Variable.variables.clear();
                }else{
                    cmd = cmd[1].split(" ");
                    for(String s : cmd) {
                        Variable.variables.remove(s);
                    }
                }
            }else if(cmd[0].equals("exit")){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }
}
