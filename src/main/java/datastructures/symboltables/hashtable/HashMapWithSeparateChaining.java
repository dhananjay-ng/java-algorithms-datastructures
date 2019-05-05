package datastructures.symboltables.hashtable;

import java.util.ArrayList;

public class HashMapWithSeparateChaining<K, V> {

    private static final int INIT_CAPACITY = 4;

    //resizing will be handled by ArrayList when capacity increases
    ArrayList<HashNode<K, V>> bucket = new ArrayList<>();
    int m;
    int n;

    public HashMapWithSeparateChaining() {
        this(INIT_CAPACITY);
    }

    public HashMapWithSeparateChaining(int m) {
        this.m = m;
        for (int i = 0; i < m; i++)
            bucket.add(null);
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //get value between 0 and m-1
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    //Returns true if this map contains the specified key.
    public boolean contains(K key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    //if key is present return value else return null
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int index = hash(key);
        HashNode<K, V> head = bucket.get(index);
        while (head != null) {
            if (head.key.equals(key))
                return head.value;

            head = head.next;
        }
        return null;
    }

    public void remove(K key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        int index = hash(key);

        HashNode<K, V> head = bucket.get(index);
        if (contains(key)) {
            if (head.key.equals(key)) {
                head = head.next;
                bucket.set(index, head);
            } else {
                HashNode<K, V> prev = null;
                while (head != null) {
                    if (head.key.equals(key)) {
                        prev.next = head.next;
                        break;
                    }
                    prev = head;
                    head = head.next;
                }
            }
            n--;
            // halve table size if average length of list <= 2
            if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);

        }

    }

    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (value == null) {
            remove(key);
            return;
        }
        // double table size if average length of list >= 10
        if (n >= 10*m) resize(2*m);

        int index = hash(key);
        if (!contains(key))
            n++;

        for (HashNode<K, V> x = bucket.get(index); x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.value = value;
                return;
            }
        }
        bucket.add(index, new HashNode<>(key, value, bucket.get(index)));


    }

    private void resize(int newBucketSize) {
        HashMapWithSeparateChaining<K,V> tmp = new HashMapWithSeparateChaining<>(newBucketSize);

        for (HashNode<K, V> headNode : bucket) {
            while (headNode != null) {
                tmp.put(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }

        this.m = tmp.m;
        this.n = tmp.n;
        this.bucket = tmp.bucket;

    }

    public static void main(String[] args) {
        HashMapWithSeparateChaining<String, Integer> map = new HashMapWithSeparateChaining<>();
        map.put("this", 1);
        map.put("djisa", 1);
        map.put("sofdos", 1);
        map.put("sodkfosk", 1);
        map.put("pepo", 1);
        map.put("vskvo", 1);

    }

}

