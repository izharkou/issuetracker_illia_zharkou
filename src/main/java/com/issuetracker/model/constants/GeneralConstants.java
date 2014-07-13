package com.issuetracker.model.constants;

import java.io.File;

/**
 * General constants.
 * 
 * @author Illia Zharkou
 */
public class GeneralConstants {
	
	public final static String FORMAT_DATE = "MMMM d, yyyy - h:mm:ss a";
	public final static int ITEMS_PER_PAGE = 10;
	public final static int PAGE_OFFSET = 1;
	public final static String SORT_COLUMN_NAME = "id";
	public final static String THREE_DOTS = "...";
	public final static int DESCRIPTION_MAX_LENGTH = 100;
	public final static int SUMMARY_MAX_LENGTH = 30;
	public static final String TEMP_DIR = "temp";
	public static final String DESTINATION_DIR = File.separator + "attachments" + File.separator;
	public static final int ONE_KB = 1024;
	public final static int ONE_MB = 1048576;
	public final static int HUNDRED_MB = 104857600;
	
}
