package com.hp.ps;

public class FindSubsString {


    public void printSubsString(String s) {

        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println(s.substring(i, j));
            }
        }


    }

    public static void main(String[] args) {
        FindSubsString s = new FindSubsString();
        //s.printSubsString("abcd");
        String str1 = "Amar";
        String str2 = "Amar";
        String str3 = new String("Amar");
        String str4 = new String("Amar");

        System.out.println("str1.equals(str2) " + str1.equals(str2));
        System.out.println("str1==str2 " + (str1 == str2));


        System.out.println("str3.equals(str4) " + str3.equals(str4));
        System.out.println("str3==str4 " + (str3 == str4));


        System.out.println("str2==str3 " + (str2 == str3));
        System.out.println("str2.equals(str3) " + str2.equals(str3));
    }


}
