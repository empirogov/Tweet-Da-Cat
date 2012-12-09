package tweet.da.cat

import grails.converters.JSON

class AuthorizeController {
    def authService

    def login() {
        if (authService.authorize(params.email, params.password)) {
            render getResult("SUCCESS") as JSON
            return
        }
        render getResult("ERROR") as JSON
    }

    def logoff() {
        if (authService.isLogged()) {
            authService.removeUser()
        }
        redirect(controller: 'mainView', action: 'index')
    }

    def getResult(result) {
        return ["result": result]
    }

    def test() {
        render authService.getUser() as JSON
    }
}
