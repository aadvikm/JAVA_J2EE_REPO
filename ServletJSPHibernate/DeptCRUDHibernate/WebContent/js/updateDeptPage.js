function findDept(){
	if(validate()){
		document.getElementById('updateDeptPage').action='/DeptCRUDHibernate/updatedDetails';
		document.getElementById('updateDeptPage').method='get';
		document.getElementById('updateDeptPage').submit();
	}
	
	
}

function validate(){
	if(document.getElementById('deptId').value ==null || document.getElementById('deptId').value.trim().length ==0){
		alert('Pls enter the valid Dept Id..!!');
		return false;
	}
	return true;
}

function updateDept(){
	document.getElementById('updateDeptPage').action='/DeptCRUDHibernate/updateSuccess';
	document.getElementById('updateDeptPage').method='post';
	document.getElementById('updateDeptPage').submit();
}
function goHome(){
	document.getElementById('updateDeptPage').action = '/DeptCRUDHibernate/home';
	document.getElementById('updateDeptPage').method = 'get';
	document.getElementById('updateDeptPage').submit();
}