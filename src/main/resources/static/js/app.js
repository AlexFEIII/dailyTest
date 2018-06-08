var len = $('#special_nav li').css('width');
var oUl_s = document.getElementById('special_nav');
var aLi_s = oUl_s.getElementsByTagName('li');

$('#b_nav li a').click(function () {
    var index = $('#b_nav li a').index(this);
    $('.active').removeClass('active');
    $(this).addClass('active');
    $("#special_nav").animate({
        left: -parseInt(len) * index,
    }, 500, function () {
        $("#special_nav").animate({
            height: getStyle(aLi_s[index], 'height')
        })
    })
})

function getStyle(obj, attr) {
    return obj.currentStyle ? obj.currentStyle[attr] : getComputedStyle(obj)[attr];
}

$('.q_code').qrcode({
    width: 178,
    height: 178,
    text: "http://m.qdaily.com/mobile/downloads.html"
});


$("body").find(".show_btn").hover(function () {
    var index = $('.show_btn').index(this);
    $(".q_code").eq(index).css({
        visibility: 'visible',
        opacity: 1
    })
}, function () {
    $(".q_code").css({
        visibility: 'hidden',
        opacity: 0
    })
});