package tweet.da.cat

import static org.junit.Assert.*
import org.junit.*

class UserIntegraionTests {
    @Before
    void setUp() {
    }

    @After
    void tearDown() {
    }

    @Test
    void testUserCanSave() {
        def newUser = new User(
                    email: "test1@test.com",
                    name: "Test User",
                    nickname: "test1_user",
                    password: "12345"
        )
        newUser.save(flush: true)
        assertTrue User.findByEmail(newUser.email).name == newUser.name
    }

    @Test
    void testUserCanUpdate() {
        def user = new User(
                email: "test@test.com",
                name: "Test User",
                nickname: "test_user",
                password: "12345"
        )
        user.save()
        def newName = "new name"

        def testUser = User.get(user.id)
        testUser.name = newName
        testUser.save(flush: true)

        assertTrue User.findByName(newName) == testUser
    }

    @Test
    void testUserCanDelete() {
        def user = User.first()
        user.delete()
        assertFalse User.exists(user.id)
    }
}
