$(document).ready(function () {
    var token = getCookie("Authorization");

        $.ajax({
            type: "GET",
            url: "/user/usertokeninfo",
            headers: {
                'Authorization':token
            },
            dataType: "json", // 指定返回类型
            success: function (data) {
                console.log(data);
                $("#js-user").text(data.userName);
                $("#js-netName").text(data.netname);
                $("#js-sex").text(data.sex);
                $("#js-email").text(data.email);
                $("#js-phone").text(data.phone);
                $("#js-cTime").text(data.createtime);
            },
            error: function () {
                window.location.href="/";
                setCookie("Authorization", '', -1);
            }
        });

    $("#js-bt").click(function(){
        var sex=$("#js-ssex").val();
        var email = $("#js-semail").val();
        var phone = $("#js-sphone").val();
        var uscontent = {"email": email, "phone":phone , "sex":sex};
        $.ajax({
            type: "POST",
            url: "/user/modify",
            contentType: "application/json; charset=utf-8",
            headers: {
                'Authorization':token
            },
            data: JSON.stringify(uscontent),
            dataType: "json", // 指定返回类型
            success: function (data) {
                if(data.statusCode==="000003"){
                    setCookie("Authorization", data.result.token.accessToken, 1);
                    window.location.href="/person.html";
                }else {
                    alert("修改失败")
                }
            },
            error: function () {
                alert("系统出现问题");
            }
        });
    })


    function setCookie(cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
        var expires = "expires=" + d.toGMTString();
        document.cookie = cname + "=" + cvalue + "; " + expires;
    }
});