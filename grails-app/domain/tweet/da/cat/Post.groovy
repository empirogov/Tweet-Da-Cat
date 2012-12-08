package tweet.da.cat

class Post {

    String content
    Date dateCreated
    Date lastUpdated
    User author

    static constraints = {
        content(nullable: false, blank: false, maxSize: 141)
    }

    static namedQueries = {
        authorLike { nickname ->
            like 'author.nickname', nickname + '%'
        }

        authorInFollowings { currentUser ->
             'in'('author', currentUser.following)
        }
    }

    static belongsTo = [author: User]
}
