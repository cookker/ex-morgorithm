package morgorithm.leet.easy.validparentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    private HashMap<Character, Character> mappings;
    public boolean isValid(String s){

        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }


    public boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');


        final char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            char top = stack.peek();

            if (map.containsKey(c) && map.get(c) == top) {
                stack.pop();
            }else{
                return false;
            }

        }

        return true;
    }

    public boolean isValid3(String s) {

        if(s == null || s.length() == 1){
            return false;
        }
        if(s.length() == 0){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        Stack<Character> pushStack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');


        final char[] chars = s.toCharArray();
        int charSize = 0;

        for (char c : chars) {
            System.out.println("c = " + c);
            if (c == '{' || c == '[' || c == '(') {
                pushStack.push(map.get(stack.push(c)));
                charSize++;
                continue;
            }

            if(pushStack.size() == 0){
                return false;
            }

            if (c == pushStack.peek()) {
                stack.pop();
                pushStack.pop();
                charSize++;
            }
        }

        return stack.size() == 0 && pushStack.size() == 0 && s.length() == charSize;
    }
}
