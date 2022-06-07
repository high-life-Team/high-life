//아이디 찾기
$(document).on('click', '.idfind_btn ', (function () {
 

 $('#member_id').val("");
 $('#password').val("");
 $("#modal_login").hide();
 
 $("#modal_idfind_login").show();

}));

//아이디 찾기 취소
$(document).on('click', '#modal_idfind_login_close_btn', (function () {
	
	 //취소버튼 클릭시 내용 지우기
	 $('#member_id').val("");
	 $('#password').val("");
	 $('#nickname').val("");
	 $('#email').val("");
 
 $("#modal_idfind_login").hide();
 $("#modal_idfindresult").hide();
 	
}));


	
//아이디 찾기 결과
$(document).on('click', '#login_idfind_button', (function() {
	console.log("닉네임 : " + $("#nickname").val());
	console.log("이메일 : " + $("#email").val());
	
	
$.ajax({
      
    type : "post",
    url : "/idfind",
    dataType : "text",
    data : {nickname : $("#nickname_nickname").val(), email : $("#email_email").val()},
    error : function(){},
    success : function(result){
	
	     if(result==""){
         $("#modal_idfindresult").show();
         $("#idfindresult_font").html('회원정보를 확인해 주세요.');
         $("#idfindresult_font").css('color', 'black');
         $("#idfindresult_font").css('font-size', '30px');
         }
         
         else{
         $("#modal_idfind_login").hide();
         $('#email_email').val("");
         
         $("#modal_idfindresult").show();
         $("#idfindresult_font").html('아이디는 ' + result +  ' 입니다.');
         $("#idfindresult_font").css('color', 'black');
         $("#idfindresult_font").css('font-size', '30px');
         }
         
         },
         error: function(e) {
            alert("회원 정보를 다시 입력해주세요");
            console.log(e);
         }
      }); //ajax end
   }));
/* 아이디 찾기 END */