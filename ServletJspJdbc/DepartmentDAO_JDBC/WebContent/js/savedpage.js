function goBack(){
	document.getElementById('savedFormId').action = '/DepartmentDAO_JDBC/deptPage';
	document.getElementById('savedFormId').method = 'post';
	document.getElementById('savedFormId').submit();
}

function saveDept(){
	if(validateSaveDept()){
		document.getElementById('savedFormId').action = '/DepartmentDAO_JDBC/savedPage';
		document.getElementById('savedFormId').method = 'post';
		document.getElementById('savedFormId').submit();
	}
	
}

function validateSaveDept(){
	if(document.getElementById('deptName').value == null || document.getElementById('deptName').trim().length() == 0 ){
		alert('Please enter valid dept name.');
		return false;
	}
	if(document.getElementById('locId').value == null || document.getElementById('locId').value.trim().length() == 0 || NaN(document.getElementById('locId').value.trim())){
		alert('Please enter valid dept name.');
		return false;
	}
	if(document.getElementById('mgrId').value != null ){
		if(NaN(document.getElementById('mgrId').value.trim())){
			alert('Please enter numberic value for mgr id.');
			return false;
		}
	}
	return true;
}