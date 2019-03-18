$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/hotel/list?id="+getUrlParam("id"),
        dataType: "json", // 指定返回类型
        success: function (data) {
            var hptellist = data[1],spotell = data[0];
            var likestr = "",spli="";
            console.log(hptellist);
            console.log(spotell);
            $.each(spotell, function (index) {
                if(getUrlParam("id")==(index+1)){
                    spli=spli+"<a href='hotellist.html?id="+spotell[index].id+"' class='list-group-item active'>"+spotell[index].spots+"</a>";
                }else {
                    spli=spli+"<a href='hotellist.html?id="+spotell[index].id+"' class='list-group-item'>"+spotell[index].spots+"</a>";
                }
            });
            $("#js-spotslist").append(spli);

            $.each(hptellist, function (index) {
                likestr = likestr +"<div class='col-lg-4 col-md-6 mb-4'>"+
                    "<div class='card h-100'>"+
                "<a href='#'><img src='"+hptellist[index].image+"/1.jpg' class='img-thumbnail' alt='Cinque Terre' width='700' height='400'></a>"+
                "<div class='card-body'>"+
                "<h4 class='card-title'>"+
                "<a href='hotelcomment.html?id="+hptellist[index].id+"'>"+hptellist[index].hotel+"</a>"+
                "</h4>"+
                "<h5>"+hptellist[index].money+"￥</h5>"+
                "<p class='card-text'>"+hptellist[index].content+"</p>"+
                "</div>"+
                "<div class='card-footer'>"+
                "<small class='text-muted'>&#9733; &#9733; &#9733; &#9733; &#9734;</small>"+
                "</div>"+
                "</div>"+
                "</div>"
            });
            $("#js-hotellist").append(likestr);

        },
        error: function () {
            alert("系统出现问题");
        }
    });

});