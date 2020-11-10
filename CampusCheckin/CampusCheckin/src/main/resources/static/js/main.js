/**
 * 
 */

function validate() {
	var name = document.getElementById("name").value;
	var studentID = document.getElementById("studentID").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	if (name == '') {
		alert('Please enter a valid name.');
		return false;
	} else if (studentID == '') {
		alert('Please enter a valid name.');
		return false;
	} else if (email == '') {
		alert('Please enter a valid name.');
		return false;
	}
	else if (password == '') {
		alert('Please enter a valid name.');
		return false;
	}
	else {
		return true;
	}
	
	
}

function postUsers() {
	var name = document.getElementById("name").value;
	var studentID = document.getElementById("studentID").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	fetch('/users' , {method: 'POST', body: {"name":`${name}`,"studentID":`${studentID}`,"email":`${email}`,"password":`${password}`}})
		.then(results => results.json()).then(console.log)
}

function test() {
	console.log("working")
}