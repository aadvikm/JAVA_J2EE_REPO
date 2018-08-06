function findLoc(){
	if(validate()){
		document.getElementById('findpage').action = '/LocationCRUDHibernate/searchedLocPage';
		document.getElementById('findpage').method = 'get';
		document.getElementById('findpage').submit();
	}
	
}


function goHome(){
	document.getElementById('findpage').action = '/LocationCRUDHibernate/homePage';
	document.getElementById('findpage').method = 'get';
	document.getElementById('findpage').submit();
}

function validate(){
	if(document.getElementById('locId').value==null||document.getElementById('locId').value.trim().length==0){
		alert('Please Enter a valid Location Id..!!');
		return false;
	}
	
	return true;
}