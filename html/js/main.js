$(document).ready(function(){

    $('input').each(function(index, element) {
        var $element = $(element);
        var defaultValue = $element.val();
        $element.focus(function() {
            var actualValue = $element.val();
            if (actualValue == defaultValue) {
                $element.val('');
            }
        });
        $element.blur(function() {
            var actualValue = $element.val();
            if (!actualValue) {
                $element.val(defaultValue);
            }
        });
    });

    $(".scrollTop").hide();

    $(function () {
        $(window).scroll(function () {
            if ($(this).scrollTop() > 100) {
                $('.scrollTop').fadeIn();
            } else {
                $('.scrollTop').fadeOut();
            }
        });

        $('.scrollTop a').click(function () {
            $('body,html').animate({
                scrollTop: 0
            },1000);
            return false;
        });
    });

});
