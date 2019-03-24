import java.util.*;

public class MySort {
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
	public static void sort(int arr[]) {
		int tmp = 0;
		for(int j = 0; j < arr.length; j++) {
			for(int i = j; i < arr.length; i++) {
				if(arr[j] > arr[i]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	public static void printArr(int arr[]) {
		System.out.print("[");
		for(int i = 0; i < arr.length - 1; i++)
			System.out.print(arr[i] + ",");
		System.out.println(arr[arr.length-1] + "]");	
	}
	
	public static void main(String[] args) {
		/*
		System.out.print("Enter size of Array : ");
		int size = sc.nextInt();
		int [] arr = new int[size];
		
		System.out.print("Enter index of Array : ");
		for(int i = 0; i < size; i++)
			arr[i] = sc.nextInt();
		*/
		int [] arr1 = new int[10000];
		int [] arr2 = new int[10000];
		
		for(int i = 0; i < 10000; i++)
			arr1[i] = (int)(Math.random()*100) + 1;
		
		for(int i = 0; i < 10000; i++)
			arr2[i] = arr1[i];
		//System.out.print("Before Sorted : ");
		//printArr(arr);
		long start1 = System.currentTimeMillis();
		sort(arr1);
		long end1 = System.currentTimeMillis();
		
		long start2 = System.currentTimeMillis();
		mergesort(arr2, 0, arr2.length-1);
		long end2 = System.currentTimeMillis();
		//System.out.print("After Sorted : ");
		//printArr(arr);
		System.out.println("My Sort 실행 시간 : " + (end1 - start1) / 1000.0);
		System.out.println("Merge Sort 실행 시간 : " + (end2 - start2) / 1000.0);
	}
}
