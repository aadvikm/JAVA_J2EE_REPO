function findEmp(){
	if(validate()){
		document.getElementById('getEmpPageForm').action = '/EmpCRUD/getEmpDetail';
		document.getElementById('getEmpPageForm').method = 'post';
		document.getElementById('getEmpPageForm').submit();
	}
}

function validate(){
	if(document.getElementById('empId').value == null || document.getElementById('empId').value.trim().length == 0 ){
		alert('Please enter valid emp id.');
		return false;
	}
	return true;
}

function goHome(){
	document.getElementById('getEmpPageForm').action = '/EmpCRUD/home';
	document.getElementById('getEmpPageForm').method = 'get';
	document.getElementById('getEmpPageForm').submit();
}