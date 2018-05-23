function foodSearch() {
    var search = $("#foodSearch").val();
    $("#forSearch").show();
    $("#homePage").hide();
    $("#delicious").hide();
    $("#myMenu").hide();
    $("#dietitian").hide();
    $("#shuoshuo").hide();
    $("#myCollection").hide();
    $.ajax({
        type: "POST",
        url: "/user/foodSearch?name="+search+"&pageNum=0",
        dataType: "json",
        success: function (data) {
            var homeSearch = $("#homeSearch");
            homeSearch.html("");
            $(data.content).each(function (index, food) {
                var row = "<div class='img'>" + "<a target='_blank' href='/user/foodMethod?foodId=" +food.id+ "'><img src='" + food.foodIcon + "'/></a>"
                    + "<span class='foodWork'>" + food.foodWork + "</span>"
                    + "<span class='foodName'>" + food.foodName + "</span><br>"
                    + "<span class='foodPopularity'>" + food.foodPopularity + "</span><br>"
                    + "<input type='button' class='foodCollection' value='点击收藏' name='" + food.id + "'/> "
                    + "</div>";
                homeSearch.append(row);
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

            var nowPage = $("#homeSearchNowPage");
            nowPage.text(data.number + 1);
            var totalPages = $("#homeSearchAllPages");
            totalPages.text(data.totalPages);
        }
    });
}