package ds;

import java.util.Hashtable;


public class  DisjointSet<T> {
    private Hashtable<T, DisjointForestNode<T>> tab = new Hashtable<T, DisjointForestNode<T>>();

    /* Procedure: makeSet
    *  Preconditions: x is an element of type T
    *  Parameters: x, a value of type T which will be the value of the newly created Set.
    *  Purpose: Make a new Set based on the value x, while setting up the node to be itself. Add the newly created node to the hashtable.
    *  Product: A hashtable containing the newly created node of value x, and a newly created set.
    *  Postconditions: The root of the newly created node is itself, meaning root.parent = root.
    */
    public void makeSet(T x){
        DisjointForestNode<T> root = new DisjointForestNode<T>(null, x, 0);
        root.setParent(root);
        tab.put(x, root);
    }

    /* Procedure: findSet
    *  Preconditions: x is an element of type T
    *  Parameters: x, a value of type T
    *  Purpose: to find the root of the tree that contains the node of value x, and update each node in the path of that node to the root to point directly to the root. 
    *  Product: A new set in which each node in the path of the found node to the root points directly to the root, implementing the path compression.
    *  Postconditions: height of the modified set is equal to or less than the original set before we applied the path compression.
    */

    public DisjointForestNode<T> findSet(T x){
        if (tab.get(x) == null) {
            return null;
        } else {
            DisjointForestNode<T> node = tab.get(x);
            if (!node.equals(node.getParent())) {
                node.setParent(findSet(node.getParent().getValue()));
            }
            return node.getParent();
        }
    }

    /* Procedure: link
    *  Preconditions: x and y are node holding a value of type T and are the nodes of two distinct sets.
    *  Parameters: x and y that are node holding a value of type T
    *  Purpose: to merge and link two distinct sets.
    *  Product: a single set containing two sets which the root are x and y.   *  Postconditions: the node of the newly merge sets is either the node x and y. It should be the one that has a higher rank than the other.
    */
    public void link(DisjointForestNode<T> x, DisjointForestNode<T> y){
        if (x == null || y == null) {
            return;
        } else if (x.getRank() > y.getRank()) {
            y.setParent(x);
        } else {
            x.setParent(y);
            if (x.getRank() == y.getRank()) {
                y.setRank(y.getRank() + 1);
            }
        }
    }

    /* Procedure: union
    *  Preconditions: x and y are roots of two distinct sets.    *  Parameters: x and y, both of type T
    *  Purpose: create a set which is the union the two set containing the node of value x and y.    
    *  Product: a single set which is the union of two distinct set.    
    *  Postconditions: calling findSet(x) and findSet(y) to the updated set returns the same root.*/
    public void union(T x, T y) {
        link(findSet(x), findSet(y));
    }
}
