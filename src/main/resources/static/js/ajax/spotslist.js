$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/spots/list",
        dataType: "json", // 指定返回类型
        success: function (data) {
            var likestr = "";
            $.each(data, function (index) {
                likestr = likestr +"<div class='card mb-4'>"+
                    "<div class='card-img-top'><img  src='"+data[index].image+"/2.jpg' alt='Card image cap'style='width: 100%; height: 80%'></div>"+

                    "<div class='card-body'>"+
                    "<h2 class='card-title'>"+data[index].spots+"</h2>"+
                    "<p class='card-text'>"+data[index].content+"</p>"+
                "<a href='view.html?id="+data[index].id+"' class='btn btn-primary'>更多 &rarr;</a>"+
                "</div>"+
                "<div class='card-footer text-muted'>"+data[index].createtime+"</div>"+
                "</div>"
            });
            $("#js-list").append(likestr);
    },
    error: function () {
        alert("系统出现问题");
    }
});

});