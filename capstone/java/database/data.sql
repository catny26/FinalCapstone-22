BEGIN TRANSACTION;

INSERT INTO users (username,full_name,password_hash,role) VALUES ('user','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,full_name,password_hash,role) VALUES ('admin','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,full_name,password_hash,role) VALUES ('testpatient','test patient','$2a$10$qa.fO8Fxhq.K/R8SuH2pxOLov8/6auvtZsy6MDVNuh9BNM6SBiABm','ROLE_USER');
INSERT INTO users (username,full_name,password_hash,role) VALUES ('testdoctor','test doctor','$2a$10$3RuzpY.OPF/7nQ19TtbgRO4Cx6W9kvErZLrAtfpr55j2SLWB6NK.6','ROLE_DOCTOR');


INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour, office_image_url, delay) VALUES ('Cardiology Consultants of Philadelphia', '207 N Broad St, Philadelphia, PA 19107', 2152273627, '08:00', '16:00', 50.00, 'https://array-architects.com/wp-content/uploads/2021/01/Array_CCP-Hero-1.png', false);
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour, delay) VALUES ('Philadelphia Family Medicine', '1028 W Oregon Ave, Philadelphia, PA 19148', 2153897766, '09:00', '18:00', 60.00, false);
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour, delay) VALUES ('Ninth Street Internal Medicine', '805 Locust St, Philadelphia, PA 19107', 2154408681, '07:30', '17:00', 80.00, false);
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour, delay) VALUES ('Philadelphia Dentistry', '1601 Walnut St #1302, Philadelphia, PA 19102', 2155686222, '08:00', '17:00', 70.00, false);


INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('madesman','Paulien Vlad', '$2a$10$FmPjRAtJ/XLPwQfAH8sf6eEjat4ehBeSnqz4L8zs5Rbudv3qiGNtu', 'ROLE_DOCTOR', 'Family');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('sbrauer','Nanuk Eva', '$2a$10$blE3WmKuGu2nHT88Wo5NwuEtpZ0Hgi9IIgnIX/nEz8wUuuU/wo8FW', 'ROLE_DOCTOR', 'Family');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('wmercier','Noni Clark', '$2a$10$LGyfMaBG509OtLRI1WTak.RDVYZoA9RC7YLPWBbdScboUR2CVeC/.', 'ROLE_DOCTOR', 'Family');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('xli','Cathy Ngo', '$2a$10$r1KdcR4OHZrTsAEU32uAF.zbIrEMlUPxBGg3zTnQpok3t7qzn.IbK', 'ROLE_DOCTOR', 'Family');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('jbagnick','Jenn Lee', '$2a$10$Nx9n81B6ABz18iFEXxLHAupS/9QCN5CSQXgbrgHRPaRKXlwqY.2uy', 'ROLE_DOCTOR', 'Family');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('dmajor','Sam Muskovitz', '$2a$10$wNyZzPrFdUjjUOAz10fGAO/vhKb3SnA3xRJXf37MIvHqq4La1DYQW', 'ROLE_DOCTOR', 'Radiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('zfont','Juhani Muhamad', '$2a$10$8m9rqnIHYeYUpPcjfT3I0ORI4RyqHix/p3674KgxSnUYqnYMT3PO2', 'ROLE_DOCTOR', 'Radiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('dzackey','Rhode Beata', '$2a$10$imaujXo0ds4i2BMF2HBRQOgwkPoUafNUQtFjMEvKbPx17IdREAy.e', 'ROLE_DOCTOR', 'Radiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('jambriz','Daniela Gusta', '$2a$10$URcE.pZrRB1bq2SErycMSO0DxzDbuQany3dVbawJNZwMwSgQlcHj6', 'ROLE_DOCTOR', 'Radiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('ebeppel','Giorgos Sachiko', '$2a$10$HxNL9cvdcP4F5PilT/Yu.O6gNwVJ9tV38M4CudUpE6ota5l9vS7Se', 'ROLE_DOCTOR', 'Radiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('mbuckley','Ivo Uther', '$2a$10$bpBoltKN8Gde1ZvsvUhbhe4xPpvJfG8AHOFiDF/HnwRQxBtmhmP8y', 'ROLE_DOCTOR', 'Radiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('hcohen','Tom Beerbower', '$2a$10$DGGq9yUNOhdfnnODxsn3iu5pgGVPW4xzog5eqcF3kCq64O0xd3rNe', 'ROLE_DOCTOR', 'Pediatrist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('bbullock','Myron Law-Doom', '$2a$10$4f/PnRylwEJzbnjuZPq9juagz1eXzhGmmfoCzGdARoAYqR4NTB6NC', 'ROLE_DOCTOR','Psychiatrist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('avadher','Gervaise Antton', '$2a$10$OgfCuYbVpmDbbGKMd.PLRuVg/Vg57ZgJugPW8PP.GpwSnJyHfN/uq', 'ROLE_DOCTOR', 'Anesthesiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('bnguyen','Gwenneth Dotty', '$2a$10$RKiPuJqXehsfFDsMseZoZOvHdyrBsjVNSoHucFNuFtVMiFNFrYed2', 'ROLE_DOCTOR', 'Anesthesiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('eziegler','Agnija Eliana', '$2a$10$E1H5vZicpwwi6t6ijfXCueZlUBikOTpeXbNXCfRFIa.4pbjwdBUNu', 'ROLE_DOCTOR', 'Anesthesiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('okhan','Krystyna Eugen', '$2a$10$wW5L2OkNPjNRUsSe0NopYunl9QFsKo05mB7diM0UH4iqQLR6t35wK', 'ROLE_DOCTOR', 'Anesthesiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('zlyons','Catherine Karen', '$2a$10$MQE4fwQ0uGwd4k2WnRoHYeRLUwjzw0Ih44L.kfMEagGsZwOHXhxrG', 'ROLE_DOCTOR', 'Anesthesiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('test', 'test', '$2a$10$kKRzGHx/1nyYJY79NFluU.hAQniAaQwVjK6l7Px3YLiCB.iE8BAei', 'ROLE_DOCTOR', 'Test');

INSERT INTO users (username, full_name, password_hash, role) VALUES ('ibenton','Bojidar Veronika', '$2a$10$jjcNLETKswckI1/ABwir/.qvatRV3MZQvqV..nmsbhJQcgVMqDCva', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('gbrook','Oberon Valentina', '$2a$10$5S/w4GBdqyN7XRlqeMWr1eRVcG1CQICw4.qoZIjiPHcKlTRHtwdcS', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('swillis','Tanguy Dorotea', '$2a$10$FmscFDenWl3I7VP6p7UxJ.PdMkKcCe4TFy8YLAPdprBFvYhTy/.vO', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('vfrost','Starr Kisecawchuck', '$2a$10$pRWj.JubjAM8VJBgWzYH4uqNdDosXYPU7SKVBVThrg9TumvKFPt.6', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('klara','Aleksander Tjeerd', '$2a$10$S5qhm5QClLqa0BdOf0QYietpbAKO.6cEHU4.sHGGj4bh3wmv4krsi', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('hrobson','Sietske Magdalena', '$2a$10$/bo3sMBOqysDWiaxiG.LmODUo.0r5BAXYBIUbmu./sVdHRykCerwG', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('obutler','Brandon Butler', '$2a$10$s7iTzx0ThOqz.lfSi7m6Gu0zcWuRbJKp8S.jk9r1QEt2eUBCyfopu', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('cwarren','Zotikos Mónica', '$2a$10$gvRLGJQCaI3XUaA5pQtiWublHbDsMYAUEMPXUvpW6ZGv/1k1LvlL2', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('amalone','Halina Steel-Crash', '$2a$10$TTh0CWQ5BKt/9i56RBq2qOT1WdEz9RT1C06j.CbuCCIdDRMk3dW.K', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('wrivers','Orna Chisomo', '$2a$10$bAkbO09mNMj2lO1L7NNldOFtDNUDsMp/CorqaAPniGxgi6tFhF0jO', 'ROLE_USER');

INSERT INTO users_office_info (office_id, user_id) VALUES (1, 5);
INSERT INTO users_office_info (office_id, user_id) VALUES (1, 6);
INSERT INTO users_office_info (office_id, user_id) VALUES (1, 7);
INSERT INTO users_office_info (office_id, user_id) VALUES (2, 8);
INSERT INTO users_office_info (office_id, user_id) VALUES (2, 9);
INSERT INTO users_office_info (office_id, user_id) VALUES (2, 10);
INSERT INTO users_office_info (office_id, user_id) VALUES (2, 11);
INSERT INTO users_office_info (office_id, user_id) VALUES (2, 12);
INSERT INTO users_office_info (office_id, user_id) VALUES (2, 13);
INSERT INTO users_office_info (office_id, user_id) VALUES (3, 14);
INSERT INTO users_office_info (office_id, user_id) VALUES (3, 15);
INSERT INTO users_office_info (office_id, user_id) VALUES (3, 16);
INSERT INTO users_office_info (office_id, user_id) VALUES (3, 17);
INSERT INTO users_office_info (office_id, user_id) VALUES (4, 18);
INSERT INTO users_office_info (office_id, user_id) VALUES (4, 19);
INSERT INTO users_office_info (office_id, user_id) VALUES (4, 20);
INSERT INTO users_office_info (office_id, user_id) VALUES (4, 21);
INSERT INTO users_office_info (office_id, user_id) VALUES (4, 22);
INSERT INTO users_office_info (office_id, user_id) VALUES (3, 22);
INSERT INTO users_office_info (office_id, user_id) VALUES (2, 22);
INSERT INTO users_office_info (office_id, user_id) VALUES (1, 22);
INSERT INTO users_office_info (office_id, user_id) VALUES (2, 23);
INSERT INTO users_office_info (office_id, user_id) VALUES (1, 23);

INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (4, 'He listens!', 5, 23, 1, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'I love seeing this doctor', 6, 24, 1, 'Thanks, Gina!');
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'Dr. Mercier has been extremely helpful.', 7, 29, 1, 'Thank you, Olivia!');
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (3, null, 9, 25, 2, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (4, 'Good doctor.', 11, 26, 2, 'Thank you!');
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'My son loves his doctor!', 11, 30, 2, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (3, 'Doctor seemed rushed.', 10, 28, 2, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (2, 'Dr. Cohen would not give me the diet pills I wanted.', 16, 31, 3, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'Dr. Cohen embodies the philosophy and approach of Patch Adams.', 16, 32, 3, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (4, 'Very caring doctor.', 17, 23, 3, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'She has been my dentist for years.', 21, 27, 4, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'Fixed my teeth!', 18, 28, 4, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (4, 'Good dentist', 19, 26, 4, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (4, null, 20, 30, 4, null);



INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (5, '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', null, null, null, null, '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (6, '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', null, null, null, null, '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (7, '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', null, null, null, null, '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (8, '08:00', '16:00', '08:00', '16:00', '08:00', '16:00', '08:00', '16:00', '08:00', '16:00', null, null, null, null, '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (9, null, null, null, null, '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (10, '08:00', '16:00', null, null, null, null, '08:00', '16:00', '08:00', '16:00', '08:00', '16:00', '08:00', '16:00', '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (11, '08:00', '17:00', '08:00', '17:00', null, null, null, null, '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (12, '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', null, null, null, null, '08:00', '17:00', '08:00', '17:00', '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (13, '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', null, null, null, null, '08:00', '17:00', '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (14, '09:00', '16:00', null, null, null, null, '09:00', '16:00', '09:00', '16:00', '09:00', '16:00', '09:00', '16:00', '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (15, '09:00', '17:00', '09:00', '17:00', null, null, null, null, '09:00', '17:00', '09:00', '17:00', '09:00', '17:00', '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (16, '09:00', '17:00', '09:00', '17:00', '09:00', '17:00', null, null, null, null, '09:00', '17:00', '09:00', '17:00', '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (17, '09:00', '17:00', '09:00', '17:00', '09:00', '17:00', '09:00', '17:00', null, null, null, null, '09:00', '17:00', '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (18, '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', null, null, null, null, '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (19, '08:00', '16:00', '08:00', '16:00', '08:00', '16:00', '08:00', '16:00', '08:00', '16:00', null, null, null, null, '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (20, null, null, null, null, '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (21, '08:00', '16:00', null, null, null, null, '08:00', '16:00', '08:00', '16:00', '08:00', '16:00', '08:00', '16:00', '12:00', '13:00');
INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) VALUES (22, '08:00', '17:00', '08:00', '17:00', null, null, null, null, '08:00', '17:00', '08:00', '17:00', '08:00', '17:00', '12:00', '13:00');


INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (5, 23, 1, '09:00', '10:00', '2022-08-22', 'Confirmed', 'Referred by PCP for chest pain');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (8, 24, 4, '14:00', '15:00', '2022-08-22', 'Pending', 'Annual checkup');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (14, 28, 10, '10:00', '11:30', '2022-08-22', 'Confirmed', 'Bloodwork');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (22, 30, 18, '16:00', '17:00', '2022-08-23', 'Confirmed', 'Teeth cleaning');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (21, 31, 17, '15:00', '16:00', '2022-08-09', 'Cancelled', 'Jaw pain');


INSERT INTO notifications (user_id, message, is_read) VALUES (5, 'Patient is waiting for appointment confirmation.', true);
INSERT INTO notifications (user_id, message, is_read) VALUES (23, 'The doctor has confirmed your appointment.', true);
INSERT INTO notifications (user_id, message, is_read) VALUES (21, 'Appointment cancelled successfully.', true);
INSERT INTO notifications (user_id, message, is_read) VALUES (8, 'Patient is waiting for appointment confirmation.', false);

COMMIT TRANSACTION;
