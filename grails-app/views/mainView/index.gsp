<g:applyLayout name="main">
    <header>
        <h1 class="title"><span>All Da Catz</span> / <span class="inactive">Just Ma Cat</span></h1>
    </header>
    <div class="scrollTop">
        <div></div>
        <a href="#">Наверх</a>
    </div>
    <g:render template="/post/post_list" model="[posts: posts]" />
</g:applyLayout>