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


    static constraintsClosure = { val, obj ->
        if (!obj.seniority && !obj.commission) {
            return "seniority.and.commission.cannot.be.empty.together"
        }
    }

    static constraints = {
        importFrom User
        seniority size: 0..30, nullable: true, validator: constraintsClosure
        commission min: 0.0, max: 1.0, scale: 2, nullable: true, validator: constraintsClosure
        sum min: 0.0, max: 20000.0, scale: 2
    }

}
