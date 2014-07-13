$(function() {
	var form = $("#passwdEdit"),
		submit = $(".button", form),
		successfulMsg = $(".message.successful"),
		errorMsg = $(".message.error"),
		loading = $(".loading"),
		id = $("#id", form),
		passwd = $("#password", form),
		repeatPasswd = $("#password_repeat", form),
		// password validation regex
		passValidator = /[\da-zA-Z@%$,.:;!?]{5,32}/;
		
	// enable tipsy
	var inputs = [passwd, repeatPasswd];
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
		
		// check password
		if(!passValidator.test(passwd.val())) {
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
			"id": id.val(),
			"password": passwd.val()
		};
		
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/user/edit/" + id.val() + "/password",
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