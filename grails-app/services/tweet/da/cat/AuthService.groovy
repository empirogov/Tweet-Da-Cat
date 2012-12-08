package tweet.da.cat

import org.springframework.web.context.request.RequestContextHolder
import javax.servlet.http.HttpSession

class AuthService {

    static transactional = false
    static scope = "singleton"

    def setUser(userId) {
        getSession().userId = userId
    }

    def getUser() {
        if (getSession().userId) {
            return User.findById(getSession().userId);
        }
        return null;
    }

    def removeUser() {
        getSession().userId = null
    }

    boolean isLogged() {
        return (getSession().userId)
    }

    private HttpSession getSession() {
        return RequestContextHolder.currentRequestAttributes().getSession()
    }
}
