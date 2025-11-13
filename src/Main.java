import java.util.Iterator;

public class Main {

    static String[] list ={"A", "E", "D", "Q", "J", "T", "M", "S"};
    public static void main(String[] args) {
        BST<String> bst = new BST<>();
        for(String x : list){
            bst.put(x);
        }

        String result = bst.ceilling("Q");
        System.out.println(result);

        Iterator<String> it = bst.keys("D", "T").iterator();

        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}