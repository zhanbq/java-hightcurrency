package com.jikeshijian.ch02.StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
        Map<String, String> parenMap = new HashMap<String, String>();
        parenMap.put(")","(");
        parenMap.put("]","[");
        parenMap.put("}","{");

        Stack<String> stringStack = new Stack<>();

        for(int i = 0; i<s.length();i++){
            String c = String.valueOf(s.charAt(i));
            if(!parenMap.containsKey(c)){
                boolean res = stringStack.add(c);
            }else if(stringStack != null ){
                String pop = stringStack.pop();
                String s1 = parenMap.get(c);
                if(!s1.equals(pop)){
                    return false;
                }
            }
        }
        return stringStack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "{}[[]]";
        boolean valid = ValidParentheses.isValid(test);
        System.out.println(valid);
    }
}
