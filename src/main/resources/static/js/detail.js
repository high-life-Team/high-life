//댓글 글자수 제한
   $(document).ready(function() {
        $('#comment_content').on('keyup', function() {
            $('#test_cnt').html("("+$(this).val().length+" / 500)");
 
            if($(this).val().length > 500) {
                $(this).val($(this).val().substring(0, 500));
                $('#test_cnt').html("(500 / 500)");
            }
        });
    });