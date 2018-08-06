function createDepartment() {
	
		document.getElementById('createDeptPage').action = '/DeptCRUDHibernate/createdDetails'
		document.getElementById('createDeptPage').method = 'get';
		document.getElementById('createDeptPage').submit();
	

}


function goHome(){
	document.getElementById('createDeptPage').action = '/DeptCRUDHibernate/home';
	document.getElementById('createDeptPage').method = 'get';
	document.getElementById('createDeptPage').submit();
}