package pointOffer;

public class Question_nk_6 {
    public static int Fibonacci(int n) {
        if(n == 1 || n == 2) return 1;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length ; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[n-1];
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
    }
}