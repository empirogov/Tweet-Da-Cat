package tweet.da.cat

import grails.converters.JSON

class AuthorizeController {
    def authService

    def login() {
        User u = User.findByEmailAndPassword(params.email, params.password)
        if (u) {
            authService.setUser(u.id)
            render getResult("SUCCESS") as JSON
            return
        }
        render getResult("ERROR") as JSON
    }

    def logoff() {
        if (authService.isLogged()) {
            authService.removeUser()
            render getResult("SUCCESS") as JSON
            return
        }
        render getResult("ERROR") as JSON
    }

    def getResult(result) {
        return ["result": result]
    }

    def test() {
        render authService.getUser() as JSON
    }
}
