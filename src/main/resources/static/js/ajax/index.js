$(document).ready(function () {
    var a = getCookie("Authorization");
    if (a != "") {
        $("#js-loginbut").remove();
    }
    $.ajax({
        type: "GET",
        url: "/spots/list",
        dataType: "json", // 指定返回类型
        success: function (data) {
            var likestr = "";
            $.each(data, function (index, n) {
                likestr = likestr +"<div class='col-lg-3 col-md-6 mb-4'>"+
                    "<div class='card'>"+
                    "<img src='"+data[index].image+"/1.jpg' class='img-thumbnail' alt='Cinque Terre' style='width: 100%; height: 200px'>"+
                "<div class='card-body'>"+
                "<h4 class='card-title'>"+data[index].spots+"</h4>"+
                "<p class='card-text'>"+data[index].content+"</p>"+
                "</div>"+
                "<div class='card-footer'>"+
                "<a href='view.html?id="+data[index].id+"' class='btn btn-primary'>查看更多</a>"+
                "</div>"+
                "</div>"+
                "</div>"
            });
            $("#js-center").append(likestr);

        },
        error: function () {
            alert("系统出现问题");
        }
    });

});