package tweet.da.cat

import static org.junit.Assert.*
import org.junit.*

class UserIntegraionTests {

    def user

    @Before
    void setUp() {
        user = new User(
            email: "test@test.com",
            name: "Test User",
            nickname: "test_user",
            password: "12345"
        )

        println(user)

        user.save()
    }

    @After
    void tearDown() {
    }

    @Test
    void testUserCanSave() {
        def newUser = new User(
                    email: "test@test.com",
                    name: "Test User",
                    nickname: "test_user",
                    password: "12345"
        )
        newUser.save(flush: true)
        assertTrue User.findByEmail(newUser.email).name == newUser.name
    }

    @Test
    void testUserCanUpdate() {
        def newName = "new name"

        println user
        def testUser = User.get(user.id)
        testUser.name = newName
        testUser.save(flush: true)

        assertTrue User.findByName(newName) == testUser
    }

    @Test
    void testUserCanDelete() {
        user.delete()
        assertFalse User.exists(user.id)
    }
}
