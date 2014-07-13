$(function() {
	var form = $("#userEdit"),
		submit = $(".button", form),
		successfulMsg = $(".message.successful"),
		errorMsg = $(".message.error"),
		loading = $(".loading"),
		id = $("#id", form),
		firstName = $("#firstName", form),
		lastName = $("#lastName", form),
		email = $("#email", form),
		role = $("select", form),
		// email validation regex
		emailValidator = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		
	// enable tipsy
	var inputs = [firstName, lastName, email];
	$.each(inputs, function(key, value) {
		value.tipsy({trigger: "manual", gravity: "w"});
	});
	
	// wait for submit event
	submit.bind("click", function(e) {
		var error = false;
		
		// hide messages 
		$.each([successfulMsg, errorMsg], function(key, value) {
			$(value).addClass("hidden");
		});
		// hide tipsy
		$.each(inputs, function(key, value) {
			$(value).tipsy("hide");
		});
		
		// check first name
		if(firstName.val().length < 2 || firstName.val().length > 30) {
			firstName.tipsy("show");
			error = true;
		}
		// check last name
		else if(lastName.val().length < 2 || lastName.val().length > 30) {
			lastName.tipsy("show");
			error = true;
		}
		// check if email is invalid
		else if(!emailValidator.test(email.val())) {
			email.tipsy("show");
			error = true;
		}
		
		if(error) return;
		
		// show preloader
		loading.removeClass("hidden");
		
		// build post-body
		var body = {
			"id": id.val(),
			"firstName": firstName.val(),
			"lastName": lastName.val(),
			"email": email.val(),
			"role": role.val()
		};
		
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/user/edit/" + id.val(),
			type: "post",
			dataType: "json",
			data: JSON.stringify(body),
			contentType: "application/json",
		    mimeType: "application/json",
		    complete: function(jqXHR, textStatus) {
		    	switch (jqXHR.status) {
			        case 200:
			            successfulMsg.removeClass("hidden");
			            break;
			        default:
			            errorMsg.removeClass("hidden");
			    }
		    	// hide preloader
		    	loading.addClass("hidden");
		    }
		});
	});
});