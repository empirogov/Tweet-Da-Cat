<article class="tweet-container">
    <div class="avatar-container left"><img src="${resource(file: post.author.userAvatar)}" ></div>
    <div class="tweet">
        <div class="tweet-data-block">
            <div class="username">@${post.author.nickname}</div>
            <div class="datetime">(${post.dateCreated}):</div>
        </div>
        <div class="tweet-content"><p>${post.content}</p></div>

        <div class="follow right" data-target="/url/kuda/posylat/id-usera">Подписаться</div>

    </div>
    <div class="clear"></div>
</article>