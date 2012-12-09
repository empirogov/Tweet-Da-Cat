package tweet.da.cat

import grails.converters.JSON

class FeedController {

    def feedsService

    def index() { }

    def listFiltered() {
       def posts = feedsService.getFeeds(params)
       render(view: 'list', model: [posts: posts])
    }

    def changeViewType() {
        feedsService.setViewType(params.viewType)
        redirect(action: 'listFiltered')
    }
}
