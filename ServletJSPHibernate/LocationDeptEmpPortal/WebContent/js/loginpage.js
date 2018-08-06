function login(){
	if( validate()){
		document.getElementById('loginpage').action ='/LocationDeptEmpPortal/loginServlet';
		document.getElementById('loginpage').method='post'
		document.getElementById('loginpage').submit();
		
	}
}

function validate(){
	if(document.getElementById('username').value == null || document.getElementById('username').value.trim().length==0){
		alert('Please Enter a valid username..!!');
		return false;
	}
	if(document.getElementById('password').value==null||document.getElementById('password').value.trim().length==0){
		alert('Please Enter a valid password..!!');
		return false;
	}
	return true;
}


function reset(){
	if(validate()){
		document.getElementById('username').value='';
		document.getElementById('password').value='';
	}

}