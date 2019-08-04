package leetcode;

public class Leetcode_4_2 {

    /**
     *  将俩数组分成左右两部分，若
     *  1) len(left_part) == len(right_part)
     *  2) max(left_part) <= min(right_part)
     *     保证（B[j-1] <= A[i] and A[i-1] <= B[j])
     *  则 median = (max(left_part) + min(right_part))/2
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //将第一个数组设置为 较短数组
        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        if (m == 0) return (nums2[(n - 1) / 2] + nums2[n / 2]) / 2.0;
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        while (imin < imax) {
            //imin与imax → i → j，所以只要调整imin与imax
            //先设定i为数组1中位数，因保证左右部分个数相同，可推算（i+j = m-i+1 + n-j+1）出j的位置,
            int i = (imin + imax) / 2, j = halfLen - i;
            if (i < m && nums2[j - 1] > nums1[i]) {
                //i is too small, must increase it
                imin++;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                //数组1的左 大于数组2的右，说明数组1左太多了，i应该减小（通过imax减少体现，不是直接减少）
                imax--;
            } else {
                int maxOfLeft, minOfRight;
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                //奇数，直接就是左部分最大
                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }
                //偶数，需要找到右部分最小
                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxOfLeft + minOfRight) / 2.0;
            }
        }
        return -1;
    }

    /**
     * 没有使用imin与imax，直接使用i来作为移动的指针，本质相同
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        if (m == 0) return (nums2[(n - 1) / 2] + nums2[n / 2]) / 2.0;
        int halfLen = (m + n + 1) / 2;
        int i = m / 2;
        while (true) {
            int j = halfLen - i;
            if (i < m && nums2[j - 1] > nums1[i]) {
                //i is too small, must increase it
                i++;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                i--;
            } else {
                int maxOfLeft, minOfRight;
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                //奇数，直接就是左部分最大
                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }
                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxOfLeft + minOfRight) / 2.0;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 6};
        int[] b = new int[]{2, 3, 5};
        double d = new Leetcode_4_2().findMedianSortedArrays(a, b);
        System.out.println(d);
    }
}

