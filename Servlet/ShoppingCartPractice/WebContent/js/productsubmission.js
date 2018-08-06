function resetForm(){

var penQuantitySelectDropdown = document.getElementById('penQuantity');
penQuantitySelectDropdown.options.selectedIndex=0;
document.getElementById('penPrice').value='';

var pencilQuantitySelectDropdown = document.getElementById('pencilQuantity');
pencilQuantitySelectDropdown.options.selectedIndex=1;
document.getElementById('pencilPrice').value='';

var eraserQuantitySelectDropdown = document.getElementById('eraserQuantity');
eraserQuantitySelectDropdown.options.selectedIndex=0;
document.getElementById('eraserPrice').value='';

var eraserQuantitySelectDropdown = document.getElementById('colorpenQuantity');
eraserQuantitySelectDropdown.options.selectedIndex=0;
document.getElementById('colorpenPrice').value='';

}

function validate(){
if(document.getElementById('penPrice').value == null || document.getElementById('penPrice').value.trim().length == 0 || isNaN(document.getElementById('penPrice').value)){
alert('Please enter valid value for Pen Price.');
return false;
}
if(document.getElementById('pencilPrice').value == null || document.getElementById('pencilPrice').value.trim().length == 0 || isNaN(document.getElementById('pencilPrice').value)){
alert('Please enter valid value for Pencil Price.');
return false;
}
if(document.getElementById('eraserPrice').value == null || document.getElementById('eraserPrice').value.trim().length == 0 || isNaN(document.getElementById('eraserPrice').value)){
alert('Please enter valid value for Eraser Price.');
return false;
}
if(document.getElementById('colorpenPrice').value == null || document.getElementById('colorpenPrice').value.trim().length == 0 || isNaN(document.getElementById('colorpenPrice').value)){
	alert('Please enter valid value for ColorPen Price.');
	return false;
}
return true;
}

function validateAndSubmit(){
if(validate()){
	document.getElementById('productSubmissionForm').submit();
}
}