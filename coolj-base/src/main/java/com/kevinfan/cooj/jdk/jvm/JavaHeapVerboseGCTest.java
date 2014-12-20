package com.kevinfan.cooj.jdk.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * VM args:
 * <p>
 * -Xms1024m -Xmx1024m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:verbose_gc.log
 * </p>
 */
public class JavaHeapVerboseGCTest {
    private static Map<String, String> data = new HashMap<String, String>();

    public static void main(String[] args) {
        System.out.println("verbose gc test begin...");

        final String prefix = "kevinj_";

        //load
        System.out.println("loading strings to map...");
        for (int i = 0; i < 1000000; i++) {
            String str = prefix + i;
            data.put(str, str);
        }

        System.out.println(data.size() + " strings loaded to map");
        System.gc();

        System.out.println("removing strings to map...");
        for (int i = 0; i < 500000; i++) {
            String str = prefix + i;
            data.remove(str);
        }

        System.out.println(data.size() + " strings remained after remove");
        System.gc();

        System.out.println("verbose gc test end~");
    }
}
