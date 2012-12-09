$(document).ready(function(){

    $('input').initPlaceholders();
    initResizeEvents();
    initSearch();

    initScrollTop();
    initPagination();

    initHiddenForms();

    initTweetForm();
    textareaHeight();

    initAddFollower();
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
                $existingVictim.fadeIn().find('.error').hide();
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
                        sendAJAXRequest(
                            e.currentTarget,
                            getAllFormValues($(e.currentTarget).closest('.popup-mask')),
                            authFormCompletion
                        );
                    });
                $(window).trigger('resize');
            };
            $('body').addClass('fixed');
        };
        return false;
    });
};

getAllFormValues = function ($form) {
    var dataToSend = {};
    $form.find('input')
        .each(function () {
            dataToSend[$(this).attr('name')] = $(this).val();
        });
    return dataToSend;
};

initTweetForm = function () {
    $('#add-tweet-form').submit(function() {
        $.post(
            $(this).attr('action'),
            $(this).serializeArray(),
            function(data) {
                if (data == "SUCCESS") {
                    $('#nickname-search').keyup();
                } else {
                    alert('something was wrong')
                }
            }
        );
        return false;
    });

//    $('.message .submit').on('click', function (e) {
//        sendAJAXRequest(
//            e.currentTarget,
//            getAllFormValues($(e.currentTarget).closest('.message')),
//            function () {
//                $(e.currentTarget).trigger('submit');
//            }
//        );
//    });
};

authFormCompletion = function (answer) {
    if ($.parseJSON(answer.responseText).result == 'SUCCESS') {
        window.location.href = getHomeUrl();
    } else {
        $('.popup-wrapper').find('.error').fadeIn();
    };
};

sendAJAXRequest = function (el, dataToSend, completion) {
    var $elt = $(el),
        target = $elt.data('target');
    $.ajax({
        url: target,
        data: dataToSend,
        timeout: 2000,
        complete: completion
    });
};

getHomeUrl = function () {
    return $('body').data('homeurl');
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

initSearch = function() {
    $('#search-form').submit(function() { return false; });
    $('#nickname-search').keyup(function() {
        var $this = $(this),
            actionUrl = $this.closest('form').attr('action'),
            value = $this.val();

        $.get(actionUrl, { nickname: value }, function(data) {
            $('.tweet-wrapper').html(data);
        });
    });

    $('.filter-feeds').click(function() {
        var $this = $(this),
            value = $this.data('value'),
            url = $this.data('url');

        $('.filter-feeds').addClass('inactive');
        $this.removeClass('inactive');
        $.get(url, { viewType: value }, function(data) {
            $('.tweet-wrapper').html(data);
        });
    })
}

initPagination = function() {
    $('.paginator a').live('click', function() {
        $.get($(this).attr('href'), {}, function(data) {
            $('.tweet-wrapper').html(data);
        });
        return false;
    });
};

initAddFollower = function () {
    $(document).on('click', '.follow', function () {
        var target = $(this).data('target');
        $.post(
            target,
            function(answer) {
                if (answer.result == 'SUCCESS') {
                    $(document).find('.follow[data-target="' + target + '"]').fadeOut();
                } else {
                    alert('something was wrong')
                }
            }
        );
    });
};
