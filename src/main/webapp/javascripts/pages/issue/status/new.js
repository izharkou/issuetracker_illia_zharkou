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
		type = $("#type", form),
		priority = $("#priority", form),
		project = $("#project", form),
		build = $("#build", form),
		assignee = $("#assignee", form),
		assigneeLabel = $("label[for='assignee'] span");
		
	// enable tipsy
	var inputs = [summary, description, assignee];
	$.each(inputs, function(key, value) {
		value.tipsy({trigger: "manual", gravity: "w"});
	});
	
	// status change
	status.bind("change", function(e) {
		if(status.val() == "1") {
			assignee
				.val("-1")
				.attr("disabled", "disabled");
			assigneeLabel.addClass("hidden");
			assignee.tipsy("hide");
		} else {
			assignee.removeAttr("disabled");
			assigneeLabel.removeClass("hidden");
		}
	});
	
	// project change: need to load builds
	project.bind("change", function(e) {
    	// show preloader
    	loading.addClass("hidden");
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/project/" + project.val() + "/builds",
			type: "get",
			dataType: "json",
		    success: function(data) {
		    	// clear old options
		    	build.html("");
		    	for(i in data) {
		    		build.append('<option value="' + data[i].id + '">' 
		    				+ data[i].version + '</option>');
		    	}
		    },
		    complete: function(jqXHR, textStatus) {
		    	// hide preloader
		    	loading.addClass("hidden");
		    }
		});
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
		
		// check summary
		if(summary.val().length < 10) {
			summary.tipsy("show");
			error = true;
		}
		// check description
		else if(description.val().length < 10) {
			description.tipsy("show");
			error = true;
		}
		// check assignee
		else if(status.val() == "2" && assignee.val() == "-1") {
			assignee.tipsy("show");
			error = true;
		}
		
		if(error) return;
		
		// show preloader
		loading.removeClass("hidden");
		
		// build post-body
		var body = {
			"id": id.val(),
			"summary": summary.val(),
			"description": description.val(),
			"status": {"id": status.val()},
			"type": {"id": type.val()},
			"priority": {"id": priority.val()},
			"build": {"id": build.val()}
		};
		if(status.val() == "2") {
			body.assignee = {"id": assignee.val()};
		}
		
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