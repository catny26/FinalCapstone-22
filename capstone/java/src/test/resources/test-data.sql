BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,full_name) VALUES ('user1','user1','ROLE_USER', 'user1'); -- Id: 1
INSERT INTO users (username,password_hash,role,full_name) VALUES ('user2','user2','ROLE_USER', 'user2'); -- Id: 2
INSERT INTO users (username,password_hash,role,type_of_doctor,full_name) VALUES ('user3','user3','ROLE_DOCTOR','Doctor', 'user3'); -- Id: 3

INSERT INTO notifications (user_id, message, is_read) VALUES (1, 'HELLO WORLD', false); -- Id: 1
INSERT INTO notifications (user_id, message, is_read) VALUES (1, 'Good Bye', true); -- Id: 2
INSERT INTO notifications (user_id, message, is_read) VALUES (3, 'Your appointment is scheduled for December 25th, 2002', false); --Id: 3
INSERT INTO notifications (user_id, message, is_read) VALUES (3, 'NO :(', true); -- Id: 4

INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, sat_start, sat_end, lunch_start, lunch_end) VALUES (1, '08:00:00', '17:00:00', '08:00:00', '17:00:00', '08:00:00', '17:00:00', '12:00:00', '1:00:00');

INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,1,1, '13:00', '13:30', '2022-08-15', 'Confirmed', 'Because I feel like it');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,2,1, '12:00', '13:00', '2022-01-01', 'Canceled', 'Not allowed, Not on new years');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,1,1, '9:00', '12:00', '2022-05-17', 'Pending', 'Early Morning Surgery');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,2,1, '10:00', '14:00', '2022-08-09', 'Canceled', 'Way too long');


COMMIT TRANSACTION;
