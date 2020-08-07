package com.jikeshijian.ch02.anagram;

import java.util.HashMap;

public class Anagram {


    public boolean isAnagram(String s1, String s2){

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length() ; i++) {
            String s = String.valueOf(s1.charAt(i));
            Integer count = map1.get(s);
            if(null == count){
                map1.put(s,1);
            }else{
                map1.put(s,count+1);
            }
        }
        for (int i = 0; i < s2.length() ; i++) {
            String s = String.valueOf(s2.charAt(i));
            Integer count = map2.get(s);
            if(null == count){
                map2.put(s,1);
            }else{
                map2.put(s,count+1);
            }
        }
        return  map1.equals(map2);
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        String s1 = "anagram";
        String s2 = "naagrama";
        boolean anagram1 = anagram.isAnagram(s1, s2);
        System.out.println(anagram1);
    }
}
