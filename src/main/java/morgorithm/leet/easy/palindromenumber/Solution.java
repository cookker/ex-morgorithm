package morgorithm.leet.easy.palindromenumber;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public boolean isPalindrome(int x) {
        if( x < 0){
            return false;
        }
        Deque<Integer> integerList = new LinkedList<>();

        while(x > 0){
            integerList.addLast(x%10);
            x /= 10;
        }

        while(true){
            if(integerList.size() <= 1){
                return true;
            }
            if( integerList.getFirst().equals(integerList.getLast())){
                integerList.removeFirst();
                integerList.removeLast();
                continue;
            }else {
                break;
            }
        }

        return false;

    }
    /*
    * ==SOLUTION==
    * if(num < 0) return  false;
        int reversed = 0, remainder, original = num;
        while(num != 0) {
            remainder = num % 10; // reversed integer is stored in variable
            reversed = reversed * 10 + remainder; //multiply reversed by 10 then add the remainder so it gets stored at next decimal place.
            num  /= 10;  //the last digit is removed from num after division by 10.
        }
        // palindrome if original and reversed are equal
        return original == reversed;
    * */
}
