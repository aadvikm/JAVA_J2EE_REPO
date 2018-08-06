function resetForm(){

var penQuantitySelectDropdown = document.getElementById('penQuantity');
penQuantitySelectDropdown.options.selectedIndex=0;
var check1 =document.getElementById('checkbox1');
check1.checked=false;

var pencilQuantitySelectDropdown = document.getElementById('pencilQuantity');
pencilQuantitySelectDropdown.options.selectedIndex=1;
var check2 =document.getElementById('checkbox2');
check2.checked=false;


var eraserQuantitySelectDropdown = document.getElementById('eraserQuantity');
eraserQuantitySelectDropdown.options.selectedIndex=2;
var check3 =document.getElementById('checkbox3');
check3.checked=false;
}



function validateAndSubmit(){	
	if(validate()){
		document.getElementById('productpage').action='/StationaryPurchase/submitProduct';
		document.getElementById('productpage').method='post';
		document.getElementById('productpage').submit();
	}
	
}

function validate(){
	var check1 =document.getElementById('checkbox1');
	var check2 =document.getElementById('checkbox2');
	var check3 =document.getElementById('checkbox3');
	if(check1.checked ==true ||check2.checked ==true ||check3.checked==true){
		return true;
	}
	else{
		alert('Please select any products to proceed further..!!');
		return false;
	}
		
	
}

function logout(){
	document.getElementById('productpage').action='/StationaryPurchase/logoutServlet';
	document.getElementById('productpage').method='post';
	document.getElementById('productpage').submit();
}

