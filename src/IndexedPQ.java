public class IndexedPQ {
    private int maxN;
    private int n;
    private int[] pq;
    private int[] qp;
    private int[] keys;

    public IndexedPQ(int maxN){
        if(maxN < 0 ) throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        keys = new int[maxN + 1];
        pq   = new int[maxN + 1];
        qp   = new int[maxN + 1];
        for(int i = 0; i <= maxN; i++){
            qp[i] = -1;//인덱스 값과 벨류값을 설정
        }
    }

    public void insert(int i, int key){
        validateIndex(i);
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    private void swim(int n) {
        while(n > 1 && greater(n/2, n)){
            exch(n, n/2);
            n = n/2;
        }
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]] > keys[pq[j]];
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void validateIndex(int i) {//i값이 0 ~ max-1 안에 있는 확인하는 메소드
        if (i < 0) throw new IllegalArgumentException("index is negative: " + i);
        if (i >= maxN) throw new IllegalArgumentException("index >= capacity: " + i);
    }

    private boolean contains(int i){ //인덱스 i가 이미 우선순위 큐에 존재하는 지 확인하는 메소드
        validateIndex(i);
        return  qp[i] != -1;//인덱스 i값을 넣었을 때, -1일 경우에는 false, -1이 아닐 경우에는 true
    }
}
