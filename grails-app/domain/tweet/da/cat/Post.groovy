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
            author {
                like 'nickname', "${nickname}%"
            }
        }

        authorInFollowings { currentUser ->
             'in'('author', currentUser.following)
        }
    }

    static mapping = {
        author lazy: false
    }

    static belongsTo = [author: User]
}
