/*
 This class is written by Rami Achkoudir, using implementations from using https://algs4.cs.princeton.edu/
 DepthFirst is an algorithm that traverses a graph data structure by starting at the root node and
 traversing as far as possible using adjacent vertices before backtracking recursively
 */
package edu.princeton.cs.algs4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DepthFirst{
    private boolean marked[];		// boolean array to check if marked
    private int[] edgeTo;			// array to store last vertex used
    private int source;				// declare source


    public DepthFirst(Graph G, int s){
        marked = new boolean[G.V()];		// mark this vertex
        edgeTo = new int[G.V()];			// the last vertex before chosen vertex
        this.source = s;					// source input
        dfs(G,s);							// do dfs traversing
    }

    // mark the source vertex as true, look for next adjacent vertex (using bag from graph method)
    //and call the method recursively with the new vertex as the source vertex. 
    //when adjacent node is marked, return to previous node using edgeTo.
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G,w);
            }
        }

    }

    //checks if there is a path between destination and source vertex
    //uses EdgeTo array to see previous vertex and iterates through the array until we reach
    //the source
    public boolean hasPathTo(int v)
    {  return marked[v];  }

    public Iterable<Integer> PathTo(int v){
        if (!hasPathTo(v)) {
            System.out.println("Not found");
            System.exit(0);}
        
        
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x])
            path.push(x);
        path.push(source);
        return path;
    }

public static void main(String[] args) throws FileNotFoundException {
	
	File x = new File("C:\\Users\\usr-ramach01\\eclipse-workspace\\labb4\\src\\edu\\princeton\\cs\\algs4\\graph.txt");
    Scanner sc = new Scanner(x);

    String key = "";
    int vertex = 0;
    //Two symbol tables, both takes in every node, one is reversed
    ST<String, Integer> st1 = new ST<>(); 
    ST<Integer, String> st2 = new ST<>(); 
   
    // pushing the key-pair onto separate stacks
    Stack<String> stack1 = new Stack<>(); 
    Stack<String> stack2 = new Stack<>(); 

    //if key not in table, add key and vertex
    while(sc.hasNext()){
        key = sc.next();
        if(st1.get(key) == null){
            st1.put(key, vertex);
            st2.put(vertex, key);
            vertex++;
        }
        //push first key of pair
        stack1.push(key);

        
        key = sc.next();
        if(st1.get(key) == null){
            st1.put(key, vertex);
            st2.put(vertex, key);
            vertex++;
        }
        //push next key of the pair
        stack2.push(key);
    
    }
    // create graph where size is number of vertex
    Graph graph = new Graph(vertex);
    sc.close();
    // iterate through stack and pop them, this will add an edge between indices of table1
    while(!stack1.isEmpty()){
        graph.addEdge(st1.get(stack1.pop()), st1.get(stack2.pop()));
    }


    System.out.println("Enter two cities to find a path: ");

    Scanner sc2 = new Scanner(System.in);
    String X = sc2.next().toUpperCase();
    String Y = sc2.next().toUpperCase();
    sc2.close();
    
    
    //calls on PathTo method which generates a stack with integers from source to destination
    //table 2 will receive a stack and return the country-state corresponding with each index
    DepthFirst dfp = new DepthFirst(graph,st1.get(X));
    String str = "";
    //use Table2 as a "translation" from indices to Strings
    for (int i : dfp.PathTo(st1.get(Y))){
        str += st2.get(i) +"->";
    }	
    System.out.println(str);

}
}


