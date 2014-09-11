package com.kevinfan.cooj.groovy

/**
 * @author Kevin Fan $2014/08/31$
 */
class Language {
    String name
    String version
}

//if
def lang = null
if (lang) {
    println 'null to true'
} else {
    println 'null to false'
}

lang = new Language()
assert lang

//while
def i = 0
while (i < 100) {
    ++i
}
assert i == 100

//for
for (a in 5..10) {
    print a + ","
}

//switch
String httpMsg(int code) {
    String msg = "unknown"

    switch (code) {
        case 200: msg = 'ok'; break
        case 404: msg = 'not found'; break
        default: break
    }
}

assert httpMsg(200) == 'ok'

