package morgorithm.ex.xor;

public class Xor {

    public static void main(String[] args) {

        int [] a = new int [] {1,2,3,5};

        int dap = 0;
        for(int i = 1 ; i <= 5 ; i++){
            dap ^= i;
        }

        for(int i = 0 ; i < a.length ; i++){
            dap ^= a[i];
        }

        System.out.println(dap);

    }
}
