import java.util.*;

public class Graph {
    private Map<Vertex, ArrayList<Pair<Vertex,Integer>>> edges;
    private ArrayList<Vertex> vertices;
    int comparisions = 0;

    public Graph(){
        edges = new HashMap<>();
        vertices = new ArrayList<Vertex>();
    }
    public void addVertex(Vertex vertex){
        vertices.add(vertex);
        edges.put(vertex, new ArrayList<Pair<Vertex,Integer>>());
    }
    public void addEdge(Vertex vertex, Vertex vertex1, int weight){
        edges.get(vertex).add(new Pair<>(vertex1,weight));
        edges.get(vertex1).add(new Pair<>(vertex,weight));
    }
    public ArrayList<Pair<Vertex,Integer>> getSuc(Vertex vertex){
        return edges.get(vertex);
    }
    public void primMst(Vertex root){
        ArrayList<Vertex> mst = new ArrayList<Vertex>();
        vertices.forEach(e -> {
            e.setKey(Integer.MAX_VALUE);
            e.setParent(null);
        });
        root.setKey(0);
        root.setParent(root);
        PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                comparisions++;

                return Integer.compare(o1.getKey(),o2.getKey());
            }
        });
        pq.offer(root);
        while(!pq.isEmpty()){
            Vertex current = pq.poll();
            mst.add(current);
            for( Pair<Vertex,Integer> suc: this.getSuc(current)){
                if(!suc.getK().isVisited() && suc.getT() < suc.getK().getKey() ){
                    suc.getK().setKey(suc.getT());
                    suc.getK().setParent(current);
                    suc.getK().visit();
                    pq.offer(suc.getK());
                }
            }
        }
       printGraph(mst);
    }

    private void printGraph(ArrayList<Vertex> mst) {
        StringBuilder str = new StringBuilder();
        int totalWeigth = 0;
        for(int a =0; a < mst.size()-1; a++){
            int weight = findWeight(mst.get(a), mst.get(a+1));
            str.append("Edge " + mst.get(a).getLabel() + " ----- " + mst.get(a+1).getLabel() + " with weight " + weight + "\n");
            totalWeigth+=weight;
        }
        System.out.println(str.toString());
        System.out.println("Total weight of MST is " + totalWeigth);
        System.out.println( this.comparisions + " Number of Comparisions made ");
    }

    private int findWeight(Vertex pairs, Vertex pairs1) {
        int a = 0;
        for( Pair<Vertex,Integer> pair: edges.get(pairs)){
            if(pair.getK().equals(pairs1)){
                a = pair.getT();
            }

        }
        return a;

    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }
}
