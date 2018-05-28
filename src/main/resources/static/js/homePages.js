function homePages() {
    $.ajax({
        type: "POST",
        url: "/user/homePage?pageNum=0",
        dataType: "json",
        success: function (data) {
            var home = $("#home");
            home.html("");
            $(data.content).each(function (index, food) {
                var row = "<div class='img'>" + "<a target='_blank' href='/user/changshi?foodId=" + food.id + "'><img src='" + food.icon + "'/></a>"
                    + "<span class='foodName'>" + food.title + "</span><br>"
                    + "<span class='foodPopularity'>" + food.popularity + "</span><br>"
                    + "</div>";
                home.append(row);
            });

            var nowPage = $("#homeNowPage");
            nowPage.text(data.number + 1);
            var totalPages = $("#homeAllPages");
            totalPages.text(data.totalPages);
        }
    })
}


var ps = document.getElementById("homePages").getElementsByTagName("a");

for (var s = 0; s < ps.length; s++) {
    ps[s].onclick = function () {
        for (var k = 0; k < ps.length ; k++) {
            if (ps[k] == this) {
                var num = 0;
                var nowPage = parseInt($("#homeNowPage").text()) - 1;
                var totalPages = $("#homeAllPages").text();
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
                    url: "/user/homePage?pageNum=" + num,
                    dataType: "json",
                    success: function (data) {
                        var tt = $("#home");
                        tt.html("");
                        $(data.content).each(function (index, food) {
                            var row = "<div class='img'>" + "<a target='_blank' href='/user/changshi?foodId=" + food.id + "'><img src='" + food.icon + "'/></a>"
                                + "<span class='foodName'>" + food.title + "</span><br>"
                                + "<span class='foodPopularity'>" + food.popularity + "</span><br>"
                                + "</div>";
                            tt.append(row);

                        });
                        var nowPage = $("#homeNowPage");
                        nowPage.text(data.number + 1);
                        var totalPages = $("#homeAllPages");
                        totalPages.text(data.totalPages);
                    }
                });
            }
        }
    }
}