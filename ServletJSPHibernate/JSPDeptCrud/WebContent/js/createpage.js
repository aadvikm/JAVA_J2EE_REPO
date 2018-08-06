function createDept(){
	document.getElementById('createpage').action = '/JSPDeptCrud/createDept?action=newDeptPage';
	document.getElementById('createpage').method = 'post';
	document.getElementById('createpage').submit();
}


function goHome(){
	document.getElementById('createpage').action = '/JSPDeptCrud/homePage';
	document.getElementById('createpage').method = 'post';
	document.getElementById('createpage').submit();
}

function getLocationManagers(elementObj){
	alert(elementObj.id);
	alert(elementObj.value);
	alert(document.getElementById('locationId').value);
	document.getElementById('createpage').action = '/JSPDeptCrud/createDept?action=getLocationManagers&locationId='+elementObj.value;
	document.getElementById('createpage').method = 'post';
	document.getElementById('createpage').submit();
	
}