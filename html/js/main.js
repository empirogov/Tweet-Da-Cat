$(document).ready(function(){

    $('input').initPlaceholders();

    initScrollTop();

});

initScrollTop = function () {

    $('.scrollTop').hide();

    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.scrollTop').fadeIn();
        } else {
            $('.scrollTop').fadeOut();
        }
    });

    $('.scrollTop a').click(function () {
        $('body').animate({
            scrollTop: 0
        }, 1000);
        return false;
    });
};
