package com.issuetracker.model.services;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.issuetracker.model.domains.Comment;
import com.issuetracker.model.domains.Issue;
import com.issuetracker.model.domains.User;
import com.issuetracker.model.repositories.CommentRepository;
import com.issuetracker.model.services.interfaces.CommentService;
import com.issuetracker.model.services.interfaces.UserService;

/**
 * Default comment service.
 * 
 * @author Illia Zharkou
 */
@Service("commentService")
@Repository
@Transactional
public class DefaultCommentService implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private UserService userService;
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.CommentService#findByIssue(com.issuetracker.model.domains.Issue)
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Comment> findByIssue(Issue issue) {
		return commentRepository.findByIssueOrderByIdAsc(issue);
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.CommentService#save(com.issuetracker.model.domains.Comment)
	 */
	@Override
	public Comment save(Comment comment) {
		// set author as current user
		User user = userService.getCurrentUser();
		comment.setAddedBy(user);
		// set current time
		DateTime now = new DateTime(System.currentTimeMillis());
		comment.setAddDate(now);
		return commentRepository.save(comment);
	}
	
}
