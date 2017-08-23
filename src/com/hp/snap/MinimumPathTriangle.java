package com.hp.snap;

import java.util.ArrayList;

public class MinimumPathTriangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        for(int i = a.size()-1; i >0;i--){
            ArrayList<Integer> iLessRow = a.get(i-1);
            ArrayList<Integer> iRow = a.get(i); 
            int sizeiRow = iRow.size();
            for(int j=0; j < sizeiRow -1; j ++){
                if(iRow.get(j) > iRow.get(j+1)){
                    iLessRow.set(j, iLessRow.get(j) + iRow.get(j+1));
                }else {
                    iLessRow.set(j, iLessRow.get(j) + iRow.get(j));
                }
            }
        }
        return a.get(0).get(0);
    }

}
