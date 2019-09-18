import java.io.Serializable;
import java.util.HashMap;

public class BiMap<K, V> implements Serializable {
    HashMap<K, V> map = new HashMap<>();
    HashMap<V, K> reverse = new HashMap<>();

    public void put(K key, V value) {
        map.put(key, value);
        reverse.put(value, key);
    }

    public K getKey(V value) {
        return reverse.get(value);
    }

     public V getValue(K key) {
        return map.get(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean containsValue(V value) {
        return reverse.containsKey(value);
    }

}
