package com.kevinfan.cooj.guava;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Created by kevinjom on 14-8-27.
 */
public class Guavaer {
    public static void main(String... args) {
        System.out.println(realName("Joyce"));
        System.out.println(realName(null));

        Guer guer = new Guer(24, "kevinfan");
        System.out.println(equals(null, guer));
        System.out.println(equals(guer, guer));
    }

    private static String realName(String name) {
        //Optional<String> optional = Optional.fromNullable(name);
        // return "Real " + optional.or("Kevin");

        return "Real " + Objects.firstNonNull(name, "Kevin");
    }

    private static <T> boolean equals(T a, T b) {
        return Objects.equal(a, b);
    }


    static class Guer {
        private int num;
        private String str;

        Guer() {
        }

        Guer(int num, String str) {
            this.num = num;
            this.str = str;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Guer)) return false;

            Guer guer = (Guer) o;

            if (num != guer.num) return false;
            if (str != null ? !str.equals(guer.str) : guer.str != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = num;
            result = 31 * result + (str != null ? str.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Guer{" +
                    "num=" + num +
                    ", str='" + str + '\'' +
                    '}';
        }
    }

}
