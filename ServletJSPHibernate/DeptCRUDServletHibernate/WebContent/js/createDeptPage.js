function createDepartment() {
	
		document.getElementById('createDeptPage').action = '/DeptCRUDServletHibernate/createdDetails'
		document.getElementById('createDeptPage').method = 'get';
		document.getElementById('createDeptPage').submit();
	

}


function goHome(){
	document.getElementById('createDeptPage').action = '/DeptCRUDServletHibernate/home';
	document.getElementById('createDeptPage').method = 'get';
	document.getElementById('createDeptPage').submit();
}