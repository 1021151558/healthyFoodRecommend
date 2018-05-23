var ds = document.getElementById("collectionPages").getElementsByTagName("a");

for (var s = 0; s < ds.length; s++) {
    ds[s].onclick = function () {
        for (var k = 0; k < ds.length; k++) {
            if (ds[k] == this) {
                var num = 0;
                var nowPage = parseInt($("#collectionNowPage").text()) - 1;
                var totalPages = $("#collectionAllPages").text();
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
                    url: "/user/myCollection?pageNum="+num+"&nicheng="+$("#userNicheng").text(),
                    dataType: "json",
                    success: function (data) {
                        var tt = $("#collectionFood");
                        tt.html("");
                        $(data.content).each(function (index, food) {
                            var row = "<div class='img'>" + "<a target='_blank' href='/user/foodMethod?foodId=" +food.id+ "'><img src='" + food.foodIcon + "'/></a>"
                                + "<span class='foodWork'>" + food.foodWork + "</span>"
                                + "<span class='foodName'>" + food.foodName + "</span><br>"
                                + "<span class='foodPopularity'>" + food.foodPopularity + "</span><br>"
                                + "<input type='button' class='foodCollection' value='已收藏' name='" + food.id + "'/> "
                                + "</div>";
                            tt.append(row);

                        });
                        var nowPage = $("#collectionNowPage");
                        nowPage.text(data.number + 1);
                        var totalPages = $("#collectionAllPages");
                        totalPages.text(data.totalPages);
                    }
                });
            }
        }
    }
}