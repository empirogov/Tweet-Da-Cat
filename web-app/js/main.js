$(document).ready(function(){

    $('input').initPlaceholders();
    initResizeEvents();

    initScrollTop();

    initHiddenForms();

    textareaHeight();
});

initResizeEvents = function () {
    $(window).on('resize', function () {
        $('.popup-wrapper').each(function () {
            var tH = $(this).height(),
                wH = $(window).height();
            if (wH > tH) {
                $(this).css('margin-top', parseInt((wH - tH)/3) + 'px');
            };
        });
    });
};

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
            var $existingVictim = $(victimSelector.replace('ion', 'ion-active'));
            if ($existingVictim.length) {
                $existingVictim.fadeIn();
            } else {
                $victimSource
                    .children()
                    .clone()
                    .attr('id', victimSelector.replace('ion', 'ion-active').replace('#', ''))
                    .insertAfter($victimTarget)
                    .removeClass('hidden')
                    .hide()
                    .fadeIn()
                    .on('click', function () {
                        $(this).fadeOut();
                        $('body').removeClass('fixed');
                    })
                    .children()
                    .on('click', function (e) {
                        e.stopPropagation();
                    })
                    .find('.submit')
                    .on('click', function (e) {
                        sendAuthRequest(e.currentTarget);
                    });
                $('.popup-wrapper').each(function () {
                    var tH = $(this).height(),
                        wH = $(window).height();
                    if (wH > tH) {
                        $(this).css('margin-top', parseInt((wH - tH)/3) + 'px');
                    };
                });
            };
            $('body').addClass('fixed');
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
sendAuthRequest = function (el) {
    var $elt = $(el),
        target = $elt.data('target'),
        dataToSend = {};
    $elt.closest('.popup-mask')
        .find('input')
        .each(function() {
            dataToSend[$(this).attr('name')] = $(this).val();
        });
    $.ajax({
        url: target,
        data: dataToSend,
        timeout: 2000,
        complete: function (answer) {

            if ($.parseJSON(answer.responseText).result == 'SUCCESS') {
                window.location.href = getHomeUrl();
            } else {
                return false;
            };
        },
        error: function () {
            alert('Конденсат в карбюраторе!');
        }
    });
};
getHomeUrl = function () {
    return $('body').data('homeurl');
};