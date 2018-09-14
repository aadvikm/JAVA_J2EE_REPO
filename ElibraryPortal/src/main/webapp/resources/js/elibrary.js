function loginFunction(){
		var menu = _.template($('#loginMenuContainerTemp').html());
		$('#menuContainer').html(menu());
		var main = _.template($('#loginMainContainerTemp').html());
		$('#mainContainer').html(main());
		
}

function adminLogin(){
	if( $('#adminId').val() == undefined || $('#adminId').val() == null || $('#adminId').val() == ''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild AdminId. Please Enter valid Value.'}));
		return;
	}
	if( $('#password1').val() == undefined || $('#password1').val() == null || $('#password1').val() == ''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild Password. Please Enter valid Value.'}));
		return;
	}
	
	$.ajax ({
		'url' : './authenticateAdmin?adminId='+$('#adminId').val()+'&password='+ $('#password1').val(),
		'type' : 'POST',
		'success' : function(resultData){
			if(resultData != null && resultData.role == "Admin"){
				var adminMenu =_.template($('#adminMenuTemp').html());
				$('#menuContainer').html(adminMenu());
				var adminMain =_.template($('#adminMainTemp').html());
				$('#mainContainer').html(adminMain());
			}
		},
		
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
		
	});
}


function addLibrarianForm(){
	var addLibTemp =_.template($('#addLibrarianTemp').html());
	$('#mainContainer').html(addLibTemp({librarianDetail : ''}));
}

function addLibrarian(){
alert('hi');
	if(validateAddLibrarianForm()){
		var formData = {
			librarianUserId: $('#librarianUserId').val(),
			name : $('#name2').val(),
			emailId : $('#email2').val(),
			password :$('#password2').val(),
			mobileNo :$('#mobile2').val(),
		};
	
		
		$.ajax({
			'url'  : './addLibrarian',
			'type' : 'POST',
			'data' : JSON.stringify(formData),
			'headers' : { 
				'Accept': 'application/json',
				'Content-Type': 'application/json' 
			},
			'success' :function(resultData) {
				console.log(JSON.stringify(resultData));
				if (JSON.stringify(resultData).indexOf(
						"Exception Occurred.") != -1) {
					var ErrorTemplate = _.template($('#errMsgTempl').html());
					$('#msgDiv').html(ErrorTemplate({msg : resultData}));
				} else {
					var addLibTemp =_.template($("#addLibrarianTemp").html());
					$('#mainContainer').html(addLibTemp({librarianDetail :JSON.parse(resultData.jsonData)}));
					var InfoTemplate = _.template($("#infoMsgTempl").html());
					$("#msgDiv").html(InfoTemplate({msg : 'Librarian Added  successfully.'}));
				}
			},
				
			'error' : function(request, error) {
				alert('Request: ' + request);
				alert('Error: ' + error);
			}
		});
	}
}

function viewLibrarian(){
	$.ajax({
			'url' : './getAllLibrarians',
			'type' : 'GET',
			'success' : function(resultData) {
				console.log(JSON.stringify(resultData));
				if(resultData.errorMessage != null){
					var compiledErrorTemplate = _.template($('#errMsgTempl').html());
					$('#msgDiv').html(compiledErrorTemplate({
						msg : resultData.errorMessage
					}));
				}
				else{
					var listLibrarianTemplate =_.template($("#listLibrarianTemplate").html());
					$('#mainContainer').html(listLibrarianTemplate());
					var table = $('#librariansList').DataTable({
					  data: resultData.jsonObject,
					  columns: [
						{ "title": "Librarian User Id", "data" : "librarianUserId" },
						{ "title": "Librarian Name", "data" : "name" },
						{ "title": "Email", "data" : "emailId" },
						{ "title": "Mobile No", "data" : "mobileNo"},
						{ "title": "Edit", "data": null,
							"defaultContent": "<button type='button' id='editBtn' class='btn btn-primary btn-sm'><span class='glyphicon glyphicon-edit'></span> Edit</button>"
						},
						{ "title": "Delete", "data": null,
							"defaultContent": "<button type='button' id='deleteBtn' class='btn btn-danger btn-sm'><span class='glyphicon glyphicon-trash'> Delete</button>"
						}
					  ]
					 });
					  $('#librariansList tbody').on( 'click', 'button', function () {
					  	if(this.id);
						var data = table.row( $(this).parents('tr') ).data();
						if(this.id == 'editBtn'){
							editLibrarian(data.librarianId);
						}
						else if(this.id == 'deleteBtn'){
							deleteLibrarian(data.librarianId);
						}
					} );
				}
			},
			'error' : function(request, error) {
				alert('Request: ' + request);
				alert('Error: ' + error);
			}
		});
}
function editLibrarian(librarianId){
alert('edit librarian - '+librarianId);

	$.ajax({
		'url' :'./editLibrarian?librarianId=' +librarianId,
		'type' : 'POST',
		
		'headers' : { 
			'Accept': 'application/json',
			'Content-Type': 'application/json' 
		},
		'success' :function(resultData) {
			console.log(JSON.stringify(resultData));
			if (JSON.stringify(resultData).indexOf(
					"Exception Occurred.") != -1) {
				var ErrorTemplate = _.template($('#errMsgTempl').html());
				$('#msgDiv').html(ErrorTemplate({msg : resultData}));
			} else {
				var editLibTemp =_.template($("#editLibrarianTemplate").html());
				$('#mainContainer').html(editLibTemp({librarianDetail :resultData.jsonObject}));
				$("#updateBtn").click(function() {
					updateLibrarian();
				});
			}
		},
		
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
	});
}
function deleteLibrarian(librarianId){
alert('deleteLibrarian - '+librarianId);

	$.ajax({
		'url' :'./deleteLibrarian?librarianId='+librarianId,
		'type' :'POST',
		'headers' : { 
			'Accept': 'application/json',
			'Content-Type': 'application/json' 
		},
		'success' :function(resultData) {
				if (JSON.stringify(resultData).indexOf("Exception Occurred.") != -1) {
					var compiledErrorTemplate = _.template($('#errMsgTempl').html());
					$('#msgDiv').html(compiledErrorTemplate({msg : resultData}));
				} else {
					var compiledInfoTemplate = _.template($("#infoMsgTempl").html());
					$("#msgDiv").html(compiledInfoTemplate({msg : 'Librarian Detail deleted successfully.'}));
				}
		},
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
	});
}

function updateLibrarian(){
	if(validateEditLibrarianForm()){
		var formData = {
			librarianId : $('#librarianId3').val(),
			librarianUserId: $('#librarianUserId3').val(),
			name : $('#name3').val(),
			emailId : $('#email3').val(),
			password :$('#password3').val(),
			mobileNo :$('#mobile3').val()
		};
		$.ajax({
			'url'  : './updateLibrarian',
			'type' : 'POST',
			'data' : JSON.stringify(formData),
			'headers' : { 
				'Accept': 'application/json',
				'Content-Type': 'application/json' 
			},
			'success' :function(resultData) {
				console.log(JSON.stringify(resultData));
				if (JSON.stringify(resultData).indexOf(
						"Exception Occurred.") != -1) {
					var ErrorTemplate = _.template($('#errMsgTempl').html());
					$('#msgDiv').html(ErrorTemplate({msg : resultData}));
				} else {
					var editLibTemp =_.template($("#editLibrarianTemplate").html());
					$('#mainContainer').html(editLibTemp({librarianDetail :resultData.jsonObject}));
					var InfoTemplate = _.template($("#infoMsgTempl").html());
					$("#msgDiv").html(InfoTemplate({msg : 'Librarian updated  successfully.'}));
				}
			},
				
			'error' : function(request, error) {
				alert('Request: ' + request);
				alert('Error: ' + error);
			}
		});
	}
}
function validateEditLibrarianForm(){
	if($('#librarianUserId3').val() ==undefined || $('#librarianUserId3').val() == null  || $('#librarianUserId3').val().trim().length ==0){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild librarianUserId. Please Enter valid Value.'}));
		return false;
	}
	if($('#name3').val() == undefined || $('#name3').val() == null  || $('#name3').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild Name. Please Enter valid Value.'}));
		return false;
	}
	if($('#email3').val() == undefined || $('#email3').val() == null  || $('#email3').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild emailId. Please Enter valid Value.'}));
		return false;
	}
	if($('#password3').val() == undefined || $('#password3').val() == null  || $('#password3').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild password. Please Enter valid Value.'}));
		return false;
	}
	if($('#mobile3').val() == undefined || $('#mobile3').val() == null  || $('#mobile3').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild mobileNo. Please Enter valid Value.'}));
		return false;
	}
	return true;
}


function validateAddLibrarianForm(){
	if($('#librarianUserId').val() ==undefined || $('#librarianUserId').val() == null  || $('#librarianUserId').val().trim().length ==0){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild librarianUserId. Please Enter valid Value.'}));
		return false;
	}
	if($('#name2').val() == undefined || $('#name2').val() == null  || $('#name2').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild Name. Please Enter valid Value.'}));
		return false;
	}
	if($('#email2').val() == undefined || $('#email2').val() == null  || $('#email2').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild emailId. Please Enter valid Value.'}));
		return false;
	}
	if($('#password2').val() == undefined || $('#password2').val() == null  || $('#password2').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild password. Please Enter valid Value.'}));
		return false;
	}
	if($('#mobile2').val() == undefined || $('#mobile2').val() == null  || $('#mobile2').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild mobileNo. Please Enter valid Value.'}));
		return false;
	}
	return true;
}

function logout(){
	$.ajax({
		'url' :'./logout',
		'type':'GET',
		'success': function(resultData) {
			var menu = _.template($('#loginMenuContainerTemp').html());
			$('#menuContainer').html(menu());
			var main = _.template($('#loginMainContainerTemp').html());
			$('#mainContainer').html(main());
		},
		
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
	});
}


function librarianLogin(){
	if($('#librarianId').val() == null || $('#librarianId').val() == ''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild librarianId. Please Enter valid Value.'}));
		return;
	}
	if($('#librarayPassword').val() == null || $('#librarayPassword').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild Password. Please Enter valid Value.'}));
		return;
	}
	$.ajax ({
		'url' : './authenticateLibrarian?librarianId='+$('#librarianId').val()+'&password='+ $('#librarayPassword').val(),
		'type' : 'POST',
		'success' : function(resultData){
			if(resultData.jsonObject != null && resultData.jsonObject.role == "Librarian"){
				var adminMenu =_.template($('#librarianMenuTempl').html());
				$('#menuContainer').html(adminMenu());
				var adminMain =_.template($('#librarianMainTempl').html());
				$('#mainContainer').html(adminMain());
			}
		},
		
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
		
	});
}


function addBookForm(){
	var addBookTemp =_.template($('#addBookFormTemplate').html());
	$('#mainContainer').html(addBookTemp());

}

function saveBook(){
	if(validateAddBookForm()){
		
		var data = {};
		data['callNo'] = $('#callno1').val();
		data['bookName'] = $('#name1').val();
		data['authorName'] = $('#author1').val();
		data['publisher'] = $('#publisher1').val();
		data['quantity'] = $('#quantity1').val();

		$.ajax({
			'type' : 'POST',
			'url'  : './addBook',
			'data': JSON.stringify(data),
			 'dataType': 'json',
			 'traditional': 'true',
			'contentType': "application/json",
   
			'success' :function(resultData) {
				console.log(JSON.stringify(resultData));
				if (JSON.stringify(resultData).indexOf(
						"Exception Occurred.") != -1) {
					var ErrorTemplate = _.template($('#errMsgTempl').html());
					$('#msgDiv').html(ErrorTemplate({msg : resultData}));
				} else {
					var addBookTemp =_.template($("#addBookFormTemplate").html());
					$('#mainContainer').html(addBookTemp({bookDetail :JSON.parse(resultData.jsonData)}));
					var InfoTemplate = _.template($("#infoMsgTempl").html());
					$("#msgDiv").html(InfoTemplate({msg : 'Book Added  successfully.'}));
				}
			},
				
			'error' : function(request, error) {
				alert('Request: ' + request);
				alert('Error: ' + error);
			}
		});
	}
}



function validateAddBookForm(){
	if($('#callno1').val() ==undefined || $('#callno1').val() == null  || $('#callno1').val().trim().length ==0){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild callno. Please Enter valid Value.'}));
		return false;
	}
	if($('#name1').val() == undefined || $('#name1').val() == null  || $('#name1').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild Name. Please Enter valid Value.'}));
		return false;
	}
	if($('#author1').val() == undefined || $('#author1').val() == null  || $('#author1').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild author. Please Enter valid Value.'}));
		return false;
	}
	if($('#publisher1').val() == undefined || $('#publisher1').val() == null  || $('#publisher1').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild publisher. Please Enter valid Value.'}));
		return false;
	}
	if($('#quantity1').val() == undefined || $('#quantity1').val() == null  || $('#quantity1').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild quantity. Please Enter valid Value.'}));
		return false;
	}
	return true;
}


function viewBook(){
		$.ajax({
				'url' : './getAllBooks',
				'type' : 'GET',
				'success' : function(resultData) {
					console.log(JSON.stringify(resultData));
					if(resultData.errorMessage != null){
						var compiledErrorTemplate = _.template($('#errMsgTempl').html());
						$('#msgDiv').html(compiledErrorTemplate({
							msg : resultData.errorMessage
						}));
					}
					else{
						var listBookTemplate =_.template($("#listBookTemplate").html());
						$('#mainContainer').html(listBookTemplate());
						var table = $('#bookList').DataTable({
						  data: resultData.jsonObject,
						  columns: [
							{ "title": "CallNo", "data" : "callNo" },
							{ "title": "Book Name", "data" : "bookName" },
							{ "title": "Author Name", "data" : "authorName" },
							{ "title": "Publisher", "data" : "publisher"},
							{ "title": "Quantity", "data": "quantity"},
							{ "title": "Issued", "data": "issued"},
							{ "title": "Remaining", "data": "remaining"},
							{ "title": "Delete", "data": null,
								"defaultContent": "<button type='button' id='deleteBtn' class='btn btn-danger btn-sm'><span class='glyphicon glyphicon-trash'> Delete</button>"
							}
						  ]
						 });
						  $('#bookList tbody').on( 'click', 'button', function () {
						  	if(this.id);
							var data = table.row( $(this).parents('tr') ).data();
							if(this.id == 'deleteBtn'){
								deleteBook(data.bookId);
							}
						});
					}
				},
				'error' : function(request, error) {
					alert('Request: ' + request);
					alert('Error: ' + error);
				}
			});
}



function deleteBook(bookId){
alert('deleteBook - '+bookId);

	$.ajax({
		'url' :'./deleteBook?bookId='+bookId,
		'type' :'POST',
		'headers' : { 
			'Accept': 'application/json',
			'Content-Type': 'application/json' 
		},
		'success' :function(resultData) {
				if ((resultData.jsonData) ==null) {
					var compiledErrorTemplate = _.template($('#errMsgTempl').html());
					$('#msgDiv').html(compiledErrorTemplate({msg : resultData.errorMessage}));
				} else {
					var compiledInfoTemplate = _.template($("#infoMsgTempl").html());
					$("#msgDiv").html(compiledInfoTemplate({msg : 'Book Detail deleted successfully.'}));
				}
		},
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
	});
}

function issueBookForm(){
	$.ajax({
		'url' : './getBookAndStudentList',
		'type' : 'GET',
		'success' :function(result) {
		console.log(JSON.stringify(result));
				if ((result.errorMessage) !=null) {
					var compiledErrorTemplate = _.template($('#errMsgTempl').html());
					$('#msgDiv').html(compiledErrorTemplate({msg : result.errorMessage}));
				} else {
					var issuBookTemp =_.template($("#issueBookFormTemp").html());
					$('#mainContainer').html(issuBookTemp());
					$("#bookId").empty();
					$("#bookId").append('<option value=\'\'></option>');
					alert(JSON.stringify(result));
					console.log(result);
					var issueBookDetail =result.jsonObject.bookDetail;
					$.each(issueBookDetail, function(index, bookDetail){
						console.log(index+'----'+bookDetail.callNo);
						$('#bookId').append('<option value='+bookDetail.bookId+'>'+bookDetail.bookName+'</option>');
					});
					
					$("#studentId").empty();
					$("#studentId").append('<option value=\'\'></option>');
					alert(JSON.stringify(result));
					console.log(result);
					var issueStudentDetail =result.jsonObject.studentDetail;
					$.each(issueStudentDetail, function(index, studentDetail){
						console.log(index+'----'+studentDetail.studentId);
						$('#studentId').append('<option value='+studentDetail.studentId+'>'+studentDetail.name+'</option>');
					});
				}
	},
	'error' : function(request, error) {
		alert('Request: ' + request);
		alert('Error: ' + error);
	}
	});
}

function issueBook(){
	
	if(validateIssueBookForm()){
		
		var studentId = $('#studentId').val();
		var bookId = $('#bookId').val();
		
		$.ajax({
			'url'  : './saveStudentBookDetail?studentId='+studentId+'&bookId='+bookId,
			'type' :'POST',
			'headers' : { 
				'Accept': 'application/json',
				'Content-Type': 'application/json' 
			},
   
			'success' :function(resultData) {
				console.log(JSON.stringify(resultData));
				if ((resultData.errorMessage) !=null) {
					var compiledErrorTemplate = _.template($('#errMsgTempl').html());
					$('#msgDiv').html(compiledErrorTemplate({msg : resultData.errorMessage}));
				} else {
					var issuBookTemp =_.template($("#issueBookFormTemp").html());
					$('#mainContainer').html(issuBookTemp({studentDetail :JSON.parse(resultData.jsonData)}));
					var InfoTemplate = _.template($("#infoMsgTempl").html());
					$("#msgDiv").html(InfoTemplate({msg : 'Book issued successfully.'}));
				}
			},
				
			'error' : function(request, error) {
				alert('Request: ' + request);
				alert('Error: ' + error);
			}
		});

	}
}

function validateIssueBookForm(){

	if($('#studentname').val() == undefined || $('#studentname').val() == null  || $('#studentname').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild studentname. Please Enter valid Value.'}));
		return false;
	}
	if($('#mobileNo3').val() == undefined || $('#mobileNo3').val() == null  || $('#mobileNo3').val() ==''){
		var errMsg =_.template($('#errMsgTempl').html());
		$('#msgDiv').html(errMsg({'msg': 'Invaild MobileNo. Please Enter valid Value.'}));
		return false;
	}

	return true;
}


function viewIssuedBook(){
	$.ajax({
		'url' : './getAllIssuedBooks',
		'type' : 'GET',
		'success' : function(resultData) {
			console.log(JSON.stringify(resultData));
			if(resultData.errorMessage != null){
				var compiledErrorTemplate = _.template($('#errMsgTempl').html());
				$('#msgDiv').html(compiledErrorTemplate({
					msg : resultData.errorMessage
				}));
			}
			else{
				var listBookTemplate =_.template($("#viewIssuedBookTemp").html());
				$('#mainContainer').html(listBookTemplate());
				var table = $('#issuedBookList').DataTable({
				  data: resultData.jsonObject,
				  columns: [
					{ "title": "CallNo", "data" : "callNo" },
					{ "title": "Student UserId", "data" : "studentUserId" },
					{ "title": "Student Name", "data" : "studentName" },
					{ "title": "Mobile", "data" : "mobileNo"},
					{ "title": "Issued Date", "data": "issueDateAsString"},
					{ "title": "Return Status", "data": "returnStatus"},
					{ "title": "Return", "data": null,
						"defaultContent": "<button type='button' id='returnBtn' class='btn btn-danger btn-sm'><span class='glyphicon glyphicon-trash'> ReturnBook</button>"
					}
				  ]
				 });
				  $('#issuedBookList tbody').on( 'click', 'button', function () {
				  	if(this.id);
					var data = table.row( $(this).parents('tr') ).data();
					if(this.id == 'returnBtn'){
						returnBookForm(data.studentBookId);
					}
				});
			}
		},
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
	});
}


function returnBookForm(studentBookId){
	$.ajax({
		'url' :'./returnBookForm?studentBookId='+studentBookId,
		'type' :'GET',
		'headers' : { 
			'Accept': 'application/json',
			'Content-Type': 'application/json' 
		},
		'success' :function(resultData) {
				if ((resultData.errorMessage) !=null) {
					var compiledErrorTemplate = _.template($('#errMsgTempl').html());
					$('#msgDiv').html(compiledErrorTemplate({msg : resultData.errorMessage}));
				} else {
					var returnBookTemp =_.template($("#returnBookTemp").html());
					$('#mainContainer').html(returnBookTemp({returnBook :resultData.jsonObject}));
				}
		},
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
	});
}

function returningBook(){
	$.ajax({
		'url' :'./returningBook?studentBookId='+$('#studentBookId').val(),
		'type' :'POST',
		'headers' : { 
			'Accept': 'application/json',
			'Content-Type': 'application/json' 
		},
		'success' :function(resultData) {
				if ((resultData.errorMessage) !=null) {
					var compiledErrorTemplate = _.template($('#errMsgTempl').html());
					$('#msgDiv').html(compiledErrorTemplate({msg : resultData.errorMessage}));
				} else {
					var compiledInfoTemplate = _.template($("#infoMsgTempl").html());
					$("#msgDiv").html(compiledInfoTemplate({msg : 'Book returned successfully.'}));
				}
		},
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
	});
}