var uli = document.getElementById("tizhi").getElementsByTagName("li");

var iList = new Array("meirong", "jianfei", "xiaohua", "yangshen", "bushen", "jiedu", "fangshu", "bunao", "yingyang","tangniaobin","gaoxueya");

for (var i = 0; i < uli.length; i++) {

    uli[i].onclick = function () {

        for (var j = 0; j < uli.length; j++) {
            if (uli[j] == this) {
                $("#nowName").text(iList[j]);
                $("#nowName").hide();
                $.ajax({
                    type: "POST",
                    url: "/user/meirong?pageNum=0&foodTable=" + iList[j],
                    dataType: "json",
                    success: function (data) {
                        var tt = $("#meirong1");
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

                        var nowPage = $("#nowPage");
                        nowPage.text(data.number + 1);
                        var totalPages = $("#allPages");
                        totalPages.text(data.totalPages);
                    }
                });

            }
        }
    }
}

var tds = document.getElementById("meirongPages").getElementsByTagName("a");

for (var s = 0; s < tds.length ; s++) {
    tds[s].onclick = function () {
        for (var k = 0; k < tds.length; k++) {
            if (tds[k] == this) {
                var num = 0;
                var nowPage = parseInt($("#nowPage").text()) - 1;
                // console.log("nowPage:" + nowPage);
                var totalPages = $("#allPages").text();
                // console.log("totalPage:" + totalPages);
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
                    url: "/user/meirong?pageNum=" + num + "&foodTable=" + $("#nowName").text(),
                    dataType: "json",
                    success: function (data) {
                        var tt = $("#meirong1");
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
                        var nowPage = $("#nowPage");
                        nowPage.text(data.number + 1);
                        var totalPages = $("#allPages");
                        totalPages.text(data.totalPages);
                    }
                });
            }
        }
    }
}
