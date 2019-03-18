
$(document).ready(function () {
    //登陆获取token
    $("#js-go").click(function () {
        var username = $("#js-username").val();
        var pass = $("#js-password").val();
        pass = md5(pass);
        var uscontent = {"username": username, "password":pass };
        console.log(uscontent);
        $.ajax({
            type: "POST",
            url: "/user/login",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(uscontent),
            dataType: "json", // 指定返回类型
            success: function (data) {
                if(data.statusCode==="000000"){
                    setCookie("Authorization", data.result.token.accessToken, 1);
                    window.location.href="/";
                }else {
                    alert("用户密码错误/用户不存在");
                }
            },
            error: function () {
                alert("系统出现问题");
            }
        });
    });
    //注册获取token
    $("#js-rgo").click(function () {
        var username = $("#js-rusername").val();
        var netname = $("#js-rnetname").val();
        var pass = $("#js-rpassword").val();
        var uscontent = {"username": username,"netname":netname, "password": md5(pass)};
        console.log(uscontent);
        $.ajax({
            type: "POST",
            url: "/user/register",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(uscontent),
            dataType: "json", // 指定返回类型
            success: function (data) {
                if(data.statusCode==="000001"){
                    setCookie("Authorization", data.result.token.accessToken, 1);
                    window.location.href="/";
                }else {
                    alert("账号/用户名重复")
                }

            },
            error: function () {
                alert("系统出现问题");
            }
        });
    });
//设置cookic
    function setCookie(cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
        var expires = "expires=" + d.toGMTString();
        document.cookie = cname + "=" + cvalue + "; " + expires;
    }

});