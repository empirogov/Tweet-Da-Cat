import tweet.da.cat.User
import tweet.da.cat.Post

Post.all.each { it.delete(flush: true) }
User.all.each { it.delete(flush: true) }

def usersCount = 10;
def postsForUserCount = 100;

for (int i = 0; i < usersCount; i++) {
    def user = new User(
            email: "test${i}@test.com",
            nickname: "test_user${i}",
            name: "Test User ${i}",
            password: "12345"
    )

    user.save()
    for (int j = 0; j < postsForUserCount; j++) {
        def post = new Post(content: "test content ${j}")
        user.addToPosts(post)
    }

    user.save()
}