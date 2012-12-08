/**
 * Имитирует поддержку атрибута placeholder в ie9 и более старых
 *
 * */

(function ($, window, undefined) {
    $.fn.initPlaceholders = function () {
        return this.each(function () {

            if ($(this).is('input[type="text"]')) {
                var $element = $(this);
                if (($.browser.msie) && (parseInt($.browser.version))<10) {
                    $element.focus(function(e) {
                        var def = e.currentTarget.defaultValue,
                            cVal = $element.val();
                        if (cVal == def) {
                            $element.val('');
                        };
                    });
                    $element.blur(function(e) {
                        if (!$element.val().length) {
                            $element.val(e.currentTarget.defaultValue);
                        };
                    });
                } else if ($element.val() === $element.attr('placeholder')) {
                    $element.val('');
                }
            };
        });
    };
})(jQuery, this);