package morgorithm.leet.easy.romantointeger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> romanTable = new HashMap<>();

        romanTable.put('I', 1);
        romanTable.put('V', 5);
        romanTable.put('X', 10);
        romanTable.put('L', 50);
        romanTable.put('C', 100);
        romanTable.put('D', 500);
        romanTable.put('M', 1000);

        int length = s.length();
        int sum = romanTable.get(s.charAt(length - 1));

        for (int i = length - 2; i >= 0; i--) {
            if(romanTable.get(s.charAt(i)) >= romanTable.get(s.charAt(i + 1))){
                sum += romanTable.get(s.charAt(i));
            }else{
                sum -= romanTable.get(s.charAt(i));
            }
        }


        return sum;
    }

//    public int romanToInt(String s) {
//
//        Map<Character, Integer> romanTable = new HashMap<>();
//
//        romanTable.put('I', 1);
//        romanTable.put('V', 5);
//        romanTable.put('X', 10);
//        romanTable.put('L', 50);
//        romanTable.put('C', 100);
//        romanTable.put('D', 500);
//        romanTable.put('M', 1000);
//
//        final char[] chars = s.toCharArray();
//        int sum = 0;
//        boolean mustWatchNext = false;
//        for(int i = 0 ; i < chars.length; i++){
//            final char c = chars[i];
//
//            if(c == 'I' || c == 'X' || c == 'C'){
//                mustWatchNext = true;
//            }
//
//            if(mustWatchNext && i + 1 < chars.length){
//                final char n = chars[i+1];
//                if( c == 'I' && n == 'V') {
//                    sum += 4;
//                    i++;
//                }else if ( c == 'I' && n == 'X'){
//                    sum += 9;
//                    i++;
//                }else if ( c == 'X' && n == 'L'){
//                    sum += 40;
//                    i++;
//                }else if ( c == 'X' && n == 'C'){
//                    sum += 90;
//                    i++;
//                }else if ( c == 'C' && n == 'D'){
//                    sum += 400;
//                    i++;
//                }else if ( c == 'C' && n == 'M'){
//                    sum += 900;
//                    i++;
//                }else {
//                    sum += romanTable.get(c);
//                }
//                mustWatchNext = false;
//            }else{
//                sum += romanTable.get(c);
//            }
//
//        }
//
//        return sum;
//    }
}
