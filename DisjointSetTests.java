package ds;

public class DisjointSetTests<T> {
    
    /* Procedure: printSet
    *  Parameters: forest, a Disjoint Set object. value, an integer.
    *  Purpose: print on a separate line the root, if any, of the node with the given value.
    *  Product: none
    */
    public static void printSet(DisjointSet forest, Integer value){
        DisjointForestNode<Integer> root = forest.findSet(value);
        
        System.out.println(root.getValue());
    }

    // Purpose: test if make-set and union work with integer nodes
    public static boolean makeSetofFourIntegers(){
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        DisjointSet forest = new DisjointSet<Integer>();

        forest.makeSet(a);
        forest.makeSet(b);
        forest.makeSet(c);
        forest.makeSet(d);

        forest.union(a, b);
        forest.union(c, d);
        forest.union(a, d);

        return forest.findSet(a).getValue() == forest.findSet(d).getValue();
    }

    // Purpose: test if make-set and union work with string nodes
    public static boolean makeSetofFourStrings(){
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        DisjointSet forest = new DisjointSet<String>();

        forest.makeSet(a);
        forest.makeSet(b);
        forest.makeSet(c);
        forest.makeSet(d);

        forest.union(a, b);
        forest.union(c, d);
        forest.union(a, d);

        return forest.findSet(a).getValue().equals(forest.findSet(d).getValue());
    }

    // Purpose: test if union works with non-existent set
    public static boolean unionWithNonExistentSet(){
        String a = "a";
        String b = "b";
        String d = "d";
        DisjointSet forest = new DisjointSet<String>();

        forest.makeSet(a);
        forest.makeSet(b);

        forest.union(a, b);
        DisjointForestNode originalRoot = forest.findSet(a);

        forest.union(a, d);
        DisjointForestNode newRoot = forest.findSet(a);

        return originalRoot.equals(newRoot);
    }


    // Purpose: test if make-set and union work with integer nodes
    public static boolean findNonExistentSet(){
        DisjointSet forest = new DisjointSet<Integer>();

        return forest.findSet(1) == null;
    }

    // Purpose: test if union of two non-existent sets works 
    public static boolean joinNonExistentSets(){
        Integer a = 1;
        Integer b = 2;
        DisjointSet forest = new DisjointSet<Integer>();

        forest.union(a,b);

        return forest.findSet(a) == null;
    }

    // Purpose: test if union of the same set works 
    public static boolean joinSameSet(){
        Integer a = 1;
        DisjointSet forest = new DisjointSet<Integer>();

        forest.makeSet(a);
        DisjointForestNode oldRoot =  forest.findSet(a);

        forest.union(a,a);
        
        return forest.findSet(a).equals(oldRoot);
    }

    public static void main(String args[]){
        System.out.println(makeSetofFourIntegers());
        System.out.println(makeSetofFourStrings());
        System.out.println(unionWithNonExistentSet());
        System.out.println(findNonExistentSet());
        System.out.println(joinNonExistentSets());
        System.out.println(joinSameSet());
    }
}
