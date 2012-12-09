package tweet.da.cat

import grails.converters.JSON

class RegisterController {

    def index() {
        def p = params
        User u = new User(email: params.email, nickname: params.login, password: params.password)
        if (u.save()) {
            render getResult("SUCCESS") as JSON
            return
        }
        render getResult("ERROR") as JSON
    }

    def getResult(resultCode) {
        return ['result': resultCode]
    }
}