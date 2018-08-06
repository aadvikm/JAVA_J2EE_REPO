function createDept(){
	document.getElementById('createpage').action = '/DeptCrudDropDown/createDept?action=newDeptPage';
	document.getElementById('createpage').method = 'post';
	document.getElementById('createpage').submit();
}


function goHome(){
	document.getElementById('createpage').action = '/DeptCrudDropDown/homePage';
	document.getElementById('createpage').method = 'post';
	document.getElementById('createpage').submit();
}

function getLocationManagers(elementObj){
	alert(elementObj.value);
	document.getElementById('createpage').action = '/DeptCrudDropDown/createDept?action=getLocationManagers&locationId='+elementObj.value;
	document.getElementById('createpage').method = 'post';
	document.getElementById('createpage').submit();
	
}