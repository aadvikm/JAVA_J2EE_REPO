function login(){
	if(validateLoginForm()){
		document.getElementById('loginForm').method ='post';
		document.getElementById('loginForm').action = '/EmpCrudJSP/loginServlet';
		document.getElementById('loginForm').submit();
	}
}

function validateLoginForm(){
	if(document.getElementById('uname').value == null || document.getElementById('uname').value.trim().length == 0){
		alert('Please enter valid user name.');
		return false;
	}
	if(document.getElementById('pwd').value == null || document.getElementById('pwd').value.trim().length == 0){
		alert('Please enter valid password.');
		return false;
	}
	return true;
}

function clearForm(){
	var uname = document.getElementById('uname');
	uname.value = '';
	document.getElementById('pwd').value = '';
}