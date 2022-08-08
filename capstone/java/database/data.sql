BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES ('Cardiology Consultants of Philadelphia', '207 N Broad St, Philadelphia, PA 19107', 2152273627, '08:00', '16:00', 50.00);
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES ('Philadelphia Family Medicine', '1028 W Oregon Ave, Philadelphia, PA 19148', 2153897766, '09:00', '18:00', 60.00);
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES ('Ninth Street Internal Medicine', '805 Locust St, Philadelphia, PA 19107', 2154408681, '07:30', '17:00', 80.00);
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour) VALUES ('Philadelphia Dentistry', '1601 Walnut St #1302, Philadelphia, PA 19102', 2155686222, '08:00', '17:00', 70.00);


INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');
INSERT INTO users (username, password_hash, role) VALUES ('', '', '');

INSERT INTO users_office_info (office_id, user_id) VALUES ( ,)

INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES ();
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES ();
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES ();
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES ();
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES ();
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES ();
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES ();


INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES ();
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES ();
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES ();
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES ();
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES ();
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES ();
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES ();
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES ();



INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES ();
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES ();
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES ();
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES ();
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES ();
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES ();
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES ();
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES ();

INSERT INTO notifications (user_id, message, is_read) VALUES ()
COMMIT TRANSACTION;
