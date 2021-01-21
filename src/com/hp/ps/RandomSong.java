package com.hp.ps;

import java.util.PriorityQueue;

public class RandomSong {

    static class Pair implements Comparable<Pair>{

        int hotelId;
        Integer score;
        public Pair(int hotelId, Integer score){
            this.hotelId=hotelId;
            this.score = score;
        }

        @Override
        public int compareTo(Pair o) {
            return this.score.compareTo(o.score);
        }
    }

    public void playSongs(String[] songs) {
        int l = songs.length;

        System.out.println("--------------");
        printSongs(songs);
        for (int i = 0; i < l; i++) {
            int randomSongs = getRandom(l - i);
            String temp = songs[l - i - 1];
            songs[l - i - 1] = songs[randomSongs];
            songs[randomSongs] = temp;

        }
        printSongs(songs);
        System.out.println("--------------");
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();


    }



    int getRandom(int upto) {
        double r = Math.random() * 1000;
        return (int) r % upto;
    }

    void printSongs(String[] songs) {
        for (int i = 0; i < songs.length; i++) {
            System.out.print(songs[i] + ", ");
        }
        System.out.println();
    }


}
