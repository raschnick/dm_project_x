CREATE SCHEMA project_x;

drop schema project_x;

INSERT INTO user (id, country, name) VALUES (1, "Switzerland", "Max Müller");
INSERT INTO node (dtype, id, name, file_type, size, folder_id) VALUES ("folder", 1, "rootfolder", null, 1000, null);
INSERT INTO permission (id, date, type, node_id, user_id) VALUES (1, "2022-06-03", "wr", null, 1);


select * from user;
select * from node;
select * from permission;