import com.hp.ps.StudentFriend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
//        Node tail = new Node(20);
//        Node head = new Node(10, tail);
//
//        RandomSong rs = new RandomSong();
//
//        String[] songs = {"A", "B", "C", "D", "E"};
//        rs.playSongs(songs);
//        songs = new String[]{"A", "B", "C", "D", "E"};
//        rs.playSongs(songs);
//        songs = new String[]{"A", "B", "C", "D", "E"};
//        rs.playSongs(songs);
//        songs = new String[]{"A", "B", "C", "D", "E"};
//        rs.playSongs(songs);
//        songs = new String[]{"A", "B", "C", "D", "E"};
//        rs.playSongs(songs);

        StudentFriend studentFriend =  new  StudentFriend();

        List<String> queryType = new ArrayList<String>();
        queryType.add("Friend");
        queryType.add("Total");
        List<Integer> students1 = new ArrayList<Integer>();
        students1.add(1);
        students1.add(2);

        List<Integer> students2 = new ArrayList<Integer>();
        students2.add(2);
        students2.add(3);
        List<Integer> r = StudentFriend.getTheGroups(3, queryType, students1, students2);
        System.out.println(r);



    }

}
