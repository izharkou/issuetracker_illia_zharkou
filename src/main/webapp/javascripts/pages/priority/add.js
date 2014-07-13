$(function() {
	var form = $("#priorityEdit"),
		submit = $(".button", form),
		successfulMsg = $(".message.successful"),
		errorMsg = $(".message.error"),
		loading = $(".loading"),
		name = $("#name", form);
	
	// enable tipsy
	name.tipsy({trigger: "manual", gravity: "w"});
	
	// wait for submit event
	submit.bind("click", function(e) {
		// hide messages 
		$.each([successfulMsg, errorMsg], function(key, value) {
			$(value).addClass("hidden");
		});
		// hide tipsy
		name.tipsy("hide");
		
		// check name
		if(name.val().length < 2 || name.val().length > 30) {
			name.tipsy("show");
			return;
		}
		
		// show preloader
		loading.removeClass("hidden");
		
		// build post-body
		var body = {
			"name": name.val()
		};
		
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/priority/add",
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