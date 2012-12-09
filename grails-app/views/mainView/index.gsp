<g:applyLayout name="main">
    <header>
        <h1 class="title">
            <span class="filter-feeds" data-url="${createLink(controller: 'feed', action: 'changeViewType')}"
                  data-value="${tweet.da.cat.FeedsService.ALL_VIEW_TYPE}">
                Все котики
            </span>
            <g:if test="${session.userId}">
                / <span class="filter-feeds inactive"
                        data-url="${createLink(controller: 'feed', action: 'changeViewType')}"
                        data-value="${tweet.da.cat.FeedsService.FOLLOWING_VIEW_TYPE}">
                Мои котики
            </span>
            </g:if>
        </h1>
    </header>

    <div class="scrollTop">
        <div></div>
        <a href="#">Наверх</a>
    </div>
    <g:render template="/post/post_list" model="[posts: posts, postsCount: postsCount]"/>
</g:applyLayout>