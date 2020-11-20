import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {


        Graph fiveVertices = new Graph();
        Graph tenVertices = new Graph();
        Graph fifteenVertices = new Graph();
        Graph twentyVertices = new Graph();
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
        for(int a = 97; a < 123; a++){
            char vertex = (char) a;
            vertices.add(new Vertex(vertex));
        }
        addEdgesMax(fifteenVertices,1);
        twentyVertices.primMst(vertices.get(0));


    }

    private static void addEdgesMin(Graph graph, int weight) {
        StringBuilder str = new StringBuilder();
        for( int a= 0; a<graph.getVertices().size()-1; a++){
            graph.addEdge(graph.getVertices().get(a), graph.getVertices().get(a+1),weight);
            weight++;

        }
        for (Vertex vertex : graph.getVertices()) {
          graph.getSuc(vertex).forEach(e ->str.append( "Root Node " + vertex.getLabel() + " Vertex " + e.k + " Weight " + e.t + "\n"));
        }
        System.out.println(str.toString());
    }
    private static void addEdgesMax(Graph graph , int weight){
        StringBuilder str = new StringBuilder();
        for( int a= 0; a<graph.getVertices().size()-1; a++){
            for(int b =a+1; b<graph.getVertices().size(); b++) {

                graph.addEdge(graph.getVertices().get(a), graph.getVertices().get(b), weight);




            }

        }
        for (Vertex vertex : graph.getVertices()) {
            graph.getSuc(vertex).forEach(e ->str.append( "Root Node " + vertex.getLabel() + " Vertex " + e.k + " Weight " + e.t + "\n"));
        }
        System.out.println(str.toString());
    }

    private static void addVertices(Graph graph, int i, ArrayList<Vertex> vertices) {
        for( int a= 0; a < i; a++){
            graph.addVertex(vertices.get(a));
        }
        System.out.println( "Number of nodes " + graph.getVertices().size() + " added");
    }
}
