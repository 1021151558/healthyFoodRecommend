var ali = document.getElementById("liebiao").getElementsByTagName("li");

var idList = new Array("homePage", "delicious", "peopleType", "myMenu", "dietitian", "shuoshuo", "myCollection");



for (var i = 0; i < ali.length; i++) {

    ali[i].onclick = function () {
        $("#forSearch").hide();
        for (var j = 0; j < ali.length; j++) {
            document.getElementById(idList[j]).style.display = "none";
            if (ali[j] == this) {
                document.getElementById(idList[j]).style.display = "block";


                if (idList[j] == "peopleType") {
                    $.ajax({
                        type: "POST",
                        url: "/user/meirong?pageNum=0&foodTable=" + pList[0],
                        dataType: "json",
                        success: function (data) {
                            var tt = $("#person");
                            tt.html("");
                            $("#personNowName").text(pList[0]);
                            $("#personNowName").hide();
                            $(data.content).each(function (index, food) {
                                var row = "<div class='img'>" + "<a target='_blank' href='/user/foodMethod?foodId=" + food.id + "'><img src='" + food.foodIcon + "'/></a>"
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
                                        url: "/user/saveFood?foodId=" + id + "&nicheng=" + nicheng,
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


                if (idList[j] == "myMenu") {
                    $.ajax({
                        type: "POST",
                        url: "/user/meirong?pageNum=0&foodTable=" + iList[0],
                        dataType: "json",
                        success: function (data) {
                            var tt = $("#meirong1");
                            tt.html("");
                            $("#nowName").text(iList[0]);
                            $("#nowName").hide();
                            $(data.content).each(function (index, food) {
                                var row = "<div class='img'>" + "<a target='_blank' href='/user/foodMethod?foodId=" + food.id + "'><img src='" + food.foodIcon + "'/></a>"
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
                                        url: "/user/saveFood?foodId=" + id + "&nicheng=" + nicheng,
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



                if (idList[j] == "myCollection") {



                    $.ajax({
                        type: "POST",
                        url: "/user/myCollection?pageNum=0&nicheng=" + $("#userNicheng").text(),
                        dataType: "json",
                        success: function (data) {
                            refreshCollection(data);

                        }
                    });


                    function refreshCollection(data) {


                        var collectionFood = $("#collectionFood");
                        collectionFood.html("");
                        $(data.content).each(function (index, food) {
                            var row = "<div class='img'>" + "<a target='_blank' href='/user/foodMethod?foodId=" + food.id + "'><img src='" + food.foodIcon + "'/></a>"
                                + "<span class='foodWork'>" + food.foodWork + "</span>"
                                + "<span class='foodName'>" + food.foodName + "</span><br>"
                                + "<span class='foodPopularity'>" + food.foodPopularity + "</span><br>"
                                + "<input type='button' class='foodCollection' value='删除' name='" + food.id + "'/> "
                                + "</div>";
                            collectionFood.append(row);
                        });

                        $(".foodCollection").click(function () {

                            var id = $(this).attr("name");
                            console.log(id);
                            var nicheng = $("#userNicheng").text();
                            if ($(this).val() == "删除") {
                                $.ajax({
                                    type: "POST",
                                    url: "/user/deleteFood?foodId=" + id + "&nicheng=" + nicheng+"&pageNum=0",
                                    dataType: "json",
                                    success: function (data) {
                                        refreshCollection(data);

                                    }
                                });


                            }
                        });

                        var nowPage = $("#collectionNowPage");
                        nowPage.text(data.number + 1);
                        var totalPages = $("#collectionAllPages");
                        totalPages.text(data.totalPages);

                    }

                }


            }
        }
    }
}

