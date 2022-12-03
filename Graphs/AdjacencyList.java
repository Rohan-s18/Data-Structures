import java.util.*;

public class AdjacencyList {
	private Vertex[] graph;
	private int size;

	class Vertex implements Comparable<Vertex>{	
		String name;
		List<Edge> edges;

		Vertex(String name){
			this.name = name;
			this.edges = new ArrayList<Edge>();
		}

		@Override
		public int compareTo(AdjacencyList.Vertex o) {
			//TODO: Check which Vertex comes first alphabetically
			return 0;
		}
	}

	class Edge{
		String destString;
		int destIndex;
	}

	public AdjacencyList() {
		graph = new Vertex[10];
		size = 0;
	}

	public boolean addNode(String name) {
		Vertex temp = new Vertex(name);

		//Checking if it already exists
		if(indexOf(name) != -1)
			return false;

		int index = findIndexToInsert(temp);

		
		for(int i = size; i > index; i--) {
			graph[i] = graph[i-1];
		}

		graph[index] = temp;
		size++;

		//Updating the destIndex of the edges
		for(int i = 0; i < size; i++) {
			List<Edge> myList = graph[i].edges;
			for(int j = 0; j < myList.size(); j++) {

				//Check if the destINdex > index, then increase destIndex by 1

			}
		}

		return true;
	}

	public boolean addEdge(String from, String to) {
		int fromIndex = indexOf(from);
		int toIndex = indexOf(to);

		if(fromIndex == -1 || toIndex == -1)
			return false;

		List<Edge> toList = graph[toIndex].edges;
		List<Edge> fromList = graph[fromIndex].edges;

		//Add edge to toList, fromList 

		//While adding edges make sure that they are alphabetical using the compareTo method 

		graph[toIndex].edges = toList;
		graph[fromIndex].edges = fromList;
		return true;
	}


	//-----------------------------------------------Helper Methods------------------------------------------------------------------------

	

	//Helper function to find the index of the vertex with the same name int the array of vertices

	private int indexOf(String name) {
		for(int i = 0; i < size; i++) {
			if(graph[i].name.equals(name))
				return i;
		}
		return -1;
	}

	

	//TODO: Implement the resize method for the graph
	private void resize() {


	}

	//TODO: Find the index where you need to insert

	private int findIndexToInsert(Vertex v) {
		return -1;
	}

}


