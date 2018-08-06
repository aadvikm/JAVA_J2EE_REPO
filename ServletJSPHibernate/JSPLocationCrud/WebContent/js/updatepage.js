function findLoc(){
	if(validate()){
		document.getElementById('updatepage').action = '/JSPLocationCrud/updateLocation?action=searchLocation';
		document.getElementById('updatepage').method = 'post';
		document.getElementById('updatepage').submit();
	}
}


function goHome(){
	document.getElementById('updatepage').action = '/JSPLocationCrud/homePage';
	document.getElementById('updatepage').method = 'get';
	document.getElementById('updatepage').submit();
}

function validate(){
	if(document.getElementById('locId').value==null||document.getElementById('locId').value.trim().length==0){
		alert('Please Enter a valid Location Id..!!');
		return false;
	}  
	return true;
}

function updateLoc(){
	document.getElementById('updatepage').action = '/JSPLocationCrud/updateLocation?action=updateLocation';
	document.getElementById('updatepage').method = 'post';
	document.getElementById('updatepage').submit();
}