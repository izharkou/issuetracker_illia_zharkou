$(function() {
	var form = $("#issueSearch"),
		submit = $(".button", form),
		errorMsg = $(".message.error"),
		loading = $(".loading"),
		id = $("#id", form),
		summary = $("#summary", form),
		description = $("#description", form),
		status = $("#status", form),
		resolution = $("#resolution", form),
		type = $("#type", form),
		priority = $("#priority", form),
		project = $("#project", form),
		build = $("#build", form),
		assignee = $("#assignee", form),
		results = $("#results");
	
	// formar summary
	var formattedSummary = function(summary) {
		if(summary.length > 30) {
			return summary.substring(0, 27) + "...";
		}
		return summary;
	};
	
	// project change: need to load builds
	project.bind("change", function(e) {
    	// clear old options
    	build.html("<option value=\"-1\"></option>");
    	// show preloader
    	loading.addClass("hidden");
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/project/" + project.val() + "/builds",
			type: "get",
			dataType: "json",
		    success: function(data) {
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
		// hide error message
		errorMsg.addClass("hidden");
		// show preloader
		loading.removeClass("hidden");
		
		// build post-body
		var body = {
			"id": id.val(),
			"summary": summary.val(),
			"description": description.val()
		};
		if(status.val() != "-1") {
			body.status = {"id": status.val()};
		}
		if(resolution.val() != "-1") {
			body.resolution = {"id": resolution.val()};
		}
		if(type.val() != "-1") {
			body.type = {"id": type.val()};
		}
		if(priority.val() != "-1") {
			body.priority = {"id": priority.val()};
		}
		if(build.val() != "-1") {
			body.build = {"id": build.val()};
		}	
		if(assignee.val() != "-1") {
			body.assignee = {"id": assignee.val()};
		}
		
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/issue/search/",
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
		    			var issue = data[i];
		    			body.append("<tr>"
		    					+ "<td><a href=\"/IssueTracker/issue/" + issue.id + "\">" + issue.id + "</a></td>"
		    					+ "<td class=\"bold " + issue.priority.name + "\">" + issue.priority.name + "</td>"
		    					+ "<td>" + ((issue.assignee) ? issue.assignee.firstName + " " + issue.assignee.lastName : '-/-') + "</td>"
		    					+ "<td>" + issue.type.name + "</td>"
		    					+ "<td>" + issue.status.name + "</td>"
		    					+ "<td>" + formattedSummary(issue.summary) + "</td>"
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