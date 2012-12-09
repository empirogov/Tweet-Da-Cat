<div id="registration-form" class="hidden">
    <div id="registration" class="popup-mask">
        <div class="popup-wrapper">
            <header class="popup-header">
                <h1 class="popup-title">Регистрация</h1>
            </header>

            <div class="field-box">
                <div class="field-help">Логин:</div>
                <input type="text" name="login" placeholder="Хочу быть ..."/>

                <div class="clear"></div>

            </div>

            <div class="field-box">
                <div class="field-help">Пароль:</div>
                <input type="password" name="password"
                       placeholder="От 1 до 3 цифр латинского алфавита"/>

                <div class="clear"></div>

            </div>

            <div class="field-box">
                <div class="field-help">E-mail:</div>
                <input type="email" name="email" placeholder="Номер почтового ящика"/>

                <div class="clear"></div>

                <div class="error">Или что-то случилось, или одно из двух...</div>
            </div>

            <div class="submit"
                 data-target="${createLink(controller: 'register', action: 'index')}">Хочу котика!</div>
        </div>
    </div>
</div>
