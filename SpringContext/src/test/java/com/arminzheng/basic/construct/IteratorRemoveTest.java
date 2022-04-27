package com.arminzheng.basic.construct;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * IteratorRemoveTest
 *
 * @author zy
 * @version 2022/4/15
 */
public class IteratorRemoveTest {
    public static void main(String[] args) {
        // Arrays.asList 返回的arraylist并不是真正的ArrayList（不同类）
        // List<String> strings = Arrays.asList("A", "AA", "AAA", "AAAA", "AAAAA");
        ArrayList<String> strings =
                new ArrayList<String>() {
                    {
                        add("A");
                        add("AA");
                        add("AAA");
                        add("AAAA");
                        add("AAAAA");
                    }
                };
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            //
            String next = iterator.next();
            if (next.contains("AA")) {
                System.out.println("next = " + next);
                // 在进行删除前，必须获取到能删除的元素（使用next方法）
                iterator.remove();
            }
        }

        System.out.println("strings = " + strings);
    }
}
