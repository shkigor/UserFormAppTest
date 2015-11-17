package com.userformapp

class User {

    String userLogin
    String userEmail
    BigDecimal userCalc

    static constraints = {
        userLogin blank: false
        userEmail blank: false, email: true
    }
}
