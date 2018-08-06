function logout(){
	document.getElementById('orderconfirm').action='/ShoppingCart/logoutServlet';
	document.getElementById('orderconfirm').method='post';
	document.getElementById('orderconfirm').submit();
}