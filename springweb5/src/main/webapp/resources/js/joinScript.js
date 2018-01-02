/**
 * 
 */
function check() {
	
	alert('check JS 실행');
	
	var writepassword = document.getElementById('password');
	if (writepassword.value == '' || writepassword.value.length > 12 || writepassword.value.length < 4) {
		alert('비밀번호를 올바르게 입력하여 주세요');
		writepassword.focus();
		writepassword.select();
		return false;
	}
	
	var passValid = document.getElementById('passwordValid');
	if (passValid.value == '' || passValid.value != writepassword.value) {
		alert('비밀번호 재입력을 올바르게 입력하여 주세요');
		passValid.focus();
		passValid.select();
		return false;
	}
	
	var inputName = document.getElementById('name');
	if (inputName.value == '' || inputName.value.length > 8) {
		alert('이름을 올바르게 입력하여 주세요');
		inputName.focus();
		inputName.select();
		return false;
	}
	
	var inputEmail = document.getElementById('emailHead');
	var selectEmail = document.getElementById('emailFoot')
	var obt = document.getElementById('email');
	
	if (inputEmail.value > 10) {
		alert('이메일을 올바르게 입력하여 주세요');
		inputEmail.focus();
		inputEmail.select();
		return false;
	}
	
	obt.value = inputEmail.value + '@' + selectEmail.value;
	alert(obt.value);
	
	var selectedDivision = document.getElementById('division');
	if (selectedDivision.value == '') {
		alert('고객 구분을 올바르게 선택하여 주세요');
	}
	
	var inputIDNo = documen.getElementById('idno');
	if(inputIDNo.value =='' || inputIDNo.value.length > 16) {
		alert('식별번호를 올바르게 입력하여 주세요');
		inputIDNo.focus();
		inputIDNo.select();
		return false;
	}
	
	
}

function idCheck() {
	window.open("idcheck", "ID 중복체크","top=200,left=300,width=450,height=250,resizable=no");
}

function idValidCheck() {
	var id = document.getElementById('userID');
	var checkIDs = /^[a-z0-9]{3,8}/;
	
	if (!(checkIDs.test(id.value))) {
		alert('아이디는 영문 혹은 숫자로 4자리 이상 9자리 이하여야 합니다.');
		id.focus();			
		id.select();
		return false;
	}
}
	
function usethisID() {
	var checkedID = document.getElementById('userID');
	var idForm = opener.document.getElementById('userID');
	idForm.value = checkedID.value;
	this.close();
}
