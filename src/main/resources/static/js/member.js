var idcheck = 2;
var nicknamecheck = 2;
var pwcheck = 2;
var emailcheck = 2;
var emailcodecheck = 2;
var emailok = 2; 
var email_timer = 2;
var serveremailcheck = "";
var clientemailcheck = "";
var phonecheck = 2;
var birthcheck = 2;
var birthcheck_dd = 2;
var birthcheck_mm = 2;
var birthcheck_yy = 2;
var leaf_year = 2;
var t_year = 2;
var t_month = 2;


$(document).ready(function(){
	
//아이디,이메일 영문,숫자만 입력 가능
$("input[name=id]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
	}
	});

$("input[name=nickname]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^a-zA-Z가-힣ㄱ-ㅎ0-9]/gi,''));
	}
	});

$("input[name=email]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^a-z0-9@.]/gi,''));
	}
	});

$("input[name=phone]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^0-9-]/gi,''));
	}
	});

$("input[name=birth_yy]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^0-9-]/gi,''));
	}
	});

$("input[name=birth_dd]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^0-9-]/gi,''));
	}
	});
//아이디,이메일 영문,숫자만 입력 가능 END



//아이디 중복 체크
$("input[name=id]").keyup(function(){
	let id = $('#id_id').val();
	if(id.length < 5){
		$("#idcheck_font").html('5자 이상의 아이디를 입력해주세요. (영문, 숫자)');
		$("#idcheck_font").css('color', 'gray');
		$("#idcheck_font").css('font-size', '11px');
	}
	else{
	$.ajax({
		url : "/membercheck",
		type : "post",
		data :{'id': id},
		dataType : 'json',
		success : function(result){
			if(result == 0){
				$("#idcheck_font").html('사용할 수 있는 아이디 입니다.');
				$("#idcheck_font").css('color', 'green');
				$("#idcheck_font").css('font-size', '11px');
				idcheck = 1;
			} else{
				$("#idcheck_font").html('사용할 수 없는 아이디 입니다.');
				$("#idcheck_font").css('color', 'red');
				$("#idcheck_font").css('font-size', '11px');
				idcheck = 2;
			}
		},
		error : function(){
			alert("서버요청실패");
		}
	});//ajax
	}
})
//아이디 중복 체크 END



//<!-- 닉네임 중복 체크 -->
$("input[name=nickname]").keyup(function(){
	let id = $('#nickname_nickname').val();
	if(id.length <2){
		$("#nicknamecheck_font").html('2자 이상의 닉네임을 입력해주세요. (한글, 영문, 숫자)');
		$("#nicknamecheck_font").css('color', 'gray');
		$("#nicknamecheck_font").css('font-size', '11px');
	}
	else{
	$.ajax({
		url : "/membercheck_nickname",
		type : "post",
		data :{'nickname': id},
		dataType : 'json',
		success : function(result){
			if(result == 0){
				$("#nicknamecheck_font").html('사용할 수 있는 닉네임 입니다.');
				$("#nicknamecheck_font").css('color', 'green');
				$("#nicknamecheck_font").css('font-size', '11px');
				nicknamecheck = 1;
			} else{
				$("#nicknamecheck_font").html('사용할 수 없는 닉네임 입니다.');
				$("#nicknamecheck_font").css('color', 'red');
				$("#nicknamecheck_font").css('font-size', '11px');
				nicknamecheck = 2;
			}
		},
		error : function(){
			alert("서버요청실패");
		}
	});//ajax
	}
})
//<!-- 닉네임 중복 체크 END -->



//<!-- 이메일 중복 체크 -->
$("input[name=email]").keyup(function(){
	let id = $('#email_email').val();
	let emailYN = isEmail(id);
	clientemailcheck = id;
	if(id.includes('@')==false){ //만약 id 에 작성 내용에 @가 없을경우
		$("#emailcheck_font").html('이메일을 입력해주세요.');
		$("#emailcheck_font").css('color', 'gray');
		$("#emailcheck_font").css('font-size', '11px');
		
	}
	else{
		
	$.ajax({
		url : "/membercheck_email",
		type : "post",
		data :{'email': id},
		dataType : 'json',
		success : function(result){
			if(result == 0 && emailYN == true){
				$("#emailcheck_font").html('사용할 수 있는 이메일 입니다.');
				$("#emailcheck_font").css('color', 'green');
				$("#emailcheck_font").css('font-size', '11px');
				emailcheck = 1;
				
			} else{
				$("#emailcheck_font").html('사용할 수 없는 이메일 입니다.');
				$("#emailcheck_font").css('color', 'red');
				$("#emailcheck_font").css('font-size', '11px');
				emailcheck = 2;
			}
		},
		error : function(){
			alert("서버요청실패");
		}
	});//ajax
	}
})
//<!-- 이메일 중복 체크 END -->
	
//<!-- 이메일 인증번호 전송시작 -->
	$('#emailCheck').click(function(){ // 이메일 인증번호 전송
		
		let clientEmail = $("#email_email").val();
		let emailYN = isEmail(clientEmail);
		
		console.log("입력 이메일 : " + clientEmail);
		
		if(emailYN == true && emailcheck == 1 && emailok == 2 && email_timer == 2){
			setTimeout(function() {
				alert("인증번호가 발송되었습니다. 이메일을 확인하세요.");
				}, 2000);
			
			 // json 형식으로 데이터 set
	        var params = {
	        		userEmail : $("#email_email").val()
	        }
	        // ajax 통신
	        $.ajax({
	            type : "POST",            // HTTP method type(GET, POST) 형식이다.
	            url : "/mail/send",      // 컨트롤러에서 대기중인 URL 주소이다.
	            data : params,            // Json 형식의 데이터이다.
	            success : function(){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
	            	email_timer = 1;
	                emailcodecheck = 1;
	                console.log("인증번호 발송");
	                countDown();
	                servermailcheck = clientEmail;
	                console.log("서버에 전송된 이메일 : " + servermailcheck)
	                
	            },
	            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
	                emailcodecheck = 0;
	                alert("인증번호 발송에 실패하였습니다.")
	            }
	        });  
			
		}else if(emailYN == true && emailcheck == 1 && emailok == 1){
			alert("이메일 인증을 이미 완료하였습니다.")
		}else if(emailYN == true && emailcheck == 1 && emailok == 2 && email_timer == 1){
			alert("이메일 발송이 이미 완료되었습니다.")
		}
		else{
			alert("이메일 형식 및 이메일을 확인해주세요.")
		}
	
    });
    
//<!-- 이메일 인증번호 전송종료 -->
	
//<!-- 이메일 인증번호 일치여부 판단 시작-->	
	$("#request").click(function(){  
		
		if(emailcodecheck==1){
	        // json 형식으로 데이터 set
	        var params = {
	        		emailCode : $("#emailCode").val(),
	        		timer : $('#emailtime2').text()
	        }
	            
	        // ajax 통신
	        $.ajax({
	            type : "POST",            // HTTP method type(GET, POST) 형식이다.
	            url : "/mail/codeCheck",      // 컨트롤러에서 대기중인 URL 주소이다.
	            data : params,            // Json 형식의 데이터이다.
	            success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
	                // 응답코드 > 0000
 					if(res.success){ 		// 성공
	                	alert(res.success);
	                	console.log(res.success);
	                	emailok = 1;
	                	
	                }else if(res.expire){   // 인증시간 만료
	                	alert(res.expire);
	                	console.log(res.expire);
	                	
	                }else{					// 잘못된 인증번호
	                	alert(res.wrong);
	                	console.log(res.wrong);
	                }
                },
	            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
	                alert("통신 실패.")
	                emailok = 2;
	            }
	        });
		}else{
			alert("인증번호를 발급받아주세요.")
			mailok=2;
		}

    });
//<!-- 이메일 인증번호 일치여부 판단 종료-->	
	
//<!-- 이메일 유효성 검사 시작-->
	function isEmail(asValue){ 
		var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		return regExp.test(asValue); // 형식에 맞는 경우 true 리턴
	}
//<!-- 이메일 유효성 검사 종료-->

/* 이메일 인증번호 유효시간 시작  */
	
	function countDown(){
		var sessionTime = $("#sessionTime").val();
		
		if(emailcodecheck == 1){
		  var AuthTimer = new $ComTimer()
		  AuthTimer.comSecond = 30; // 세션 유지시간 설정
		  AuthTimer.fnCallback = function(){alert("다시인증을 시도해주세요.")}
		  AuthTimer.timer =  setInterval(function(){AuthTimer.fnTimer()},1000);
		  AuthTimer.domId = document.getElementById("emailtime");
		  AuthTimer.domId2 = document.getElementById("emailtime2");
		}
		} 
	

function $ComTimer(){
    //prototype extend
}

$ComTimer.prototype = {
    comSecond : ""
    , fnCallback : function(){}
    , timer : ""
    , domId : ""
    , fnTimer : function(){
    	
    	var m = Math.floor(this.comSecond / 60) + " 분 " + (this.comSecond % 60) + " 초";	// 남은 시간 계산
        var m2 = this.comSecond;	// 남은 시간 계산
    	
    	if(emailok==1){
    		this.domId.innerHTML = "<img id=\"checkimg3\" src=\"/css/images/check.png\" width=\"20px\"; height= 20px\"; style=\"margin-left: 50px\">";
            this.domId2.innerText = m2;
            console.log("1111");
            clearInterval(this.timer);
            
    	}else{
    		this.comSecond--;					// 1초씩 감소
            // console.log(m);
            // console.log(m2);
            this.domId.innerText = m;
            this.domId2.innerText = m2;
            if (this.comSecond < 0) {			// 시간이 종료 되었으면..
                clearInterval(this.timer);		// 타이머 해제
                alert("인증시간이 초과하였습니다. 다시 인증해주시기 바랍니다.")
                email_timer = 2;
            }
    		
    	}

    }
    ,fnStop : function(){
    	// console.log("222");
        clearInterval(this.timer);
    }
}
	
	
	
	/* 이메일 인증번호 유효시간 종료  */











//<!-- 휴대폰 번호 중복 체크 -->
$("input[name=phone]").keyup(function(){
	let id = $('#phone_phone').val();
	if(id.length < 13){ //만약 id 에 작성 내용에 @가 없을경우
		$("#phonecheck_font").html('휴대폰 번호를 입력해주세요.');
		$("#phonecheck_font").css('color', 'gray');
		$("#phonecheck_font").css('font-size', '11px');
	}
	else{
	console.log(id);
	$.ajax({
		url : "/membercheck_phone",
		type : "post",
		data :{'phone': id},
		dataType : 'json',
		success : function(result){
			console.log(result);
			if(result == 0){
				$("#phonecheck_font").html('사용할 수 있는 휴대폰 번호 입니다.');
				$("#phonecheck_font").css('color', 'green');
				$("#phonecheck_font").css('font-size', '11px');
				phonecheck = 1;
				
			} else{
				$("#phonecheck_font").html('사용할 수 없는 휴대폰 번호 입니다.');
				$("#phonecheck_font").css('color', 'red');
				$("#phonecheck_font").css('font-size', '11px');
				phonecheck = 2;
			}
		},
		error : function(){
			alert("서버요청실패");
		}
	});//ajax
	}
})
//<!-- 휴대폰 번호 중복 체크 END -->



//<!-- 1900 ~ 올해까지만 생년월일 입력 가능 -->
$("#birth_yy").keyup(function(){
	let id = $("#birth_yy").val();
	let today = new Date();
	let this_year = today.getFullYear();
	
	if(this_year == id){
		t_year = 1;
	}
	else{
		t_year = 2;
	}
	

	if(1900 <= id && id <= this_year){
		birthcheck_yy = 1;
		console.log("년도 : " + birthcheck_yy);
	}
	else{
		birthcheck_yy = 2;
		console.log("년도 : " + birthcheck_yy);
	}
	
	if(id%4 ==0){
	if(id%400 != 0 && id%100 == 0){
		leap_year = 2;
		/* 윤년아님 */
	}else{
		leap_year = 1;
		/* 윤년 */
		}
	
	}else{
			leap_year = 2;
		/* 윤년 아님 */
	}

	
	
})

//<!-- 생년월일 월 -->
	$("#birth_mm").change(function() {

		let id = $("#birth_mm").val();
		let today = new Date();
		let t_mm = today.getMonth() + 1;
		
		if(t_year ==1 && t_mm == id){
			t_month = 1;
		}
		else{
			t_month = 2;
		}
		
		if(t_year == 1 && t_mm < id){ //만약 입력 년도가 올해랑 동일하고, 입력 달이 이번달보다 크다면 회원가입 불가능.
		birthcheck_mm = 2;
		
		}else{ 						//그렇지 않다면 회원가입 가능하며, 1부터 12를 선택했을 경우 birthcheck_mm과 this_mm을 가능 상태로 만듦.
			if (13 > id && id > 0) { 
				birthcheck_mm = 1;
			}
			else { //1~12를 선택하지 않았을 경우 회원가입 불가능
			birthcheck_mm = 2;
			}
		
		}
		
	})



//<!-- 생년월일 일 -->
$("#birth_dd").keyup(function(){

	let id = $('#birth_mm').val();
	let dd = $('#birth_dd').val();
	
	let today = new Date();
	let t_dd = today.getDate();
	
	if(t_year == 1 && t_month == 1 && dd > t_dd){ // 
		birthcheck_dd = 2;
	}
	
	/* id(월)이 1월이고 선택한 날자가 0보타 크며(1일), 32일보다 작을 경우(31일) 체크 성공 */
	else if(id == 1 && 0 < dd && dd < 32){
		birthcheck_dd = 1;
		console.log("1" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
	}		
	
	/* 윤년일 때 29일 */
	/* id(월)이 2월이고 선택한 날자가 0보타 크며(1일), 30일보다 작고(29일) 윤년일 때 29일 체크 성공 */
	else if(id == 2 && 0 < dd && dd < 30 && leap_year == 1){
		birthcheck_dd = 1;
		console.log("2" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
		console.log("윤년 O" + leap_year);
	}
	
	/* 윤년이 아닐때 2월 28일*/
	/* 2월에 0일보다 크고 29일보다 작고 윤년이 아닌경우*/
	else if(id == 2 && 0 < dd && dd < 29){
		birthcheck_dd = 1;
		console.log("2" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
		console.log("윤년 X" + leap_year);
	}
	
	
	else if(id == 3 && 0 < dd && dd < 32){
		birthcheck_dd = 1;
		console.log("3" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
	}
	
	else if(id == 4 && 0 < dd && dd < 31){
		birthcheck_dd = 1;
		console.log("4" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
	}
	
	else if(id == 5 && 0 < dd && dd < 32){
		birthcheck_dd = 1;
		console.log("5" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);

	}
	
	else if(id == 6 && 0 < dd && dd < 31){
		birthcheck_dd = 1;
		console.log("6" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
	}
	
	else if(id == 7 && 0 < dd && dd < 32){
		birthcheck_dd = 1;
		console.log("7" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
	}
	
	else if(id == 8 && 0 < dd && dd < 32){
		birthcheck_dd = 1;
		console.log("8" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
	}
	
	else if(id == 9 && 0 < dd && dd < 31){
		birthcheck_dd = 1;
		console.log("9" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
	}
	
	else if(id == 10 && 0 < dd && dd < 32){
		birthcheck_dd = 1;
		console.log("10" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
	}
	
	else if(id == 11 && 0 < dd && dd < 31){
		birthcheck_dd = 1;
		console.log("11" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
	}
	
	else if(id == 12 && 0 < dd && dd < 32){
		birthcheck_dd = 1;
		console.log("12" + "월 : " + birthcheck_mm + " / " + "일 : " + birthcheck_dd);
	}
	
	else{
		birthcheck_dd = 2;
	}	
	
	console.log("t년 : " + t_year + "/ t월 : " + t_month + "/ t일 : " + t_dd + "/ 입력일 : " + dd);
	console.log(birthcheck_dd);
})
	
	//년도 체크
	let today = new Date();
	let year = today.getFullYear();
	let month = today.getMonth() +1;
	let day = today.getDate();

	w_year = $("#birth_yy").val(); //$('input[name=birth_yy]').val();//2022
	w_month = $("#birth_mm").val();
	w_day = $("#birth_dd").val();
		
	if(w_year < year) {
		birthcheck=1;
	}
		
	if(w_year == year && w_month < month){
		birthcheck=1;
	}
	
	if(w_year == year && w_month == month && w_day <= day){
		birthcheck=1;
	}



//회원가입 버튼 function
$("#member_btn").on('click', function(ev){
if(idcheck==2){
	alert("아이디를 확인해주세요.");
	ev.preventDefault();
	
}

else if(nicknamecheck==2){
	alert("닉네임을 확인해주세요.");
	ev.preventDefault();
	
}

else if(pwcheck==2){
	alert("비밀번호를 확인해주세요.");
	ev.preventDefault();
	
}

else if(emailcheck==2){
	alert("이메일을 확인해주세요.");
	ev.preventDefault();
	
}

else if(emailok==2){
	alert("이메일 인증을 해주세요.");
	ev.preventDefault();
	
}

else if(phonecheck==2){
	alert("휴대폰 번호를 확인해주세요.");
	ev.preventDefault();
	
}

else if(birthcheck_yy==2){
	alert("생년월일의 '년'을 확인해주세요.");
	ev.preventDefault();
	
}

else if(birthcheck_mm==2){
	alert("생년월일의 '월'을 확인해주세요.");
	ev.preventDefault();
	
}

else if(birthcheck_dd==2){
	alert("생년월일의 '일'을 확인해주세요.");
	ev.preventDefault();
	
}

else if(birthcheck==2){
	alert("생년월일을 년, 월, 일 순으로 다시 작성해주세요.");
	ev.preventDefault();
}
else if(clientemailcheck != servermailcheck){
	alert("인증한 이메일을 입력해주세요.");
	ev.preventDefault();
}

			



// 최종 버튼 체크

if(idcheck == 1 && nicknamecheck == 1 && pwcheck == 1 && emailok == 1 && phonecheck == 1 && birthcheck == 1 && birthcheck_yy == 1 && birthcheck_dd == 1 && birthcheck_mm == 1){
	
	//<!-- 생년월일 ymd ++ -->

	var birthString = $('input[name=birth_yy]').val() + "-" + $("select[name=birth_mm]").val() + "-" + $('input[name=birth_dd]').val();
	$('input[type=hidden]').val(birthString);
	//<!-- 생년월일 ymd ++ END -->

}// 최종 버튼 체크

}); //회원가입 버튼 function END
}); //ready function END

//<!-- 비밀번호 중복체크 -->
$(function(){
	$("#pw_success").hide();
	$("#pw_fail").hide();
	$("input").keyup(function(){
		var pw_text=$("#pw_text").val();
		var pw_check_text=$("#pw_check_text").val();
		if(pw_text != "" || pw_check_text != ""){
			if(pw_text == pw_check_text){
				$("#pw_success_id").show();
				$("#pw_fail_id").hide();
				pwcheck=1;
				
			}else{
				$("#pw_success_id").hide();
				$("#pw_fail_id").show();
				pwcheck=2;
				
			}
		}
	});
})
//<!-- 비밀번호 중복체크 END -->

//<!-- 휴대폰 번호 - 자동생성 -->
function inputPhoneNumber(obj) {

    var number = obj.value.replace(/[^0-9]/g, "");
    var phone = "";

    if(number.length < 4) {
        return number;
    } else if(number.length < 7) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3);
        
    } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7, 4);
		
    } 
    
    obj.value = phone;
}
// 휴대폰 번호 - 자동생성 END

//<!-- 미래인지 확인 -->

