import tweet.da.cat.User
import tweet.da.cat.Post

Post.all.each { it.delete() }
User.all.each { it.delete() }

def usersCount = 10;
def postsForUserCount = 100;

def lastUserId = 0
for (int i = 0; i < usersCount; i++) {
    def user = new User(
            email: "test${i}@test.com",
            nickname: "test_user${i}",
            name: "Test User ${i}",
            password: "12345"
    )

    user.save(flush: true)
    lastUserId = user.id
    for (int j = 0; j < postsForUserCount; j++) {
        def date = new Date((int)(Math.random() * 3000), (int)(Math.random() * 12), (int)(Math.random() * 30))
        def post = new Post(content: "test content ${j}", dateCreated: date, lastUpdated: date)
        user.addToPosts(post)
    }

    user.save(flush: true)
}

//
//user4 = User.get(lastUserId - 2)
//user6 = User.get(lastUserId -1)
//user5 = User.get(lastUserId)
//
//user5.addToFollowing(user4)
//user5.addToFollowing(user6)
//user5.save()

