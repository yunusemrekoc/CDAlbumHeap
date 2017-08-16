
public class Heap {
	private int size;
	public int[] heapArray;
	public static int[] sortedArray;

	// ----------------------------------
	Heap(int size)// constructor
	{
		this.size = size + 1;
		heapArray = new int[this.size];
		sortedArray = new int[size];
	}

	// ------------------------------------------
	public void constructHeap(int[] array) {
		heapArray[0] = 0;
		for (int x = 1; x < heapArray.length; x++) {
			heapArray[x] = array[x - 1];
			if (x == 1)
				continue;
			heapify(x);
		}
	}

	// --------------------------------------
	public void heapify(int x) {
		int parent = heapArray[x / 2];
		int child = heapArray[x];
		if (child < parent) {
			int temp;
			temp = heapArray[x];
			heapArray[x] = heapArray[x / 2];
			heapArray[x / 2] = temp;
		}
		if (x > 1)
			heapify(x / 2);
	}

	// ------------------------------------------
	public void sort() {
		for (int x = 0; x < sortedArray.length; x++) {
			sortedArray[x] = heapArray[1];
			heapArray[1] = heapArray[size - 1 - x];
			heapifyForParent(1, size - 1 - x);
		}
	}

	// -------------------------------------------
	public void heapifyForParent(int x, int current) {
		int parent = x;
		int leftChild = 2 * x;
		int rightChild = 2 * x + 1;

		if (leftChild < current && rightChild < current) {
			if (heapArray[parent] > heapArray[leftChild]
					&& heapArray[parent] > heapArray[rightChild]) {
				int minimum_Index = heapArray[leftChild] < heapArray[rightChild] ? leftChild
						: rightChild;
				int temp = heapArray[parent];
				heapArray[parent] = heapArray[minimum_Index];
				heapArray[minimum_Index] = temp;
				heapifyForParent(minimum_Index, current);
			}
		}

		if (leftChild < current) {
			if (heapArray[parent] > heapArray[leftChild]) {
				int temp;
				temp = heapArray[parent];
				heapArray[parent] = heapArray[leftChild];
				heapArray[leftChild] = temp;
				heapifyForParent(leftChild, current);
			}
		}

		if (rightChild < current) {
			if (heapArray[parent] > heapArray[rightChild]) {
				int temp;
				temp = heapArray[parent];
				heapArray[parent] = heapArray[rightChild];
				heapArray[rightChild] = temp;
				heapifyForParent(rightChild, current);
			}
		}
	}
	// --------------------------------------------------------------
}// end Heap class