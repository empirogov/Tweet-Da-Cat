package tweet.da.cat

import grails.converters.JSON

class FeedController {

    def feedsService

    def index() { }

    def listFiltered() {
       def posts = feedsService.getFeeds(params)
       render(view: '/post/_post_list', model: [posts: posts, postsCount: posts.size()])
    }

    def changeViewType() {
        feedsService.setViewType(params.viewType)
        redirect(action: 'listFiltered')
    }
}
