let type; //신고하기 버튼 타입 글 or 댓글 구분
let reportnum; //신고하는 게시글 or 댓글 번호
let reportid; //게시글 조회하는 회원 아이디 , 비로그인이면 ''
let reportpostid; //게시글 작성한 아이디
let etc = $('#reportTxt'); //기타 값이 들어갈 곳
console.log("reportTxt.js실행중");



//신고하기 버튼 클릭 이벤트
$(document).on('click', '.report_btn button', (function () {
 reportid = $('#member_id').val();
 console.log("신고하기 클릭 이벤")
 //로그인 여부 확인
 if(reportid == null || reportid == ''){
   $("#modal_logincheck").show();
   return;
 }

 //게시글인지 댓글인지 확인 후 글번호/댓글번호 받아오기
 type = $(this).attr('class');
 let str =  $(this).attr('id');
 if(type == "reportpostbtn"){
   //게시글 신고
   reportnum = str.substring(5);
 }
 else{
   //댓글 신고
   reportnum = str.substring(8);
 }
 
 $("#modal_report").show();

})); //신고하기 버튼 이벤트 end

//신고 사유 textarea 글자 수 제한
$(document).on('keyup', '#reportTxt', function() {
     $('#reportTxt_count').html("("+$(this).val().length+" / 100)");

     if($(this).val().length > 100) {
         $(this).val($(this).val().substring(0, 100));
         $('#reportTxt_count').html("(100 / 100)");
     }
 });
//radio 9번 클릭시 textarea 활성화
$(document).on('click', 'input[name="report"]', (function(){
 if($(this).val() == "기타"){				
    	$('#reportTxt').attr('readonly', false);
 }
 else{
	  $('#reportTxt').attr('readonly', true);
   $('#reportTxt').val("");
 }			
}));

//신고 취소 버튼
$(document).on('click', '#modal_report_close_btn', (function () {
 $("#modal_report").hide();
 //radio, textarea 초기화
 $('#reportTxt').val("");
 $('#reportTxt_count').html("(0 / 100)");
 $('input[value="1"]').prop('checked', true);				
}));

//신고 확인 버튼
$(document).on('click', '#modal_report_ok_btn', (function () {
 let radioval =  $('input[name="reportTxt"]:checked').val();
 let reason = "";
 if(radioval == etc){
   reason = "기타 : " + $('#reportTxt').val();	
   model.addAttribute("reason", reason); // [key, value]
 }
 else{
   reason = $("label[for='radio"+radioval+"']").text();
   model.addAttribute("reason", reason); // [key, value]
 }
 
 //신고하기 insert ajax
 //게시글 신고인 경우
 if(type == "reportpostbtn"){
   $.ajax({
     url: "/postreport",
     data: { 'reportid': reportid,
         'reason': reason,
         'postnum' : reportnum},
     type: 'post',
     dataType: 'json',
     success: function (result) {
       $("#modal_report").hide();	

       if(result == 0){
         alert("게시글 신고 실패 다시 시도해주세요");
       }
       
       //radio, textarea 초기화
       $('#reportTxt').val("");
       $('#reportTxt_count').html("(0 / 100)");
       $('input[value="1"]').prop('checked', true);
     }
   });
 }
 //댓글 신고인 경우
 else{
   $.ajax({
     url: "/commentreport",
     data: { 'reportid': reportid,
         'reason': reason,
         'commentnum' : reportnum
       },
     type: 'post',
     async: false,
     dataType: 'json',
     success: function (result) {
       $("#modal_report").hide();	

       if(result == 0){
         alert("댓글 신고 실패 다시 시도해주세요");
       }						
           
       //radio, textarea 초기화
       $('#reportTxt').val("");
       $('#reportTxt_count').html("(0 / 100)");
       $('input[value="1"]').prop('checked', true);
     }
   });	
 }			
})); //신고 확인 버튼 이벤트 end	
