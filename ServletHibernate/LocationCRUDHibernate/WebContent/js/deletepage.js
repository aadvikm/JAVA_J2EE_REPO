function findLoc(){
	if(validate()){
		document.getElementById('deletepage').action = '/LocationCRUDHibernate/deletingLocation';
		document.getElementById('deletepage').method = 'post';
		document.getElementById('deletepage').submit();
	}
	
}


function goHome(){
	document.getElementById('deletepage').action = '/LocationCRUDHibernate/homePage';
	document.getElementById('deletepage').method = 'get';
	document.getElementById('deletepage').submit();
}

function validate(){
	if(document.getElementById('locId').value==null||document.getElementById('locId').value.trim().length==0){
		alert('Please Enter a valid Location Id..!!');
		return false;
	}
	
	return true;
}

function deleteLoc(){
	document.getElementById('deletepage').action = '/LocationCRUDHibernate/deletedLocationPage';
	document.getElementById('deletepage').method = 'get';
	document.getElementById('deletepage').submit();
}