public class LRUCache {
    
    private class Node {
        Node pre;
        Node next;
        int val;
        int key;
        Node(int key, int val) {
            this.val = val;
            this.key = key;
            this.pre = null;
            this.next = null;
        }
    }
    
    private int cap;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<Integer, Node>();
        head = tail = null;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            if (node == head) {
                // do nothing
            } else {
                if (node == tail) {
                    tail = tail.pre;
                    tail.next = null;
                } else {
                    node.next.pre = node.pre;
                    node.pre.next = node.next;
                }
                node.next = head;
                head.pre = node;
                node.pre = null;
                head = node;
            }
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) head.val = value;
        else {
            Node node = new Node(key, value);
            if (cache.size() == cap) {
                int temp = tail.key;
                tail = tail.pre;
                if (tail != null) tail.next = null;
                cache.remove(temp);
            }
            if (head == null) head = tail = node;
            else {
                node.next = head;
                head.pre = node;
                head = node;
            }
            cache.put(key, node);
        }
    }
}

// a hack
public class LRUCache {
    
    private static int cap;
    private Map<Integer, Integer> cache;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new java.util.LinkedHashMap(capacity, 0.75f,true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cap;
            }
        };
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        cache.put(key, value);
    }
}