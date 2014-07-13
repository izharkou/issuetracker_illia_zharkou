$(function() {
	var form = $("#issueEdit"),
		submit = $(".button", form),
		successfulMsg = $(".message.successful"),
		errorMsg = $(".message.error"),
		loading = $(".loading"),
		id = $("#id", form),
		summary = $("#summary", form),
		description = $("#description", form),
		status = $("#status", form),
		statusVal = status.val(),
		resolution = $("#resolution", form),
		type = $("#type", form),
		priority = $("#priority", form),
		build = $("#build", form),
		assignee = $("#assignee", form);
		
	// wait for submit event
	submit.bind("click", function(e) {
		// show preloader
		loading.removeClass("hidden");
		
		// build post-body
		var body = {
			"id": id.val(),
			"summary": summary.val(),
			"description": description.val(),
			"status": {"id": status.val()},
			"resolution": {"id": resolution.val()},
			"type": {"id": type.val()},
			"priority": {"id": priority.val()},
			"build": {"id": build.val()},
			"assignee": {"id": assignee.val()}
		};
		
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/issue/edit/" + id.val(),
			type: "post",
			dataType: "json",
			data: JSON.stringify(body),
			contentType: "application/json",
		    mimeType: "application/json",
		    complete: function(jqXHR, textStatus) {
		    	switch (jqXHR.status) {
			        case 200:
			            successfulMsg.removeClass("hidden");
			            // if status was changed
			            if(statusVal != status.val()) {
			            	// reload page
			            	if(window.location.search == "?success=1") {
			            		window.location.reload();
			            	} else {
			            		window.location.search = "?success=1";
			            	}
			            }
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