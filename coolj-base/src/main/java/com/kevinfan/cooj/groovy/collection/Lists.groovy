package com.kevinfan.cooj.groovy.collection

/**
 * @author Kevin Fan $2014/09/01$
 */
List<Integer> list = (0..5).toList()
assert list[1..3] == [1, 2, 3]
assert list[2, 3, 5] == [2, 3, 5]

list[1..3] = [3, 2, 1]
assert list[1, 2, 3] == [3, 2, 1]

list[0, 1] = [100, 99]
assert list[0..1] == [100, 99]

assert list.size() == 6

list.clear()

assert list.size() == 0

list[0] = 1
assert list.size() == 1

list[1..1] = [2, 3, 4]
assert list.size() == 4
assert list == [1, 2, 3, 4]

assert list[-1] == 4
assert list[-2] == 3

//methods

//plus
list = []
list += 0
assert list == [0]

list += [1, 2]
assert list == [0, 1, 2]

//leftShift like append
list << 3 << 4
assert list == (0..4).toList()

//multiply
list = [1, 2]
list *= 2
assert list == [1, 2, 1, 2]



