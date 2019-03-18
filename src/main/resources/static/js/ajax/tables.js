$(document).ready(function () {
    var token = getCookie("Authorization");

        $.ajax({
            type: "GET",
            url: "/user/usercomment",
            headers: {
                'Authorization':token
            },
            dataType: "json", // 指定返回类型
            success: function (data) {
                var likestr = "";
                $.each(data, function (index) {
                    likestr+="<tr>" +
                        "<td>"+data[index].id+"</td>" +
                        "<td>"+data[index].content+"</td>" +
                        "<td>"+data[index].spotes+"</td>" +
                        "</tr>";
                });
                $("#js-comment").append(likestr);
            },
            error: function () {
                window.location.href="/";
                setCookie("Authorization", '', -1);
            }
        });

});