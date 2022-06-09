//writeform modal
$(document).on('click', '.writeform_btn ', (function () {
 $("#modal_writeform").show();
}));

//writeform modal
$(document).on('click', '#modal_writeform_close_btn', (function () {
$("#modal_writeform").hide();
}));


	
//이미지 노출

 var fileInput  = document.querySelector( "#id_photo" ),
     button     = document.querySelector( ".input-file-trigger" ),
     the_return = document.querySelector(".file-return");

       // Show image
       fileInput.addEventListener('change', handleImage, false);
       var canvas = document.getElementById('image_canvas');
       var ctx = canvas.getContext('2d');


        function handleImage(e){
           var reader = new FileReader();
           reader.onload = function(event){
               var img = new Image();
               // var imgWidth =
               img.onload = function(){
                   canvas.width = 300;
                   canvas.height = 300;
                   ctx.drawImage(img,0,0,300,300);
               };
               img.src = event.target.result;
               // img.width = img.width*0.5
               // canvas.height = img.height;
           };
           reader.readAsDataURL(e.target.files[0]);
       }
       

 //글쓰기 글자수 제한
   $(document).ready(function() {
        $('#content').on('keyup', function() {
            $('#test_cnt_2').html("("+$(this).val().length+" / 500)");
 
            if($(this).val().length > 500) {
                $(this).val($(this).val().substring(0, 500));
                $('#test_cnt_2').html("(500 / 500)");
            }
        });
    });