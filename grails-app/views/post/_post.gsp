<article class="tweet-container">
    <div class="avatar-container left"><img src="${post.author.userAvatar}" ></div>
    <div class="tweet">
        <div class="tweet-data-block">
            <div class="username">@${post.author.nickname}</div>
            <div class="datetime">(${post.dateCreated}):</div>
        </div>
        <div class="tweet-content"><p>${post.content}</p></div>

        <g:if test="${post.author.couldFollowed(session.userId)}">
            <div class="follow right" data-target="${createLink(controller: 'user', action: 'subscribe', id: post.author.id)}">Подписаться</div>
        </g:if>

    </div>
    <div class="clear"></div>
</article>