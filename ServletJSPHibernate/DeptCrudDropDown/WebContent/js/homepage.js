function createDept(){
	document.getElementById('homepage').action='/DeptCrudDropDown/createDept?action=loadCreatePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function updateDept(){
	document.getElementById('homepage').action='/DeptCrudDropDown/updateDept?action=loadUpdatePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function deleteDept(){
	document.getElementById('homepage').action='/DeptCrudDropDown/deleteDept?action=loadDeletePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function findDept(){
	document.getElementById('homepage').action='/DeptCrudDropDown/findDept?action=loadFindPage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function logout(){
	document.getElementById('homepage').action='/DeptCrudDropDown/logoutServlet';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}