package tweet.da.cat

import grails.converters.JSON

class RegisterController {

    def authService

    def index() {
        User u = new User(email: params.email, nickname: params.login, password: params.password)
        if (u.save()) {
            authService.setUser(u.id)
            render getResult("SUCCESS") as JSON
            return
        }
        render getResult("ERROR") as JSON
    }

    def getResult(result) {
        return ["result": result]
    }
}
