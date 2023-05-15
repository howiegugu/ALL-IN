package com.guguhowie.other;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * List集合中添加100万个字符串，每个字符串由1000个UUID组成
 * -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 * 将转存文件导入到MAT分析
 */
public class TestJvmOutOfMemory {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            String str = "";
            for (int j = 0; j < 1000; j++) {
                str += UUID.randomUUID().toString();
            }
            list.add(str);
        }
        System.out.println("ok");
    }

}
