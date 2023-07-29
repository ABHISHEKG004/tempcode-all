package MCexamples.cache.factories;


import MCexamples.cache.Cache;
import MCexamples.cache.policies.LRUEvictionPolicy;
import MCexamples.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new HashMapBasedStorage<Key, Value>(capacity));
    }
}
