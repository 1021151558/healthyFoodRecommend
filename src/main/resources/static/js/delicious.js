function delicious() {
    var h = $("#height").val();
    var w = $("#weight").val();
    var bmi = w / (h * h);
    var healthy = $("#healthy");
    $("#bmi").val(bmi);
    if (bmi < 18.5) {
        healthy.text("过轻");
    } else if (bmi <= 23.9) {
        healthy.text("正常");
    } else if (bmi <= 27.9) {
        healthy.text("过重");
    } else if (bmi <= 32) {
        healthy.text("肥胖");
    } else {
        healthy.text("非常肥胖");
    }
    $.ajax({
        type: "POST",
        url: "/user/tuijian?bmi=" + bmi + "&wish=" + $("#select").val() + "&pageNum=0",
        dataType: "json",
        success: function (data) {
            var deliciousFood = $("#deliciousFood");
            deliciousFood.html("");
            $(data.content).each(function (index, food) {
                var row = "<div class='img'>" + "<a target='_blank' href='/user/foodMethod?foodId=" +food.id+ "'><img src='" + food.foodIcon + "'/></a>"
                    + "<span class='foodWork'>" + food.foodWork + "</span>"
                    + "<span class='foodName'>" + food.foodName + "</span><br>"
                    + "<span class='foodPopularity'>" + food.foodPopularity + "</span><br>"
                    + "<input type='button' class='foodCollection' value='点击收藏' name='" + food.id + "'/> "
                    + "</div>";
                deliciousFood.append(row);
            });
            $(".foodCollection").click(function () {
                var id = $(this).attr("name");
                var nicheng = $("#userNicheng").text();
                if ($(this).val() == "点击收藏") {
                    $.ajax({
                        type: "POST",
                        url: "/user/saveFood?foodId=" + id+"&nicheng="+nicheng,
                        dataType: "json",
                        success: function (data) {

                        }
                    });
                    $(this).val("已收藏");
                }
            });

            var nowPage = $("#deliciousNowPage");
            nowPage.text(data.number + 1);
            var totalPages = $("#deliciousAllPages");
            totalPages.text(data.totalPages);
        }
    })
}