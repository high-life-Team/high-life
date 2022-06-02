$(".box_title").each(function () {
    const length = 30;
        $(this).each(function () {
        if ($(this).text().length >= length) {
        $(this).text($(this).text().substr(0, length) + "...")
        }
    });
});

$(".box_content").each(function () {
    const length = 100;
    $(this).each(function () {
        if ($(this).text().length >= length) {
            $(this).text($(this).text().substr(0, length) + "...")
        }
    });
});
