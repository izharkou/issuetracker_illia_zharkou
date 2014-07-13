drop table if exists users;
drop table if exists statues;
drop table if exists resolutions;
drop table if exists priorities;
drop table if exists types;
drop table if exists projects;
drop table if exists builds;
drop table if exists audit;
drop table if exists issues;
drop table if exists comments;
drop table if exists attachments;

create table users(
    id int primary key auto_increment, 
    first_name varchar(30) not null, 
    last_name varchar(30) not null, 
    email varchar(50) not null unique, 
    role int not null, 
    passwd varchar(32)
);

create table statuses(
    id int primary key auto_increment, 
    name varchar(30) not null unique
);

create table resolutions(
	id int primary key auto_increment,
	name varchar(30) not null unique
);

create table types(
	id int primary key auto_increment,
	name varchar(30) not null unique
);

create table priorities(
	id int primary key auto_increment,
	name varchar(30) not null unique
);

create table projects(
	id int primary key auto_increment,
	name varchar(30) not null unique,
	description varchar(1000) not null,
	manager int not null references users(id)
);

create table builds(
	id int primary key auto_increment,
	project_id int not null references projects(id),
	version varchar(30) not null,
	is_current boolean not null
);

create table audit(
	id int primary key auto_increment, 
	created_by int not null references users(id),
	modified_by int not null references users(id),
    created_date timestamp not null,
    modified_date timestamp not null
);

create table issues(
    id int primary key auto_increment, 
    audit_id int not null references audit(id),
    summary varchar(500) not null,
    description varchar(1000) not null,
    status_id int not null references statuses(id),
    type_id int not null references types(id),
    priority_id int not null references priorities(id),
    build_id int not null references builds(id),
    assignee_id int null references users(id),
    resolution_id int null references resolutions(id)
);

create table comments(
	id int primary key auto_increment, 
	issue_id int not null references issues(id),
	added_by int not null references users(id),
	comment varchar(1000) not null,
	add_date timestamp not null
);

create table attachments(
	id int primary key auto_increment,
	filename varchar(300) not null,
	added_by int not null references users(id),
	add_date timestamp not null,
	issue_id int not null references issues(id)
);