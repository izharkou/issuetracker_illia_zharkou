$(function() {
	var form = $("#projectEdit"),
		submit = $(".button", form),
		successfulMsg = $(".message.successful"),
		errorMsg = $(".message.error"),
		loading = $(".loading"),
		id = $("#id", form),
		name = $("#name", form),
		description = $("#description", form),
		manager = $("#manager", form),
		build = $("#build", form),
		addBuild = $(".input-link", form);
		
	// enable tipsy
	var inputs = [name, description];
	$.each(inputs, function(key, value) {
		value.tipsy({trigger: "manual", gravity: "w"});
	});
	
	// add new build
	addBuild.bind("click", function(e) {
		var promptText = addBuild.attr("original-title");
		if((version = prompt(promptText)) != null) {
			// show preloader
	    	loading.removeClass("hidden");
	    	
	    	// build post-body
			var body = {
				"version": version,
				"current": false
			};
			
			// send ajax-request to server
			$.ajax({
				url: "/IssueTracker/project/build/add?id=" + id.val(),
				type: "post",
				dataType: "json",
				data: JSON.stringify(body),
				contentType: "application/json",
			    mimeType: "application/json",
			    success: function(data) {
			    	if(data.id === parseInt(data.id)) {
			    		// add to select
			    		build.append('<option value="' + data.id + '">' 
			    				+ data.version + '</option>');
			    		build.val(data.id);
			    	}
			    },
			    complete: function(jqXHR, textStatus) {
			    	// hide preloader
			    	loading.addClass("hidden");
			    }
			});
		}
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
		
		if(error) return;
		
		// show preloader
		loading.removeClass("hidden");
		
		var builds = [];
		$("option", build).each(function(key, value) {
			builds.push({
				"id": $(value).attr("value"),
				"version": $(value).html(),
				"current": build.val() == $(value).attr("value")
			});
		});
		// build post-body
		var body = {
			"id": id.val(),
			"name": name.val(),
			"description": description.val(),
			"manager": {"id": manager.val()},
			"builds": builds
		};
		
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/project/edit/" + id.val(),
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