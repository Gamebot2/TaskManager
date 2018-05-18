CREATE DATABASE `taskmanager` /*!40100 DEFAULT CHARACTER SET utf8 */;
create table task_list(task_name VARCHAR(100) not null, task_class VARCHAR(100) not null, status VARCHAR(100) not null);
insert into task_list (task_name, task_class, status) values("Shower curtain", "Gov", "ACTIVE");
insert into task_list (task_name, task_class, status) values("Webassign", "Physics", "ACTIVE");
insert into task_list (task_name, task_class, status) values("Study", "Microecon", "ACTIVE");
insert into task_list (task_name, task_class, status) values("Prepare for Test", "Statistics", "COMPLETED");