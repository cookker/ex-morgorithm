package morgorithm.mine.template;

import static morgorithm.mine.template.BufferedReaderFunction.solution;

public class TemplateMain {

    public static void main(String[] args) {
        solution(integerList -> System.out.println("integerList = " + integerList));
    }
}
