package tweet.da.cat

class User {
    String email
    String name
    String nickname
    String password
    double latitude
    double longitude

    //TODO: Add file field for photo

    Date dateCreated
    Date lastUpdated

    static constraints = {
        email(email:  true, unique: true, blank: false, nullable: false)
        nickname(unique: true, blank: false, nullable: false, size: 3..15)
        name(size: 3..20, nullable: true)
        password(size: 5..15, nullable: false)
    }

    static hasMany = [following: User, posts: Post]
}
