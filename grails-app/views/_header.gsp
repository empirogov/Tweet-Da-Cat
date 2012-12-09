<div class="header-container">
    <header class="wrapper clearfix">
        <g:if test="${session.userId == null}">
            <div class="authorization-container">
                <div class="clearfix">
                    <a href="#registration-form" class="registration">Регистрация</a>
                    <g:render template="/snippets/popups/register" />
                    <a href="#authorization-form" class="login">Вход</a>
                    <g:render template="/snippets/popups/login" />
                </div>
            </div>
        </g:if>
        <g:render template="/snippets/forms/filter" />
        <g:if test="${session.userId}">
            <g:render template="/snippets/forms/tweet" />
        </g:if>
    </header>
</div>
