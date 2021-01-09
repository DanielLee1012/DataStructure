package com.leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author heibai
 * @date 2021/1/9 13:50
 * 判断括号是否匹配
 */
public class Valid_parentheses {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String inputString = scanner.next();
        System.out.println(Sulution.isValid(inputString));
    }
}

class Sulution{
    public static boolean isValid(String s){
        if (s.length()==0)
            return false;
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)=='{' ||s.charAt(i)=='[' ||s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            else {
                if (stack.isEmpty())
                    return false;
                Character charPop = stack.pop();
                if (s.charAt(i)==')' && charPop!='(')
                    return false;
                if (s.charAt(i)=='}' && charPop!='{')
                    return false;
                if (s.charAt(i)==']' && charPop!='[')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
