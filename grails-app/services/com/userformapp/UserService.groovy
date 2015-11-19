package com.userformapp

import grails.transaction.Transactional

class UserException extends RuntimeException {
    String message
    User user
}


@Transactional
class UserService {

    static final Integer DEFAULT_STAG = 0
    static final Integer DEFAULT_GOOD_STAG = 20
    static final BigDecimal DEFAULT_COMMISSION = 0.05

    User saveUser(User user) {
//        def user = new User(userLogin: userLogin, userEmail: userEmail, userCalc: userCalc)
        if (user.validate() && user.save()) {
            return user
        } else {
            throw new UserException(message: "Can't save User", user: user)
        }
    }

    BigDecimal calculateUserCommission(Integer seniority, BigDecimal commission) {
        commission = commission ? commission : DEFAULT_COMMISSION
        if (seniority >= DEFAULT_GOOD_STAG) {
            commission = commission * 2
        }
        return commission
    }

    BigDecimal calculateSalary(Integer seniority, BigDecimal commission, BigDecimal sum) {
        seniority = seniority ? seniority : DEFAULT_STAG
        return sum * commission + seniority
    }

}
