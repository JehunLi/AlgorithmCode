import java.util.ArrayList;

public class HeapSort {
    public static void sort(ArrayList<Integer> arr){
        int last = arr.size() -1;
        int lastParent = getParentIndex(last);
        for(int i =lastParent; i >= 0; i--){
            sink(arr, i, last);
        }
        while(last>0){
            exchange(arr, 0, last--);
            sink(arr,0, last);
        }
    }

    private static void sink(ArrayList<Integer> arr, int i, int end) {
        while(i<=getParentIndex(end)){
            int left = getLeftChildIndex(i);
            int right = getRightChildIndex(i);
            int largerChild;
            if(end<left) break;
            else if(end < right) largerChild = left;
            else largerChild = more(arr.get(right), arr.get(left)) ? right : left;

            if(more(arr.get(largerChild), arr.get(i))){
                exchange(arr, largerChild, i);
                i = largerChild;
            }else break;
        }
    }


    private static void exchange(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private static boolean more(int a, int b) {
        return a > b;
    }

    private static int getRightChildIndex(int i) {
        return (i*2)+2;
    }

    private static int getLeftChildIndex(int i) {
        return (i*2)+1;
    }

    private static int getParentIndex(int i) {
        return (i-1)/2;
    }
}
