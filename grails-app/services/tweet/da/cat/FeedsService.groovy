package tweet.da.cat

import org.springframework.web.context.request.RequestContextHolder

class FeedsService {
    static final int MAX_POSTS = 100;
    static final String FILTER_VAR = "FEED_FILTER";
    static final String VIEW_VAR = "FEED_VIEW";
    static final int ALL_VIEW_TYPE = 0;
    static final int FOLLOWING_VIEW_TYPE = 1;

    def authService

    def getFeeds(params = null) {
        def posts = Post.createCriteria().list(max: MAX_POSTS, sort: 'dateCreated', order: 'desc') {
            if (params?.nickname) {
                author {
                    like 'nickname', "${params.nickname}%"
                }
            }

            if (getViewType() == FOLLOWING_VIEW_TYPE) {
                def ids = authService.user.following*.id as List
                author {
                    'in'('id', ids)
                }

            }
        }

        return posts
    }

    def getFilter() {
        return session.getValue(FILTER_VAR);
    }

    def getViewType() {
        if (![ALL_VIEW_TYPE, FOLLOWING_VIEW_TYPE].contains(getSession().getValue(VIEW_VAR))) {
            return ALL_VIEW_TYPE;
        }
        return getSession().getValue(VIEW_VAR);
    }

    def getSession() {
        return RequestContextHolder.currentRequestAttributes().getSession()
    }
}
