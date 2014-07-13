$(function() {
	var form = $("#userSearch"),
		submit = $(".button", form),
		errorMsg = $(".message.error"),
		loading = $(".loading"),
		firstName = $("#firstName", form),
		lastName = $("#lastName", form),
		email = $("#email", form),
		results = $("#results"),
		role = $("#role", form);
	
	// wait for submit event
	submit.bind("click", function(e) {
		var error = false;
		
		// hide message
		errorMsg.addClass("hidden");
		// hide table
		results.addClass("hidden");
		// show preloader
		loading.removeClass("hidden");
		
		// build post-body
		var body = {
			"firstName": firstName.val(),
			"lastName": lastName.val(),
			"email": email.val()
		};
		// add role
		if(role.val() != "") {
			body.role = role.val();
		}
		
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/user/search",
			type: "post",
			dataType: "json",
			data: JSON.stringify(body),
			contentType: "application/json",
		    mimeType: "application/json",
		    success: function(data) {
		    	if(data.length == 0) {
		    		errorMsg.removeClass("hidden");
		    		results.addClass("hidden");
		    	} else {
		    		results.removeClass("hidden");
		    		var body = $("tbody", results).html("");
		    		for(i in data) {
		    			var user = data[i];
		    			body.append("<tr>"
		    					+ "<td><a href=\"/IssueTracker/user/" + user.id +  "\">" + user.id + "</td>"
		    					+ "<td>" + user.firstName + "</td>"
		    					+ "<td>" + user.lastName + "</td>"
		    					+ "<td>" + user.email + "</td>"
		    					+ "</tr>");
		    		}
		    	}
		    },
		    complete: function(jqXHR, textStatus) {
		    	if(jqXHR.status != 200) {
		            errorMsg.removeClass("hidden");
		            results.addClass("hidden");
			    }
		    	// hide preloader
		    	loading.addClass("hidden");
		    }
		});
	});
});