package com.userformapp

class UserController {

    static defaultAction = "home"

    def index() { }

    def home() {
        render "<h1>Real Programmers drink beer</h1>"
    }

    def random() {
        def staticAuthor = "Anonymous"
        def staticContent = "Real Programmers don't eat much quiche"
        [ author: staticAuthor, content: staticContent]
    }
}
