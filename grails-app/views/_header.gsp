<div class="header-container">
    <header class="wrapper clearfix">
        <g:if test="${session.userId == null}">
        <div class="authorization-container">
            <div class="clearfix">
                <a href="#registration-form" class="registration">Регистрация</a>

                <div id="registration-form" class="hidden">
                    <div id="registration" class="popup-mask">
                        <div class="popup-wrapper">
                            <header class="popup-header">
                                <h1 class="popup-title">Регистрация</h1>
                            </header>
                            <div class="field-box">
                                <div class="field-help">Логин:</div>
                                <input type="text" name="login" placeholder="Отображаемое имя юзверя"/>
                                <div class="clear"></div>
                                <div class="error">Пользователь с таким именем здесь уже есть</div>
                            </div>
                            <div class="field-box">
                                <div class="field-help">Пароль:</div>
                                <input type="password" name="password" placeholder="От 1 до 3 цифр латинского алфавита"/>
                                <div class="clear"></div>
                                <div class="error">Слишком сложно чтобы запомнить. Может попробовать что-нибудь попроще?</div>
                            </div>
                            <div class="field-box">
                                <div class="field-help">E-mail:</div>
                                <input type="email" name="email" placeholder="Номер почтового ящика"/>
                                <div class="clear"></div>
                                <div class="error">С этим адресом что-то не то...</div>
                            </div>
                            <div class="submit">Хочу котика!</div>
                        </div>
                    </div>
                </div>

                <a href="#authorization-form" class="login">Вход</a>

                <div id="authorization-form" class="hidden">
                    <div id="auth-form" class="popup-mask">
                        <div class="popup-wrapper">
                            <header class="popup-header">
                                <h1 class="popup-title">Авторизация</h1>
                            </header>
                            <div class="field-box">
                                <div class="field-help">Логин:</div>
                                <input type="text" name="login" placeholder="Отображаемое имя юзверя"/>
                                <div class="clear"></div>
                                <div class="error">Имя пользователя не найдено. Потерялось наверное...</div>
                            </div>
                            <div class="field-box">
                                <div class="field-help">Пароль:</div>
                                <input type="password" name="password" placeholder="Отображаемое имя юзверя"/>
                                <div class="clear"></div>
                                <div class="error">Неверный пароль. Ещё раз?</div>
                            </div>
                            <div class="submit">Хочу котика!</div>
                        </div>
                    </div>
                </div>
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
