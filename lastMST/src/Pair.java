public class Pair<K,T> {
    K k;
    T t;
    public Pair(K k , T t){
        this.k = k;
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setK(K k) {
        this.k = k;
    }

    public K getK() {
        return k;
    }
}
