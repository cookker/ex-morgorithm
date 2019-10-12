package morgorithm.mine.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface BufferedReaderFunction {

    void process(List<Integer> integerList);

    static void solution(BufferedReaderFunction readerFunction) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final String line = br.readLine();
            final String[] split = line.split(" ");
            final List<Integer> collect = Arrays.stream(split)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            readerFunction.process(collect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
