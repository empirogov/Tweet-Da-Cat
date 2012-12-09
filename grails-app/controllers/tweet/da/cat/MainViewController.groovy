package tweet.da.cat

class MainViewController {

    def feedsService

    def index() {
        def posts = getPosts(params)
        [posts: posts, postsCount: posts.size()]
    }

    def getPosts(params) {
        feedsService.getFeeds(params)
    }
}
