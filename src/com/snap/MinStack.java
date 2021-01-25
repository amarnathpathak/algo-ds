package com.snap;

import java.util.Stack;

public class MinStack {
    int minEle;
    int minIndex = -1;
    Stack<Integer> s;
    public MinStack(){
        s = new Stack<Integer>();
    }
    /*returns min element from stack*/
    int getMin()
    {
        if(minIndex==-1){
            return -1;
        }
        return minEle;// Your code here
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        if(s.isEmpty()){
            return -1;
        }
        int index = s.size()-1;
        int ele = s.pop();
        if(index==minIndex){
            int i= index -1;
            minEle = s.get(i);
            while(i > 0){
                if(s.get(--i) < minEle){
                    minIndex = i;
                    minEle = s.get(i);
                }
            }
        }
        return ele;
        // Your code here       
    }
    /*push element x into the stack*/
    void push(int x)
    {
       if(s.size()==0){
           minEle = x;
           minIndex=0;
       }
       s.push(x);
       if(x < minEle){
           minIndex = s.size()-1;
           minEle = x;
       }
       
    }   

}
