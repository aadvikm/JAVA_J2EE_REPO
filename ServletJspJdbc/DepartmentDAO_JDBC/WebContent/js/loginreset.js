function resetForm() {
	alert('Reseting..!!');
	document.getElementById('username').value='';
	document.getElementById('password').value='';

}

function validate() {
	if (document.getElementById('username').value == null || document.getElementById('username').value.trim().length == 0) {
		alert('Please enter valid username.');
		return false;
	}

	if (document.getElementById('password').value == null || document.getElementById('password').value.trim().length == 0)  {
		alert('Please enter valid password.');
		return false;
	}
	return true;
}


function validateAndSubmit() {
	if (validate()) {
		document.getElementById('loginreset').submit();
	}
}

