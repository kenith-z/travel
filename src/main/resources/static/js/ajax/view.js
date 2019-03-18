$(document).ready(function () {
    var id= getUrlParam("id");
    $.ajax({
        type: "GET",
        url: "/spots/Info?id="+id,
        dataType: "json", // 指定返回类型
        success: function (data) {
            $("#js-spots").text(data[0].spots);
            $("#js-creatatime").text(data[0].createtime);
            $("#js-images").attr('src',data[0].image+"/1.jpg");
            $("#js-spotscenter").html(data[0].content);
            var likestr = "";
            var commentlist = data[1];
            $.each(commentlist, function (index) {
                likestr = likestr +"<div class='media mb-4'>"+
                    "<img class='d-flex mr-3 rounded-circle' src='images/user/"+commentlist[index].fatherId+".jpg' alt='' style='width: 50px;height: 50px'>"+
                    "<div class='media-body'>"+
                    "<h5 class='mt-0' id='js-commentname'>"+commentlist[index].userName+"</h5>"+
                    "<p id='js-comment'>"+commentlist[index].content+"</p>"+
                    "</div>"+
                "</div>"
            });
            $("#js-commentlist").append(likestr);

        },
        error: function () {
            window.location.href="/view.html?id="+id;
        }
    });
    $("#js-butt").click(function () {
        var token = getCookie("Authorization");
        if(token!=""){
            var a = $("#js-cont").val();
            var uscontent = {"content": a, "spotsId":id};
            $.ajax({
                type: "POST",
                url: "/user/setcomment",
                contentType: "application/json; charset=utf-8",
                headers: {
                    'Authorization':token
                },
                data: JSON.stringify(uscontent),
                dataType: "json", // 指定返回类型
                success: function (data) {
                    window.location.href="/view.html?id="+id;
                }
            });
        }else{
            window.location.href="/login.html";
        }
    });
});