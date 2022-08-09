BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,full_name) VALUES ('user1','user1','ROLE_USER', 'user1'); -- Id: 1
INSERT INTO users (username,password_hash,role,full_name) VALUES ('user2','user2','ROLE_USER', 'user2'); -- Id: 2
INSERT INTO users (username,password_hash,role,type_of_doctor,full_name) VALUES ('user3','user3','ROLE_DOCTOR','Doctor', 'user3'); -- Id: 3

INSERT INTO notifications (user_id, message, is_read) VALUES (1, 'HELLO WORLD', false); -- Id: 1
INSERT INTO notifications (user_id, message, is_read) VALUES (1, 'Good Bye', true); -- Id: 2
INSERT INTO notifications (user_id, message, is_read) VALUES (3, 'Your appointment is scheduled for December 25th, 2002', false); --Id: 3
INSERT INTO notifications (user_id, message, is_read) VALUES (3, 'NO :(', true); -- Id: 4

INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (3, '09:00:00', '17:00:00', '09:00:00', '17:00:00', '09:00:00', '17:00:00', '09:00:00', '17:00:00', '09:00:00', '17:00:00', null, null, null, null, '12:00:00', '13:00:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (3, null, null, null, null, '08:00:00', '16:00:00', '08:00:00', '16:00:00', '08:00:00', '16:00:00', '08:00:00', '16:00:00', '08:00:00', '16:00:00', '11:00:00', '12:00:00', );
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (3, '09:30:00', '17:30:00', '09:30:00', '17:30:00', null, null, null, null, '09:30:00', '17:30:00', '09:30:00', '17:30:00', '09:30:00', '17:30:00', '11:30:00', '12:30:00', );
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (3, '09:00:00', '17:00:00', null, null, null, null, '09:00:00', '17:00:00', '09:00:00', '17:00:00', '09:00:00', '17:00:00', '09:00:00', '17:00:00', '12:00:00', '13:00:00');


INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,1,1, '13:00', '13:30', '2022-08-15', 'Confirmed', 'Because I feel like it'); --Id:1
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,2,1, '12:00', '13:00', '2022-01-01', 'Canceled', 'Not allowed, Not on new years'); --Id:2
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,1,1, '9:00', '12:00', '2022-05-17', 'Pending', 'Early Morning Surgery'); --Id:3
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3,2,1, '10:00', '14:00', '2022-08-09', 'Canceled', 'Way too long'); --Id:4

INSERT INTO office_info (office_id, office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES (1, "Office 1", "1 Street, Philadelphia, PA 19101", "2155551231", "08:00", "16:00", 50.00);
INSERT INTO office_info (office_id, office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES (2, "Office 2", "2 Street, Philadelphia, PA 19102", "2155551232", "09:00", "17:00", 60.00);
INSERT INTO office_info (office_id, office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES (3, "Office 3", "3 Street, Philadelphia, PA 19103", "2155551233", "10:00", "18:00", 70.00);
INSERT INTO office_info (office_id, office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES (4, "Office 4", "4 Street, Philadelphia, PA 19104", "2155551234", "11:00", "19:00", 80.00);


COMMIT TRANSACTION;
