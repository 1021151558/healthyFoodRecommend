var pli = document.getElementById("typeOfPerson").getElementsByTagName("li");

var pList = new Array("yunfu", "changfu", "youer", "xuelingqi", "qingshaonian", "laoren", "gaowen", "diwen", "fushe","dusu","yundongyuan");

for (var i = 0; i < pli.length; i++) {

    pli[i].onclick = function () {

        for (var j = 0; j < pli.length; j++) {
            if (pli[j] == this) {
                $("#personNowName").text(pList[j]);
                $("#personNowName").hide();
                $.ajax({
                    type: "POST",
                    url: "/user/meirong?pageNum=0&foodTable=" + pList[j],
                    dataType: "json",
                    success: function (data) {
                        var tt = $("#person");
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

                        var nowPage = $("#personNowPage");
                        nowPage.text(data.number + 1);
                        var totalPages = $("#personAllPages");
                        totalPages.text(data.totalPages);
                    }
                });

            }
        }
    }
}

var pds = document.getElementById("personPages").getElementsByTagName("a");

for (var s = 0; s < pds.length; s++) {
    pds[s].onclick = function () {
        for (var k = 0; k < pds.length ; k++) {
            if (pds[k] == this) {
                var num = 0;
                var nowPage = parseInt($("#personNowPage").text()) - 1;
                // console.log("nowPage:" + nowPage);
                var totalPages = $("#personAllPages").text();
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
                    url: "/user/meirong?pageNum=" + num + "&foodTable=" + $("#personNowName").text(),
                    dataType: "json",
                    success: function (data) {
                        var tt = $("#person");
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
                        var nowPage = $("#personNowPage");
                        nowPage.text(data.number + 1);
                        var totalPages = $("#personAllPages");
                        totalPages.text(data.totalPages);
                    }
                });
            }
        }
    }
}