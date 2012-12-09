<div id="authorization-form" class="hidden">
    <div id="auth-form" class="popup-mask">
        <div class="popup-wrapper">
            <header class="popup-header">
                <h1 class="popup-title">Авторизация</h1>
            </header>

            <div class="field-box">
                <div class="field-help">E-mail:</div>
                <input type="text" name="email" placeholder="Номер почтового ящика"/>

                <div class="clear"></div>

            </div>

            <div class="field-box">
                <div class="field-help">Пароль:</div>
                <input type="password" name="password" placeholder="Сигнатура ключа"/>

                <div class="clear"></div>

                <div class="error">Или что-то случилось, или одно из двух...</div>
            </div>

            <div class="submit"
                 data-target="${createLink(controller: 'authorize', action: 'login')}">Хочу котика!</div>
        </div>
    </div>
</div>