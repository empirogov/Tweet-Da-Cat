package tweet.da.cat

import grails.converters.JSON

class FeedController {

    def feedsService

    def index() { }

    def listFiltered() {
//        String filter = getFilter()
//        String viewType = getViewType()
        def posts = feedsService.getFeeds(params)
//        def posts = Post.list([max: MAX_POSTS, order: 'desc', sort: 'dateCreated'])
        render posts as JSON
    }
}
