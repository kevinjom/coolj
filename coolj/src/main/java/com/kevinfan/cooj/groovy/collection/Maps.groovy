package com.kevinfan.cooj.groovy.collection

/**
 * Created by kevinjom on 14-9-2.
 */

def empty = [:]
assert empty.size() == 0
assert empty.isEmpty()
assert empty instanceof HashMap

def map = [
        name: 'kevinjom',
        age : 25
]


println map
def keys = []
def values = []
map.each { k, v ->
    keys << k
    values << v
}
println "kyes: $keys"
println "values: $values"



assert map['age'] == 25

map['name'] = 'gro22'
assert map.get('name') == 'gro22'


def origin = [b: 2, a: 1, c: 3]
def typed = new TreeMap()
typed.putAll(origin)
println typed


assert [x: 1] == ['x': 1]
x = 'a'
assert [x: 1] == ['x': 1]
assert [(x): 1] == ['a': 1]

