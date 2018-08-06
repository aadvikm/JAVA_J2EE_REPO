function findDept(){
	if(validate()){
		document.getElementById('deleteDeptPage').action='/DeptCRUDHibernate/deletedDetails';
		document.getElementById('deleteDeptPage').method='get';
		document.getElementById('deleteDeptPage').submit();
	}
	
	
}

function validate(){
	if(document.getElementById('deptId').value ==null || document.getElementById('deptId').value.trim().length ==0){
		alert('Pls enter the valid Dept Id..!!');
		return false;
	}
	return true;
}

function deleteDept(){
	document.getElementById('deleteDeptPage').action='/DeptCRUDHibernate/deleteSuccess';
	document.getElementById('deleteDeptPage').method='post';
	document.getElementById('deleteDeptPage').submit();
}
function goHome(){
	document.getElementById('deleteDeptPage').action = '/DeptCRUDHibernate/home';
	document.getElementById('deleteDeptPage').method = 'get';
	document.getElementById('deleteDeptPage').submit();
}