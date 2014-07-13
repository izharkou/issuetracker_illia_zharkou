insert into users(first_name, last_name, email, role, passwd) values
	('Admin', 'admin', 'admin@admin.com', 2, 'admin'),
	('Robin', 'Sowell', 'Robin_Sowell@mail.com', 1, '2Bc%.'),
	('Wes', 'Baker', 'Wes_Baker@mail.com', 1, '3Cd$,'),
	('Derek', 'Jones', 'Derek_Jones@mail.com', 1, '4Cd@:'),
	('Kurt', 'Deutscher', 'Kurt_Deutscher@mail.com', 1, '4Cd@:');
    
insert into statuses(name) values 
	('New'), 
	('Assigned'), 
	('In Progress'), 
	('Resolved'), 
	('Closed'), 
	('Reopened');
	
insert into resolutions(name) values 
	('Fixed'), 
	('Invalid'), 
	('Wontfix'), 
	('Worksforme');
	
insert into priorities(name) values 
	('Critical'), 
	('Major'), 
	('Important'), 
	('Minor');
	
insert into types(name) values 
	('Cosmetic'), 
	('Bug'), 
	('Feature'), 
	('Performance');
	
insert into projects(name, description, manager) values
	('Avast Free Antivirus 2014', 'Avast Free Antivirus 2014 continues our legacy. The entire avast! 2014 family includes a DynaGen-powered intelligent antivirus that streams micro-updates to your computer in real time, to catch new malware faster. Plus, you can fix current problems instantly, without uninstalling a previous antivirus. And it even has high-tech options like Remote Assistance.', 1),
	('AVG AntiVirus Free 2014', 'AVG AntiVirus Free not only gives you the top-quality antivirus protection and security features that youd usually expect only from a paid product, but added privacy features for 2014 help keep your personal information safe both online and on your PC, and the new integrated File Shredder permanently deletes sensitive files to keep them from falling into the wrong hands. Add to this our Anti-Spyware Technology and WiFi Guard, and you can be sure that wherever you are, at home or on the move, were taking your privacy seriously.', 2),
	('CCleaner', 'CCleaner is a freeware system optimization, privacy and cleaning tool. It removes unused files from your system allowing Windows to run faster and freeing up valuable hard disk space. It also cleans traces of your online activities such as your Internet history. Additionally it contains a fully featured registry cleaner.', 3),
	('KMPlayer', 'KMPlayer is all in one media player, covering various formats such as VCD, DVD, AVI, MKV, Ogg Theora, OGM, 3GP, MPEG-1/2/4, WMV, RealMedia, QuickTime. It has an extra feature to play Incomplete/Damaged AVI file, Locked Media Files while downloading or sharing, Compressed Audio Album (zip, rar) and so on. It also supports WIDI, 3D, 4K and handles a wide range of subtitles and allows you to capture audio, video, and screenshots in many ways.', 4),
	('YTD Video Downloader', 'YTD Video Downloader is more than a Youtube downloader. It allows you to download HD and HQ videos, from dozens of sites and convert them to other video formats. The program is easy to use. Just specify the URL, similar to a Youtube downloader, for the video you want to download and click the Download button. From there, YTD Video Downloader will download the video from the URL you specified. The program also allows you to convert downloaded videos for iPad, iPod, iPhone, PSP, Cell Phone, Windows Media, and XVid, or play video that you have previously downloaded or converted.', 5),
	('Free YouTube Downloader', 'Would you like to watch your favorite videos from YouTube whenever and wherever you please? All this and more is possible with Free YouTube Downloader. With this download manager you can save YouTube videos in various video and audio formats. We support standard quality, high quality and even Full High Definition video.', 1),
	('IObit Malware Fighter', 'IObit Malware Fighter is an advanced malware & spyware removal utility that detects, removes the deepest infections, and protects your PC from various potential spyware, adware, trojans, keyloggers, bots, worms, and hijackers. With the unique "Dual-Core" engine and the heuristic malware detection, IObit Malware Fighter detects the most complex and deepest spyware and malware in a very fast and efficient way. IObit Malware Fighter has a enhanced real-time protection and frequent automatic updating for prevention of zero-day security threats. IObit Malware Fighter can work with your Antivirus for a superior PC security.', 2),
	('Advanced SystemCare', 'Advanced SystemCare Free is a comprehensive PC care utility that takes one-click approach to help protect, repair and optimize your computer. Scanning and finding what other utilities might miss, it can keep your PC error-free and smoother than ever.', 3),
	('Start Menu 8', 'Start Menu 8 is specially designed for Window 8. It offers a perfect solution for users who work with Windows Start Menu all the time and are not accustomed to the new Metro start screen in Windows 8. This smart tool brings back both the start button and Windows Start Menu, and offers the option to skip Metro start page, allowing users who only work on desktop to boot to Windows 8 desktop directly.', 4),
	('WinRAR (32-bit)', 'WinRAR is a 32-bit / 64-bit Windows version of RAR Archiver, the powerful archiver and archive manager. WinRARs main features are very strong general and multimedia compression, solid compression, archive protection from damage, processing of ZIP and other non-RAR archives, scanning archives for viruses, programmable self-extracting archives(SFX), authenticity verification, NTFS and Unicode support, strong AES encryption, support of multivolume archives, command line and graphical interface, drag-and-drop facility, wizard interface, theme support, folder tree panel, multithread support and Windows x64 shell integration. WinRAR provides complete support for RAR and ZIP archives and is able to unpack and convert CAB, ARJ, LZH, TAR, GZ, ACE, UUE, BZ2, JAR, ISO, Z, 7-Zip archives. WinRAR is available in over 40 languages.', 5),
	('Download App', 'The Download App is a free application from Download.com that helps keep the software on your Windows computer up-to-date, as well as clean up the junk that accumulates on your system over time. Using the software catalog that powers Download.com, the Download App provides secure, spyware-free software updates, and makes it easy to keep track of all your software updates in one place.', 1);
	
insert into builds(project_id, version, is_current) values
	(1, '1.0.0', false),
	(1, '1.0.1', true),
	(2, '2.0.0', false),
	(2, '2.1.1', true),
	(3, '3.0.1', false),
	(3, '3.1.1', true),
	(4, '4.0.0', false),
	(4, '4.2.1', true),
	(5, '5.0.0', false),
	(5, '5.10.1', true),
	(6, '6.3.0', false),
	(6, '6.4.1', true),
	(7, '7.1.0', false),
	(7, '7.1.1', true),
	(8, '8.0.0', false),
	(8, '8.2.1', true),
	(9, '9.0.0', false),
	(9, '9.1.0', true),
	(10, '10.0.0', false),
	(10, '10.2.1', true),
	(11, '11.0.0', false),
	(11, '11.2.1', true);
	
insert into audit(created_by, modified_by, created_date, modified_date) values
	(1, 1, '2014-1-1 10:15:15', '2014-1-1 10:16:42'),
	(2, 2, '2014-1-1 10:15:15', '2014-1-1 10:16:42'),
	(3, 3, '2014-1-1 10:15:15', '2014-1-1 10:16:42'),
	(4, 4, '2014-1-1 10:15:15', '2014-1-1 10:16:42'),
	(5, 5, '2014-1-1 10:15:15', '2014-1-1 10:16:42'),
	(1, 1, '2014-2-2 12:10:11', '2014-2-2 12:20:15'),
	(2, 2, '2014-2-2 12:10:11', '2014-2-2 12:20:15'),
	(3, 3, '2014-2-2 12:10:11', '2014-2-2 12:20:15'),
	(4, 4, '2014-2-2 12:10:11', '2014-2-2 12:20:15'),
	(5, 5, '2014-2-2 12:10:11', '2014-2-2 12:20:15'),
	(1, 2, '2014-2-2 12:10:11', '2014-2-2 12:20:15');
	
insert into issues(audit_id, summary, description, status_id, type_id, priority_id, build_id, assignee_id, resolution_id) values
	(1, 'When clearing caches, it’s now site specific, which can cause problems pulling data across sites.', 'So- site A is using caching- has a template on a tag pulling in site B entries.  You add a new entry to site B- cache is cleared automatically but ONLY for site B.  Site A’s cache not cleared.  So- the new entry doesn’t show up on site A until the cache expires.', 3, 1, 4, 1, 1, null),
	(2, 'Errors when trying to switch language.', 'When going to edit profile, and language settings, I get the following errors if I try to change language: A PHP Error was encountered!', 3, 2, 3, 1, 1, null),
	(3, 'Javascript error after upgrade to EE 2.8.1.', 'I get this bug only when I go to create a custom field.  I can create the new channel and channel group just fine.', 3, 3, 2, 3, 3, null),
	(4, 'Local Environment Deleting Files From File Manager Won’t Delete Files.', 'I have a local environment on my machine running EE that connects to a remote database on a separate server.', 3, 4, 1, 4, 4, null),
	(5, 'Grid Relationship returning field returning field data when it doesn’t have any.', 'I have a grid field called carousel which displays images and text with a link to content. The content is either a page or a product and this is achieved by via a relationship. To create the link, I check if the link has a fields called product_type. If it does, the link goes to the product URL.', 3, 1, 4, 5, 1, null),
	(6, 'Search limit do not honor settings.', 'I have quick search form on my site and have limited it to 50 characters. How is it possible that spam-bots still can put this type of search queries to that form?', 1, 2, 3, 6, null, null),
	(7, 'Control panel preferences are being database cached.', 'When I check the config on the exp_sites table, it shows the new value, but the new value doesn’t pull into the CP until I remove database caching.', 1, 3, 2, 7, null, null),
	(8, 'Member activation emails flagged as spam on Bluehost.', 'If a site uses member activation emails for new member accounts, the default subject line is flagged as spam by Bluehost. I ran into this issue recently on a new site. I then tested other EE sites from v1.7 to v2.8 and they all had the same issue and on multiple Blueshost accounts on different boxes. None of my other sites on other hosting providers had this issue.', 1, 4, 1, 8, null, null),
	(9, 'Undefined alert when logging in to expired session.', 'If your session times out a popup appears prompting you to login to continue. When doing so with the correct password you get an alert saying ‘undefined’. Refreshing the page shows that you’ve been logged back in successfully.', 1, 1, 4, 9, null, null),
	(10, 'Register New Member not available for non-Super Admin.', 'I have created a Member Group - “Editor”.  That Member Group has Can administrate members accounts set to Yes, but when I log in as an Editor and select “Register Member”, I get the following message: You do not have the required permissions to add new members to any group.', 1, 2, 3, 10, null, null),
	(11, 'Cant delete Board, fatal error!', 'When I try to delete board using Forum Module 3.1.4, it doesnt work. I get the following error.', 1, 3, 1, 11, null, null);
	
insert into comments(issue_id, added_by, comment, add_date) values
	(1, 1, 'Sorry about that, Riverboy! I’ve got it fixed up for the next release and the patch is laid out above. If you have any trouble with it, let me know.', '2014-1-1 10:16:42'),
	(2, 2, 'Yay, thanks. modfied, deleted board, all should be good.', '2014-1-1 10:16:42'),
	(3, 3, 'Looking at the code fix above, my version of the forum has the original line of code at 420. I replaced with the fix as noted above, but it chucks me another error - so I just reverted back.', '2014-1-1 10:16:42'),
	(4, 4, 'Im getting still this with 2.8.1, so it wasnt fixed after all?', '2014-1-1 10:16:42'),
	(5, 5, 'Sorry for the confusion, but it should make it into the next release.', '2014-1-1 10:16:42');
	