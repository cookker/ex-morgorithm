package morgorithm.leet.easy.longestcommonprefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                System.out.println("strs[i].indexOf(prefix)" + strs[i].indexOf(prefix));
                prefix = prefix.substring(0, prefix.length() - 1);
                System.out.println("prefix=" + prefix);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {


        if(strs == null || strs.length == 0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }



        final List<char[]> collect = Arrays.stream(strs)
                .flatMap(s -> Stream.of(s.toCharArray()))
                .collect(Collectors.toList());

        final Integer minLength = collect.stream()
                .map(s -> s.length)
                .min(Integer::compareTo)
                .orElse(0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < minLength ; i++){
            char s = '\0';
            boolean allSame = true;
            for (char[] chars : collect) {
                if(s != '\0'){
                    allSame &= (s == chars[i]);
                }
                s = chars[i];
            }
            if(!allSame){
                return sb.toString();
            }else{
                sb.append(s);
            }
        }

        return sb.toString();
    }
}