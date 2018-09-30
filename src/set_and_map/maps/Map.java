package set_and_map.maps;

public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    int size();

    boolean isEmpty();

    boolean contains(K key);

    V get(K k);

    void set(K key, V newValue);
}
