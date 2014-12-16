package com.kevinfan.cooj.groovy

/**
 * @author Kevin Fan $2014/08/31$
 */

// ----------------------------
// -- lists
// ----------------------------

list = [0, 1, 2, 3, 4, 5]
assert List.class.isAssignableFrom(list.getClass())
println "index 1 is ${list[1]}"

list[7] = 7
assert list.size() == 8

list.each { e -> println e }

// ----------------------------
// -- maps
// ----------------------------
codes = [
        200: 'ok',
        404: 'not found'
]

assert Map.class.isAssignableFrom(codes.getClass())
assert codes.size() == 2
assert codes[200] == 'ok'

// ----------------------------
// -- ranges
// ----------------------------
def range = 1..100
assert range.size() == 100
println "type of range is : ${range.class} "
println range[1]
