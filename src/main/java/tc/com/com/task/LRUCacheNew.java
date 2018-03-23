package tc.com.com.task;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by bjtanchuan on 2018/3/19.
 */
public class LRUCacheNew {

    private LRUConcurrentHashMapCache<Integer, Integer> cache;

    public LRUCacheNew(int capacity) {
        cache = new LRUConcurrentHashMapCache<>(capacity);
    }

    public int get(int key) {
        Integer v = cache.get(key);
        return v == null ? -1 : v;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }


    public static void main(String[] args){
        LRUCacheNew cache = new LRUCacheNew(2);
        System.out.println(cache.get(2));
        cache.put(2,6);
        System.out.println("null");
        System.out.println(cache.get(1));
        cache.put(1,5);
        System.out.println("null");
        cache.put(1,2);
        System.out.println("null");
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    class LRUConcurrentHashMapCache<K, V>{

        private final int maxCapacity;
        private final ConcurrentHashMap<K, CacheNode<K, V>> cache;
        private CacheNode<K, V> head;
        private CacheNode<K, V> tail;

        LRUConcurrentHashMapCache(int capacity) {
            cache = new ConcurrentHashMap<>(capacity);
            this.maxCapacity = capacity;
        }

        V get(K key) {
            CacheNode<K, V> node = cache.get(key);
            if(null != node){
                moveToHead(node);
            }
            return node == null ? null : node.value;
        }

        void put(K key, V value) {
            CacheNode<K, V> node = cache.get(key);
            if (null == node) {
                node = new CacheNode<>();
                node.key = key;
                if(cache.size() >= maxCapacity){
                    cache.remove(tail.key);
                    removeTailOfCacheNodeChain();
                }
            }
            node.value = value;
            moveToHead(node);
            cache.put(key, node);
        }

        void moveToHead(CacheNode<K, V> node){
            if (head != null) {
                if(head == node){
                    return;
                }
                if(node.pre != null){
                    node.pre.next = node.next;
                }
                if (node.next != null) {
                    node.next.pre = node.pre;
                }
                if(node == tail){
                    tail = node.pre;
                }
                node.next = head;
                head.pre = node;
                head = node;
                node.pre = null;
            } else {
                head = node;
                tail =node;
            }
        }

        CacheNode<K, V> remove(K key){
            CacheNode<K, V> node = cache.get(key);
            if(node != null){
                if(node.pre != null){
                    node.pre.next = node.next;
                }
                if(node.next != null){
                    node.next.pre = node.pre;
                }
                if(node == head){
                    head = node.next;
                }
                if(node == tail){
                    tail = node.pre;
                }
                return node;
            }
            return cache.remove(key);

        }

        void removeTailOfCacheNodeChain(){
            if(null == tail){
                return;
            }
            if(tail == head){
                tail = null;
                head = null;
                return;
            }
            tail = tail.pre;
            tail.next = null;
        }

        class CacheNode<K, V> {
            CacheNode<K, V> pre;
            CacheNode<K, V> next;
            K key;
            V value;
        }

    }

}

