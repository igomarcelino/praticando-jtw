INSERT INTO TB_USER(user_login, user_password)VALUES('admin', '$2a$12$C0vwo.6NB7Pzb9uv4c5QzOFntMQKm3lKgBBrbTN.AH9TCHIwVrF7W');
INSERT INTO TB_USER(user_login, user_password)VALUES('user', '$2a$12$C0vwo.6NB7Pzb9uv4c5QzOFntMQKm3lKgBBrbTN.AH9TCHIwVrF7W');

INSERT INTO TB_ROLES(role_name)VALUES('ADMIN');
INSERT INTO TB_ROLES(role_name)VALUES('BASIC');

INSERT INTO TB_USER_ROLES(id_user, id_role)VALUES(1,1);