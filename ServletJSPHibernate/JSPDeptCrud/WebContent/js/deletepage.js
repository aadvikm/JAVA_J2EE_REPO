function findDept(){
	if(validate()){
		document.getElementById('deletepage').action = '/JSPDeptCrud/deleteDept?action=searchedPage';
		document.getElementById('deletepage').method = 'post';
		document.getElementById('deletepage').submit();
	}
	
}


function goHome(){
	document.getElementById('deletepage').action = '/JSPDeptCrud/homePage';
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
	document.getElementById('deletepage').action = '/JSPDeptCrud/deleteDept?action=deletedPage';
	document.getElementById('deletepage').method = 'post';
	document.getElementById('deletepage').submit();
}