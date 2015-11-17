package com.userformapp

class User {

    String userLogin
    String userEmail
    BigDecimal userSum

    static constraints = {
        userLogin blank: false
        userEmail email: true
        userSum size: 0..20000
    }
}
