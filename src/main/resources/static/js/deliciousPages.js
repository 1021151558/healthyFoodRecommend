var ms = document.getElementById("deliciousPages").getElementsByTagName("a");

for (var s = 0; s < ms.length ; s++) {
    ms[s].onclick = function () {
        for (var k = 0; k < ms.length; k++) {
            if (ms[k] == this) {
                var num = 0;
                var nowPage = parseInt($("#deliciousNowPage").text()) - 1;
                var totalPages = $("#deliciousAllPages").text();
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

                $.ajax({
                    type: "POST",
                    url: "/user/tuijian?bmi=" + $("#bmi").val() + "&wish=" + $("#select").val() + "&pageNum=" + num,
                    dataType: "json",
                    success: function (data) {
                        var tt = $("#deliciousFood");
                        tt.html("");
                        $(data.content).each(function (index, food) {
                            var row = "<div class='img'>" + "<a target='_blank' href='/user/foodMethod?foodId=" +food.id+ "'><img src='" + food.foodIcon + "'/></a>"
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
                        var nowPage = $("#deliciousNowPage");
                        nowPage.text(data.number + 1);
                        var totalPages = $("#deliciousAllPages");
                        totalPages.text(data.totalPages);
                    }
                });
            }
        }
    }
}