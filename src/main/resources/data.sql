INSERT INTO roles(description,name) values ('Admin', 'ADMIN');
INSERT INTO roles(description,name) values ('User', 'USER');
INSERT INTO users (email,password) values ('admin@gmail.com','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u');
INSERT INTO users (email,password) values ('user@gmail.com','$2a$12$D6Xf.d26xiJO6qLEuN2efu046u.4xhT1YmyE.drzF/C2Ei5KSI9Ye');
insert into user_roles(user_id,role_id) values (1,1);
insert into user_roles(user_id,role_id) values (2,2);