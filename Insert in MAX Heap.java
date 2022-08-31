public class insertionHeap {

	static void heapify(int[] arr, int n, int i)
	{
		int parent = (i - 1) / 2;
	
		if (arr[parent] > 0) {
			if (arr[i] > arr[parent]) {
				
				int temp = arr[i];
				arr[i] = arr[parent];
				arr[parent] = temp;
			
				heapify(arr, n, parent);
			}
		}
	}
	static int insertNode(int[] arr, int n, int Key)
	{
		n = n + 1;

		arr[n - 1] = Key;

		heapify(arr, n, n - 1);
		return n;
	}
	static void printArray(int[] arr, int n)
	{
		for (int i = 0; i < n; ++i)
			System.out.println(arr[i] + " ");

		System.out.println();
	}

	public static void main(String args[])
	{
		int MAX = 1000;
		int[] arr = new int[MAX];
		
		arr[0] = 10;
		arr[1] = 5;
		arr[2] = 3;
		arr[3] = 2;
		arr[4] = 4;
		
		int n = 5;
		int Key = 15;
		n = insertNode(arr, n, Key);

		printArray(arr, n);
	}
}
