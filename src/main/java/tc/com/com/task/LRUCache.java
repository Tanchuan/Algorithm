package tc.com.com.task;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bjtanchuan on 2018/3/19.
 */
public class LRUCache{

    private LRULinkedCache<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LRULinkedCache<>(capacity);
    }

    public int get(int key) {
        Integer v = cache.get(key);
        return v == null ? -1 : v;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }


    public static void main(String[] args){
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.put(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }

    class LRULinkedCache<K, V> extends LinkedHashMap<K, V>{

        private final int maxCapacity;
        private static final float DEFAULT_LOAD_FACTOR = 0.75f;
        private final ReentrantLock lock = new ReentrantLock();

        public LRULinkedCache(int capacity) {
            super(capacity, DEFAULT_LOAD_FACTOR, true);
            this.maxCapacity = capacity;
        }

        @Override
        public V put(K key, V value) {
            try {
                lock.lock();
                return super.put(key, value);
            } finally {
                lock.unlock();
            }
        }

        @Override
        public V get(Object key) {
            try {
                lock.lock();
                return super.get(key);
            } finally {
                lock.unlock();
            }
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> entry){
            return maxCapacity < size();
        }
    }

}

