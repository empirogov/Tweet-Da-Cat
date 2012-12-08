package tweet.da.cat

import grails.converters.JSON

class AuthorizeController {

    def login() {
        User u = User.findByEmailAndPassword(params.email, params.password)
        if (u) {
            session.putValue("currentUser", u)
            render getResult("SUCCESS") as JSON
        }
        render getResult("ERROR") as JSON
    }

    def logoff() {
        if (session.getValue("currentUser")) {
            session.removeValue("currentUser")
            render getResult("SUCCESS") as JSON
        }
        render getResult("ERROR") as JSON
    }

    def getResult(result) {
        return ["result": result]
    }
}
