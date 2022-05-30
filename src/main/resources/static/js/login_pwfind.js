var emailcodecheck = 2;
var emailok = 2; 
var emailcheck = 2;
var pwfind_timer = 2;

$(document).ready(function(){
console.log(emailok);
$("input[name=pwfind_id]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
	}
	});

$("input[name=pwfind_email]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^a-z0-9@.]/gi,''));
	}
	});

$("input[name=pwfind_phone]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^0-9-]/gi,''));
	}
	});

$("input[name=pwfind_birth_yy]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^0-9-]/gi,''));
	}
	});

$("input[name=pwfind_birth_dd]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^0-9-]/gi,''));
	}
	});
}); //readyfunction end

/* 비밀번호 찾기 */
$(document).on('click', '#modal_pwfind_ok_btn', (function(ev) {
	
	if(emailcodecheck==2){
	alert("이메일 인증을 확인해주세요.");
	ev.preventDefault();
	console.log("emailcodecheck : " + emailcodecheck);
	console.log("emailcode : " + emailok);
	}
	
	else if(emailok==2){
		alert("이메일 인증을 확인해주세요.");
		ev.preventDefault();
		console.log("emailcode : " + emailok);
		console.log("emailcodecheck : " + emailcodecheck);
	}
	
	else{
	
	var birth = $('input[name=pwfind_birth_yy]').val() + "-" + $("select[name=pwfind_birth_mm]").val() + "-" + $('input[name=pwfind_birth_dd]').val();
	$('input[type=hidden]').val(birth);
	let id = $('input[name=pwfind_id]').val();
	let email = $('input[name=pwfind_email]').val();
	let phone = $('input[name=pwfind_phone]').val();

	console.log(id + birth + email + phone);


	$.ajax({
		url: "/pwfind",
		type: "post",
		data: {'id': id, 'email': email, 'phone': phone, 'birth': birth },
		dataType: 'text',
		success: function(result) {
			
			if(result==""){
			console.log("result" + result);
			$("#modal_pwfind").hide();
			$('#pwfind_id_id').val("");
			$('#pwfind_email_email').val("");
			$('#pwfind_phone_phone').val("");
			$('#pwfind_birth_yy').val("");
			$('#pwfind_birth_mm').val("월");
			$('#pwfind_birth_dd').val("");
			$('#pwfindemailCode').val("");
			$('#pwfindemailtime').val("");
			$('#checkimg2').hide();
			emailcodecheck = 2;
			emailok = 2;
			emailcheck = 2;
			pwfind_timer = 2;
			document.getElementById('pwfind_email_email').readOnly = false;

			$("#modal_pwfindresult").show();
			$("#pwfindresult_font").html('회원정보를 확인해 주세요.');
			$("#pwfindresult_font").css('color', 'black');
			$("#pwfindresult_font").css('font-size', '20px');
			}
			
			else{
			console.log("result" + result);
			$("#modal_pwfind").hide();
			$('#pwfind_id_id').val("");
			$('#pwfind_email_email').val("");
			$('#pwfind_phone_phone').val("");
			$('#pwfind_birth_yy').val("");
			$('#pwfind_birth_mm').val("월");
			$('#pwfind_birth_dd').val("");
			$('#pwfindemailCode').val("");
			$('#pwfindemailtime').val("");
			$('#checkimg2').hide();
			emailcodecheck = 2;
			emailok = 2;
			emailcheck = 2;
			pwfind_timer = 2;
			document.getElementById('pwfind_email_email').readOnly = false;

			$("#modal_pwfindresult").show();
			$("#pwfindresult_font").html('비밀번호는 ' + result + ' 입니다.');
			$("#pwfindresult_font").css('color', 'black');
			$("#pwfindresult_font").css('font-size', '20px');
			}
			
			
		},
		error: function(e) {
			alert("회원 정보를 다시 입력해주세요");
			console.log(e);
		}
	});//ajax
		
	}
}))
/* 비밀번호 찾기 END */	

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
	


//비밀번호 찾기 버튼 클릭 이벤트
$(document).on('click', '.pwfind_btn', (function() {

	emailcodecheck = 2;
	emailok = 2;
	emailcheck = 2;
	pwfind_timer = 2;
	setTimeout(function(){
	$("#modal_pwfind").show();
	},700)
	

})); //신고하기 버튼 이벤트 end



//비밀번호 찾기 취소 버튼
$(document).on('click', '#modal_pwfind_close_btn', (function() {
	$('#pwfind_id_id').val("");
	$('#pwfind_email_email').val("");
	$('#pwfind_phone_phone').val("");
	$('#pwfind_birth_yy').val("");
	$('#pwfind_birth_mm').val("월");
	$('#pwfind_birth_dd').val("");
	$('#pwfindemailCode').val("");
	$('#pwfindemailtime').val("");
	$('#checkimg2').hide();
	$("#modal_pwfind").hide();
	document.getElementById('pwfind_email_email').readOnly = false;
	emailcodecheck = 2;
	emailok = 3;
	emailcheck = 2;
	pwfind_timer = 2;
}));

//확인버튼
$(document).on('click', '#modal_pwfindresult_close_btn', (function() {
	$("#modal_pwfindresult").hide();
	emailcodecheck = 2;
	emailok = 2;
	emailcheck = 2;
	pwfind_timer = 2;
}));


/* id 삭제완료 */
/* pwfind 이메일 인증 시작*/
$(document).ready(function(){
	
	var result = "";
	/* 이메일 인증번호 전송시작  */
	$('#pwfindemailCheck').click(function(){ // 이메일 인증번호 전송
		
		let clientEmail = $("#pwfind_email_email").val();
		let emailYN = isEmail(clientEmail);
		
		console.log("입력 이메일 : " + clientEmail);
		
		if(emailYN == true && emailcheck == 2 && emailok == 2){
			setTimeout(function() {
				alert("인증번호가 발송되었습니다. 이메일을 확인하세요.");
				}, 2000);
			
			 // json 형식으로 데이터 set
	        var params = {
	        		userEmail : $("#pwfind_email_email").val()
	        }
	        // ajax 통신
	        $.ajax({
	            type : "POST",            // HTTP method type(GET, POST) 형식이다.
	            url : "/mail/send",      // 컨트롤러에서 대기중인 URL 주소이다.
	            data : params,            // Json 형식의 데이터이다.
	            success : function(){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
	                pwfind_timer = 1;
	                emailcodecheck = 1;
	                emailcheck = 1;
	                console.log("인증번호 발송");
	                console.log(result);
	                countDown();
	            },
	            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
	                emailcodecheck = 2;
	                alert("인증번호 발송에 실패하였습니다.")
	            }
	        });  
			
		}else if(emailYN == true && emailcheck == 1 && emailok == 1){
			alert("이메일 인증을 이미 완료하였습니다.")
		}else if(emailYN == true && emailcheck == 1 && emailok == 2 && pwfind_timer == 1){
			alert("이메일 발송이 이미 완료되었습니다.")
		}
		else{
			alert("이메일 형식에 알맞게 입력해주세요.")
		}
	
    });
	/* 이메일 인증번호 전송종료  */
	
	/* 이메일 인증번호 일치여부 판단 시작  */
	$("#pwfindrequest").click(function(){  
		
		if(emailcodecheck==1){
	        // json 형식으로 데이터 set
	        var params = {
	        		emailCode : $("#pwfindemailCode").val(),
	        		timer : $('#pwfindemailtime2').text()
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
	                	document.getElementById('pwfind_email_email').readOnly = true;
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
	                alert("통신 실패.");
	                emailok = 2;
	            }
	        });
		}else{
			alert("인증번호를 발급받아주세요.")
			emailok = 2;
		}

    });
	/* 이메일 인증번호 일치여부 판단 종료  */
	

	function isEmail(asValue){
		var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		return regExp.test(asValue); // 형식에 맞는 경우 true 리턴
	}
	
	/* 이메일 인증번호 유효시간 시작  */
	
	function countDown(){
		var sessionTime = $("#sessionTime").val();
		
		if(emailcodecheck == 1){
		  var AuthTimer = new $ComTimer()
		  AuthTimer.comSecond = 30; // 세션 유지시간 설정
		  AuthTimer.fnCallback = function(){alert("다시인증을 시도해주세요.")}
		  AuthTimer.timer =  setInterval(function(){AuthTimer.fnTimer()},1000);
		  AuthTimer.domId = document.getElementById("pwfindemailtime");
		  AuthTimer.domId2 = document.getElementById("pwfindemailtime2");
		  $('#pwfindemailtime').show();
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
    		this.domId.innerHTML = "<img id=\"checkimg2\" src=\"/css/images/check.png\" width=\"20px\"; height= 20px\"; style=\"margin-left: 50px\">";
            this.domId2.innerText = m2;
            console.log("1111");
            clearInterval(this.timer);
            
    	}else if(emailok==3){
			console.log("멈춰라")
			clearInterval(this.timer);
			this.domId.innerText = "";
		}
    	else{
    		this.comSecond--;					// 1초씩 감소
            // console.log(m);
            // console.log(m2);
            this.domId.innerText = m;
            this.domId2.innerText = m2;
            if (this.comSecond < 0) {			// 시간이 종료 되었으면..
                clearInterval(this.timer);		// 타이머 해제
                alert("인증시간이 초과하였습니다. 다시 인증해주시기 바랍니다.")
                this.domId.innerText = "";
                emailcheck = 2;
                pwfind_timer = 2;
            }
    		
    	}

    }
    ,fnStop : function(){
        clearInterval(this.timer);
    }
}
	
	
	
	/* 이메일 인증번호 유효시간 종료  */
	
	
});// jquery code	
	
	