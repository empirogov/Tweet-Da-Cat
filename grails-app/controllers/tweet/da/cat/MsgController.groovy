package tweet.da.cat

class MsgController {
    def authService

    def addPost() {
        if (authService.isLogged()) {
            if (authService.getUser().addToPosts(new Post(content: params.get("tweet")))) {
                render getResult("SUCCESS")
                return
            }
        }
        render getResult("ERROR")
    }

    def getResult(resultCode) {
        return ['result': resultCode]
    }
}
