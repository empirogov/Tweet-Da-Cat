package tweet.da.cat

import grails.converters.deep.JSON

class MsgController {
    def authService

    def addPost() {
        if (authService.isLogged()) {
            def user = authService.user;
            if (user.addToPosts( new Post(content: params.content)) && user.save(flush: true)) {
                render text: "SUCCESS"
                return
            }
        }
        render text: "ERROR"
    }

    def getResult(resultCode) {
        return ['result': resultCode]
    }
}
