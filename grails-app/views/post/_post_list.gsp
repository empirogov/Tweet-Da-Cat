<div class="tweet-wrapper">
<g:each in="${posts}" var="post">
    <g:render template="/post/post" model="[post: post]" />
</g:each>

    <div class="paginator">
        <tweet:paginate next="Постаршее" prev="Посвежее" total="${posts.totalCount}" controller="feed" action="listFiltered" />
    </div>
</div>
