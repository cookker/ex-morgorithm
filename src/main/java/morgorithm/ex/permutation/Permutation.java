package morgorithm.ex.permutation;

public class Permutation <T> {

    public void printAllRecursive(int n, T[] elements, char delimiter) {
        if(n == 1) {
            printArray(elements, delimiter);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements, delimiter);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements, delimiter);
        }
    }

    private void swap(T[] input, int a, int b) {
        T tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static <T> void printArray(T[] elements, char delimiter) {
        String delimiterSpace = delimiter + " ";
        for(int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + delimiterSpace);
        }
        System.out.print('\n');
    }
    public static void main(String[] argv) {

        Integer[] elements = {1,1,0};
        Permutation<Integer> permutation = new Permutation<>();
        permutation.printAllRecursive(3, elements, ':');

    }

}
