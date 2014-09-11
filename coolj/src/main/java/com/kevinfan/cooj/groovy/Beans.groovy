package com.kevinfan.cooj.groovy

/**
 * @author Kevin Fan $2014/08/31$
 */

class User {
    long pk
    String loginId

    String toString() {
        return "[User]pk=$pk, loginId=$loginId" //GString
    }
}

def user = new User()
user.pk = 123

println user

user.loginId = "kevinfan@github.com"

println user

