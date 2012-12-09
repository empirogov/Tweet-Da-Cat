package tweet.da.cat

import org.springframework.web.context.request.RequestContextHolder

class FeedsService {
    static final int MAX_POSTS = 5;
    static final String FILTER_VAR = "FEED_FILTER";
    static final String VIEW_VAR = "FEED_VIEW";
    static final String ALL_VIEW_TYPE = "0";
    static final String FOLLOWING_VIEW_TYPE = "1";

    def authService

    def getFeeds(params = null) {
        def posts = Post.createCriteria().list(
                max: 5,
                offset: params?.offset ?: 0,
                sort: 'dateCreated',
                order: 'desc') {
            def viewType = getViewType()
            author {
                if (viewType.equals(FOLLOWING_VIEW_TYPE) && authService.isLogged()) {
                    def ids = authService.user.following*.id as ArrayList<Long>
                    ids.add(authService.user.id)
                    if (ids && ids.size()) {
                        'in'('id', ids.value)
                    }
                }
                if (params?.nickname) {
                    like 'nickname', "${params?.nickname}%"
                }

            }
        }

        return posts
    }

    def getFilter() {
        return session.getValue(FILTER_VAR);
    }

    def getViewType() {
        def value = getSession().getValue(VIEW_VAR)
        if (![ALL_VIEW_TYPE, FOLLOWING_VIEW_TYPE].contains(value)) {
            return ALL_VIEW_TYPE;
        }
        return getSession().getValue(VIEW_VAR);
    }

    def setViewType(viewType) {
        getSession().putValue(VIEW_VAR, viewType)
    }

    def getSession() {
        return RequestContextHolder.currentRequestAttributes().getSession()
    }
}
