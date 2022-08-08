BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER'); -- Id: 1
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER'); -- Id: 2
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER'); -- Id: 3

INSERT INTO notifications (user_id, message, is_read) VALUES (1, 'HELLO WORLD', false); -- Id: 1
INSERT INTO notifications (user_id, message, is_read) VALUES (1, 'Good Bye', true); -- Id: 2
INSERT INTO notifications (user_id, message, is_read) VALUES (3, 'Your appointment is scheduled for December 25th, 2002', false); --Id: 3
INSERT INTO notifications (user_id, message, is_read) VALUES (3, 'NO :(', true); -- Id: 4

INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, sat_start, sat_end, lunch_start, lunch_end) VALUES (1, '08:00:00', '17:00:00', '08:00:00', '17:00:00', '08:00:00', '17:00:00', '12:00:00', '1:00:00');


COMMIT TRANSACTION;
