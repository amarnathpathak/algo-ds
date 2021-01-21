package com.hp.ps;


import java.util.*;


public class StudentFriend {

    public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {

        // Write your code here
        Map<Integer, Friend> fMap = new HashMap<Integer, Friend>();
        for(int i=1; i<=n;i++){
            fMap.put(i, new Friend(i));
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<queryType.size();i++){
            Friend s1 = fMap.get(students1.get(i));
            Friend s2 = fMap.get(students2.get(i));
            if(queryType.get(i)=="Friend"){

                s1.friends.add(s2);
                s2.friends.add(s1);
            }
            if(queryType.get(i)=="Total"){
                int s1t = studentCount(s1, n);
                int s2t = studentCount(s2, n);
                int r = s1t + s2t;
                result.add(r);
            }
        }
        return result;
    }
    private static int studentCount(Friend f, int n){
        boolean[] visited = new boolean[n];
        return studentCount(f, visited);
    }
    private static int studentCount(Friend f, boolean[] visited){
        if(visited[f.n-1]==true){
            return 0;
        }
        visited[f.n-1] = true;
        //List<Friend> friends = f.friends;
        int b = 1;
        for(Friend friend: f.friends){
            b+=studentCount(friend, visited);
        }
        return b;
    }

    private static class Friend {
        public int n;
        public Set<Friend> friends;
        public Friend(int n){
            this.n = n;
            friends = new HashSet<Friend>();
        }
    }
}