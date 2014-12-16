package com.kevinfan.cooj.groovy.datatype

/**
 * @author Kevin Fan $2014/09/01$
 */
class Room {
    private int size
    private String label

    Room(int size) {
        this.size = size
    }

    Room plus(Room another) {
        int total = this.size + another.size
        return new Room(total)
    }
}

//hava a try
Room a = new Room(1)
Room b = new Room(2)
Room c = a + b
assert c.size == 3

//try list
List list1 = [1, 2, 3]
List list2 = [2, 3]

assert (list1 + list2).size() == 5

List sub = list1 - list2
assert sub.size() == 1
assert sub[0] == 1




