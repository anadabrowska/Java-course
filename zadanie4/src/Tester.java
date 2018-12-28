import  calculations.*;



public class Tester {
    public static void main(String[] args){
        Variable.set("x",2.0);
        Variable.set("y",2.0);

        Expression expr1 = new Add(
                new Num(3),
                new Num(7)
        );

        Expression expr2 = new Add(
                new Num(2.0),
                new Mult(
                        new Variable("x"),
                        new Num(7.0)
                )
        );

        Expression expr3 = new Div(
                new Sub(
                        new Mult(
                                new Num(3),
                                new Num(11)
                        ),
                        new Num(1)
                ),
                new Add(
                        new Num(7),
                        new Num(5)
                )
        );

        Expression expr4 = new Atan(
                new Div(
                        new Mult(
                                new Add(
                                        new Variable("x"),
                                        new Num(13)
                                ),
                                new Variable("x")
                        ),
                        new Num(2)
                )
        );

        Expression expr5 = new Add(
                new Pow(
                        new Num(2),
                        new Num(5)
                ),
                new Mult(
                        new Variable("x"),
                        new Log(
                                new Num(2),
                                new Variable("y")
                        )
                )
        );
        try {
            System.out.println(expr1.toString() + " = " + expr1.calculate());
            System.out.println(expr2.toString() + " = " + expr2.calculate());
            System.out.println(expr3.toString() + " = " + expr3.calculate());
            System.out.println(expr4.toString() + " = " + expr4.calculate());
            System.out.println(expr5.toString() + " = " + expr5.calculate());

        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(new Add(new Num(5), new Variable("y")).equals
                            (new Add(new Num(5),new Variable("y"))));
    }

}
