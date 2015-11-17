package com.userformapp

class UserController {

//    static scaffold = true
    static defaultAction = "calc"

//    def index() { }

    def random() {
        def staticAuthor = "Anonymous"
        def staticContent = "Real Programmers don't eat much quiche"
        [ author: staticAuthor, content: staticContent]
    }

    def calc(UserCalcCommand ucc) {
        if (request.method == "POST") {
            if (ucc.hasErrors()) {
                render view: "calc", model: [user: ucc]
            } else {
                def user = new User(ucc.properties)
//                if (user.validate()) {
//                    user.save(flush: true)
//                    flash.message = "Welcome aboard, ${ucc.fullName ?: ucc.username}"
//                    redirect(uri: '/')
//                } else {
//                    // maybe not unique loginId?
//                    flash.message = "Error Registering User"
//                    return [user: ucc]
//                }
                render "<h1>Real Programmers drink beer</h1>"
            }
        }
    }
}


class UserCalcCommand {

    String userLogin
    String userEmail
    Integer seniority
    BigDecimal commission = 0.05
    BigDecimal sum

    static constraints = {
        importFrom User
        seniority (size: 0..30)
        commission (min: 0.0, max: 1.0, scale: 2)
        sum (min: 0.0, max: 20000.0, scale: 2)
    }

}
