function createDept(){
	document.getElementById('homePage').action='/DeptCRUDServletHibernate/createDepartment';
	document.getElementById('homePage').method='post';
	document.getElementById('homePage').submit();
}

function findDept(){
	document.getElementById('homePage').action='/DeptCRUDServletHibernate/findDepartment';
	document.getElementById('homePage').method='get';
	document.getElementById('homePage').submit();
}

function updateDept(){
	document.getElementById('homePage').action='/DeptCRUDServletHibernate/updateDepartment';
	document.getElementById('homePage').method='get';
	document.getElementById('homePage').submit();
}
function deleteDept(){
	document.getElementById('homePage').action='/DeptCRUDServletHibernate/deleteDepartment';
	document.getElementById('homePage').method='post';
	document.getElementById('homePage').submit();
}