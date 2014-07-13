$(function() {
	var form = $("#commentAdd"),
		wrap = $(".comments"),
		submit = $(".button", form),
		issue = $("#issue", form),
		comment = $("#comment", form);
	
	// wait for submit event
	submit.bind("click", function(e) {
		// check comment text
		if(comment.val().length == 0) {
			return;
		}
		// build post-body
		var body = {
			"issue": {"id": issue.val()},
			"comment": comment.val()
		};
		comment.val("");
		// send ajax-request to server
		$.ajax({
			url: "/IssueTracker/issue/comment",
			type: "post",
			dataType: "json",
			data: JSON.stringify(body),
			contentType: "application/json",
		    mimeType: "application/json",
		    success: function(data) {
				// add to comments list
				wrap.append("<div class=\"comment\">"
					+ "<div class=\"author\">" 
						+ "<a href=\"/IssueTracker/user/" + data.addedBy.id + "\">"
							+ data.addedBy.firstName + " " 
							+ data.addedBy.lastName 
						+ "</a>"
					+ "</div>"
					+ "<p>" + data.comment + "</p>"
					+ "</div>");
		    }
		});
	});
});