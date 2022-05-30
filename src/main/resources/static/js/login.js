$(document).ready(function(){

$('#login_btn').click(function(){
	let id = $('#id_id').val();
	if(id==""){
		alert("아이디를 입력해주세요");
	}
	else{
	console.log(id);
	$.ajax({
		url : "/membercheck",
		type : "post",
		data :{'id': id},
		dataType : 'json',
		success : function(result){
			console.log(result);
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
	});//ajax
	}
})
})