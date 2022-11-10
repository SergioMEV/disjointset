package pset5;

public class DisjointForestNode<T> {
    private DisjointForestNode<T> parent;
    private T value;
    private int rank;

    public DisjointForestNode(DisjointForestNode<T> parent, T value, int rank){
        this.parent = parent;
        this.value = value;
        this.rank = rank;
    }

    // Purpose: return the parent node of the current node
    public DisjointForestNode<T> getParent(){
        return this.parent;
    }

    // Purpose: set the parent of current node to input node n
    public void setParent(DisjointForestNode<T> n){
        this.parent = n;
    }

    // Purpose: return the value of the current node
    public T getValue(){
        return this.value;
    }

    // Purpose: set the value of the current node to given value val    
    public void setValue(T val){
        this.value = val;
    }

    // Purpose: return the rank of current node
    public int getRank(){
        return this.rank;
    }

    // Purpose: set the rank of current node to given rank
    public void setRank(int rank){
        this.rank = rank;
    }
}
