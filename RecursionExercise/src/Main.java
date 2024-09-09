
public class Main {
	public int findLargest (int [] array, int n) {
		// Base case
		if (n == 1) {
			return array[0];
		
		}
		// Recursive case
		int nextLargest = findLargest(array, n - 1);
		return Math.max(array[n-1], nextLargest);
	}

	public static void main(String[] args) {
		
		int [] array = {8, 19, 27, 6, 9};
		Main main = new Main();
		int largest = main.findLargest(array, array.length);
		System.out.println("The largest element is " + largest);
		
		
		
		

	}
	
	
	

}
