function createDept(){
	document.getElementById('createpage').action = '/DeptCrudJSP/createDept?action=newDeptPage';
	document.getElementById('createpage').method = 'post';
	document.getElementById('createpage').submit();
}


function goHome(){
	document.getElementById('createpage').action = '/DeptCrudJSP/homePage';
	document.getElementById('createpage').method = 'post';
	document.getElementById('createpage').submit();
}