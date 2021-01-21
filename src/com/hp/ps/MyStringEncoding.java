package com.hp.ps;

import java.util.ArrayList;
import java.util.List;

public class MyStringEncoding {

    char[] encoders = {'a', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    public int findNumberOfDecodedMessage(int num) {

        String str = String.valueOf(num);
        if (str.length() == 1) return 1;

        int sum = findNumberOfDecodedMessage(Integer.valueOf(str.substring(1)));

        if (str.length() > 1 && isValid(str.substring(0, 2))) {
            if (str.length() == 2) {
                sum++;
            } else {
                sum = sum + findNumberOfDecodedMessage(Integer.valueOf(str.substring(2)));
            }

        }
        return sum;
    }

    public void printDecodedMessage(int num) {
        int numberOfWays = findNumberOfDecodedMessage(num);
        System.out.println("Number Of Ways: " + numberOfWays);
        List<String> messages = getDecodedMessage(num);

        for (String s : messages) {
            System.out.println(s);
        }


    }

    private List<String> getDecodedMessage(int num) {

        String str = String.valueOf(num);
        if (str.length() == 1) {
            List<String> list = new ArrayList<String>();
            list.add(decode(str));
            return list;
        }


        List<String> list = getDecodedMessage(Integer.valueOf(str.substring(1)));
        String a = decode(str.substring(0, 1));
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String sec = list.get(i);
                String b = a + sec;
                list.set(i, b);
            }
        }


        if (str.length() == 2) {
            String first = str.substring(0, 2);
            if (isValid(first)) {
                list.add(decode(first));
            }
            return list;
        }

        if (str.length() > 2) {
            String first = str.substring(0, 2);
            if (isValid(first)) {
                List<String> seconds = getDecodedMessage(Integer.valueOf(str.substring(2)));
                for (int i = 0; i < seconds.size(); i++) {
                    String sec = seconds.get(i);
                    String b = decode(first) + sec;
                    list.add(b);
                }
            }

        }
        return list;
    }


    private String decode(String num) {
        return String.valueOf(encoders[Integer.parseInt(num)]);
    }

    private boolean isValid(String s) {
        int num = Integer.parseInt(s);
        return num >= 1 && num <= 26;
    }

    public static void main(String[] args) {
        MyStringEncoding mse = new MyStringEncoding();
        mse.printDecodedMessage(227);
    }


}
