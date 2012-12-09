<g:each in="${posts}" var="post">
    <g:render template="/post/post" model="[post: post]" />
</g:each>

<g:paginate total="${postsCount}" />