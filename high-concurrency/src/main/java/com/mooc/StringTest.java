package com.mooc;

import java.util.ArrayList;
import java.util.Collections;

public class StringTest {


    public static void main(String[] args) {
        String a = "ab";
        String b = "ab";
        System.out.println(a==b);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);

        Collections.sort(list);

        list.set(3,2);

        Collections.reverse(list);

        System.out.println(list);


    }
}
