function logout(){
	document.getElementById('orderDetailPage').action='/StationaryPurchase/logoutServlet';
	document.getElementById('orderDetailPage').method='post';
	document.getElementById('orderDetailPage').submit();
}

function buy(){
	document.getElementById('orderDetailPage').action='/StationaryPurchase/orderConfirm';
	document.getElementById('orderDetailPage').method='post';
	document.getElementById('orderDetailPage').submit();
}

function goBack(){
	document.getElementById('orderDetailPage').action='/StationaryPurchase/goBack';
	document.getElementById('orderDetailPage').method='get';
	document.getElementById('orderDetailPage').submit();
}