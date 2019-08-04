package sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] a = {4, 6, 7, 9, 8, 3, 2};
        sort(a);
        for (int n : a
        ) {
            System.out.println(n + "");
        }
    }

    /**
     * 堆排序的一些坑：  可以配合画图理解
     * 升序用大根堆，降序用小根堆
     * <p>
     * 1. 算法第四版上 是要求第一个元素为空，这样2k和2k+1就是子节点，k/2就是父节点
     * 但是往往给你的数组是0开始的，所以 取n = comparables.length - 1
     * 取 2k+1 和 2K+2为子节点
     * <p>
     * 2. 在取子节点较大 为 比较对象的时候 需要判断 j<n n以内才是堆，以外是排序好了的
     * <p>
     * 3.建堆从n / 2 - 1 开始
     *
     * @param comparables
     */
    public static void sort(int[] comparables) {
        int n = comparables.length - 1;
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(comparables, i, n);
        }
        while (n != 0) {
            comparables = exch(comparables, 0, n--);//交换头尾，尾为堆最大值，堆缩小
            sink(comparables, 0, n);//堆的修复
        }
    }

    private static void sink(int[] comparables, int k, int n) {
        while (2 * k < n) {//只要当前的k还存在子节点
            int j = 2 * k + 1;
            //选择 大的子节点..这个地方是个坑，必须加上j < n.只能用n里面的参与判断，n外的是已排序好的
            if (j < n && comparables[j] < comparables[j + 1]) j++;
            if (comparables[k] > comparables[j]) break; //若父 小于 子 停止
            exch(comparables, k, j);
            k = j;
        }
    }

    private static int[] exch(int[] comparables, int i, int i1) {
        int temp = comparables[i];
        comparables[i] = comparables[i1];
        comparables[i1] = temp;
        return comparables;
    }


}
