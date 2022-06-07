$(document).on('click', '.pwfind_btn ', (function () {

 

 $('#member_id').val("");
 $('#password').val("");
 $("#modal_login").hide();
 
 $("#modal_pwfind_login").show();


}));




//신고 취소 버튼
$(document).on('click', '#modal_pwfind_login_close_btn', (function () {
	
	 //취소버튼 클릭시 내용 지우기
	 $('#member_id_member_id_pwfind').val("");
	 $('#nickname_nickname_pwfind').val("");
	 $('#email_email_pwfind').val("");
 
 $("#modal_pwfind_login").hide();
 $("#modal_pwfindresult").hide(); //결과창
 

}));

//비밀번호 찾기 결과
$(document).on('click', '#login_pwfind_button', (function() {
	
	
	
$.ajax({
      
    type : "post",
    url : "/pwfind",
    dataType : "text",
    data : {member_id : $("#member_id_pwfind").val(), email : $("#email_email_pwfind").val(), nickname : $("#nickname_nickname_pwfind").val() },
    error : function(){},
    success : function(result){
	
	     if(result==""){
         $("#modal_pwfindresult").show();
         $("#pwfindresult_font").html('회원정보를 확인해 주세요.');
         $("#pwfindresult_font").css('color', 'black');
         $("#pwfindresult_font").css('font-size', '30px');
         }
         
         else{
         $("#modal_pwfind_login").hide();
         $('#email_email_pwfind').val("");
         
         $("#modal_pwfindresult").show();
         $("#pwfindresult_font").html('비밀번호는 ' + result +  ' 입니다.');
         $("#pwfindresult_font").css('color', 'black');
         $("#pwfindresult_font").css('font-size', '30px');
         }
         
         },
         error: function(e) {
            alert("회원 정보를 다시 입력해주세요");
            console.log(e);
         }
      }); //ajax end
   })); 
 		


