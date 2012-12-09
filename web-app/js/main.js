$(document).ready(function(){

    $('input').initPlaceholders();

    initScrollTop();

    initHiddenForms();

    textareaHeight();
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
        $('body, html').animate({
            scrollTop: 0
        }, 1000);
        return false;
    });
};

initHiddenForms = function () {
    $(document).on('click', 'div.authorization-container a', function () {
        var victimSelector = $(this).attr('href'),
            $victimSource = $(this).next(victimSelector),
            $victimTarget = $('.body-wrapper');
        if ($victimSource.length) {
            $victimSource
                .attr('id', victimSelector.replace('#','_'))
                .clone()
                    .attr('id', victimSelector.replace('_', ''))
                    .insertAfter($victimTarget)
                    .removeClass('hidden')
                    .hide()
                    .fadeIn();

        };
        return false;
    });
};

textareaHeight = function() {
    $('.message textarea').on('keyup', function (e) {
        var $el = $(this),
            elheight = $el.height(),
            elscroll = this.scrollHeight;
        if (elscroll > elheight) {
            $el.css({height: elscroll - 20});
        }
        elheight = $el.height();
            elscroll = this.scrollHeight;
        if(e.keyCode == 8){
            $el.css({height: elheight - 20});
        }
    });
};
