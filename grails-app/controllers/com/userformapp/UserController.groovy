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
//        if (request.method != "POST") {
//            return
//        }

        if (ucc.hasErrors()) {
            render view: "index", model: [user: ucc]
            return
        }

        User newUser

        try {
            newUser = userService.createAndCalculateUser(ucc)
            flash.message = "controller.welcome" + "${newUser.userLogin}"
        } catch (UserException ue) {
            flash.message = ue.message
        }

        redirect action: "result", id: newUser?.id

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
    }
}

