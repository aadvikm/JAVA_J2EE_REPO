function createDept(){
	document.getElementById('homepage').action='/CreateUpdateDeptDropDown/createDept?action=loadCreatePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function updateDept(){
	document.getElementById('homepage').action='/CreateUpdateDeptDropDown/updateDept?action=loadUpdatePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}

function logout(){
	document.getElementById('homepage').action='/CreateUpdateDeptDropDown/logoutServlet';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}