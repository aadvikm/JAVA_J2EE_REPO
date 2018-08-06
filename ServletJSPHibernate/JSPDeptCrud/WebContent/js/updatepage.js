function findDept(){
	if(validate()){
		document.getElementById('updatepage').action = '/JSPDeptCrud/updateDept?action=searchedPage';
		document.getElementById('updatepage').method = 'post';
		document.getElementById('updatepage').submit();
	}
	
}


function goHome(){
	document.getElementById('updatepage').action = '/JSPDeptCrud/homePage';
	document.getElementById('updatepage').method = 'post';
	document.getElementById('updatepage').submit();
}

function validate(){
	if(document.getElementById('deptId').value==null||document.getElementById('deptId').value.trim().length==0){
		alert('Please Enter a valid department Id..!!');
		return false;
	}
	
	return true;
}

function updateDept(){
	document.getElementById('updatepage').action = '/JSPDeptCrud/updateDept?action=updatedPage';
	document.getElementById('updatepage').method = 'post';
	document.getElementById('updatepage').submit();
}