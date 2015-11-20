package com.userformapp

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
class UserServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "calculate User salary"() {

        given: "User seniority, commission and sum"
        Integer seniority = stag
        BigDecimal commission = commis
        BigDecimal sum = suma

        when: "calculateSalary for User"
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


    @Unroll
    void "calculate commission when seniority >=20"() {

//        given: "User seniority, commission, sum"
//        Integer seniority = 25
//        BigDecimal commission = 0.5
//        BigDecimal sum = 10000
//
//        when: "calculateSalary for User with seniority >=20"
//        BigDecimal result = service.calculateSalary(seniority, commission, sum)
//        result = (result - seniority) / sum
//
//        then: "commission will be multiply on 2"
//        result == commission * 2

        given: "User seniority, commission, sum"
        Integer seniority = stag
        BigDecimal commission = commis
        BigDecimal sum = suma

        when: "calculateSalary for User with seniority >=20"
        BigDecimal result = service.calculateSalary(seniority, commission, sum)
        result = (result - seniority) / sum

        then: "commission will be multiply on 2"
        result == expected

        where:
        stag        |       commis      |       suma        |       expected
        18          |       0.1         |       1000        |       0.1
        19          |       0.4         |       1000        |       0.4
        19          |       null        |       1000        |       0.05
        20          |       0.4         |       1000        |       0.8
        21          |       0.2         |       500         |       0.4
        22          |       null        |       500         |       0.1
        40          |       null        |       500         |       0.1
    }
}
