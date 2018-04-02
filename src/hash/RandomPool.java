package hash;

import java.util.HashMap;
import java.util.Random;

/**
 * 实现一个随机池，要求池里的元素不重复，有一个添加元素的add方法和删除元素的remove方法，
 * 还有能够等概率获得一个随机元素的方法
 */
public class RandomPool {
    private HashMap<String, Integer> map1 = new HashMap<>();
    private HashMap<Integer, String> map2 = new HashMap<>();
    private Random random = new Random();
    private int size = 0;

    public void add(String key){
        if (!map1.containsKey(key)) {
            map1.put(key, size);
            map2.put(size++, key);
        }
    }

    public String getRandom(){
        if (size == 0){
            return null;
        }
        int key = random.nextInt(size);
        return map2.get(key);
    }

    public void remove(String key){
        String last = map2.get(size--);
        int value = map1.get(key);
        map2.remove(value);
        map1.remove(key);
        map1.put(last, value);
        map2.put(value, last);
    }

    public static void main(String[] args) {
        RandomPool randomPool = new RandomPool();
        String[] test = "fja ajf art fae pol eqe ujn mlk lzq org".split(" ");
        for (String s : test){
            randomPool.add(s);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(randomPool.getRandom() + " ");
        }
        System.out.println();
        for (int i = 2; i < test.length; i++) {
            randomPool.remove(test[i]);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(randomPool.getRandom() + " ");
        }
    }
}
