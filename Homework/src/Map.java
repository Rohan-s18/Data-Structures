import java.util.*;

public class Map {
	//Instance variables
	private Building[] buildings;		//Array for the buildings on the map
	private int numBuildings;			//count for the number of buildings
	private int maxNum;					
	PriorityQueue<Road> dijkstraPQ;		//Priority Queue for Dijkstra's algorithm (Since Java doesn't have heap, I will use its priority queue)
	int[] dj;							//array for dijkstra's algorithm 
	Boolean[] finalSet;					//Set for finalized buildings in dijkstra's algorithm
	
	private class Building{
		private String id;					//Id for the building
		private LinkedList<Road> roads;		//Adjacency list
		//private boolean encountered;
		//private boolean done;
		private Building parent;			//Pointer to parent building
		//private int cost;
		private Building(String id) {
			this.id = id;
			roads = new LinkedList<Road>();
		}
	}
	
	private class Road implements Comparator<Road>, Comparable<Road>{
		//This class implements Comparator and Comparable so that it can be added to the priority queue
		private int toIndex;		//index of destination building
		private int cost;			//cost of the road
		private Road(int toIndex, int cost) {
			this.toIndex = toIndex;
			this.cost = cost;
		}
		@Override
		public int compare(Road o1, Road o2) {		
			if(o1.cost < o2.cost)
				return -1;
			if(o2.cost < o1.cost)
				return 1;
			return 0;
		}
		@Override
		public int compareTo(Road o) {
			if(this.cost < o.cost)
				return -1;
			if(this.cost > o.cost)
				return 1;
			return 0;
		}
	}
	
	public Map(int maximum) {
		//Initialization
		maxNum = maximum;
		buildings = new Building[maxNum];
		numBuildings = 0;
		dijkstraPQ = new PriorityQueue<Road>();
		dj = new int[maximum];
		finalSet = new Boolean[maximum];
	}

	public static void main(String[] args) {
		/*
		//Initializing the Map
		Map testMap = new Map(2);
		
		//Adding the buildings
		testMap.addBuilding("PB Lewis");
		testMap.addBuilding("Tinkham Veale");
		testMap.addBuilding("KSL");
		testMap.addBuilding("Tomlinson");
		testMap.addBuilding("Crawford Hall");
		testMap.addBuilding("Strosacker");
		testMap.addBuilding("Schmitt");
		testMap.addBuilding("Nursing Research Building");
		
		//Adding the roads
		testMap.addRoad("PB Lewis", "Tinkham Veale", 10);
		testMap.addRoad("PB Lewis", "Nursing Research Building", 30);
		testMap.addRoad("KSL", "Crawford Hall", 20);
		testMap.addRoad("Tinkham Veale", "KSL", 5);
		testMap.addRoad("Crawford Hall", "Tomlinson", 5);
		testMap.addRoad("Crawford Hall", "Strosacker", 15);
		testMap.addRoad("Strosacker", "Schmitt", 10);
		testMap.addRoad("Schmitt", "Nursing Research Building", 20);
		
		testMap.printGraph();
		System.out.println("\n");
		//testMap.removeBuilding("Nursing Research Building");
		testMap.printGraph();
		System.out.println("\n");
		//System.out.println(testMap.shortestLength("PB Lewis", "Crawford Hall"));
		int x = testMap.shortestLength("PB Lewis", "Crawford Hall");
		//testMap.printSolution(testMap.dj);
		testMap.shortestLengthPrint("PB Lewis", "Crawford Hall", x);
		System.out.println("\n");
		List<String> myList = testMap.shortestPath("PB Lewis", "Crawford Hall");
		testMap.shortestPathPrint(myList);
		System.out.println("\n");
		System.out.println(testMap.minimumTotalLength());*/
		
		
		
		
		Map midwestMap = new Map(2);
		midwestMap.addBuilding("Buffalo");
		midwestMap.addBuilding("Cleveland");
		midwestMap.addBuilding("Pittsburgh");
		midwestMap.addBuilding("Columbus");
		midwestMap.addBuilding("Cincinnati");
		midwestMap.addBuilding("Toledo");
		midwestMap.addBuilding("Detroit");
		midwestMap.addBuilding("Chicago");
		midwestMap.addBuilding("Indianapolis");
		midwestMap.addBuilding("Milwaukee");
		
		//Adding roads
		midwestMap.addRoad("Buffalo", "Cleveland", 191);
		midwestMap.addRoad("Buffalo", "Pittsburgh", 216);
		midwestMap.addRoad("Cleveland", "Toledo", 117);
		midwestMap.addRoad("Cleveland", "Columbus", 143);
		midwestMap.addRoad("Cleveland", "Pittsburgh", 135);
		midwestMap.addRoad("Pittsburgh", "Columbus", 185);
		midwestMap.addRoad("Columbus", "Cincinnati", 101);
		midwestMap.addRoad("Cincinnati", "Toledo", 198);
		midwestMap.addRoad("Cincinnati", "Indianapolis", 110);
		midwestMap.addRoad("Toledo", "Detroit", 60);
		midwestMap.addRoad("Toledo", "Chicago", 244);
		midwestMap.addRoad("Detroit","Chicago",281);
		midwestMap.addRoad("Chicago", "Indianapolis", 181);
		midwestMap.addRoad("Chicago", "Milwaukee", 60);
		
		ArrayList<String> highways = new ArrayList<String>();
		highways.add("Pittsburgh");
		highways.add("Cleveland");
		highways.add("Chicago");
		highways.add("Detroit");
		midwestMap.addRoads("Chicago", highways, 1000);
		
		//Printing the graph
		midwestMap.printGraph();
		System.out.println("\n");
		
		midwestMap.removeBuilding("Milwaukee");
		midwestMap.removeRoad("Chicago", "Detroit");
		midwestMap.printGraph();
		System.out.println("\n");
		
		
		int x = midwestMap.shortestLength("Buffalo", "Toledo");
		midwestMap.shortestLengthPrint("Buffalo", "Toledo", x);
		//midwestMap.printSolution(midwestMap.dj);
		System.out.println("\n");
		
		List<String> ll = midwestMap.shortestPath("Buffalo", "Toledo");
		midwestMap.shortestPathPrint(ll);
		System.out.println("\n");
		
		int y = midwestMap.minimumTotalLength();
		System.out.println("The minimum total length of road is: " + String.valueOf(y));
		System.out.println("\n");
		
		int z = midwestMap.secondShortestPath("Cleveland", "Buffalo");
		System.out.println("The second shortest length: " + String.valueOf(z));
		
		
		
	}
	
	//----------------------------------------------------------General Purpose Helper methods--------------------------------------------------------------------------------
	
	//Returns the index of the building with the given String id
	private int indexOf(String str) {		//Returns the index of the building with the given String id
		
		for(int i = 0; i < numBuildings; i++) {
			if(buildings[i] != null && buildings[i].id.toLowerCase().equals(str.toLowerCase()))
				return i;			//returning the index of the building with the same id
		}
		
		return -1;		//returning -1 if building is not in the array
	}
	
	//Increases the size of all of the instance arrays if the number of buildings exceeds the limit
	private void checkOverLoad() {			
		
		if(numBuildings < maxNum) 		
			return;							//Exiting the method if we are within the safe limit
		
		//storing the old arrays
		int oldMax = maxNum;
		Building[] oldBuildings = buildings;
		int[] oldDj = dj;
		Boolean[] oldSet = finalSet;
		maxNum *= 2;
		
		//Increasing the size of the arrays
		buildings = new Building[maxNum];
		dj = new int[maxNum];
		finalSet = new Boolean[maxNum];
		
		//Re-adding the elements back to the original arrays
		for(int i = 0; i < oldMax; i++) {
			buildings[i] = oldBuildings[i];
			dj[i] = oldDj[i];
			finalSet[i] = oldSet[i];
		}
	}

	//Method to print the graph the way it is represented on paper (Adjacency List representation)
	public void printGraph() {				
		for(int i = 0; i < numBuildings; i++) {
			String printStr = "";
			if(buildings[i] != null) {
				printStr += buildings[i].id;						//Adding the id of the building to the String
				if(!buildings[i].roads.isEmpty()) {
					printStr += " : ";
					for(Road r : buildings[i].roads) {		//Traversing through the Linked List of roads 
						if(buildings[r.toIndex]!=null) {
							printStr += buildings[r.toIndex].id;	//Adding the id of the destination building to the String
							printStr += ", ";
						}
					}
					printStr = printStr.substring(0,printStr.length()-2);
				}
				System.out.println(printStr);
			}
		}
	}
	
	//Method to print the shortest length between the source and destination
	public final void shortestLengthPrint(String source, String destination, int x) {
		System.out.println(destination + " is " + String.valueOf(x)+ " away from "+ source);
	}
	
	//Method to print the path, given the returned list of Strings from the shortest path method
	public final void shortestPathPrint(List<String> ls) {
		
		if(ls.size() == 0)		//if the list is empty
			return;
		
		String printStr = "";
		for(String s : ls)
			printStr += s + " -> ";
		printStr = printStr.substring(0,printStr.length()-3);
		
		System.out.println(printStr);
	}
	
	//Method that returns the length of the road between the source and destination (if it exists) <= This method will be used in second shortest path
	private int lengthOfRoad(String source, String destination) {
		
		//Getting the indices for the source and destination
		int src = indexOf(source);
		int dest = indexOf(destination);
		
		//If building doesn't exist we will throw an illegal argument exception
		if(src == -1 || dest == -1)
			throw new IllegalArgumentException("Add buildings that exist on the map");		
		
		LinkedList<Road> myList = buildings[indexOf(source)].roads;		//Getting the list of roads from the building at the source
		Iterator<Road> itr;
		//Traversing through the list of roads to see if one of them is to the destination
		for(itr = myList.iterator(); itr.hasNext();) {
			Road r = itr.next();
			if(buildings[r.toIndex].id.toLowerCase().equals(destination.toLowerCase()))
				return r.cost;											//Returning the cost of the road if we find it in the list
		}
		return 0;		//This happens if no road exists between the source and destination	
	}
	
	//--------------------------------------------------------End of General Purpose Helper methods------------------------------------------------------------------------------
	

	
	//Method to add a building to the map
	public final boolean addBuilding(String name) {
		
		if(indexOf(name) != -1)			//Case that the building already exists on the map
			throw new IllegalArgumentException("Building Already Exists");
		
		buildings[numBuildings] = new Building(name);		//Adding a new Building object with the id as name
		numBuildings++;
		checkOverLoad();		//Checking if we have overloaded
		return true;
	}
	
	//Method to add a bidirectional road between the source building and destination building of a given length
	public final boolean addRoad(String fromBuilding, String toBuilding, int length) {
		int i = indexOf(fromBuilding);		//finding the index of the source building
		int j = indexOf(toBuilding);		//finding the index of the destination building
		
		if(i == j)							//If both indices are the same, then no road can be added between them
			return false;
		
		if(i == -1) {						//Case if the source building doesn't exist on the map
			addBuilding(fromBuilding);		//Adding the source building to the map
			i = indexOf(fromBuilding);
		}
		if(j == -1) {						//Case if the destination building doesn't exist on the map
			addBuilding(toBuilding);		//Adding the destination building to the map
			j = indexOf(toBuilding);
		}
		
		LinkedList<Road> tempList = buildings[i].roads;		//Getting the list of roads of the source building
		Iterator<Road> itr; 
		for(itr = tempList.iterator(); itr.hasNext();) {	//Traversing through the list in order to see if a road between the buildings already exists
			Road r = itr.next();				
			if(r.toIndex == j)								//Case if the road points to the destination building
				return false;								//Since a road already exists, no road can be add
		}
		
		buildings[i].roads.add(new Road(j,length));			//Adding a road to the destination to the list of roads from the source building
		buildings[j].roads.add(new Road(i,length));			//Adding a road to the source to the list of roads from the destination building (bidirectional road)
		return true;
	}
	
	//Method to add a collection of roads between the source building and destination buildings
	public final boolean addRoads(String fromBuilding,Collection<String> toBuildings, int length) {
		
		int i = indexOf(fromBuilding);
		if(i == -1)						//Adding the source building if doesn't exist on the map
			addBuilding(fromBuilding);
		
		Iterator<String> itr = toBuildings.iterator();
		while(itr.hasNext()) {			//Traversing through the collection of Strings
			String toBuilding = itr.next();
			addRoad(fromBuilding, toBuilding, length);		//Using the existing addRoad method to add a road between the buildings
		}
		return true;
	}
	
	//method to remove a building from the map
	public final boolean removeBuilding(String name) {
		
		int buildingIndex = indexOf(name);		//Getting the index of the building to be removed
		if(buildingIndex == -1)					//Cannot remove a building if it doesn't exist on the map
			return false;
		
		//Shifting all of the buildings which were after the building to be removed, to the left by one space
		for(int index = buildingIndex; index < numBuildings; index++) 
			buildings[index] = buildings[index+1];
		
		numBuildings--;			//decreasing the counter for the number of buildings
		
		//Updating the destination indices of the roads
		for(int j = 0; j < numBuildings; j++) {
			Iterator<Road> tempItr = buildings[j].roads.iterator();
			while(tempItr.hasNext()) {				//Traversing through the list of roads
				Road r = tempItr.next();
				
				//If the destination index is greater than the index of the removed building, the destination index will be reduced by 1
				if(r.toIndex > buildingIndex)		
					r.toIndex--;
				
				//If the destination index points to the building to the removed building, then we will delete this node
				if(r.toIndex == buildingIndex)
					tempItr.remove();
			}
		}
		return true;
	}
	
	//Method to remove a road between 2 buildings
	public final boolean removeRoad(String fromBuilding, String toBuilding) {
		
		//finding the indices of the source and destination buildings
		int i = indexOf(fromBuilding);
		int j = indexOf(toBuilding);
		if(i == -1 || j == -1)
			return false;			//returning false, if one of the 2 buildings doesn't exist
		
		ListIterator<Road> delItr;
		//Traversing through the List of Roads from the source buildings, and deleting the road that points to the destination, if we encounter it.
		for(delItr = buildings[i].roads.listIterator(); delItr.hasNext();) {
			Road r = delItr.next();
			if(r.toIndex == j) {		//Checking the pointer
				delItr.remove();		//Deleting the road if it matches
				break;
			}
		}
		//Traversing through the List of Roads from the destination buildings, and deleting the road that points to the source, if we encounter it.
		for(delItr = buildings[j].roads.listIterator(); delItr.hasNext();) {
			Road r = delItr.next();
			if(r.toIndex == i) {		//Checking the pointer
				delItr.remove();		//Deleting the road if it matches
				return true;
			}
		}
		return false;
	}
	
	//Method to find shortest length between 2 buildings
	public final int shortestLength(String source, String destination) {
		
		//Finding the indices of the source and destination
		int src = indexOf(source);
		int dest = indexOf(destination);
		//Throwing an illegal argument exception if either of the buildings is not on the Map
		if(src == -1 || dest == -1) 
			throw new IllegalArgumentException("Illegal source or destination");
		
		shortestLengthHelper(src);		//Using the helper method which uses Djikstra's algorithm to find the shortest path
		return dj[dest];
	}
	
	//---------------------------------------------Private helper methods for Dijkstra's Algorithm-----------------------------------------------------------------------------------------
	
	private void shortestLengthHelper(int src) {
		
		//dj[k] : It is the current path cost estimate for the building at the kth index
		//finalSet[k] : The boolean at this index represents whether the building at the kth index is finalized or not
		//dijkstraPQ : It is the priority queue where we store paths in the form of roads from the source building to all of the buildings, it helps us make the algorithm more efficient
		
		
		//Initialization of variables
		int numSet = 0;									//Initializing the counter for the finalized buildings as 0
		
		for(int i = 0; i < numBuildings; i++) {
			//Initializing the path estimate for every building with the maximum integer (infinity is not available for java) 
			dj[i] = Integer.MAX_VALUE;	
			
			//Initializing the set of finalized buildings as false for every building
			finalSet[i] = false;					
		}
		
		dijkstraPQ.add(new Road(src,0));		//Adding a road of length 0, since it is from the source to the source
		dj[src] = 0;							//Keeping the path cost estimate for the source as 0 
		buildings[src].parent = null;			//Setting the parent of the source building as zero, since it is that start of the shortest path
		numSet++;								//Increasing the number of finalized buildings
		
		while(numSet < numBuildings) {			//Staying in this loop till the number of finalized buildings is less than the number of buildings
			
			//If the priority queue is empty, we will return from this method
			if(dijkstraPQ.isEmpty())
				return;
			
			int index = dijkstraPQ.remove().toIndex;	//Getting the index of the neighbor with the lowest road cost
			if(finalSet[index])							//We will skip this loop if the building at 'index' has been finalized
				continue;
			
			finalSet[index] = true;						//Finalizing the building at 'index'
			numSet++;									//Increasing the number of finalized buildings by 1
			
			//Using a helper method to process the neighbors of the building at 'index'
			processNeighborsDjikstra(index);
		}
		
	}
	
	private void processNeighborsDjikstra(int x) {
		
		//roadDistance : stores the cost of the roads from the building at index x to its neighbors
		//newDistance: stores the path cost estimate for the buildings which are the neighbors of the building at index x
		
		int roadCost = -1;
        int totalPathCost = -1;
        Building b = buildings[x];
        Iterator<Road> itr;
        
        for(itr = b.roads.iterator();itr.hasNext();) {		//Traversing through all of the one-hop neighbors of the building at index x
        	Road r = itr.next();
        	int neighborIndex = r.toIndex;					//Getting the index of the one-hop neighbor of the building at x
        	
        	if(!finalSet[neighborIndex]) {					//If the building at 'neighborIndex' is not finalized yet
        		
        		roadCost = r.cost;							//Setting the road distance as the cost of the road
                totalPathCost = dj[x] + roadCost;			//Setting the total cost as the sum of the path cost of the building at index 'x' and the road cost
                
                //If the totalPathCost is less than the current cost estimate for neighbor index, then we will update it to the totalPathCost
                if (totalPathCost < dj[neighborIndex]) {	
                    dj[neighborIndex] = totalPathCost;
                    buildings[neighborIndex].parent = buildings[x];		//Setting the building at x as the parent of the building at neighborIndex 
                }
                
                //Adding a path from the source building to the building at neighborIndex with a cost of its cost estimate 
                dijkstraPQ.add(new Road(neighborIndex,dj[neighborIndex]));		
        	}
        }
	}
	
	//-------------------------------------------End of private helper methods for Dijkstra's algorithm-----------------------------------------------------------------------------------
	
	//Method that returns the list of the ids of the buildings which are in the shortest path between source and destination
	//------------------------------------------End of private helper methods for Dijkstra's Algorithm--------------------------------------------------------------------------------------
	
	public final List<String> shortestPath(String source, String destination){
		
		//Getting the indices of the source and destination buildings
		int src = indexOf(source);
		int dest = indexOf(destination);
		
		//Checking if one of the buildings doesn't exist or if both buildings are the same
		if(src == -1 || dest == -1 || src == dest)
			return null;			//Returning null
		
		//Calling the shortest length method which uses dijkstra's algorithm, because the algorithm already creates a spanning tree for the shortest path already
		shortestLength(source,destination);
		
		//Creating initializing 2 lists
		LinkedList<String> tempList = new LinkedList<String>();
		LinkedList<String> pathList = new LinkedList<String>();
		
		Building destBuilding = buildings[dest];	//Obtaining the destination building
		
		Building trav = destBuilding;				//Using this building to traverse through the spanning tree
		
		while(trav != null) {	//Traversing through the list till we reach the end of the spanning tree 
			tempList.add(trav.id);		//Adding the id of the building which we are currently at
			trav = trav.parent;			//Moving up the spanning tree by setting the traversal building to its parent
		}
		
		//Since tempList is the path from destination to source, we have to reverse it
		ListIterator<String> tempListIter = tempList.listIterator();
		
		//Moving to the end of tempList
		do {
			tempListIter.next();
		}
		while(tempListIter.hasNext());
		
		//Moving backwards from tempList and adding it to pathList
		while(tempListIter.hasPrevious()) {
			pathList.add(tempListIter.previous());
		}
		return pathList;
	}
	
	
	public final int minimumTotalLength() {
		//We will be using Prim's algorithm to find the minimum spanning tree
		//A[k] : represents whether the building at index 'k' has been added to the minimum spanning tree or not
		//roadLen[k] : stores the length of the road connecting the building at index k in the minimum spanning tree
		//numInA : we use it as a counter to see how many buildings have been finalized into the MST
		
		//Initialization
		boolean[] A = new boolean[numBuildings];
		int[] roadLen = new int[numBuildings];
		int numInA = 0;
		
		for(int i = 0; i < numBuildings; i++) {
			//Setting every index to false since the set is initially empty
			A[i] = false;
			//Setting the road length for every index to the maximum integer (because java doesn't have infinity)
			roadLen[i] = Integer.MAX_VALUE;
		}
		
		//We will be starting off with the building at index 0
		PriorityQueue<Road> primsPQ = new PriorityQueue<Road>();
		primsPQ.add(new Road(0,0));
		roadLen[0] = 0;													
		buildings[0].parent = null;						
		numInA++;
		
		//Will remain inside the loop till the number of finalized buildings is less than the number of buildings
		while(numInA < numBuildings) {
			
			//breaking the loop is the priority queue is empty
			if(primsPQ.isEmpty())
				break;
			
			//Pulling out the index of the building with the lowest 
			int index = primsPQ.poll().toIndex;
			
			//Skipping the loop iteration if it is in the MST
			if(A[index])
				continue;
			
			//Setting the building into the MST
			A[index] = true;
			numInA++;
			Building b = buildings[index];
			Iterator<Road> itr;
			
			//Processing the neighbors of Building b
			for(itr = b.roads.iterator();itr.hasNext();) {
				Road r = itr.next();
				int temp = r.toIndex;
				
				if(!A[temp]) {
					//The building isn't in the MST
					if(r.cost < roadLen[temp]) {
						//If the road cost is less than the current cost estimate, then it updates the cost and its parent
						roadLen[temp] = r.cost;
						buildings[temp].parent = buildings[index];
					}
					primsPQ.add(new Road(temp,r.cost));
				}
			}
		}
		
		//To find the length of the minimum spanning tree, we will add up all of their cost estimates and return the sum
		int sum = 0;
		for(int i = 0; i < roadLen.length; i++) 
			sum += roadLen[i];
		return sum;
	}
	
	
	public final int secondShortestPath(String source, String destination) {
		/* To find the second shortest path:
		 * 1) We will first find the shortest path
		 * 2) For all of the buildings on the shortest path, we will keep removing the roads between them one-by-one and use the shortest length method
		 * 3) We will compare and store all of the shortest lengths of the alternatives, and return the one that is the smallest
		 * */
		
		if(source.equals(destination))	//Returning 0, if the source and destination are the same
			return 0;
		
		//Throwing an illegal argument exception if the buildings aren't on the map
		if(indexOf(source) == -1 || indexOf(destination) == -1)
			throw new IllegalArgumentException("Buildings should be on the map");
		
		List<String> shortest = shortestPath(source,destination);	//Getting the list of the shortest path
		
		//Storing all of the stops on the shortest path into an array
		String[] stops = new String[shortest.size()];
		Iterator<String> itr = shortest.iterator();
		for(int i = 0; i < stops.length; i++) 
			stops[i] = itr.next();
		
		int secondShortest = Integer.MAX_VALUE;				//Setting the second shortest path length to the maximum integer
		for(int j = 0; j < stops.length - 1; j++) {			//Traversing through the loop
			//Storing the id of consecutive buildings on the shortest path
			String s1 = stops[j];							
			String s2 = stops[j+1];
			
			int x = lengthOfRoad(s1,s2);					//Finding the length of the road between the 2 buildings
			removeRoad(s1,s2);								//Removing the road between the 2 buildings
			int temp = shortestLength(source,destination);	//Calculating the shortest path after deletion of the road
			if(temp < secondShortest)						//If the temp shortest path is less than the current second shortest length
				secondShortest = temp;
			addRoad(s1,s2,x);								//Adding the road back to the map
		}
		return secondShortest;
	}	

	
	//Miscellaneous Private helper methods
	
	public void printSolution(int dist[]){
        System.out.println("Building \t\t\t Distance from Source");
        for (int i = 0; i < numBuildings; i++) {
            System.out.println(buildings[i].id + " \t\t\t " + dist[i]);
        }
    }

}
