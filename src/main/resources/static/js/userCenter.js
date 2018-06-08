$('.a_contain a').click(function () {
    $('.a_contain a').css({
        'border-bottom': '5px solid transparent',
    })
    $(this).css({
        'border-bottom': '5px solid #ffc81f',
    })
});

$('.a_contain a').eq(0).click(function () {
    $('.information').animate({
        height: 100,
    });
    $('.information ul').animate({
        left: 0,
    });
});

$('.a_contain a').eq(1).click(function () {
    $('.information').animate({
        height: 510,
    });
    $('.information ul').animate({
        left: -1010,
    });
});

var $canvas = $('#new_hope');
$canvas.drawPolygon({
    layer: true,
    name: 'change3',
    fillStyle: 'rgba(170, 170, 170,.1)',
    x: 175,
    y: 150,
    radius: 0,
    sides: 5,
});
$canvas.drawPolygon({
    layer: true,
    name: 'change2',
    fillStyle: 'rgba(170, 170, 170,.1)',
    x: 175,
    y: 150,
    radius: 0,
    sides: 5,
});
$canvas.drawPolygon({
    layer: true,
    name: 'change1',
    fillStyle: 'rgba(255, 204, 102,.1)',
    strokeStyle: '#ffc81f',
    x: 175,
    y: 150,
    radius: 0,
    sides: 5,
});
$canvas.animateLayer('change1', {
    radius: 85,
}, 1000);
$canvas.animateLayer('change2', {
    radius: 105,
}, 1000);
$canvas.animateLayer('change3', {
    radius: 125,
}, 1000);
var radial1 = $canvas.createGradient({
    x1: 45,
    y1: 112,
    x2: 45,
    y2: 112,
    r1: 1,
    r2: 3,
    c1: '#ffc81f',
    c2: 'rgba(255, 200, 31,.1)'
});
var radial2 = $canvas.createGradient({
    x1: 300,
    y1: 112,
    x2: 300,
    y2: 112,
    r1: 1,
    r2: 3,
    c1: '#ffc81f',
    c2: 'rgba(255, 200, 31,.1)'
});
var radial3 = $canvas.createGradient({
    x1: 96,
    y1: 255,
    x2: 96,
    y2: 255,
    r1: 1,
    r2: 3,
    c1: '#ffc81f',
    c2: 'rgba(255, 200, 31,.1)'
});
var radial4 = $canvas.createGradient({
    x1: 255,
    y1: 255,
    x2: 255,
    y2: 255,
    r1: 1,
    r2: 3,
    c1: '#ffc81f',
    c2: 'rgba(255, 200, 31,.1)'
});
var radial5 = $canvas.createGradient({
    x1: 175,
    y1: 20,
    x2: 175,
    y2: 20,
    r1: 1,
    r2: 3,
    c1: '#ffc81f',
    c2: 'rgba(255, 200, 31,.1)'
});
$canvas.drawArc({
    layer: true,
    name: 'fadeIn1',
    fillStyle: radial1,
    x: 125,
    y: 105,
    radius: 5,
    opacity: 0
});
$canvas.drawArc({
    layer: true,
    name: 'fadeIn2',
    fillStyle: radial2,
    x: 125,
    y: 105,
    radius: 5,
    opacity: 0
});
$canvas.drawArc({
    layer: true,
    name: 'fadeIn3',
    fillStyle: radial3,
    x: 125,
    y: 105,
    radius: 5,
    opacity: 0
});
$canvas.drawArc({
    layer: true,
    name: 'fadeIn4',
    fillStyle: radial4,
    x: 125,
    y: 105,
    radius: 5,
    opacity: 0
});
$canvas.drawArc({
    layer: true,
    name: 'fadeIn5',
    fillStyle: radial5,
    x: 125,
    y: 105,
    radius: 5,
    opacity: 0
});
$canvas.animateLayer('fadeIn1', {
    x: 45,
    y: 112,
    opacity: 1,
}, 1000);
$canvas.animateLayer('fadeIn2', {
    x: 300,
    y: 112,
    opacity: 1,
}, 1000);
$canvas.animateLayer('fadeIn3', {
    x: 96,
    y: 255,
    opacity: 1,
}, 1000);
$canvas.animateLayer('fadeIn4', {
    x: 255,
    y: 255,
    opacity: 1,
}, 1000);
$canvas.animateLayer('fadeIn5', {
    x: 175,
    y: 20,
    opacity: 1,
}, 1000);
$canvas.drawText({
    layer: true,
    fillStyle: '#fff',
    x: 175,
    y: 5,
    fontSize: 10,
    fontFamily: 'Verdana, sans-serif',
    text: '颜    控'
});
$canvas.drawText({
    layer: true,
    fillStyle: '#fff',
    x: 20,
    y: 110,
    fontSize: 10,
    fontFamily: 'Verdana, sans-serif',
    text: '开脑洞'
});
$canvas.drawText({
    layer: true,
    fillStyle: '#fff',
    x: 325,
    y: 112,
    fontSize: 10,
    fontFamily: 'Verdana, sans-serif',
    text: '技术宅'
});
$canvas.drawText({
    layer: true,
    fillStyle: '#fff',
    x: 70,
    y: 255,
    fontSize: 10,
    fontFamily: 'Verdana, sans-serif',
    text: '二次元'
});
$canvas.drawText({
    layer: true,
    fillStyle: '#fff',
    x: 280,
    y: 255,
    fontSize: 10,
    fontFamily: 'Verdana, sans-serif',
    text: '商业家'
});

$('#input_t').keyup(function () {
    var origin = 34;
    var len = $(this).val().length;
    if (origin - len >= 0) {
        $('.t_num').eq(0).html(origin - len);
        $('.t_span').eq(0).css({
            opacity: 1
        });
        $('.t_span').eq(1).css({
            opacity: 0
        });
    } else if (origin - len < 0) {
        $('.t_num').eq(1).html(len - origin);
        $('.t_span').eq(0).css({
            opacity: 0
        });
        $('.t_span').eq(1).css({
            opacity: 1
        });
    }
});
