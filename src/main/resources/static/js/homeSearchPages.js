var ts = document.getElementById("homeSearchPages").getElementsByTagName("a");

for (var s = 0; s < ts.length; s++) {
    ts[s].onclick = function () {
        for (var k = 0; k < ts.length; k++) {
            if (ts[k] == this) {
                var num = 0;
                var nowPage = parseInt($("#homeSearchNowPage").text()) - 1;
                var totalPages = $("#homeSearchAllPages").text();
                if (k == 0) {
                    num = 0;
                } else if (k == 1) {
                    if (nowPage == 0) {
                        num = 0;
                    } else {
                        num = nowPage - 1;
                    }
                } else if (k == 2) {
                    if (nowPage == totalPages - 1) {
                        num = totalPages - 1;
                    } else
                        num = nowPage + 1;
                } else {
                    num = totalPages - 1;
                }
                var search = $("#foodSearch").val();
                $.ajax({
                    type: "POST",
                    url: "/user/foodSearch?name="+search+"&pageNum="+num,
                    dataType: "json",
                    success: function (data) {
                        var tt = $("#homeSearch");
                        tt.html("");
                        $(data.content).each(function (index, food) {
                            var row ="<div class='img'>" + "<a target='_blank' href='/user/foodMethod?foodId=" +food.id+ "'><img src='" + food.foodIcon + "'/></a>"
                                + "<span class='foodWork'>" + food.foodWork + "</span>"
                                + "<span class='foodName'>" + food.foodName + "</span><br>"
                                + "<span class='foodPopularity'>" + food.foodPopularity + "</span><br>"
                                + "<input type='button' class='foodCollection' value='点击收藏' name='" + food.id + "'/> "
                                + "</div>";
                            tt.append(row);

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
        }
    }
}