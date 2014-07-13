$.fn.Login = function() {
	var form = $(this),
		email = $("#email", form),
		passwd = $("#passwd", form),
		// regex for validate email
		validator = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	// enable tipsy
	var inputs = [email, passwd];
	$.each(inputs, function(key, value) {
		value.tipsy({trigger: "manual", gravity: "n"});
	});
	
	// wait for submit event
	form.bind("submit", function(e) {
		var error = false;
		
		// hide tipsy
		$.each(inputs, function(key, value) {
			$(value).tipsy("hide");
		});
		
		// check if email is incorrect
		if(!validator.test(email.val())) {
			email.tipsy("show");
			error = true;
		}
		// check if password is empty
		else if(passwd.val().length == 0) {
			passwd.tipsy("show");
			error = true;
		}
		
		// if we got some error..
		// need to prevent submit
		if(error) {
			e.preventDefault();
			return false;
		}
		return true;
	});
};

$(function() {
	// enable login form
	$("#login").Login();
});