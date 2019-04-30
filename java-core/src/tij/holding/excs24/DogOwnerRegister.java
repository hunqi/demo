package tij.holding.excs24;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DogOwnerRegister {

    public static void main(String[] args) {

        Map<String, Dog> map = new LinkedHashMap<>();
        map.put("Tom", new Dog("Cibotlaceae")); //Cibotlaceaev 金毛狗
        map.put("Peter", new Dog("Husky")); // Husky 哈士奇
        map.put("Jim", new Dog("Alaska")); //Alaska 阿拉斯加
        map.put("Lucy", new Dog("Corgi")); //Corgi 柯基
        map.put("Xiaoming", new Dog("Rural Dog"));  // Rural Dog 田园犬
        map.put("Emiko", new Dog("Akita")); //akita 秋田犬

        System.out.println(map);

        Map<String, Dog> map1 = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>(map.keySet());

        for (String k : keys)
            map1.put(k, map.get(k));

        System.out.println(map1);
    }

}

class Dog {
    String type;

    public Dog(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
