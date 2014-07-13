$(function() {
	var form = $("#userAdd"),
		submit = $(".button", form),
		successfulMsg = $(".message.successful"),
		errorMsg = $(".message.error"),
		loading = $(".loading"),
		firstName = $("#firstName", form),
		lastName = $("#lastName", form),
		email = $("#email", form),
		role = $("select", form),
		passwd = $("#password", form),
		repeatPasswd = $("#password_repeat", form),
		// email validation regex
		emailValidator = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/,
		passValidator = /[\da-zA-Z@%$,.:;!?]{5,32}/;
		
	// enable tipsy
	var inputs = [firstName, lastName, email, passwd, repeatPasswd];
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
		// check password
		else if(!passValidator.test(passwd.val())) {
			passwd.tipsy("show");
			error = true;
		}
		// check repeat password field
		else if(repeatPasswd.val() != passwd.val()) {
			repeatPasswd.tipsy("show");
			error = true;
		}
		
		if(error) return;
		
		// show preloader
		loading.removeClass("hidden");
		
		// build post-body
		var body = {
			"firstName": firstName.val(),
			"lastName": lastName.val(),
			"email": email.val(),
			"role": role.val(),
			"password": passwd.val()
		};
		
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/user/add",
			type: "post",
			dataType: "json",
			data: JSON.stringify(body),
			contentType: "application/json",
		    mimeType: "application/json",
		    complete: function(jqXHR, textStatus) {
		    	switch (jqXHR.status) {
			        case 200:
			            successfulMsg.removeClass("hidden");
			            // clear inputs
			            $.each(inputs, function(key, value) {
			        		$(value).val("");
			        	});
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