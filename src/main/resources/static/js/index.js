var oTO_top = document.getElementById('totop');
var oTop = document.getElementById('to_top_a');
var isTop = true;
var timer = null;

$(document).ready(function () {
    $(window).scroll(function () {
        var clientHeight = getBigHeight();
        var osTop = document.documentElement.scrollTop || document.body.scrollTop;
        if (osTop >= clientHeight) { //如果滚动高度大于可视区域高度，则显示回到顶部按钮
            oTO_top.style.opacity = 1;
        } else { //否则隐藏
            oTO_top.style.opacity = 0;
        };
        //判断当点击回到顶部按钮后，滚动条在回滚过程中，若手动滚动滚动条，则清除定时器
        if (!isTop) {
            clearInterval(timer);
        }
        isTop = false;
        $('.list').css({
            opacity: 0,
        });
    });

    $.fn.scrollEnd = function (callback, timeout) {
        $(this).scroll(function () {
            var $this = $(this);
            if ($this.data('scrollTimeout')) {
                clearTimeout($this.data('scrollTimeout'));
            }
            $this.data('scrollTimeout', setTimeout(callback, timeout));
        });
    };

    $(window).scrollEnd(function () {
        $('.list').css({
            opacity: 1,
        });
    }, 1000);
}) //使用jq使两个滚动的事件，不会相互冲突

oTop.onclick = function () { //回到顶部按钮点击事件
    //设置定时器
    timer = setInterval(function () {
        var osTop = document.documentElement.scrollTop || document.body.scrollTop;
        //缓慢滚动的效果
        var speed = Math.floor(-osTop / 6);
        document.documentElement.scrollTop = document.body.scrollTop = osTop + speed;
        isTop = true; //用于阻止滚动事件清除定时器
        if (osTop === 0) {
            clearInterval(timer);
        };
    }, 30);
}

//轮播图开始
var $ul_box = $("#scroll_banner"),
    $items = $ul_box.children("li"),
    $pre = $('.pre'),
    $next = $('.next'),
    imgWidth = $('.article_max').width(),
    imgCount = $items.length;

$ul_box.prepend($items.last().clone());
$ul_box.append($items.first().clone());
imgNewWidth = $ul_box.children().length;

$ul_box.css({
    left: 0 - imgWidth,
    width: imgNewWidth * imgWidth
})

$(window).resize(function () {
    imgWidth = $('.article_max').width()
    $ul_box.css({
        left: 0 - imgWidth,
        width: imgNewWidth * imgWidth,
    })
    autoPlay();
});

var judge = true;
var timer = null;

var $nav_bottom = $("#nav_circle"),
    $project = $nav_bottom.children("li")

$next.on('click', function () {
    playnext();
})
$pre.on('click', function () {
    playpre();
})

var curidx = 0;
var mov = 1;

function playnext() {
    if (judge) {
        judge = false;
        $project.removeClass('cur').eq(curidx + 1).addClass('cur');
        if (curidx === imgCount - 1) {
            $project.removeClass('cur').eq(0).addClass('cur');
        }
        $ul_box.animate({
            left: '-=' + mov * imgWidth
        }, 500, function () {
            judge = true;
            curidx += mov;
            if (curidx === imgCount) {
                $ul_box.css({
                    left: 0 - imgWidth
                });
                curidx = 0;
            }
        })
    }
}

function playpre() {
    if (judge) {
        judge = false;
        $project.removeClass('cur').eq(curidx - 1).addClass('cur');
        if (curidx === 0) {
            $project.removeClass('cur').eq(imgCount - 1).addClass('cur');
        }
        $ul_box.animate({
            left: '+=' + mov * imgWidth
        }, 500, function () {
            judge = true;
            curidx -= mov;
            if (curidx === (-1)) {
                $ul_box.css({
                    left: 0 - imgWidth * imgCount,
                });
                curidx = imgCount - 1;
            }
        })
    }
}

$project.click(function () {
    var index = $project.index(this);
    $(this).addClass('cur').siblings("li").removeClass('cur');
    $ul_box.animate({
        left: -(index + 1) * imgWidth
    }, 500)
    curidx = index;
})

function autoPlay() {
    clearInterval(timer);
    timer = setInterval(function () {
        playnext();
    }, 4000);
}
autoPlay();

$('.article_max').hover(function () {
    clearInterval(timer);
    $pre.css({
        opacity: 1
    })
    $next.css({
        opacity: 1
    })
}, function () {
    autoPlay();
    $pre.css({
        opacity: 0
    })
    $next.css({
        opacity: 0
    })
})
//轮播图结束


//画五边形，开始时自动加载动画
var $canvas = $('#pentagon');
draw_new($canvas);

function draw_new(n) {
    n.drawPolygon({
        layer: true,
        name: 'change3',
        fillStyle: 'rgba(170, 170, 170,.1)',
        x: 125,
        y: 105,
        radius: 0,
        sides: 5,
    });
    n.drawPolygon({
        layer: true,
        name: 'change2',
        fillStyle: 'rgba(170, 170, 170,.1)',
        x: 125,
        y: 105,
        radius: 0,
        sides: 5,
    });
    n.drawPolygon({
        layer: true,
        name: 'change1',
        fillStyle: 'rgba(255, 204, 102,.1)',
        strokeStyle: '#ffc81f',
        x: 125,
        y: 105,
        radius: 0,
        sides: 5,
    });
    n.animateLayer('change1', {
        radius: 60,
    }, 1000);
    n.animateLayer('change2', {
        radius: 75,
    }, 1000);
    n.animateLayer('change3', {
        radius: 85,
    }, 1000);
    var radial1 = n.createGradient({
        x1: 43,
        y1: 80,
        x2: 43,
        y2: 80,
        r1: 1,
        r2: 3,
        c1: '#ffc81f',
        c2: 'rgba(255, 200, 31,.1)'
    });
    var radial2 = n.createGradient({
        x1: 205,
        y1: 80,
        x2: 205,
        y2: 80,
        r1: 1,
        r2: 3,
        c1: '#ffc81f',
        c2: 'rgba(255, 200, 31,.1)'
    });
    var radial3 = n.createGradient({
        x1: 76,
        y1: 175,
        x2: 76,
        y2: 175,
        r1: 1,
        r2: 3,
        c1: '#ffc81f',
        c2: 'rgba(255, 200, 31,.1)'
    });
    var radial4 = n.createGradient({
        x1: 175,
        y1: 175,
        x2: 175,
        y2: 175,
        r1: 1,
        r2: 3,
        c1: '#ffc81f',
        c2: 'rgba(255, 200, 31,.1)'
    });
    var radial5 = n.createGradient({
        x1: 125,
        y1: 20,
        x2: 125,
        y2: 20,
        r1: 1,
        r2: 3,
        c1: '#ffc81f',
        c2: 'rgba(255, 200, 31,.1)'
    });
    n.drawArc({
        layer: true,
        name: 'fadeIn1',
        fillStyle: radial1,
        x: 125,
        y: 105,
        radius: 5,
        opacity: 0
    });
    n.drawArc({
        layer: true,
        name: 'fadeIn2',
        fillStyle: radial2,
        x: 125,
        y: 105,
        radius: 5,
        opacity: 0
    });
    n.drawArc({
        layer: true,
        name: 'fadeIn3',
        fillStyle: radial3,
        x: 125,
        y: 105,
        radius: 5,
        opacity: 0
    });
    n.drawArc({
        layer: true,
        name: 'fadeIn4',
        fillStyle: radial4,
        x: 125,
        y: 105,
        radius: 5,
        opacity: 0
    });
    n.drawArc({
        layer: true,
        name: 'fadeIn5',
        fillStyle: radial5,
        x: 125,
        y: 105,
        radius: 5,
        opacity: 0
    });
    n.animateLayer('fadeIn1', {
        x: 43,
        y: 80,
        opacity: 1,
    }, 1000);
    n.animateLayer('fadeIn2', {
        x: 205,
        y: 80,
        opacity: 1,
    }, 1000);
    n.animateLayer('fadeIn3', {
        x: 76,
        y: 175,
        opacity: 1,
    }, 1000);
    n.animateLayer('fadeIn4', {
        x: 175,
        y: 175,
        opacity: 1,
    }, 1000);
    n.animateLayer('fadeIn5', {
        x: 125,
        y: 20,
        opacity: 1,
    }, 1000);
    n.drawText({
        layer: true,
        fillStyle: '#fff',
        x: 125,
        y: 10,
        fontSize: 10,
        fontFamily: 'Verdana, sans-serif',
        text: '颜    控'
    });
    n.drawText({
        layer: true,
        fillStyle: '#fff',
        x: 22,
        y: 75,
        fontSize: 10,
        fontFamily: 'Verdana, sans-serif',
        text: '开脑洞'
    });
    n.drawText({
        layer: true,
        fillStyle: '#fff',
        x: 225,
        y: 75,
        fontSize: 10,
        fontFamily: 'Verdana, sans-serif',
        text: '技术宅'
    });
    n.drawText({
        layer: true,
        fillStyle: '#fff',
        x: 55,
        y: 180,
        fontSize: 10,
        fontFamily: 'Verdana, sans-serif',
        text: '二次元'
    });
    n.drawText({
        layer: true,
        fillStyle: '#fff',
        x: 195,
        y: 180,
        fontSize: 10,
        fontFamily: 'Verdana, sans-serif',
        text: '商业家'
    });
};
//五边形结束

//画框
$('.can_join').drawLine({
    strokeStyle: '#ffc81f',
    strokeWidth: 2,
    x1: 8,
    y1: 5,
    x2: 70,
    y2: 5,
    x3: 70,
    y3: 40,
    x4: 45,
    y4: 40,
    x5: 40,
    y5: 50,
    x6: 35,
    y6: 40,
    x7: 8,
    y7: 40,
    x8: 8,
    y8: 4,
});
//结束

$(window).scroll(function () {
    if ($(document).scrollTop() >= $(document).height() - $(window).height() - 250) {

    }
});