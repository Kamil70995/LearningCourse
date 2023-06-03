drop database if exists learning_course;
drop user if exists learning_course;

create user learning_course with password '123';
create database learning_course;
grant all on database learning_course to learning_course;