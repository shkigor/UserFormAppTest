package com.userformapp

class User {

    String userLogin
    String userEmail
    BigDecimal userCalc

    static constraints = {
        userLogin blank: false, unique: true, validator: { val, obj ->
            def user = User.findByUserLogin(val)
            if (user) {
                return "user.userLogin.exist"
            }
        }
        userEmail blank: false, email: true, unique: true
        userCalc nullable: false
    }
}
