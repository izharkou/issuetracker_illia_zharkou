$(function() {
	var form = $("#projectAdd"),
		submit = $(".button", form),
		successfulMsg = $(".message.successful"),
		errorMsg = $(".message.error"),
		loading = $(".loading"),
		name = $("#name", form),
		description = $("#description", form),
		manager = $("#manager", form),
		build = $("#build", form);
		
	// enable tipsy
	var inputs = [name, description, build];
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
		
		// check name
		if(name.val().length < 2 || name.val().length > 30) {
			name.tipsy("show");
			error = true;
		}
		// check description
		else if(description.val().length < 10) {
			description.tipsy("show");
			error = true;
		}
		// check build
		else if(build.val().length < 2 || build.val().length > 30) {
			build.tipsy("show");
			error = true;
		}
		
		if(error) return;
		
		// show preloader
		loading.removeClass("hidden");
		
		// build post-body
		var body = {
			"name": name.val(),
			"description": description.val(),
			"manager": {"id": manager.val()},
			"builds": [{"version": build.val(), "current": true}]
		};
		
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/project/add",
			type: "post",
			dataType: "json",
			data: JSON.stringify(body),
			contentType: "application/json",
		    mimeType: "application/json",
		    complete: function(jqXHR, textStatus) {
		    	switch (jqXHR.status) {
			        case 200:
			            successfulMsg.removeClass("hidden");
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