<g:applyLayout name="main">
    <header>
        <h1 class="title"><span>All Da Catz</span> / <span class="inactive">Just Ma Cat</span></h1>
    </header>
    <div class="tweet-wrapper">
        <article class="tweet-container">
            <div class="avatar-container left"><img src="../materials/raw-pictures/cat-01-thumb.jpg" ></div>
            <div class="tweet">
                <div class="tweet-data-block">
                    <div class="username">@ЙАУСТАЛО</div>
                    <div class="datetime">(21:33 17.12.2012):</div>
                </div>
                <div class="tweet-content"><p>При прочих равных условиях прибор Качинского неравномерен. Выветривание дает глинистый солеперенос, что дает возможность использования Упячки</p></div>
            </div>
            <div class="clear"></div>
        </article>
        <article class="tweet-container">
            <div class="avatar-container left"><img src="../materials/raw-pictures/cat-02-thumb.jpg" ></div>
            <div class="tweet">
                <div class="tweet-data-block">
                    <div class="username">@РыжийПохабник</div>
                    <div class="datetime">(20:59 17.12.2012):</div>
                </div>
                <div class="tweet-content"><p>Давай, досвидания!</p></div>
            </div>
            <div class="clear"></div>
        </article>
    </div>
    <div class="scrollTop">
        <div></div>
        <a href="#">Наверх</a>
    </div>

    <g:render template="/post/post_list" model="[posts: posts]" />
</g:applyLayout>