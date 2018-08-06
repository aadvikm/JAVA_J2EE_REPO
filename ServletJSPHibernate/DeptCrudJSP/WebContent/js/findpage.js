function findDept(){
	if(validate()){
		document.getElementById('findpage').action = '/DeptCrudJSP/findDept?action=searchedPage';
		document.getElementById('findpage').method = 'post';
		document.getElementById('findpage').submit();
	}
	
}


function goHome(){
	document.getElementById('findpage').action = '/DeptCrudJSP/homePage';
	document.getElementById('findpage').method = 'post';
	document.getElementById('findpage').submit();
}

function validate(){
	if(document.getElementById('deptId').value==null||document.getElementById('deptId').value.trim().length==0){
		alert('Please Enter a valid department Id..!!');
		return false;
	}
	
	return true;
}