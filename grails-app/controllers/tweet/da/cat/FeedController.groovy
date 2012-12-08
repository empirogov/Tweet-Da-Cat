package tweet.da.cat

import grails.converters.JSON

class FeedController {
    static final int MAX_POSTS = 100;
    static final String FILTER_VAR = "FEED_FILTER";
    static final String VIEW_VAR = "FEED_VIEW";
    static final int ALL_VIEW_TYPE = 0;
    static final int FOLLOWING_VIEW_TYPE = 1;

    def index() { }

    def listFiltered() {
        String filter = getFilter()
        String viewType = getViewType()
        def posts = Post.list([max: MAX_POSTS, order: 'desc', sort: 'dateCreated'])
        render posts as JSON
    }

    def getFilter() {
        return session.getValue(FILTER_VAR);
    }

    def getViewType() {
        if (![ALL_VIEW_TYPE, FOLLOWING_VIEW_TYPE].contains(session.getValue(VIEW_VAR))) {
            return ALL_VIEW_TYPE;
        }
        return session.getValue(VIEW_VAR);
    }
}
