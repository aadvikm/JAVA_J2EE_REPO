function login(){
	if(validateForm()){
		document.getElementById('loginPage').method='post';
		document.getElementById('loginPage').action='/DeptCRUDServletHibernate/loginServlet'
		document.getElementById('loginPage').submit();
	}
	
}

function reset(){
	if(validateForm()){
		document.getElementById('username').value='';
		document.getElementById('password').value='';
	}
}

function validateForm(){
	if(document.getElementById('username').value ==null||document.getElementById('username').value.trim().length ==0){
		alert('Please Enter a valid Username.!');
		return false;
	}
	if(document.getElementById('password').value ==null||document.getElementById('password').value.trim().length ==0){
		alert('Please Enter a valid Password.!');
		return false;
	}
	return true;
}