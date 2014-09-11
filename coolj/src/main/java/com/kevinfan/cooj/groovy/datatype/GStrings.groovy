package com.kevinfan.cooj.groovy.datatype

/**
 * @author Kevin Fan $2014/09/01$
 */

/*
Single qouted string is not GString aware
 */

def name = 'kevinjom'
def shortSingle = 'my name is $name'
assert shortSingle.contains('$name')

def longSingle = '''my name is $name'''
assert longSingle.contains('$name')

def shortDouble = "my name is $name"
assert shortDouble.contains(name)

def longDouble = """my name is $name"""
assert longDouble.contains(name)

//escape $
def escaped = "my name is \$name"
assert escaped.contains('$')

//append string
longDouble <<= ", and i am 25"
println longDouble
assert  longDouble instanceof StringBuilder

