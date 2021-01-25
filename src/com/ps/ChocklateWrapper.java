package com.ps;

public class ChocklateWrapper {

    public static int getTotalChocklate(int n){
        int result = n;

        while(n>=3){
            int nc = n/3;
            result+=nc;
            n = n- (nc*3);
            n= n + nc;
        }
        return result;


    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(n + ": " + ChocklateWrapper.getTotalChocklate(n));

        n = 7;
        System.out.println(n + ": " + ChocklateWrapper.getTotalChocklate(n));

        n = 12;
        System.out.println(n + ": " + ChocklateWrapper.getTotalChocklate(n));

        n = 16;
        System.out.println(n + ": " + ChocklateWrapper.getTotalChocklate(n));

        n = 23;
        System.out.println(n + ": " + ChocklateWrapper.getTotalChocklate(n));
    }
}
