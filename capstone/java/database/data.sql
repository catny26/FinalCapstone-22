BEGIN TRANSACTION;

INSERT INTO users (username,full_name,password_hash,role) VALUES ('user','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,full_name,password_hash,role) VALUES ('admin','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour, office_image_url, delay) VALUES ('Cardiology Consultants of Philadelphia', '207 N Broad St, Philadelphia, PA 19107', 2152273627, '08:00', '16:00', 50, 'https://array-architects.com/wp-content/uploads/2021/01/Array_CCP-Hero-1.png', false);
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour, office_image_url, delay) VALUES ('Philadelphia Family Medicine', '1028 W Oregon Ave, Philadelphia, PA 19148', 2153897766, '09:00', '18:00', 60, 'https://www.ghp-news.com/wp-content/uploads/2020/06/doctors-office-1920-x-1080.jpg', false);
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour, office_image_url, delay) VALUES ('Thomas Jefferson University Hospital', '805 Locust St, Philadelphia, PA 19107', 2154408681, '07:30', '17:00', 80, 'https://www.pagnes.com/wp-content/uploads/2019/09/DSC_4238.jpg', false);
INSERT INTO office_info (office_name, address, phone_number, office_hours_open, office_hours_close, cost_per_hour, office_image_url, delay) VALUES ('Philadelphia Dentistry', '1601 Walnut St #1302, Philadelphia, PA 19102', 2155686222, '08:00', '17:00', 70, 'https://www.westend61.de/images/0001070955pw/interior-of-an-up-to-date-dentist-office-MINF09188.jpg', false);



INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('catngo','Cathy Ngo', '$2a$10$roEU8vxSuptaEx7pYoZZtO1yK3d96Igmm7rq5elVie2J619KOlKvK', 'ROLE_DOCTOR', 'Family Physician');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('ncrook','Noni Crook', '$2a$10$ogTEgfBYp6QWjnrIEc9eE./sg0Z5N3nNJoos/fDZ7V1HQ0mb1xObO', 'ROLE_DOCTOR', 'Family Physician');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('smusk','Sam Muskovitz', '$2a$10$650G03GHqqc54X3NLBN75OVmIBqg8dE8C2qWYgEJG/2h93yDoan2O', 'ROLE_DOCTOR', 'Family Physician');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('tbeerbower','Tom Beerbower', '$2a$10$lNRd07SC93L/J7xvu8QZfO3WRwpvnnQlrRFlktW.FkejrbT8n8z0S', 'ROLE_DOCTOR', 'Podiatrist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('mlaw','Myron Law-Doom', '$2a$10$kyAgKnRGadcD7NTZGOuzquIY2HFYWqi2mM5uf7Hzx/8CoA9pgjl0e', 'ROLE_DOCTOR', 'Psychiatrist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('abrantley', 'Amber Brantley', '$2a$10$qOuouPwl7gzvN/ECoBZLAeR5y.dipu25FwwVrqxJDHFU4kBDPloEu', 'ROLE_DOCTOR', 'Cardiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('jclayton','Joelle Clayton', '$2a$10$OH3qJIX4uYIqTGYxe4cC6eeUzzmCMeoAcc.hn3VQXrP0Z8axNyGp.', 'ROLE_DOCTOR', 'Cardiologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('tcherwony','Tara Cherwony', '$2a$10$5rXhe8Qd.PCoAMBP8m7NNOVgbDom..GIfpKxcBx4Q6x3Slop8KiVS', 'ROLE_DOCTOR', 'Dermatologist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('sbradley','Shawn Bradley', '$2a$10$yDuSJ5FPcrsT2gtWddOod..By8n5sTll7S7YFGkBztSjfqzMzGJb2', 'ROLE_DOCTOR', 'Dentist');
INSERT INTO users (username, full_name, password_hash, role, type_of_doctor) VALUES ('jlee','Jenn Lee', '$2a$10$FZdUDlfyhZB2pv5XbINVHea./A0au.b0xzHdw9Xf5NMAHCsPXiEJ2', 'ROLE_DOCTOR', 'Dentist');



INSERT INTO users (username, full_name, password_hash, role) VALUES ('aroberts','Abbie Robers', '$2a$10$O3AG4k3zGK2AlQ25BCICuO5XBMqw9xIiokim0z5zYpGeJgmj4Du7.', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('bgilroy','Bobi Gilroy', '$2a$10$Gqd18AnD8/JiWXmubZDCh.KOv2tDnfvxaLksOTXYV0sxVaSK80Ft.', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('xtinango','Christina Ngo', '$2a$10$.4LqvEWhBYny/fncCCQ68eUgaK4iIgLkTaxNlcM97UZkiPJpKWgQe', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('jschwartz','James Schwartz', '$2a$10$8ADqoiOncOF//Nr3MmHmtu68Mi8gtkifwH0zadyUj10GRG0MLY4Dq', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('jharris','Jamoni Harris', '$2a$10$/8nwx1EWiN25I/DtfMjU5OsmPsCeB5ZaXhZLQ8GqP33PpJUGNmA5O', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('jnoble','John Noble', '$2a$10$C.qXoRF5qTCvuOhkPZrVHurlnNzo8JrQ6OU3utQQCjmRuBIO0vw6q', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('jfinkeldey','Joshua Finkeldey', '$2a$10$ctvhD9gHKR.Fq.VnmWP0R.exNllLS6PJP5N.i2s/v1aKbuq5w7wPm', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('mnowell','Matt Nowell', '$2a$10$SwiVpcKv5plkJ1ZrsTc7iOVyNRfgkA/teox6gJNcJgmKGbxX1MVhq', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('mkongquee','Michael Kong-Quee', '$2a$10$75kYvpKvMTYRMs62u2z1Yucz0IlFA8RClgk4KWBrTHFY.C3v.eTSO', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('mstill','Mike Still', '$2a$10$L4Z9otQu/cYaahnZo/xJZOvqs5Dw5kc88ybusmZywHr5tNY65uUQG', 'ROLE_USER');
INSERT INTO users (username, full_name, password_hash, role) VALUES ('sbond','Sarah Bond', '$2a$10$5wG/PoWxMes6mbZ75q9NBuZ.Ttp./PX6w60LPeTDY9JhrPMPVGWAS', 'ROLE_USER');


INSERT INTO users_office_info (office_id, user_id) VALUES (1, 8);
INSERT INTO users_office_info (office_id, user_id) VALUES (1, 9);
INSERT INTO users_office_info (office_id, user_id) VALUES (2, 3);
INSERT INTO users_office_info (office_id, user_id) VALUES (2, 4);
INSERT INTO users_office_info (office_id, user_id) VALUES (2, 5);
INSERT INTO users_office_info (office_id, user_id) VALUES (3, 10);
INSERT INTO users_office_info (office_id, user_id) VALUES (3, 6);
INSERT INTO users_office_info (office_id, user_id) VALUES (3, 7);
INSERT INTO users_office_info (office_id, user_id) VALUES (4, 11);
INSERT INTO users_office_info (office_id, user_id) VALUES (4, 12);


INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'Dr. Ngo is the most attentive doctor ever!', 3, 13, 2, 'Thank you!');
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'I love seeing Dr. Crook, she is the best!', 4, 14, 2, 'Thank you!');
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'Dr. Muskovitz has been extremely helpful.', 5, 15, 2, 'Thank you!');
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'That Dr. Beerbower is a foot magician!', 6, 16, 3, 'Thank you!');
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'I have been seeing my psychiatrist, Dr. Law-Doom for years! Will never stop going!', 7, 17, 3, 'Thank you!');
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'My son loves his doctor!', 8, 18, 1, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'Very caring doctor.', 9, 19, 1, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'Great doctor.', 10, 20, 3, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'Dr. Bradley has been my dentist for years.', 11, 21, 4, null);
INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response) VALUES (5, 'Good dentist.', 12, 22, 4, null);

INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (3, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], null, null);
INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (4, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], null, null, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17]);
INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (5, array[8,9,10,11,13,14,15,16,17], null, null, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17]);
INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (6, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], null, null, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17]);
INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (7, null, null, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17]);
INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (8, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], null, null, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17]);
INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (9, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], null, null, array[8,9,10,11,13,14,15,16,17]);
INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (10, array[8,9,10,11,13,14,15,16,17], null, null, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17]);
INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (11, array[8,9,10,11,13,14,15,16,17], null, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], null, array[8,9,10,11,13,14,15,16,17]);
INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (12, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], null, array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], array[8,9,10,11,13,14,15,16,17], null);

INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3, 23, 1, '09:00', '10:00', '2022-08-23', 'Confirmed', 'Referred by PCP for chest pain');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3, 20, 1, '10:00', '11:00', '2022-08-24', 'Pending', 'Chest pain');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (3, 18, 1, '09:00', '10:00', '2022-08-25', 'Pending', 'Annual check-up');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (4, 22, 2, '14:00', '15:00', '2022-08-22', 'Confirmed', 'Annual checkup');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (5, 22, 3, '10:00', '11:30', '2022-08-22', 'Confirmed', 'Bloodwork');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (6, 15, 4, '16:00', '17:00', '2022-08-23', 'Confirmed', 'Teeth cleaning');
INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, status, reason) VALUES (7, 21, 5, '15:00', '16:00', '2022-08-09', 'Cancelled', 'Jaw pain');


INSERT INTO notifications (user_id, appointment_id, message, is_read) VALUES (3, 2, 'Patient is waiting for appointment confirmation.', false);
INSERT INTO notifications (user_id, appointment_id, message, is_read) VALUES (3, 3, 'Patient is waiting for appointment confirmation.', true);
INSERT INTO notifications (user_id, appointment_id, message, is_read) VALUES (3, 4, 'The doctor has confirmed your appointment.', true);
INSERT INTO notifications (user_id, appointment_id, message, is_read) VALUES (7, 7, 'Appointment cancelled successfully.', true);
INSERT INTO notifications (user_id, appointment_id, message, is_read) VALUES (7, 7, 'Patient has cancelled appointment.', false);

COMMIT TRANSACTION;
