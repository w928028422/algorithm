package sort;
import java.util.Arrays;

/**
 * 题目描述:给定一个无序数组，输出数组如果排序后相邻两个数的最大差值，时间复杂度O(n)，不能使用基数排序、计数排序
 * 思路:建立N+1个桶，第0号桶保存最小值，第N+1号桶保存最大值，然后把桶平分成N份装载最小值到最大值范围内的所有数，但是每个桶只记录自己是否为空，
 * 以及桶内元素的最小值和最大值。从第1号桶开始，每个桶都记录自己的最小值与前一个非空桶的最大值之差，这个差值的最大值就是结果
 * 正确性:因为有N个数和N+1个桶，所以至少有一个桶为空，那么要出现的最大差值就不可能在一个桶内，一定是前一个桶的最大值与后一个桶的最小值之差。
 */

class Bucket {
    int max;
    int min;
    boolean hasNum;

    Bucket() {
        this.max = 0;
        this.min = 0;
        this.hasNum = false;
    }
}

public class BucketSort {

    public static void main(String[] args) {
        int[] nums = Utils.randomGenerator(10, 100);
        System.out.println(Arrays.toString(nums));
        System.out.println(solution(nums));
        System.out.println(rightMethod(nums));
    }

    private static int rightMethod(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int res = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    public static int solution(int[] nums){
        if (nums == null || nums.length < 2){
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = nums.length, res = 0, bid;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        if (max == min){
            return 0;
        }
        Bucket[] buckets = new Bucket[n + 1];
        for (int i = 0; i < n + 1; i++) {
            buckets[i] = new Bucket();
        }
        for (int i = 0; i < n; i++) {
            bid = n * (nums[i] - min) / (max - min);
            buckets[bid].min = buckets[bid].hasNum ? Math.min(buckets[bid].min, nums[i]) : nums[i];
            buckets[bid].max = buckets[bid].hasNum ? Math.max(buckets[bid].max, nums[i]) : nums[i];
            buckets[bid].hasNum = true;
        }
        int lastMax = buckets[0].max;
        for (int i = 1; i < n + 1; i++) {
            if (buckets[i].hasNum){
                res = Math.max(res, buckets[i].min - lastMax);
                lastMax = buckets[i].max;
            }
        }
        return res;
    }
}
