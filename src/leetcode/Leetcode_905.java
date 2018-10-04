package leetcode;

public class Leetcode_905 {
    public static void main(String[] args) {
        Leetcode_905 a = new Leetcode_905();
        int[] num = new int[]{1, 0, 3};
        a.sortArrayByParity2(num);
    }
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int left = 0, right = A.length - 1;
        for (int aA : A) {
            if (aA % 2 == 1) {
                B[right--] = aA;
            } else {
                B[left++] = aA;
            }
        }
        return B;
    }

    public int[] sortArrayByParity2(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            if (A[left] % 2 == 0){left++; continue;}//左边寻找奇数,也就是偶数则continue
            if (A[right] % 2 == 1){right--; continue;}//右边寻找偶数,也就是奇数则continue
            exch(A, left, right);
            left++;
            right--;
        }
        return A;
    }

    private static void exch(int[] arr, int j, int k) {
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }
}

