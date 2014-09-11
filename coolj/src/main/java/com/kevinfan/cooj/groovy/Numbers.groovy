package com.kevinfan.cooj.groovy

/**
 * @author Kevin Fan $2014/08/31$
 */


int a = 123
println "type of an integer literal is: " + a.class

long b = 2434L
println "type of a long literal is: " + b.class


float c = 323.2F
println "type of a float literal is: " + c.class

double d = 2323.23
assert d instanceof Double

def e = 234
println e.class
