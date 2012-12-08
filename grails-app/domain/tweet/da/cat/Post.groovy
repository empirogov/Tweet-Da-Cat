package tweet.da.cat

class Post {
    String content
    Date dateCreated
    Date lastUpdated

    static constraints = {
        content(nullable: false, blank: false, maxSize: 141)
    }

    static belongsTo = [author: User]
}
