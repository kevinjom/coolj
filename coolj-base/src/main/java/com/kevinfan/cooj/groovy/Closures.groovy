package com.kevinfan.cooj.groovy

/**
 * @author Kevin Fan $2014/08/31$
 */

list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
list.each { e ->
    if (e % 3 == 0) {
        println e
    }
}
