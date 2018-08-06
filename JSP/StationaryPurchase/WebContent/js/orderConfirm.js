function logout(){
	document.getElementById('orderConfirm').action='/StationaryPurchase/logoutServlet';
	document.getElementById('orderConfirm').method='post';
	document.getElementById('orderConfirm').submit();
}