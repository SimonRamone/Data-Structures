import java.util.Random;
import java.lang.*;

class HeapSort {

	public static void heapSort(int[] array){
		for (int i = (int) Math.floor(array.length/2); i >= 0; i--){
			buildHeap(array, i);
		}		
	}
	
	public static void buildHeap(int[] array, int i){
		int left = i + 1;
		int right = i + 2;
		int max;
		int heapSize = array.length;
		if (left < heapSize && array[left] > array[i]){
			max = left;
		} else {
			max = i;
		}
			
		if (right < heapSize && array[right] > array[max]){
			max = right;
		}
			
		if (max != i) {
			swap(array, i, max);
			buildHeap(array, max);
		}
	}
	
	public static int[] selectionSort(int[] array){
		int temp;
		int min_index;
		
		for(int i = 0; i < array.length - 1; i++){
			min_index = i;
			for(int j = i+1; j < array.length; j++){
				if(array[min_index] < array[j]){
					min_index = j;
				}	
			}
			temp = array[i];
		array[i] = array[min_index];
		array[min_index] = temp;
		}	
		return array;
	}
	
	public static int[] generateArray(int size){
			Random rand = new Random(); // creating Random object
			int[] array = new int[size];
			for (int i = 0; i < array.length; i++) {
				array[i] = rand.nextInt(); // storing random integers in an array
			}
			return array;
	}
	
	public static final void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] numbers = generateArray(10000);
		int[] numbersCopy = new int[10000];
		System.arraycopy(numbers, 0, numbersCopy, 0, 10000);
		
		final long startTime1 = System.currentTimeMillis(); 
		selectionSort(numbers);
		final long elapsedTime1 = System.currentTimeMillis() - startTime1;
		System.out.println();
		System.out.println("The time taken for selection sort for 10 thousand integers " + elapsedTime1 + "ms");
		
		final long startTime2 = System.currentTimeMillis(); 
		heapSort(numbersCopy);
		final long elapsedTime2 = System.currentTimeMillis() - startTime2;
		System.out.println();
		System.out.println("The time taken for heap sort for 10 thousand integers " + elapsedTime2 + "ms");
	}
}