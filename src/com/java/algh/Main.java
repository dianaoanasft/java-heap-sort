package com.java.algh;

public class Main {

    public static void sort (int arr[]){
        int n = arr.length;
        //Rearrange array(building heap)
        for(int i = n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }
        //Extract elements from heap one by one
        for( int i= n-1; i>= 0; i--){
            //current root moved to the end
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            //calling max heapify on the heap reduced
            heapify(arr, i, 0);
        }
    }
    static void heapify( int arr[], int n, int i) {
        //initialize max as root
        int max = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2*i+2;

        //if left child is greater than root
        if(leftChild < n && arr[leftChild] > arr[max]){
            max = leftChild;
        }
        //if right child is greater than max
        if(rightChild < n && arr[rightChild] > arr[max]){
            max = rightChild;
        }
        //if max is not root
        if(max != i){
            int swap = arr[i];
            arr[i] = arr[max];
            arr[max] =swap;

            // heapify the affected sub-tree recursively
            heapify(arr, n, max);
        }
    }
    //print size of array n using utility function

    static void display(int arr[]){
        int n = arr.length;
        for (int i=0; i<n; ++i){
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
	int arr[] = {6, 5, 3, 1, 8, 7, 2, 4};

        System.out.println("Original array:");
        display(arr);

        sort(arr);

        System.out.println("Sorted array:");
        display(arr);
    }
}
