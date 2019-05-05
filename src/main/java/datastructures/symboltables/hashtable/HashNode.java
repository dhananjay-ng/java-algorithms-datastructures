package datastructures.symboltables.hashtable;


public class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;

    public HashNode(K key,V value) {
        this.key = key;
        this.value = value;
    }
    public HashNode(K key,V value, HashNode<K,V> next) {
        this(key, value);
        this.next = next;
    }


}

