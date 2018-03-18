package sort;

public class SmallNum{
    private static int sortProcess(int[] arr, int l, int r) {
        if(l == r){
            return 0;
        }
        int mid = (l + r) / 2;
        return sortProcess(arr, l, mid) + sortProcess(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l, p2 = mid + 1, i = 0, res = 0;
        while (p1 <= mid && p2 <= r){
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = Utils.randomGenerator(10, 10);
        Utils.printArray(arr);
        int res = sortProcess(arr, 0, arr.length - 1);
        System.out.println(res);
    }
}
