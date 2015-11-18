package com.userformapp

class User {

    String userLogin
    String userEmail
    BigDecimal userCalc

    static constraints = {
        userLogin blank: false, unique: true
        userEmail blank: false, email: true, unique: true
        userCalc nullable: false
    }
}
