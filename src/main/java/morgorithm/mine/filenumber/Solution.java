package morgorithm.mine.filenumber;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
* 파일명은 영문자 or 영문자와괄호(숫자)로 이루어져 있다.
* filename(1) : O
* filename(1.1) : X
* filename()() : X
* filename(0)(1): X
* */

public class Solution {

    public static void main(String[] args) {
//        System.out.println(">> " + "filename(1.0)".replaceAll("[a-z][A-Z]*", "*"));
//        System.out.println(">> " + "filename(1.0)".replaceAll("\\([a-z][A-Z]*\\)", "*"));
//        System.out.println(">> " + "filename(1.0)".replaceAll("[^[\\([a-z][A-Z]*\\)]]", "!"));
//        System.out.println(">> " + "filename(1.0)".replaceAll("[a-z][A-Z]*", "*"));
//        System.out.println(">> " + "filename(1.0)".replaceAll("[^0-9]", "*"));
//        System.out.println(">> " + "filename(1.0)".replaceAll("[^\\([0-9]*\\)]", "*"));
//        final String s = "filename(1.0)".replaceAll("[^\\([0-9]*\\)]", "*");
//        System.out.println(s.replaceAll("[\\(|\\)]", "#"));
//
//        System.out.println("10.0".replaceAll("[\\d+]", "#"));
//        System.out.println("10.0".replaceAll("[\\d+]", "#"));

    }
//
    public String [] suffixNumber(String [] filenames){




        final Map<String, String> collect = Arrays.stream(filenames)
                .collect(Collectors.toMap(Function.identity(), Function.identity(), (f1, f2) -> {
//                    return splitExtension(f1)[0] + "(1)" + "." + splitExtension(f1)[1];
                    return new FileNameStructure(f1).fullFileName();
                }));

        final String[] values = collect.values().toArray(new String[0]);

        return values;
    }

    public static class FileNameStructure {
        private String fileName;
        private String number;
        private String extension;
        public FileNameStructure(String str){
            final String[] strings = splitExtension(str);
            fileName = strings[0];
            extension = strings[1];
            number = fileName.replaceAll("[^\\([0-9]*\\)]", "");
            number = number.replaceAll("[\\(|\\)]", "");
//            number = fileName.replaceAll("[\\([a-z][A-Z]*\\)]", "");
            System.out.println(number);
        }

        private String getNumber(){
            return hasNumber() ? "(" + (Integer.parseInt(number) + 1) + ")" : "(1)";
        }

        public String fullFileName(){
            return getOnlyFileName() + getNumber() +"." + extension;
        }

        private String getOnlyFileName(){
            if(hasNumber()){
                return fileName.substring(0, fileName.lastIndexOf('('));
            }
            return fileName;
        }

        private boolean hasNumber(){
            return number != null && number.length() > 0;
        }
    }

    public static String [] splitExtension(String filename){
        final int i = filename.lastIndexOf('.');
        if( i > 0){
            return new String[]{filename.substring(0, i), filename.substring(i + 1)};
        }
        return new String[]{filename};
    }
}
