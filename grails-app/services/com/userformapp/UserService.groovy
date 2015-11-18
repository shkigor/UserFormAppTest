package com.userformapp

import grails.transaction.Transactional

class UserException extends RuntimeException {
    String message
    User user
}


@Transactional
class UserService {

    User saveUser(String userLogin, String userEmail, BigDecimal userCalc) {
        def user = new User(userLogin: userLogin, userEmail: userEmail, userCalc: userCalc)
        if (user.validate() && user.save()) {
            return user
        } else {
            throw new UserException(message: "Can't save User", user: user)
        }
    }

    User createUser(UserCalcCommand ucc) {
        def user = new User(ucc.properties)

        int seniority = ucc.seniority ? ucc.seniority : 0
        BigDecimal commission = ucc.commission ? ucc.commission : 0.05
        if (seniority >= 20) {
            commission = commission * 2
        }
        BigDecimal sum = ucc.sum

        BigDecimal userCalc = sum * commission + seniority

        user.userCalc = userCalc

        saveUser(user.userLogin, user.userEmail, user.userCalc)
    }
}
