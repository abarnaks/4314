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