public class KVStore {

    private final LRUCache lruCache;

    public KVStore(int capacity) {
        this.lruCache = new LRUCache(capacity);
    }

    public String get(String key) {
        return lruCache.get(key);
    }

    public void set(String key, String value) {
        lruCache.put(key, value);
    }

    public void delete(String key) {
        lruCache.remove(key);
    }
}
