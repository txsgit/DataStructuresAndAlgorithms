package LRU;

import sun.misc.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU是Least Recently Used的缩写，
 * 即最近最少使用，是一种常用的页面置换算法，选择最近最久未使用的数据予以淘汰。
 * Redis使用的就是该算法
 */
public class LRULinkeHashmap extends LinkedHashMap {

    //缓存大小
    private int capacity;

    LRULinkeHashmap(int capacity) {
        // 初始大小，0.75是装载因子，true是表示按照访问时间排序
        super(capacity, 0.75f, true);
        //传入指定的缓存最大容量
        this.capacity = capacity;
    }

    public LRULinkeHashmap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    /**
     * 实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    //测试

    public static void main(String[] args) {
        //最大5个数据
        LRULinkeHashmap cache = new LRULinkeHashmap(5);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");
        cache.put("5", "5");

        System.out.println("初始值：");
        System.out.println(cache.keySet());
        System.out.println("访问3：");
        cache.get("3");
        System.out.println(cache.keySet());
        System.out.println("访问2：");
        cache.get("2");
        System.out.println(cache.keySet());
        System.out.println("增加数据6,7：");
        cache.put("6", "6");
        cache.put("7", "7");
        System.out.println(cache.keySet());
    }

}
