
public class BST<T extends Comparable<T>>{
    private Node root;

    private class Node {
        T key;
        Node left;
        Node right;

        Node(T key) {
            this.key = key;
        }
    }

    public void put(T key){
        root = put(root, key);
    }

    //삽입
    private Node put(Node x, T key){
        if(x == null) return new Node(key);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key);
        else if(cmp > 0) x.right = put(x.right, key);
        else if(cmp == 0) x.key = key;
        return x;
    }

    public T get(T key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp < 0) x = x.left;
            else if(cmp > 0) x = x.right;
            else return x.key;
        }
        return null;
    }

    public T floor(T key){
        Node x = floor(root, key);
        if(x == null) return null;
        return x.key;
    }

    private Node floor(Node x, T key){
        if(x == null) return null;

        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0) return floor(x.left, key);

        Node t = floor(x.right, key);
        if(t != null) return t;
        else return x;
    }

    public T ceilling(T key){
        Node x = ceilling(root, key);
        if(x == null) return null;
        return x.key;
    }

    private Node ceilling(Node x, T key){
        if(x == null) return null;

        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp > 0) return ceilling(x.right, key);

        Node t = ceilling(x.left, key);
        if(t != null) return t;
        else return x;
    }

    public Iterable<T> keys(T lo, T hi){
        Queue<T> q = new Queue<T>();
        inorder(root, q, lo, hi);
        return q;
    }

    private void inorder(Node x, Queue<T> q, T lo, T hi) {
        if(x == null) return;

        inorder(x.left, q, lo, hi);
        int cmp1 = lo.compareTo(x.key);
        if(hi.compareTo(x.key) > 0){
            if(cmp1 < 0) q.enqueue(x.key);
        }

        inorder(x.right, q, lo, hi);
    }

}
