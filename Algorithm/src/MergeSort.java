import java.util.*;

public class MergeSort {
	public static Scanner sc = new Scanner(System.in);
	
	public static void mergesort(int arr[], int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			
			mergesort(arr, left, mid);
			mergesort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	public static void merge(int arr[], int left, int mid, int right) {
		int [] temp = new int[arr.length];
		int i = left;
		int j = mid+1;
		int k = left;
		
		while(i <= mid && j <= right) {
			if(arr[i] < arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		
		while(i <= mid)
			temp[k++] = arr[i++];
		while(j <= right)
			temp[k++] = arr[j++];
		
		for(int a = left; a < k; a++)
			arr[a] = temp[a];
	}
	public static void printArr(int arr[]) {
		System.out.print("[");
		for(int i = 0; i < arr.length - 1; i++)
			System.out.print(arr[i] + ",");
		System.out.println(arr[arr.length-1] + "]");	
	}
	public static void main(String[] args) {
		System.out.print("Enter size of Array : ");
		int size = sc.nextInt();
		int [] arr = new int[size];
		
		System.out.print("Enter index of Array : ");
		for(int i = 0; i < size; i++)
			arr[i] = sc.nextInt();
		
		System.out.print("Before Sorted : ");
		printArr(arr);
		long start = System.currentTimeMillis();
		mergesort(arr, 0, size-1);
		long end = System.currentTimeMillis();
		System.out.print("After Sorted : ");
		printArr(arr);
		System.out.println("실행 시간 : " + (end - start) / 1000.0);
	}
}
