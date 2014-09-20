public class LRUCache {
    
    private static class Node {
        int key;
        int value;
        Node before;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            before = null;
            next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, Node>(capacity);
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            if (node == head) return head.value;
            if (node == tail) {
                head = tail;
                tail = tail.before;
                return node.value;
            }
            node.before.next = node.next;
            node.next.before = node.before;

            node.before = tail;
            tail.next = node;
            node.next = head;
            head.before = node;
            head = node;
            tail = head.before;

            return node.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (capacity == 0) return;
        if (!cache.containsKey(key)) {
            Node node = new Node(key, value);
            if (cache.isEmpty()) {
                tail = head = node;
                head.next = tail;
                head.before = tail;
                tail.next = head;
                tail.before = head;
            } else if (cache.size() == capacity) {
                if (capacity == 1) {
                    cache.remove(head.key);
                    tail = head = node;
                    head.next = tail;
                    head.before = tail;
                    tail.next = head;
                    tail.before = head;
                } else {
                    node.next = head;
                    node.before = tail;
                    head.before = node;
                    tail.next = node;
                    head = node;
                    // remove
                    head.before = tail.before;
                    tail.before.next = head;
                    cache.remove(tail.key);
                    tail = head.before;
                }
            } else {
                node.next = head;
                node.before = tail;
                head.before = node;
                tail.next = node;
                head = node;
            }
            cache.put(key, node);
        } else {
            Node node = cache.get(key);
            if (node == head) {
                head.value = value;
                return;
            }
            if (node == tail) {
                tail.value = value;
                head = tail;
                tail = head.before;
                return;
            }
            node.value = value;
            node.before.next = node.next;
            node.next.before = node.before;
            
            node.before = tail;
            tail.next = node;
            node.next = head;
            head.before = node;
            head = node;
            cache.put(key, node);
        }
    }
}