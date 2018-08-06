function findDept(){
	if(validate()){
		document.getElementById('deletepage').action = '/DepartmentCrudJSP/deleteDept?action=searchedPage';
		document.getElementById('deletepage').method = 'post';
		document.getElementById('deletepage').submit();
	}
	
}


function goHome(){
	document.getElementById('deletepage').action = '/DepartmentCrudJSP/homePage';
	document.getElementById('deletepage').method = 'post';
	document.getElementById('deletepage').submit();
}

function validate(){
	if(document.getElementById('deptId').value==null||document.getElementById('deptId').value.trim().length==0){
		alert('Please Enter a valid Department Id..!!');
		return false;
	}
	
	return true;
}

function deleteDept(){
	document.getElementById('deletepage').action = '/DepartmentCrudJSP/deleteDept?action=deletedPage';
	document.getElementById('deletepage').method = 'post';
	document.getElementById('deletepage').submit();
}