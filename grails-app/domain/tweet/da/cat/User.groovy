package tweet.da.cat

class User {

    String avatar

    String email
    String name
    String nickname
    String password
    double latitude
    double longitude

    //TODO: Add file field for photo

    Date dateCreated
    Date lastUpdated
    List<User> following
    List<Post> posts

    static constraints = {
        email(email: true, unique: true, blank: false, nullable: false)
        nickname(unique: true, blank: false, nullable: false, size: 3..15)
        name(size: 3..20, nullable: true)
        password(size: 5..15, nullable: false)
        avatar(nullable: true, maxSize: 1024)
    }

    static mapping = {
        following lazy: false
    }

    static hasMany = [following: User, posts: Post]

    @Override
    String toString() {
        nickname
    }

    String getUserAvatar() {
        return (!this.avatar) ? "/img/default_ava.png" : this.avatar
    }

}
