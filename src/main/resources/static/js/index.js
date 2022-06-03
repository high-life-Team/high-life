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

$(".main_scroll").click(function(event){            
        event.preventDefault();
        $('html,body').animate({scrollTop:$(this.hash).offset().top}, 1200);
});

var textWrapper = document.querySelector('.main_title');
textWrapper.innerHTML = textWrapper.textContent.replace(/\S/g, "<span class='letter'>$&</span>");

anime.timeline({loop: true})
  .add({
    targets: '.main_title .letter',
    opacity: [0,1],
    easing: "easeInOutQuad",
    duration: 2250,
    delay: (el, i) => 150 * (i+1)
  }).add({
    targets: '.main_title',
    opacity: 0,
    duration: 1000,
    easing: "easeOutExpo",
    delay: 1000
  });

  
  var textWrapper = document.querySelector('.sub_title');
textWrapper.innerHTML = textWrapper.textContent.replace(/\S/g, "<span class='letter'>$&</span>");

anime.timeline({loop: true})
  .add({
    targets: '.sub_title .letter',
    opacity: [0,1],
    easing: "easeInOutQuad",
    duration: 2250,
    delay: (el, i) => 150 * (i+1)
  }).add({
    targets: '.sub_title',
    opacity: 0,
    duration: 1000,
    easing: "easeOutExpo",
    delay: 1000
  });




