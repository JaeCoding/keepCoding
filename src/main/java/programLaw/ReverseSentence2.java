package programLaw;

import java.util.Scanner;

public class ReverseSentence2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) { // 整体反转
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
//      System.out.println(new String(arr));
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) { // 局部反转
            if (arr[i] == ' ' || i + 1 == arr.length) {
                if (arr[i] == ' ') {
                    end = i - 1;
                } else if (i + 1 == arr.length)
                    end = i;
                for (int j = start; j < (start + end + 1) / 2; j++) {
                    char temp = arr[j];
                    arr[j] = arr[start + end - j];
                    arr[start + end - j] = temp;
                }
                start = i + 1;
            }
        }
        System.out.println(new String(arr));
    }
}