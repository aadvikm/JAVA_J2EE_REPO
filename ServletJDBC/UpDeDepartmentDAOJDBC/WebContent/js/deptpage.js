function updateDept() {
	document.getElementById('deptpage').action = '/UpDeDepartmentDAOJDBC/updatePage';
	document.getElementById('deptpage').method = 'post';
	document.getElementById('deptpage').submit();

}

function deleteDept() {
	document.getElementById('deptpage').action = '/UpDeDepartmentDAOJDBC/deletePage';
	document.getElementById('deptpage').method = 'post';
	document.getElementById('deptpage').submit();

}

function logout() {
	document.getElementById('deptpage').action = '/UpDeDepartmentDAOJDBC/logoutServlet';
	document.getElementById('deptpage').method = 'post';
	document.getElementById('deptpage').submit();

}
