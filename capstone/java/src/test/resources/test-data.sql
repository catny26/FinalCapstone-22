BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,full_name) VALUES ('user1','user1','ROLE_USER', 'user1'); -- Id: 1
INSERT INTO users (username,password_hash,role,full_name) VALUES ('user2','user2','ROLE_USER', 'user2'); -- Id: 2
INSERT INTO users (username,password_hash,role,full_name) VALUES ('user4','user4','ROLE_USER', 'user4'); -- Id: 4
INSERT INTO users (username,password_hash,role,full_name) VALUES ('user5','user5','ROLE_USER', 'user5'); -- Id: 5
INSERT INTO users (username,password_hash,role,type_of_doctor,full_name) VALUES ('user3','user3','ROLE_DOCTOR','Doctor', 'user3'); -- Id: 3

INSERT INTO notifications (user_id, message, is_read) VALUES (1, 'HELLO WORLD', false); -- Id: 1
INSERT INTO notifications (user_id, message, is_read) VALUES (1, 'Good Bye', true); -- Id: 2
INSERT INTO notifications (user_id, message, is_read) VALUES (3, 'Your appointment is scheduled for December 25th, 2002', false); --Id: 3
INSERT INTO notifications (user_id, message, is_read) VALUES (3, 'NO :(', true); -- Id: 4

INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (1, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], null, null);
INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (2, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], null, null, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17]);
INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (3, array[8,9,10,11,13,14,15,16,17], null, null, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17]);

INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,1,1, '13:00', '13:30', '2022-08-15', 'Confirmed', 'Because I feel like it'); --Id:1
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,2,1, '12:00', '13:00', '2022-01-01', 'Canceled', 'Not allowed, Not on new years'); --Id:2
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,1,1, '9:00', '12:00', '2022-05-17', 'Pending', 'Early Morning Surgery'); --Id:3
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,2,1, '10:00', '14:00', '2022-08-09', 'Canceled', 'Way too long'); --Id:4

INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES ('Office 1', '1 Street, Philadelphia, PA 19101', '2155551231', '08:00', '16:00', 50.00, false); --Id:1
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES ('Office 2', '2 Street, Philadelphia, PA 19102', '2155551232', '09:00', '17:00', 60.00, false); --Id:2
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES ('Office 3', '3 Street, Philadelphia, PA 19103', '2155551233', '10:00', '18:00', 70.00, false); --Id:3
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES ('Office 4', '4 Street, Philadelphia, PA 19104', '2155551234', '11:00', '19:00', 80.00, false); --Id:4

INSERT INTO users_office_info (office_id, user_id) VALUES (1,3);
INSERT INTO users_office_info (office_id, user_id) VALUES (2,3);
INSERT INTO users_office_info (office_id, user_id) VALUES (3,3);

INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (4, 'He listens!', 3, 1, 1, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'I love seeing this doctor', 3, 2, 1, 'Thanks, Gina!');
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'Dr. Mercier has been extremely helpful.', 3, 1, 1, 'Thank you, Olivia!');
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (4, 'Good doctor.', 3, 2, 2, 'Thank you!');

COMMIT TRANSACTION;