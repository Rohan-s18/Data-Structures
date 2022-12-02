//Author: Rohan Singh
//Code for undirected unweighted graph in Java

public class UndirectedGraph{

    //2D array to store edges
    private boolean[][] graph;

    //Array to hold names
    private String[] names;

    //This variable will hold the number of nodes in the graph
    private int size = 0;

    //Optional array to hold the index of parents (used during traversals)
    //private int[] parents;

    //Constructor
    public UndirectedGraph(){
        graph = new boolean[10][10];
        names = new String[10];
        size = 0;
    }

    //Overloaded Constructor
    public UndirectedGraph(capacity){
        graph = new boolean[capacity][capacity];
        names = new String[capacity];
        size = 0;
    }

    //Method to add a vertex/node to the graph
    public boolean addVertex(String name){
        //Checking if we have overloaded
        if(size >= names.length)
            resize();
        
        //Checking to see if the node exists by using the index of helper function
        if(indexOf(name) != -1)
            return false;           //Could throw an exception here

        //Adding a node of the same name to the graph
        names[size] = name;
        size++;

        return true;
    }

    //Method to add an edge/link to the graph between vertices a and b
    public boolean addEdge(String a, String b){
        //Getting the indices of the nodes
        int firstNodeIndex = indexOf(a);
        int secondNodeIndex = indexOf(b);

        //Checking to see if the vertices exist or not
        if(firstNodeIndex == -1 || secondNodeIndex == -1)
            return false;

        //Setting the connectivity to true
        graph[firstNodeIndex][secondNodeIndex] = true;
        graph[secondNodeIndex][firstNodeIndex] = true;

        return true;

    }

    //Method to add multiple vertices/nodes to the graph
    public boolean addVertices(List<String> names){
        //Iterating through the list and adding the vertices
        for(String s: names)
            addVertex(s);

        return true;
    }

    //Method to add multiple bi-directional edges between one source and multiple destinations
    public boolean addEdges(String source, List<String> destinations){
        //Iterating through the list of destinations
        for(String s: destinations)
            addEdge(source,s);

        return true;
    }

    //Method for Breadth-First Traversal of a graph from the source
    public void breadthFirstTraversal(String source){
        int sourceIndex = indexOf(source);
        //Checking if the source exists
        if(sourceIndex == -1)
            return;

        //Creating an array to track the parents of the vertices in BFT
        int[] parents = new int[size];

        //Creating an array to see which vertices have been visited/encountered during the traversal
        boolean[] encountered = new boolean[size];

        //Queue that will be used for the breadth first traversal of the graph
        Queue<Integer> traversalQueue = new LinkedList<Integer>();

        //Initializing the data structures for the traversal
        traversalQueue.add(sourceIndex);
        encountered[sourceIndex] = true;
        parents[sourceIndex] = -1;

        //Iterating while the queue is not empty
        while(!traversalQueue.isEmpty()){
            //Removing the item from the queue
            int curr = traversalQueue.poll();

            //Other actions can be done here
            System.out.println(names[curr]);

            //Iterating through all of the neighbors of the current vertex
            for(int j = 0; j < size; j++){
                //If an edge exists and the destination has not been encountered
                if(encountered[j] == false && graph[curr][j] == true){
                    encountered[j] = true;                                  //Now this vertex has been encountered
                    parents[j] = curr;                                      //Setting its parent
                    traversalQueue.add(j);                                  //Adding it to the queue
                }
            }

        }



    }



    //General Helper functions for the graph to make our life easier

    //This method will resize the matrix if it gets full
    private void resize(){
        //Storing the old variables
        oldSize = size;
        boolean[][] oldGraph = graph;
        String[] oldNames = names;

        size *= 2;
        graph = new boolean[size][size];
        names = new String[size];

        for(int i = 0; i < oldSize; i++){
            names[i] = oldNames[i];
            for(int j = 0; j < oldSize; j++){
                graph[i][j] = oldGraph[i][j];
            }
        }


    }

    //This method will give us the index of the node
    private int indexOf(String name){
        //Iterating through all of the nodes to check which one has the same name
        for(int i = 0; i < size; i++){
            if(names[i].equals(name))
                return i;
        }
        return -1;              //This will notify us that the node doesn't exist in the graph
    }
    
    
    public static void main(String[] args){
        System.out.println("Hello World!");
    }

}
