package Tutorial;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,4,6,15,19,25,30};
        System.out.println("Target is at index: "+ Search(arr, 2));
        int[] arr2 = {30, 25,20,15,10,5};
        System.out.println("Target is at index: "+ Search(arr2, 10));
    }

    // Order Agnostic Binary Search
    static int Search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            int med = start + (end-start)/2;

            if(target == arr[med]) {
                return med;
            }

            if (isAsc) {
                if(target < arr[med]) {
                    end = med - 1;
                } else {
                    start = med + 1;
                }
            } else {
                if(target > arr[med]) {
                    end = med - 1;
                } else {
                    start = med + 1;
                }
            }
        }
        return -1;
    }
}
