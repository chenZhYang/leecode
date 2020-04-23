package com.aaronchen.leecode.sortarray;

import com.aaronchen.leecode.solution.Solution;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/31 20:56
 */
public class ISolution extends Solution {


    /**
     * 冒泡排序
     * @param nums
     * @return
     */
    @Override
    public int[] sortArray(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j < nums.length;j++){
                if(nums[i] > nums[j]){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    /**
     * 冒泡排序优化
     * @param nums
     * @return
     */
    public int[] BubbleSort(int[] nums) {
        boolean flag = true;
        for(int i = 1;i<nums.length && flag;i++){
            flag = false;
            for(int j = nums.length - 1;j >= i ;j--){
                if(nums[j-1] > nums[j]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
        }
        return nums;
    }

    /**
     * 希尔排序 - 插入排序的改进版。为了减少数据的移动次数，在初始序列较大时取较大的步长，通常取序列长度的一半，此时只有两个元素比较，交换一次；之后步长依次减半直至步长为1，即为插入排序，由于此时序列已接近有序，故插入元素时数据移动的次数会相对较少，效率得到了提高。
     *
     * 时间复杂度：通常认为是O(N3/2) ，未验证　　稳定性：不稳定
     * @param nums
     */
    public int[] shellSort(int[] nums) {
        int d = nums.length >> 1;
        while(d >= 1){
            for(int i = d; i < nums.length; i++){
                int rt = nums[i];
                for(int j = i - d; j >= 0; j -= d){
                    if(rt < nums[j]){
                        nums[j + d] = nums[j];
                        nums[j] = rt;
                    }else{
                        break;
                    }
                }
            }
            d >>= 1;
        }
        return nums;
    }

    /**
     * 堆排序
     * @param nums
     * @return
     */
    public int[] heapSort(int[] nums) {
        int size = nums.length;
        for (int i = size/2-1; i >=0; i--) {
            adjust(nums, size, i);
        }
        for (int i = size - 1; i >= 1; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjust(nums, i, 0);
        }
        return nums;
    }
    private void adjust(int []nums, int len, int index) {
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        int maxIndex = index;
        if (l<len&&nums[l]>nums[maxIndex]){
            maxIndex = l;
        }
        if (r<len&&nums[r]>nums[maxIndex]){
            maxIndex = r;
        }
        if (maxIndex != index) {
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[index];
            nums[index] = temp;
            adjust(nums, len, maxIndex);
        }
    }

    /**
     * 归并排序 - 采用了分治和递归的思想，
     * 递归&分治-排序整个数列如同排序两个有序数列，
     * 依次执行这个过程直至排序末端的两个元素，
     * 再依次向上层输送排序好的两个子列进行排序直至整个数列有序
     * （类比二叉树的思想，from down to up）。
     * 时间复杂度：O(NlogN) 　　稳定性：稳定
     * @param arr
     */
    private void mergeSortInOrder(int[] arr,int bgn,int mid, int end){
        int l = bgn, m = mid +1, e = end;
        int[] arrs = new int[end - bgn + 1];
        int k = 0;
        while(l <= mid && m <= e){
            if(arr[l] < arr[m]){
                arrs[k++] = arr[l++];
            }else{
                arrs[k++] = arr[m++];
            }
        }
        while(l <= mid){
            arrs[k++] = arr[l++];
        }
        while(m <= e){
            arrs[k++] = arr[m++];
        }
        for(int i = 0; i < arrs.length; i++){
            arr[i + bgn] = arrs[i];
        }
    }

    /**
     * 计数排序 - 桶排序的改进版，桶的大小固定为10，减少了内存空间的开销。首先，找出待排序列中得最大元素max，并依次按max的低位到高位对所有元素排序；
     * 桶元素10个元素的大小即为待排序数列元素对应数值为相等元素的个数，即每次遍历待排序数列，桶将其按对应数值位大小分为了10个层级，桶内元素值得和为待排序数列元素个数。
     * @param arr
     */
    void countSort(int[] arr){
        int[] bk = new int[19];
        Integer max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(max < Math.abs(arr[i])){
                max = arr[i];
            }
        }
        if(max < 0){
            max = -max;
        }
        max = max.toString().length();
        int [][] bd = new int[19][arr.length];
        for(int k = 0; k < max; k++) {
            for (int i = 0; i < arr.length; i++) {
                int value = (int)(arr[i] / (Math.pow(10,k)) % 10);
                bd[value+9][bk[value+9]++] = arr[i];
            }
            int fl = 0;
            for(int l = 0; l < 19; l++){
                if(bk[l] != 0){
                    for(int s = 0; s < bk[l]; s++){
                        arr[fl++] = bd[l][s];
                    }
                }
            }
            bk = new int[19];
            fl = 0;
        }
    }

    /**
     * 计数排序2
     * @param nums
     * @return
     */
    private int[] countSort1(int[] nums){
        int max = -50001, min = 50001;
        for (int num: nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }


        int[] counter = new int[max - min + 1];
        for (int num: nums) {
            counter[num - min]++;
        }

        int idx = 0;
        for (int num = min; num <= max; num++) {
            int cnt = counter[num - min];
            while (cnt-- > 0) {
                nums[idx++] = num;
            }
        }
        return nums;
    }

    /**
     * 桶排序 - 实现线性排序，但当元素间值得大小有较大差距时会带来内存空间的较大浪费。首先，找出待排序列中得最大元素max，申请内存大小为max + 1的桶（数组）并初始化为0；然后，遍历排序数列，并依次将每个元素作为下标的桶元素值自增1；
     * 最后，遍历桶元素，并依次将值非0的元素下标值载入排序数列（桶元素>1表明有值大小相等的元素，此时依次将他们载入排序数列），遍历完成，排序数列便为有序数列。
     *
     * 时间复杂度：O(x*N) 　　稳定性：稳定
     * @param arr
     */
    void bucketSort(int[] arr){
        int[] bk = new int[50000 * 2 + 1];
        for(int i = 0; i < arr.length; i++){
            bk[arr[i] + 50000] += 1;
        }
        int ar = 0;
        for(int i = 0; i < bk.length; i++){
            for(int j = bk[i]; j > 0; j--){
                arr[ar++] = i - 50000;
            }
        }
    }

    /**
     *
     * 插入排序：数列前面部分看为有序，依次将后面的无序数列元素插入到前面的有序数列中，初始状态有序数列仅有一个元素，即首元素。在将无序数列元素插入有序数列的过程中，采用了逆序遍历有序数列，相较于顺序遍历会稍显繁琐，但当数列本身已近排序状态效率会更高。
     *
     * 时间复杂度：O(N2) 　　稳定性：稳定
     * @param arr
     */
    public void insertSort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            int rt = arr[i];
            for(int j = i - 1; j >= 0; j--){
                if(rt < arr[j]){
                    arr[j + 1] = arr[j];
                    arr[j] = rt;
                }else{
                    break;
                }
            }
        }
    }

    /**
     *选择排序
     */
    void selectSort(int[] arr){
        int min;
        for(int i = 0;i<arr.length;i++){
            min = i;
            for(int j = i;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     快速排序
     **/
    void qSort(int[] arr,int start,int end){
        int left = start, right = end;
        if(left < right){
            int temp = arr[left];
            while(left < right){
                while(left < right && arr[right] >= temp){
                    right--;
                }
                if(left < right){
                    arr[left] = arr[right];
                }
                while(left < right && arr[left] < temp){
                    left++;
                }
                if(left < right){
                    arr[right] = arr[left];
                }
            }
            arr[left] = temp;
            qSort(arr,start,left);
            qSort(arr,left + 1, end);
        }
    }

    /**
     * 非递归
     */
    public void qSort2(int[] a, int left, int right) {
        int pivot;
        if (left >= right){
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(left);
        stack.push(right);
        while (!stack.empty()) {
            // 先弹出high,再弹出low
            right = stack.pop();
            left = stack.pop();
            pivot = partition(a, left, right);
            // 先压low,再压high
            if (left < pivot - 1) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < right) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }

    /**
     * 对数组a中下标从low到high的元素，选取基准元素pivotKey，
     * 根据与基准比较的大小，将各个元素排到基准元素的两端。
     * 返回值为最后基准元素的位置
     */
    public int partition(int[] a, int left, int right) {
        // 三数取中,将中间元素放在第一个位置
//        if (a[low] > a[high]){
//            swap(a, low, high);
//        }
//        if (a[(low + high) / 2] > a[high]){
//            swap(a, (low + high) / 2, high);
//        }
//        if (a[low] < a[(low + high) / 2]){
//            swap(a, (low + high) / 2, low);
//        }
        //以上上面三步可有可无
        // 用第一个元素作为基准元素
        int pivotKey = a[left];
        // 两侧交替向中间扫描
        while (left < right) {
            while (left < right && a[right] >= pivotKey){
                right--;
            }
            a[left] = a[right];
            // swap(a, low, high); //比基准小的元素放到低端
            while (left < right && a[left] <= pivotKey){
                left++;
            }
            a[right] = a[left];
        }
        // 在中间位置放回基准值
        a[left] = pivotKey;
        // 返回基准元素所在位置
        return left;
    }

}
