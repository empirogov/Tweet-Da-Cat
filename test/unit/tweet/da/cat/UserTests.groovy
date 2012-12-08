package tweet.da.cat



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests {

    void testHasValidEmail() {
        def user = new User(email: "test@test.com")
        assertTrue(user.validate())

        user.email = "some_invalid_email"
        assertFalse(user.validate())
    }
}
