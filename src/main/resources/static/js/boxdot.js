// 글 박스에서 내용이 길 경우 ... 으로  표시 
$(".list_box_title").each(function () {
    const length = 30;
        $(this).each(function () {
        if ($(this).text().length >= length) {
        $(this).text($(this).text().substr(0, length) + "...")
        }
    });
});

$(".list_box_content").each(function () {
    const length = 50;
    $(this).each(function () {
        if ($(this).text().length >= length) {
            $(this).text($(this).text().substr(0, length) + "...")
        }
    });
});