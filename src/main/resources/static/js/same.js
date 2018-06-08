var oBody = document.getElementsByTagName('body')[0];
var oA = document.getElementById('last_icon');
var oDown = document.getElementsByClassName('down')[0];
var oPageNav = document.getElementsByClassName('page_nav')[0];
var oRight = document.getElementsByClassName('right')[0];
var oItem = document.getElementById('item_left');
var oMiddle = document.getElementsByClassName('middle')[0];
var oLeft = document.getElementsByClassName('left')[0];
var oDiv_a = document.getElementsByClassName('div_a')[0];
var oNav = document.getElementsByClassName('nav')[0];
var oLogo = document.getElementById('logo');
var Ologo_b = document.getElementById('logo_bottom');
var oLContent = document.getElementById('logo_content');
var oLBox = document.getElementById('logo_box');
var oApp = document.getElementsByClassName('app')[0];
var oLogin = document.getElementsByClassName('login')[0];
var oIcon_s = document.getElementsByClassName('icon_s')[0];
var onOff = true;

var oBox = document.getElementById('box');

function getBigHeight() {
    var bigHeight = document.documentElement.clientHeight || document.body.clientHeight;
    return bigHeight;
} //获取页面的高度

oA.onclick = function () {
    if (onOff) {
        onOff = false;
        oDown.style.cssText = 'transform:rotate(180deg)';
        oPageNav.style.display = 'flex';
        oLeft.style.boxShadow = '0 1px 0 #4d4d4d';
        oRight.style.boxShadow = '0 1px 0 #4d4d4d';
    } else {
        onOff = true;
        oDown.style.cssText = '';
        oPageNav.style.display = 'none';
        oLeft.style.boxShadow = '';
        oRight.style.boxShadow = '';
    }
}

var oSearch = document.getElementsByClassName('search')[0];
var oCover = document.createElement('div');
oCover.className = 'special_div';
var oWhite = document.createElement('div');
oWhite.className = 'cover_white';
var oIcon = document.createElement('div');
oIcon.className = 'icon_div';
var oA_icon = document.createElement('a');
oA_icon.className = 'oA_icon';
oA_icon.href = 'javascript:;';
var oI = document.createElement('i');
oI.className = 'iconfont';
oI.innerHTML = '&#xe61a;'
var oFrom = document.createElement('form');
oFrom.className = 'form_search';
var oAll_people = document.createElement('div');
oAll_people.className = 'all_people';
var oMain = document.createElement('div');
oMain.className = 'omain';
oMain.innerHTML = '大家都在搜';
var oUl = document.createElement('ul');
oUl.id = 'all_ul';
var num = 20;
var oSpan = document.createElement('span');
oSpan.className = 'span_form';
var oIcon_search = document.createElement('i');
oIcon_search.className = 'iconfont';
oIcon_search.innerHTML = '&#xe6fe';
var oInput_text = document.createElement('input');
oInput_text.className = 'input_text';
oInput_text.placeholder = '搜索文章';

var bigHeight = getBigHeight();
oCover.style.height = bigHeight + 'px'; //初始化遮挡层的高

window.onresize = function () {
    Cover();
}

function Cover() {
    var bigHeight = getBigHeight();
    oCover.style.height = bigHeight + 'px';
}

oSearch.onclick = function () {
    getEle_fn();
} //实现搜索的那个翻转弹窗

function getEle_fn() {
    oBody.appendChild(oCover);
    oCover.appendChild(oWhite);
    setTimeout(function () {
        oWhite.style.cssText = 'transform:translateY(0) perspective(600px) rotateX(0);opacity:1';
    }, 30);
    oWhite.appendChild(oFrom);
    oWhite.appendChild(oAll_people);
    oAll_people.appendChild(oMain);
    oAll_people.appendChild(oUl);

    for (var i = 0; i < num; i++) {
        var oLi = document.createElement('li');
        oUl.appendChild(oLi);
        var oLi_a = document.createElement('a');
        oLi.appendChild(oLi_a);
        oLi_a.href = 'javascript:;';
    }

    var getOUl = document.getElementById('all_ul');
    var aA = getOUl.getElementsByTagName('a');
    aA[0].innerHTML = '好莱坞';
    aA[1].innerHTML = '亚马逊';
    aA[2].innerHTML = '阿里巴巴';
    aA[3].innerHTML = '音乐节';
    aA[4].innerHTML = '特斯拉';
    aA[5].innerHTML = '腾讯';
    aA[6].innerHTML = '苹果';
    aA[7].innerHTML = '海淘';
    aA[8].innerHTML = '百度';
    aA[9].innerHTML = 'Google';
    aA[10].innerHTML = '小米';
    aA[11].innerHTML = '时尚';
    aA[12].innerHTML = '迪士尼';
    aA[13].innerHTML = '万达';
    aA[14].innerHTML = '星巴克';
    aA[15].innerHTML = '人工智能';
    aA[16].innerHTML = '无人机';
    aA[17].innerHTML = '华为';
    aA[18].innerHTML = 'MUJI';
    aA[19].innerHTML = '宜家';


    oFrom.appendChild(oSpan);
    oSpan.appendChild(oIcon_search);
    oFrom.appendChild(oInput_text);
    oWhite.appendChild(oIcon);
    oIcon.appendChild(oA_icon);
    oA_icon.appendChild(oI);
}

oA_icon.onclick = function () {
    oWhite.style.cssText = '';
    setTimeout(function () {
        oBody.removeChild(oCover);
    }, 300);
} //搜索的弹窗消失

function stopBubble(e) {
    //如果提供了事件对象，则这是一个非IE浏览器 
    if (e && e.stopPropagation)
        //因此它支持W3C的stopPropagation()方法 
        e.stopPropagation();
    else
        //否则，我们需要使用IE的方式来取消事件冒泡 
        window.event.cancelBubble = true;
}

oWhite.onclick = function () {
    stopBubble();
} //阻止事件冒泡，在那个遮挡层点击的时候消失，在那块白色的地方点击不会消失

oCover.onclick = function () {
    oCover.style.cssText = '';
    oWhite.style.cssText = '';
    setTimeout(function () {
        oBody.removeChild(oCover);
    }, 300);
} //遮挡层点击的时候消失

//微信公众号
$('#QR_Code').qrcode({
    width: 120,
    height: 120,
    text: "http://weixin.qq.com/r/r0x4YOjEWrUlrawD9xm9"
});

$('#weixin_code').qrcode({
    width: 120,
    height: 120,
    text: "http://weixin.qq.com/r/r0x4YOjEWrUlrawD9xm9"
});
//以上通过jq的插件自动生成二维码

$("body").find(".icon_a").eq(1).hover(function () {
    $(".weixin_box").css({
        visibility: 'visible',
        opacity: 1
    })
}, function () {
    $(".weixin_box").css({
        visibility: 'hidden',
        opacity: 0
    })
}) //二维码的隐藏与消失

$("body").find(".show_a").hover(function () {
    $(".wei_xin_bottom").css({
        visibility: 'visible',
        opacity: 1
    })
}, function () {
    $(".wei_xin_bottom").css({
        visibility: 'hidden',
        opacity: 0
    })
}) //二维码的隐藏与消失

var oMiddle_nav = document.getElementById('middle_item');
var aLi = oMiddle_nav.getElementsByTagName('li');

$(document).ready(function () {
    $(window).scroll(function () {
        var osTop = document.documentElement.scrollTop || document.body.scrollTop;

        onOff = true;
        oDown.style.cssText = '';
        oPageNav.style.display = 'none';

        if (osTop >= 90) {
            oNav.style.cssText = 'height:60px';
            oLogo.style.cssText = 'width:14px';
            Ologo_b.style.cssText = 'width:50px';
            oLContent.style.cssText = 'width:auto';
            oLBox.style.cssText = 'width:auto;margin:0';
            oDiv_a.style.cssText = 'height:60px';
            aLi[5].style.cssText = 'display:none';
            aLi[6].style.cssText = 'display:none';
            aLi[7].style.cssText = 'display:none';
            oRight.style.cssText = 'position:absolute;right:0;width:40%';
            oLogin.style.cssText = 'display:flex';
            oApp.style.cssText = 'width:14%';
            oIcon_s.style.cssText = 'width:10%';
            oItem.style.cssText = '';
            oMiddle.style.cssText = '';
            oLeft.style.cssText = '';
        } else {
            oNav.style.cssText = '';
            oLogo.style.cssText = '';
            Ologo_b.style.cssText = '';
            oLContent.style.cssText = '';
            oLBox.style.cssText = '';
            oDiv_a.style.cssText = '';
            aLi[5].style.cssText = '';
            aLi[6].style.cssText = '';
            aLi[7].style.cssText = '';
            oRight.style.cssText = '';
            oLogin.style.cssText = '';
            oApp.style.cssText = '';
            oIcon_s.style.cssText = '';
        }
    })
}) //这个是鼠标滚动的时候导航条变化的js

var event_f = function (e) {
    e.preventDefault();
} //阻止默认事件

oCover.onmouseover = function () {
    document.body.addEventListener('wheel', event_f, false);
} //鼠标在遮挡层的时候，使是页面不会滚动

oBox.onmouseover = function () {
    document.body.removeEventListener('wheel', event_f, false);
} //离开遮挡层的时候页面滚动


var bigCover = $('<div></div>');
bigCover.addClass('special_div');
var bigCover_c = $('<div></div>');
bigCover_c.addClass('small_white');
bigCover_c.css({
    opacity: 0,
    'transform': 'translateY(-20px) perspective(600px) rotateX(10deg)',
});
var box_in = $('<div></div>');
box_in.addClass('box_in');
var title_img = $('<div></div>');
title_img.addClass('title_img');
var title_a = $('<a></a>');
title_a.attr('href', 'javascript:;');
var $c_I_a = $('<a href="javascript:;" id="c_I_a"></a>');
bigCover_c.append($c_I_a);
var c_I = $('<i></i>');
c_I.addClass('iconfont');
c_I.html('&#xe61a;');
var line_div = $('<p></p>');
line_div.addClass('line_div');
var span_line = $('<span></span>');
span_line.addClass('line_span');
span_line.html('社交账号登录');
var social_login = $('<div></div>');
social_login.addClass('social_login');
var oP = $('<p></p>');
oP.addClass('line_div');
var oP_span = $('<span></span>');
oP_span.addClass('line_span');
oP_span.html('或者');
// var form_div = $('<form></form>');
var form_div = $('<div></div>');
form_div.addClass('form_div');
// form_div.attr('action','/login')
// form_div.attr('name','form')
// form_div.attr('method','post')
var photo_input = $('<input/>');
photo_input.attr('type', 'text');
// photo_input.attr('name', 'user[email]');
photo_input.attr('name','username');
photo_input.attr('placeholder', '手机号 / 电子邮箱');
var s_input = $('<input/>');
s_input.attr('type', 'password');
// s_input.attr('name', 'user[password]');
s_input.attr('name','password');
s_input.attr('placeholder', '密码');
var submit_input = $('<input/>');
submit_input.attr('value', '登录');
submit_input.attr('type', 'submit');
submit_input.addClass("login-button");
var cancel_input = $('<input/>');
cancel_input.attr('value', '取消');
cancel_input.attr('type', 'submit');
var f_Pword = $('<a></a>');
f_Pword.addClass('f_Pword');
f_Pword.html('忘记密码');
f_Pword.attr('href', 'javascript:;');
var new_c = $('<a></a>');
new_c.addClass('f_Pword f_right');
new_c.html('新用户');
new_c.attr('href', 'javascript:;');

var last_think = $("<img src='http://p5w1f51o8.bkt.clouddn.com/special_img.png'/>");
for (var i = 0; i < 3; i++) {
    $three_a = $('<a href="javascript:;" class="lasT_a" rel="nofollow"><i class="iconfont"></i></a>');
    social_login.append($three_a);
}

var oLogin_board = $('<div class="big_qr_box"></div>');
var oP_title = $('<p>微信登陆</p>');
var o_State = $('<div class="qr_div"><p>请使用微信扫描二维码登录</p><p>“好奇心日报”</p></div>');
var qR_img = $('<div class="qr_i_div"><img src="http://p5w1f51o8.bkt.clouddn.com/qrCode.jpg"/></div>');
//以上是用jq写的登陆框

oLogin_board.append(oP_title);
oLogin_board.append(qR_img);
oLogin_board.append(o_State);

bigCover.css({
    height: $(window).height(),
});

$(window).resize(function () {
    bigCover.css({
        height: $(window).height(),
    });
}); //当页面的尺寸变化的时候，自动刷新页面高度的值

var $btn_login = $(".login_img");
$btn_login.click(function () {
    JQ_fn();
});

function JQ_fn() {
    bigCover.appendTo('body');
    bigCover_c.appendTo(bigCover);
    setTimeout(function () {
        bigCover_c.css({
            'transform': 'translateY(0) perspective(600px) rotateX(0)',
            opacity: 1,
        });
    }, 30);
    box_in.appendTo(bigCover_c);
    title_img.appendTo(box_in);
    title_a.appendTo(title_img);
    last_think.appendTo(title_a);
    c_I.appendTo($c_I_a);
    line_div.appendTo(box_in);
    span_line.appendTo(line_div);
    social_login.appendTo(box_in);

    $('.social_login i').eq(0).html('&#xe65a;');
    $('.social_login i').eq(1).html('&#xe69a;');
    $('.social_login i').eq(2).html('&#xe636;');
    $('.social_login a').eq(0).attr('href', 'http://www.qdaily.com/oauth_sessions/weibo_token?redirect_uri=http://www.qdaily.com/');
    $('.social_login a').eq(2).attr('href', 'http://www.qdaily.com/oauth_sessions/qq_token?redirect_uri=http://www.qdaily.com/');

    oP.appendTo(box_in);
    oP_span.appendTo(oP);
    form_div.appendTo(box_in);
    photo_input.appendTo(form_div);
    s_input.appendTo(form_div);
    submit_input.appendTo(form_div);
    cancel_input.appendTo(form_div);
    f_Pword.appendTo(form_div);
    new_c.appendTo(form_div);

    $c_I_a.click(function () {
        oLogin_board.css({
            display: 'none',
        });
        bigCover_c.css({
            opacity: 0,
            'transform': 'translateY(-20px) perspective(600px) rotateX(10deg)',
        });
        setTimeout(function () {
            $(".special_div").remove();
        }, 300);
    }); //页面翻转的动画

    bigCover.mouseover(function () {
        $(document).bind('mousewheel', function (event, delta) {
            return false;
        });
    }); //使滚轮失效，禁止滚动

    $('#box').mouseover(function () {
        $(document).unbind('mousewheel');
    }); //重新启动滚轮

    title_img.after(oLogin_board);

    $('.social_login a').eq(1).on('click', function () {
        oLogin_board.nextAll().remove();
        $('.box_in').css({
            'align-content': 'flex-start',
            height: '86%',
        });
        oLogin_board.css({
            display: 'flex',
        });
    });

    bigCover.on('click', function () {
        oLogin_board.css({
            display: 'none',
        });
        bigCover_c.css({
            opacity: 0,
            'transform': 'translateY(-20px) perspective(600px) rotateX(10deg)',
        });
        setTimeout(function () {
            $(".special_div").remove();
        }, 300);
    });
    bigCover_c.on('click', function () {
        stopBubble();
    });
    
    submit_input.on("click",function () {
        var mail = $("input[name='username']").val();
        var pass = $("input[name='password']").val();
        $.ajax({
            url:"/login",
            type:"post",
            dataType:"json",
            data:{"username":mail,"password":pass},
            success:function (data) {
                alert(data.msg);
                if(data.msg != "fail"){
                    console.log(data);
                    window.location.href="/index.html"
                }else{
                    alert("登陆失败")
                }

            },error:function (data) {
            }
        })
    })
}

var oCover_white = $('<div class="cover_mobile_t"><span class="s_div_top"><a href="javascript:;" class="search_a"><input type="text" class="s_btn" placeholder="搜索"></a><span class="s_icon_btn"><i class="iconfont">&#xe6fe;</i></span></span></div>');
var many_icon = $('<div class="icon_s_bottom"><a href="../html/app.html" target="_blank"><span class="about_a_span"><div class="first_btn"><i class="iconfont">&#xe646;</i></div><p>关于我们</p></span></a><a href="../html/column.html" target="_blank"><span><div class="second_btn"><i class="iconfont">&#xe6f9;</i></div><p class="second_p">栏目中心</p></span></a></div>');
var new_kind = $('<div class="new_top_kind"><a href="javascript:;"><span><i class="iconfont">&#xe602;</i></span><p>新闻分类</p></a><div class="login_circle"><a href="javascript:;" class="login_c_btn"><span><i class="iconfont">&#xe619;</i></span><p>登录</p></a></div></div>');
var big_many_icon = $('<div class="ten_over"><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>好奇心研究所</p></a><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>长文章</p></a><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>十个图</p></a><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>Top 15</p></a><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>商业</p></a><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>智能</p></a><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>设计</p></a><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>时尚</p></a><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>娱乐</p></a><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>城市</p></a><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>游戏</p></a><a href="javascript:;"><span><i class="iconfont">&#xe61c;</i></span><p>智能</p></a></div>')
var out_div = $('<div class="out_div"></div>');
var small_div = $('<div class="small_div"></div>');
var search_s_div = $('<div class="small_div"><a href="javascript:;" class="special_search">搜索</a><div class="w_div_new"><div id="qr_code_new"></div><p class="q_Code_new_n">好奇心微信公众号</p></div></div>');
var login_s_div = $('<div class="small_div"></div>');
var very_special = $('<div class="article_middle"><div class="save_img"><canvas class="pentagon_new" width="250" height="210" style="cursor:auto;"/><a href="javascript:;" class="login_img_new"><img src="http://p5w1f51o8.bkt.clouddn.com/login.png"></a></div><a href="javascript:;" class="login_img_new">登录</a><p>登录查看你的好奇心指数</p></div>');
oCover_white.append(many_icon);
oCover_white.css({
    height: getBigHeight() * 0.21,
});
var oCover_w_b = $('<div class="cover_mobile_b"></div>');
oCover_w_b.append(out_div);
out_div.append(small_div);
out_div.append(search_s_div);
out_div.append(login_s_div);
login_s_div.append(very_special);
small_div.append(new_kind);
small_div.append(big_many_icon);
oCover_w_b.css({
    height: getBigHeight() * 0.81,
});

$('.list a').on('click', function () {
    if ($('.list img').css("display") === 'block') {
        $(document).bind('mousewheel', function (event, delta) {
            return false;
        });
        $('.list img').css({
            display: 'none',
        });
        $('.list .img_icon').css({
            display: 'block',
        });
        $('.list a').css({
            animation: 'move 1s',
        });

        oCover_white.appendTo('body');
        setTimeout(function () {
            oCover_white.animate({
                top: 0,
            }, 500);
        }, 10);

        oCover_w_b.appendTo('body');
        setTimeout(function () {
            oCover_w_b.animate({
                bottom: 0,
            }, 500);
        }, 10);
        var $canvas_new = $('.pentagon_new');
        draw_new($canvas_new);
    } else if ($('.list .img_icon').css("display") === 'block') {
        $(document).unbind('mousewheel');
        $('.list img').css({
            display: 'block',
        });
        $('.list .img_icon').css({
            display: 'none',
        });
        $('.list a').css({
            animation: 'move1 1s',
        });

        oCover_white.animate({
            top: '-20%',
        }, 500);
        setTimeout(function () {
            oCover_white.remove();
        }, 500);
        oCover_w_b.animate({
            bottom: '-80%',
        }, 500);
        setTimeout(function () {
            oCover_w_b.remove();
        }, 500);
    } else if ($('.list .img_icon2').css("display") === 'block') {
        $('.list a').css({
            animation: 'move2 1s',
        });
        search_s_div.css({
            bottom: '-100%',
        });
        $('.list .img_icon').css({
            display: 'block',
        });
        $('.list .img_icon1').css({
            display: 'none',
        });
        $('.list .img_icon2').css({
            display: 'none',
        });
    } else if ($('.list .img_icon1').css("display") === 'block') {
        $('.list a').css({
            animation: 'move3 1s',
        });
        login_s_div.css({
            right: '-100%',
        }, 500);
        $('.list .img_icon').css({
            display: 'block',
        });
        $('.list .img_icon1').css({
            display: 'none',
        });
    }

    $('.search_a').on('click', function () {
        search_s_div.css({
            bottom: 0,
        }, 500);
        login_s_div.css({
            right: '-100%',
        }, 500);
        $('.list .img_icon').css({
            display: 'none',
        });
        $('.list .img_icon1').css({
            display: 'none',
        });
        $('.list .img_icon2').css({
            display: 'block',
        });
    });
    $('.login_c_btn').on('click', function () {
        login_s_div.css({
            right: 0,
        }, 500);
        $('.list .img_icon').css({
            display: 'none',
        });
        $('.list .img_icon1').css({
            display: 'block',
        });
    });
    $('.special_search').on('click', getEle_fn);
    $(window).resize(function () {
        $('.list img').css({
            display: 'block',
        });
        $('.list .img_icon').css({
            display: 'none',
        });
        $('.list a').css({
            animation: 'move1 1s',
        });

        oCover_white.animate({
            top: '-20%',
        }, 500)
        setTimeout(function () {
            oCover_white.remove();
        }, 500);
        oCover_w_b.animate({
            bottom: '-80%',
        }, 500)
        setTimeout(function () {
            oCover_w_b.remove();
        }, 500);
    });
    $('.login_img_new').on('click', JQ_fn);
    $('#qr_code_new').empty();
    $('#qr_code_new').qrcode({
        width: 120,
        height: 120,
        text: "http://weixin.qq.com/r/r0x4YOjEWrUlrawD9xm9"
    });
});

//判断是否已经登录
$.ajax({
    url:"isLogin",
    type:"get",
    success:function(data){
        if (data != ""){
            //执行登录成功方法
            // loginSuccess(data);
            console.log("已经登陆成功~");
            console.log(data);
            loginSuccess(data);
        }else{
            console.log("还未登录")
        }
    },error:function(){
        //无视
    }
});

//登录
// $(".login-button").click(function (){
//     var mail = $("input[name='user[email]']").val();
//     var pass = $("input[name='user[password]']").val();
//     alert(mail + "  " + pass);
//     $.ajax({
//         url:"/login",
//         type:"post",
//         dataType:"json",
//         contentType:"application/x-www-form-urlencoded;charset=UTF-8",
//         data:{"username":mail,"password":pass},
//         success:function (data) {
//             alert(data);
//         },error:function (data) {
//             console.log("登陆出错")
//         }
//     })
// });

//登陆成功后执行的方法
function loginSuccess(data) {
    //用户名显示
    $(".login a:eq(1)").text(data.nickname);
    //头像显示
    if (data.headimage != null){
        $(".login_img").children("img").attr("src","http://p6yz4djye.bkt.clouddn.com/"+data.headimage);
    }
    //登陆成功后 清空 点击 出现 登陆框的方法。改为跳转到个人信息
    $btn_login.off("click");
    $btn_login.on("click",function () {
        $(".login_img").attr("href","/userCenter.html")
    })
    //不同页面特殊的显示情况
    var isCenter = window.location.href;  //获取当前地址后缀
    var str = isCenter.lastIndexOf("\/");
    isCenter = isCenter.substring(str+1,isCenter.length);
    if (isCenter == "userCenter.html"){
        $(".name_user").text(data.nickname);
        $("#center-showNickname").attr("value",data.nickname);
        $("#center-showUsername").attr("value",data.username);
        $("#input_t").text(data.personality);
        $(".z_t").children("img").attr("src","http://p6yz4djye.bkt.clouddn.com/"+data.headimage);
    }
    if (isCenter == "" || isCenter == "index.html"){
        $(".article_middle").children(".login_img").text(data.nickname);
        $(".article_middle").children("p").text("你的开脑洞好奇心还不够哦")
    }
}
//注销后执行的方法
function logout() {
    //用户名清空
    $(".login a:eq(1)").text("登陆");
    //头像清空
    $(".login_img").children("img").attr("src","http://p5w1f51o8.bkt.clouddn.com/login.png");
    //清空跳转个人中心方法，改为显示登陆框
    $btn_login.off("click");
    $btn_login.on("click",function () {
        JQ_fn();
    })
}