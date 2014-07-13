package com.issuetracker.web.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.issuetracker.model.constants.GeneralConstants;
import com.issuetracker.model.domains.Attachment;
import com.issuetracker.model.domains.Issue;
import com.issuetracker.model.domains.User;
import com.issuetracker.model.services.interfaces.AttachmentService;
import com.issuetracker.model.services.interfaces.UserService;
import com.issuetracker.web.constants.MappingConstants;
import com.issuetracker.web.constants.ViewConstants;

/**
 * Upload, download attachments for issues.
 * 
 * @author Illia Zharkou
 */
@Controller
public class UploadDownloadController {
	
	@Autowired
    private ServletContext context;
	@Autowired
	private UserService userService;
	@Autowired
	private AttachmentService attachmentService;
	
	/**
	 * Upload new attachment.
	 * 
	 * @param issueId
	 * @param request
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_UPLOAD_ATTACHMENT, method = RequestMethod.POST)
	public String upload(@RequestParam(MappingConstants.PARAM_ID) Long issueId,
			HttpServletRequest request) {
		String realPath = context.getRealPath("");
		// calculate paths
		File tmpDir = new File(realPath + GeneralConstants.TEMP_DIR);
		File destinationDir = new File(realPath 
				+ GeneralConstants.DESTINATION_DIR + issueId);
		if (!destinationDir.isDirectory()) {
			destinationDir.mkdirs();
		}
		// prepare file item factory
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		fileItemFactory.setSizeThreshold(GeneralConstants.ONE_MB);
		fileItemFactory.setRepository(tmpDir);
		// prepare file upload
		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
		uploadHandler.setSizeMax(GeneralConstants.HUNDRED_MB);
		
		try {
			List<FileItem> items = uploadHandler.parseRequest(request);
			Iterator<FileItem> iterator = items.iterator();
			String filename = null;
			// save all files
			while (iterator.hasNext()) {
				FileItem item = iterator.next();
				if (!item.isFormField()) {
					filename = item.getName();
					String name = new File(item.getName()).getName();
					File file = new File(destinationDir, name);
					item.write(file);
				}
			}
			// save attachment
			Issue issue = new Issue();
			issue.setId(issueId);
			User currentUser = userService.getCurrentUser();
			DateTime addedDate = new DateTime(System.currentTimeMillis());
			Attachment attachment = new Attachment();
			attachment.setIssue(issue);
			attachment.setAddedBy(currentUser);
			attachment.setAddDate(addedDate);
			attachment.setFilename(filename);
			attachment = attachmentService.save(attachment);
		} catch (Exception ignore) {}
		// redirect to edit page
		return ViewConstants.REDIRECT_TO_ISSUE_EDIT + issueId;
	}
	
	/**
	 * Download attachment.
	 * 
	 * @param issueId
	 * @param filename
	 * @param response
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_DOWNLOAD_ATTACHMENT, method = RequestMethod.GET)
	public void download(@RequestParam(MappingConstants.PARAM_ID) Long issueId,
			@RequestParam(MappingConstants.PARAM_FILENAME) String filename,
			HttpServletResponse response) {
		try {
			// get absolute path to file
			String fullPath = context.getRealPath(GeneralConstants.DESTINATION_DIR
					+ File.separator + issueId + File.separator + filename);
			// set mime type
			String mimeType = context.getMimeType(fullPath);
			response.setContentType(mimeType);
			// set file size
			File file = new File(fullPath);
			response.setContentLength((int) file.length());
			response.addHeader("Content-Disposition", "attachment; filename=" 
					+ file.getName());
			// write file to output
			FileInputStream in = new FileInputStream(file);
			OutputStream out = response.getOutputStream();
			byte[] buf = new byte[GeneralConstants.ONE_KB];
			int count = 0;
			while ((count = in.read(buf)) >= 0) {
				out.write(buf, 0, count);
			}
			in.close();
			out.close();
		} catch (Exception ignore) {}
	}
	
}
