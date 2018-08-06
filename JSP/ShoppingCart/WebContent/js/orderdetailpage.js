function logout(){
	document.getElementById('orderdetailpage').action='/ShoppingCart/logoutServlet';
	document.getElementById('orderdetailpage').method='post';
	document.getElementById('orderdetailpage').submit();
}

function buy(){
	document.getElementById('orderdetailpage').action='/ShoppingCart/orderConfirm';
	document.getElementById('orderdetailpage').method='post';
	document.getElementById('orderdetailpage').submit();
}
