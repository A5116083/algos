package com.company.numbers;


import java.util.IdentityHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class RomanNumber {

    private static final TreeMap<Integer,String> roman = new TreeMap<>();

    static{
        roman.put(1000, "M");
        roman.put(900, "CM");
        roman.put(500, "D");
        roman.put(400, "CD");
        roman.put(100, "C");
        roman.put(90, "XC");
        roman.put(50, "L");
        roman.put(40, "XL");
        roman.put(10, "X");
        roman.put(9, "IX");
        roman.put(5, "V");
        roman.put(4, "IV");
        roman.put(1, "I");

    }
    public static void main(String[] args) {
        // write your code here
       /* I             1
        IV            4
        V             5
        IX            9
        X             10
        XL            40
        L             50
        XC            90
        C             100
        CD            400
        D             500
        CM            900
        M             1000*/


        Scanner scanner = new Scanner(System.in);
        System.out.printf("print the interger number to be converted to Roman\n");
        int myInt = scanner.nextInt();
        scanner.close();
        try {
           // System.out.println("Equivalent RomanNum: " + getRomanNumerRecussion(myInt));
            String romanNum= toRomanViaTreeMap(myInt);
            System.out.printf("Equivalent RomanNum: %s%n", romanNum);
            Integer decimalNumber= toNumber(romanNum);
            System.out.printf("Equivalent converted decimal number: %d%n", decimalNumber);

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*int num = myInt;
        for (int i = 1; i <= num; i++) {
            try {
                System.out.println(getRomanNumerRecussion(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    private static String getRomanNumerRecussion(int num) throws  Exception{

        if((num< 0) || (num > 3999)) throw new Exception("insert value betwheen 1 and 3999");
        if(num<1)
            return "";
        if(num>=1000) return "M" + getRomanNumerRecussion(num-1000);
        if(num>=900) return "CM"+ getRomanNumerRecussion(num-900);
        if(num >=500) return "D" + getRomanNumerRecussion(num-500);
        if(num >= 400) return "CD" + getRomanNumerRecussion(num-400);
        if(num >= 100) return "C" + getRomanNumerRecussion(num-100);
        if(num >=90) return "XC" + getRomanNumerRecussion(num- 90);
        if(num >=50) return "L" + getRomanNumerRecussion(num-50);
        if(num >=40) return "XL" + getRomanNumerRecussion(num-40);
        if(num >= 10) return "X"+ getRomanNumerRecussion(num-10);
        if(num >= 9) return "IX" + getRomanNumerRecussion(num -9);
        if(num >=5) return "V" + getRomanNumerRecussion(num-5);
        if(num >=4) return "IV" + getRomanNumerRecussion(num-4);
        if(num>= 1) return "I" + getRomanNumerRecussion(num-1);


        return "";
    }

    private static String toRomanViaTreeMap(int number){
        int l =  roman.floorKey(number);
        if ( number == l ) {
            return roman.get(number);
        }
        return roman.get(l) + toRomanViaTreeMap(number-l);
    }

    static int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
    public static  int toNumber(String roman){
        int result=0;

        for (int i=0;i< roman.length();i++){
            //take the current value at i
            Integer s1= value(roman.charAt(i));
            if(i+1< roman.length()){
                Integer s2= value(roman.charAt(i+1));
                if(s1 >= s2)
                    result = result + s1;
                else{ result= result + s2-s1; i++;}
            }else
                result= result+s1;
        }
        return result;
    }
}
