package com.userformapp

import groovy.transform.ToString

@ToString
class User {

    String userLogin
    String userEmail
    BigDecimal salary

    static constraints = {
        userLogin blank: false, unique: true, validator: { val, obj ->
            def user = User.findByUserLogin(val)
            if (user) {
                return "user.userLogin.exist"
            }
        }
        userEmail blank: false, email: true, unique: true, validator: { val, obj ->
            def user = User.findByUserEmail(val)
            if (user) {
                return "user.userEmail.exist"
            }
        }
        salary nullable: false
    }
}
