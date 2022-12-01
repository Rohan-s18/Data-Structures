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

    public UndirectedGraph(){
        graph = new boolean[10][10];
        names = new String[10];
        size = 0;
    }

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
