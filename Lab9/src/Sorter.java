
public class Sorter {
	private int comparisons;
	private int swaps;
	
	public Sorter() {
		comparisons = 0;
		swaps = 0;
	}
	
	public int getComparisons() {
		return comparisons;
	}
	
	public int getSwaps() {
		return swaps;
	}
	
	public int[] bubbleSort(int intArray[]) {
		comparisons = 0;
		swaps = 0;
		int sortedArray[] = new int[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			sortedArray[i] = intArray[i];
		}
		int numSorts = 0;
		while (numSorts < sortedArray.length) {
			for(int i = 0; i < (sortedArray.length - 1) - numSorts; i++) {
				int t = sortedArray[i];
				int g = sortedArray[i+1];
	
				if(t > g) {
					int temp = sortedArray[i];
					sortedArray[i] = sortedArray[i+1];
					sortedArray[i+1] = temp;
					swaps++;
				}
				comparisons++;
			}
			numSorts++;
		}
		return sortedArray;
	}

}
