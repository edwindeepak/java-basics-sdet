import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class graphInterview {

	/*
	 * Given a list of (parent, child) integer pairs representing family
	 * relationships, write a function that returns two lists: 1. All individuals
	 * with zero known parents. 2. All individuals with exactly one known parent.
	 *
	 * Input example: int[][] pairs = { {5, 6}, {1, 3}, {2, 3}, {3, 6}, {15, 12},
	 * {5, 7}, {4, 5}, {4, 9}, {9, 12}, {30, 16} };
	 *
	 * Expected output (order does not matter): [ [1, 2, 4, 15, 30], // individuals
	 * with zero parents [5, 7, 9, 16] // individuals with exactly one parent ]
	 */

	public static void main(String[] args) {

		int[][] pairs = { { 5, 6 }, { 1, 3 }, { 2, 3 }, { 3, 6 }, { 15, 12 }, { 5, 7 }, { 4, 5 }, { 4, 9 }, { 9, 12 },
				{ 30, 16 } };
		findNodesWithZeroAndOneParents(pairs);
	}

	public static void findNodesWithZeroAndOneParents(int[][] pairs) {

		

		Set<Integer> uniqueIndividuals = new HashSet<>();

		// Step 1: Identify all unique individuals
		for (int[] x : pairs) {

			int parent = x[0];
			int child = x[1];
			uniqueIndividuals.add(parent);
			uniqueIndividuals.add(child);

		}

		System.out.println(uniqueIndividuals.toString());

		// Step 2: Count parents for each child
		Map<Integer, Integer> childmap = new HashMap<>();
		Map<Integer, Integer> parentmap = new HashMap<>();

		for (int[] x : pairs) {

			int parent = x[0];
			int child = x[1];

			if (childmap.containsKey(child)) {
				childmap.put(child, childmap.get(child) + 1);
			} else {
				childmap.put(child, 1);
			}		

		}

		
		//Step 3: Categorize individuals
		
		List <Integer> zeroParent = new ArrayList<Integer>();
		List<Integer> oneparent = new ArrayList<Integer>();
		
		for(Map.Entry<Integer, Integer> entry : childmap.entrySet()) {
			if(entry.getValue()==1) {
				oneparent.add(entry.getKey());
			}
		}
		
		System.out.println("One Parent: "+oneparent.toString());
		
		 for(int x : uniqueIndividuals) {
			 
			 if(!childmap.containsKey(x)) {
				 zeroParent.add(x);
			 }
			 
			 
			 
		 }
	
		System.out.println("Zero Parent: "+zeroParent.toString());
		
		
		
		
		

	}

}
