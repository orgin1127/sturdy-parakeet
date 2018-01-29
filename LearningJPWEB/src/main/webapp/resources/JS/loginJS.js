/**
 * 
 */
$(document).ready(function() {
	$('#myLogin').on('click', function() {
		$('#myLoginModal').css('display', 'block');
		makeLoginForm();
		$('.closeModal').on('click', closeModal);
		$('#loginSubmit').on('click', loginUser);
		
	});
	
	function makeLoginForm() {
		var contentForLoginForm = "";
		
		contentForLoginForm += '<p><form action="userLogin" method="post" id="loginForm"><table id="loginTable">';
		contentForLoginForm += '<tr><td>I D</td><td><input type="text" id="userID" name="userID" placeholder="ID를 입력하여 주세요">';
		contentForLoginForm += '<input type="hidden" id="idValidity" value="false">';
		contentForLoginForm += '<br><span id="idValidateCheck"></span></td></tr>';
		contentForLoginForm += '<tr><td>PASSWORD</td><td><input type="password" id="userPassword" name="userPassword">';
		contentForLoginForm += '<input type="hidden" id="passwordValidity" value="false">';
		contentForLoginForm += '<div id="passwordValidateCheck"></div></td></tr>'
		contentForLoginForm += '<tr><td colspan="2"><input type="button" id="loginSubmit" value="로그인"></td></tr>';
		contentForLoginForm += '</table></form></p>';
		
		$('#myLoginModalBody').html(contentForLoginForm);
	}
	function closeModal() {
		$('#myLoginModal').css('display', 'none');
	}
	function loginUser() {
		var inputID = $('#userID').val();
		var inputPassword = $('#userPassword').val();
		if (inputID != '' && inputPassword != '') {
			$.ajax({
				url: 'userLogin'
				, type: 'post'
				, data: $('#loginForm').serialize()
				, dataType: 'JSON'
				, success: function(loginedVO) {
					if (loginedVO != null) {						
						alert('환영합니다. '+loginedVO.userName + '님!');
						closeModal();
						location.reload();
						
					}
					else {
						alert('없는 계정이거나 아이디, 비밀번호를 틀리셨습니다.');
					}
				}
			});
		}
	}

});
