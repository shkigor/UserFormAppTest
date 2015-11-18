package com.userformapp

import grails.validation.Validateable

/**
 * Created by user on 18.11.15.
 */
@Validateable
class UserCalcCommand {

    String userLogin
    String userEmail
    Integer seniority
    BigDecimal commission
    BigDecimal sum

    static constraints = {
        importFrom User
        seniority size: 0..30, nullable: true, validator: { seniority, user ->
            if (!seniority && !user.commission) {
                return false
            } else {
                return true
            }
        }
        commission min: 0.0, max: 1.0, scale: 2, nullable: true, validator: { commission, user ->
            if (!commission && !user.seniority) return false
            else return true
        }
        sum min: 0.0, max: 20000.0, scale: 2
    }

}
