package com.expedia;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.*;


//Expedia Round 1
public class FirstNonRepeating {

    static class Node {
        char value;
        Node next;
        Node prev;

        public Node(char value) {
            this.value = value;
        }
    }

    public static void printNonRepeating(String input) {

        if (input == null || input.length() == 0) {
            System.out.println();
            return;
        }
        Map<Character, Node> map = new HashMap<>();
        char[] chr = input.toCharArray();
        Node head = new Node(chr[0]);
        Node last = head;
        map.put(chr[0], head);
        System.out.print(head.value);
        Integer abc = MAX_VALUE;
        for (int i = 1; i < chr.length; i++) {
            if (map.containsKey(chr[i])) {
                Node n = map.get(chr[i]);
                if (n == head) {
                    if (n.next != null) {
                        head = n.next;
                        n.next.prev = null;
                    } else {
                        head = null;
                        last = null;
                    }
                } else if (n.next != null) {
                    n.next.prev = n.prev;
                    n.next = n.next.next;
                } else if (n.next == null) {
                    n.prev.next = null;
                }
                map.remove(chr[i]);
                if (head == null) {
                    System.out.print("#");
                } else {
                    System.out.print(head.value);
                }

            } else {
                Node n = new Node(chr[i]);
                map.put(chr[i], n);
                if (head == null) {
                    head = n;
                    last = n;

                } else {
                    last.next = n;
                    n.prev = last;
                    last = n;

                }
                System.out.print(head.value);

            }

        }
        System.out.println();

    }

    public static void main(String[] args) {
        String input = "a2b2c2";

        System.out.println(input);
    }
}
