package com.userformapp

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
class UserServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "calculateSalary User.userCalc value"() {

        given:
        Integer seniority = stag
        BigDecimal commission = commis
        BigDecimal sum = suma

        when:
        BigDecimal result = service.calculateSalary(seniority, commission, sum)

        then:
        result == expected

        where:
        stag        |       commis      |       suma        |       expected
        2           |       0.4         |       1000        |       402
        10          |       null        |       500         |       35
        null        |       null        |       500         |       25
        40          |       null        |       500         |       90
    }

    void "calculate User commission when seniority >=20"() {

        given: "User commission and User seniority"
        Integer seniority = 25
        BigDecimal commission = 0.4

        when: "calculateUserCommission with seniority >=20"
        BigDecimal result = service.calculateUserCommission(seniority, commission)

        then: "commission = commission * 2"
        result == commission * 2
    }
}
