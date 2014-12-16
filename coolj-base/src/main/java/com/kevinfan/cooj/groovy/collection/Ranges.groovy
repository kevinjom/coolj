package com.kevinfan.cooj.groovy.collection

/**
 * @author Kevin Fan $2014/09/01$
 */
assert (1..10).contains(10)
assert (1..<10).contains(10) == false

def range = (1..100)
println range.class

def reversed = (100..1)
assert reversed[0] > reversed[1]

def sum = 0
for (i in reversed) {
    sum += i
}
assert sum == 5050

sum = 0
reversed.each { e -> sum += e }
assert sum == 5050

def chars = 'a'..'z'
println chars
assert chars.size() == 26

//list
list = [1, 2, 3, 4, 5]
assert list.grep(2..<4) == [2, 3]


class Weekday implements Comparable<Weekday> {
    private static final DAYS = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']

    private int index = 0

    Weekday(String day) {
        index = DAYS.indexOf(day)
    }

    Weekday next() {
        return new Weekday(DAYS[(index + 1) % DAYS.size()])
    }

    Weekday previous() {
        return new Weekday(DAYS[(index - 1) % DAYS.size()])
    }

    @Override
    int compareTo(Weekday o) {
        return index.compareTo(o.index)
    }

    String toString() {
        return DAYS[index]
    }
}

Weekday tue = new Weekday('Tue')
Weekday fri = new Weekday('Fri')

def days = (tue..fri)
assert days.size() == 4
println days


List<Weekday> weekdayList = days.toList()
weekdayList.each { e -> println e }
