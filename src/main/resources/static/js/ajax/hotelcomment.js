$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/hotel/Info?id="+getUrlParam("id"),
        dataType: "json", // 指定返回类型
        success: function (data) {
            var spotell = data[0],hotel = data[1],comlist = data[2];
            var likestr = "",spli="";

            console.log(spotell);
            console.log(hotel);
            console.log(comlist);
            $.each(spotell, function (index) {
                if(hotel.spotsId==(index+1)){
                    spli=spli+"<a href='hotellist.html?id="+spotell[index].id+"' class='list-group-item active'>"+spotell[index].spots+"</a>";
                }else {
                    spli=spli+"<a href='hotellist.html?id="+spotell[index].id+"' class='list-group-item'>"+spotell[index].spots+"</a>";
                }
            });
            $("#js-spotslist").append(spli);

            $("#js-himage").attr('src',hotel.image+"/1.jpg");
            $("#js-hotel").text(hotel.hotel);
            $("#js-money").text(hotel.money);
            $("#js-content").text(hotel.content);
            $("#js-createtime").text(hotel.createtime);


            $.each(comlist, function (index) {
                likestr = likestr +"<p>"+comlist[index].content+"</p>" +
                    "<small class='text-muted'>"+comlist[index].userName+" "+comlist[index].createTime+"</small>" +
                    "<hr>";
            });
            $("#js-comlist").prepend(likestr);

        },
        error: function () {
            alert("系统出现问题");
        }
    });
});