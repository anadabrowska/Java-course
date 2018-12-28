public class WordNumbers {

        public static String[][] numbers = {
            {"","jeden", "dwa", "trzy", "cztery",
            "pięć", "sześć", "siedem", "osiem", "dziewięć"},
            {"","jedenaście", "dwanaście", "trzynaście",
            "czternaście", "piętnaście", "szesnaście", "siedemnaście",
            "osiemnaście", "dziewiętnaście"},{"","dziesięć","dwadzieścia", "trzydzieści",
            "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt",
            "osiemdziesiąt", "dziewięćdziesiąt"},{"","sto","dwieście",
            "trzysta", "czterysta", "pięćset", "sześćset", "siedemset",
            "osiemset", "dziewięćset"},{"tysiąc","tysiące","tysięcy"},
            {"milion", "miliony", "milionów"},{"miliard","miliardy","miliardów"}
        };
        
        public static void encode(int num){
            String output = "";
            int section = 0;
            int j,d,s;

            if(num == Integer.MIN_VALUE){
                num += 8;
                output = numbers[0][8];
            }
            if(num < 0){
                System.out.print("minus ");
                num *= -1;
            }
            if(num == 0){
                output = "zero";
            }
            while(num > 0){
                j = num%10;
                d= num%100/10;
                s= num%1000/100;

                if(section > 0 && num<1000){
                    if(j == 1 && s+d == 0){
                        output = numbers[section+3][0] + " " + output;
                    }
                    else if(j == 2 || j==3 || j==4){
                        output = numbers[section+3][1]+ " " + output;
                    }
                    else{
                        output = numbers[section+3][2] + " " + output;
                    }
                }
                if(d == 1 && j>0 ){
                    output = numbers[1][j] + output;
                }
                else{
                    if(j != 0){
                        output = numbers[0][j] + " " + output;
                    }
                    if(d != 0){
                        output = numbers[2][d] + " " + output;
                    }
                    if(s != 0){
                        output = numbers[3][s] + " " + output;
                    }
                }
                num /= 1000;
                section ++;
            }
            System.out.print(output);
        }

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            try{
                int num = new Integer(args[i]);
                encode(num);
            }catch(NumberFormatException e){
                System.err.println("Błędna " + i + "-ta " + "dana: " + e.getMessage());
            }
            System.out.println();
        }

    }

}