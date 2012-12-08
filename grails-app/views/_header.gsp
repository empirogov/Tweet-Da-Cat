<div class="header-container">
    <header class="wrapper clearfix">
        <g:if test="${session.userId == null}">
        <div class="authorization-container">
            <div class="clearfix">
                <a href="#" class="registration">Регистрация</a>
                <a href="#" class="login">Вход</a>
            </div>
        </div>
        </g:if>
        <div class="poisk-container">
            <div class="clearfix">
                <form>
                    <input type="text" placeholder="Хочу котика..." value="Хочу котика...">
                    <input type="button">
                </form>
            </div>
        </div>
    </header>
</div>
