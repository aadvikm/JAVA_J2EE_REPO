function findDept(){
	if(validate()){
		document.getElementById('findDeptPage').action='/DeptCRUDHibernate/deptDetails';
		document.getElementById('findDeptPage').method='post';
		document.getElementById('findDeptPage').submit();
	}
	
}

function validate(){
	if(document.getElementById('deptId').value ==null || document.getElementById('deptId').value.trim().length ==0){
		alert('Pls enter the valid Dept Id..!!');
		return false;
	}
	return true;
}

function goHome(){
	document.getElementById('findDeptPage').action = '/DeptCRUDHibernate/home';
	document.getElementById('findDeptPage').method = 'get';
	document.getElementById('findDeptPage').submit();
}