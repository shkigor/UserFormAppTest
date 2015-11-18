package com.userformapp

class UserController {

//    static scaffold = true
//    static defaultAction = "calc"
    static allowedMethods = [calc: "POST"]
    def userService


    def result(String id) {
        def user = User.findById(id)
        [user: user]
//        if (!user) {
//            response.sendError(404)
//        } else {
//            [user: user]
//        }
    }

    def index() {

    }

    def calc(UserCalcCommand ucc) {
        if (request.method != "POST") {
            return
        }

        if (ucc.hasErrors()) {
            render view: "index", model: [user: ucc]
            return
        }

//                def user = new User(ucc.properties)
//
//                int seniority = ucc.seniority ?: 0
//                BigDecimal commission = ucc.commission ?: 0.05
//                BigDecimal sum = ucc.sum
//
//                BigDecimal userCalc = sum * commission + seniority
//
//                user.userCalc = userCalc
//
//                if (user.validate()) {
//                    user.save(flush: true)
//                    flash.message = "Welcome aboard, ${ucc.userLogin}"
//                    redirect action: "result", id: user.userLogin
////                    redirect(uri: '/')
//                } else {
//                    // maybe not unique loginId?
//                    flash.message = "Error Registering User"
//                    return [user: ucc]
//                }
////                render "<h1>Real Programmers drink beer</h1>"

        User newUser

        try {
            newUser = userService.createUser(ucc)
            flash.message = "Welcome aboard, ${newUser.userLogin}"
        } catch (UserException ue) {
            flash.message = ue.message
        }

        redirect action: "result", id: newUser?.id
    }
}


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
