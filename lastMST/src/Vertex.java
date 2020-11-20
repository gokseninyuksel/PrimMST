public class Vertex {
    private char label;
    private Vertex parent;
    private int key;
    private boolean isVisited;
    public Vertex(char label) {
        this.label = label;
        this.isVisited = false;

    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public char getLabel() {
        return label;
    }

    public Vertex getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                ", parent=" + parent +
                ", key=" + key +
                '}';
    }
    public void visit(){
        isVisited = true;
    }
    public boolean isVisited(){
        return isVisited;
    }
    public boolean equals(Object a){
        Vertex vertex = (Vertex) a;
        return vertex.getLabel() == this.getLabel();
    }
}
