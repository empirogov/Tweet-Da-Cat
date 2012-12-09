package tweet.da.cat

class MainViewController {

    def feedsService

    def index() {
        [posts: getPosts()]
    }

    def getPosts() {
        feedsService.getFeeds()
    }
}
