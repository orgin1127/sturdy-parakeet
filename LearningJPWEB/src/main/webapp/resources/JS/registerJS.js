//문서 시작시 
$(document).ready(function() {
	// When the user clicks on the button, open the modal 
	$('#myButton').on('click', function() {
		$('#myRegisterModal').css('display', 'block');
		makeRegisterForm();
		// Get the <span> element that closes the modal
		// When the user clicks on <span> (x), close the modal
		$('#registerCloser').on('click', closeRegisterModal);
				
		//ID 유효성 검사
		$('#userID').on('keyup', checkUserIDValidate);
		//Password 유효성 검사
		$('#userPassword').on('keyup', checkUserPasswordValidate);
		//Password 재입력 유효성 검사
		$('#userPasswordCheck').on('keyup', passwordInputValidateCheck);
		//닉네임 유효성 검사
		$('#userName').on('keyup', checkUserNameValidity);
		//폼 송신
		$('#registerSubmit').on('click', submitRegisterForm);
	});
});
		function makeRegisterForm() {
			var contentForModalBody = "";
			contentForModalBody += '<p><form action="register" method="post" id="registerForm"><table id="registerTable">';
			contentForModalBody += '<tr><td>I D</td><td><input type="text" id="userID" name="userID" placeholder="ID를 입력하여 주세요">';
			contentForModalBody += '<input type="hidden" id="idValidity" value="false">';
			contentForModalBody += '<br><span id="idValidateCheck"><pre></pre></span></td></tr>';
			contentForModalBody += '<tr><td>PASSWORD</td><td><input type="password" id="userPassword" name="userPassword">';
			contentForModalBody += '<input type="hidden" id="passwordValidity" value="false">';
			contentForModalBody += '<div id="passwordValidateCheck"></div></td></tr>'
			contentForModalBody += '<tr><td>PASSWORD 재입력</td><td><input type="password" id="userPasswordCheck" name="userPasswordCheck">';
			contentForModalBody += '<div id="passwordInputValidateCheck"></div></td></tr>'
			contentForModalBody += '<tr><td>닉네임</td><td><input type="text" id="userName" name="userName">';
			contentForModalBody += '<input type="hidden" id="nameValidity" value="false">';
			contentForModalBody += '<div id="nameValidateCheck"></div></td></tr>'
			contentForModalBody += '<tr><td colspan="2"><input type="button" id="registerSubmit" value="회원가입" checked="false">';
			contentForModalBody += '<input type="hidden" id="closeRegisterModal" value="registModal"></td></tr>'
			contentForModalBody += '</table></form></p>';
			$('#myRegisterModalBody').html(contentForModalBody);
		}
		function closeRegisterModal() {
			$('#myRegisterModal').css('display', 'none');
		}
		function submitRegisterForm() {
			
			var inputID = $('#userID').val();
			var inputPassword = $('#userPassword').val();
			var inputPasswordCheck = $('#userPasswordCheck').val();
			var inputUserName = $('#userName').val();
			var idCheck = $('#idValidity').attr('value');
			var passwordCheck = $('#passwordValidity').attr('value');
			var nameCheck = $('#nameValidity').attr('value');
			
			if (inputID != '' && inputPassword != '' && inputPasswordCheck != '' && inputUserName != ''
				&& idCheck != 'false'&& passwordCheck != 'false'&& nameCheck != 'false' ) {
				$.ajax({
					url: 'register'
					, type: 'post'
					, data: $('#registerForm').serialize()
					, dataType: 'text'
					, success: function(result) {
						if (result == 1) {
							alert('회원가입에 성공하셨습니다. 메인으로 돌아갑니다.');
							closeRegisterModal();
						}
						else {
							alert('회원가입에 실패하였습니다. 입력사항을 확인하여 주세요');
							return;
						}
					}
					, error: function(e) {
						alert(JSON.stringify(e));
					}
				});				
			}
			else {
				alert('필수 입력사항들을 확인하여 주세요');
			}
		}
		function checkUserIDValidate() {
			var inputID = $('#userID').val();
			$.ajax({
				url: 'userIDCheck'
				, type: 'get'
				, data: {inputID: inputID}
				, dataType: 'text'
				, success: function(IDSearchResult) {
					if (IDSearchResult == 'invalidity') {
						//$('#idValidateCheck').html(IDSearchResult+"");
						$('#idValidateCheck').html('유효하지 않은 ID입니다. 4~9자의 영어, 숫자로 입력하여 주세요.');
						$('#idValidity').attr('value', 'false');
						return;
					}
					else if (IDSearchResult == inputID ) {
						$('#idValidateCheck').html('ID중복입니다.');
						$('#idValidity').attr('value', 'false');
						return;
					}
					else {
						$('#idValidateCheck').html(' ');
						$('#idValidity').attr('value', 'true');
					}
				}
				, error: function(e) {
					alert(JSON.stringify(e));
				}
			});
		}
		function checkUserPasswordValidate() {
			var inputPassword = $('#userPassword').val();
			$.ajax({
				url: 'userPasswordCheck'
				, type: 'get'
				, data: {inputPassword: inputPassword}
				, dataType: 'text'
				, success: function(passwordSearchResult) {
					if (passwordSearchResult == 'invalidity'){
						$('#passwordValidateCheck').html('유효하지 않은 Password입니다. 5~12자의 영어, 숫자로 입력하여 주세요.');
						$('#passwordValidity').attr('value', 'false');
						return;
					}
					else {
						$('#passwordValidateCheck').html(' ');
					}
				}
				, error: function(e) {
					alert(JSON.stringify(e));
				}
			});
		}
		function passwordInputValidateCheck() {
			var inputPassword = $('#userPasswordCheck').val();
			$.ajax({
				url: 'userPasswordCheck'
				, type: 'get'
				, data: {inputPassword: inputPassword}
				, dataType: 'text'
				, success: function(passwordSearchResult) {
					if (passwordSearchResult == 'invalidity'){
						$('#passwordInputValidateCheck').html('유효하지 않은 Password입니다. 5~12자의 영어, 숫자로 입력하여 주세요.');
						$('#passwordValidity').attr('value', 'false');
						return;
					}
					else if (inputPassword != $('#userPassword').val()) {
						$('#passwordInputValidateCheck').html('Password 재입력이 일치하지 않습니다.');
						$('#passwordValidity').attr('value', 'false');
						return;
					}
					else {
						$('#passwordInputValidateCheck').html(' ');
						$('#passwordValidity').attr('value', 'true');
					}
				}
			});
		}
		function checkUserNameValidity() {
			var inputUserName = $('#userName').val();
			$.ajax({
				url: 'userNameCheck'
				, type: 'get'
				, data: {inputUserName: inputUserName}
				, dataType: 'text'
				, success: function(userNameCheckResult) {
					if(userNameCheckResult == 'invalidity') {
						$('#nameValidateCheck').html('유효하지 않은 닉네임입니다. 2~10자로 입력하여 주세요.');
						$('#nameValidity').attr('value', 'false');
						return;
					}
					else {
						$('#nameValidateCheck').html(' ');
						$('#nameValidity').attr('value', 'true');
					}
				}
			});
		}