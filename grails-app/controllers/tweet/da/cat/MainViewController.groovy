package tweet.da.cat

class MainViewController {

    def index() {
        [posts: getPosts()]
    }

    def getPosts() {
        return Post.findAll(max: 100)
    }
}
