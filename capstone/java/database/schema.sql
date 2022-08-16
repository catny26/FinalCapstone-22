BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, notifications, office_info, users_office_info, reviews, agenda, appointments CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	full_name varchar(100) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	type_of_doctor varchar(50),
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE notifications (
    notification_id SERIAL NOT NULL,
    user_id bigint NOT NULL,
    message varchar (500) NOT NULL,
    is_read boolean NOT NULL,
    CONSTRAINT PK_notification PRIMARY KEY (notification_id),
    CONSTRAINT FK_notification_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE office_info (
    office_id SERIAL,
    office_name varchar(100) NOT NULL,
    address varchar(100) NOT NULL,
    phone_number bigint NOT NULL,
    office_hours_open time NOT NULL,
    office_hours_close time NOT NULL,
    cost_per_hour money NOT NULL,
    office_image_url varchar(500),
    delay boolean NOT NULL,
    CONSTRAINT PK_office_info PRIMARY KEY (office_id)
);

CREATE TABLE users_office_info (
    office_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT PK_user_office_info PRIMARY KEY (office_id, user_id),
    CONSTRAINT FK_user_office_info_office_info FOREIGN KEY (office_id) REFERENCES office_info (office_id),
    CONSTRAINT FK_user_office_info_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE reviews(
    review_id SERIAL NOT NULL,
    amount_of_stars int NOT NULL,
    review_message varchar(500),
    doctor_id bigint NOT NULL,
    patient_id bigint NOT NULL,
    office_id bigint NOT NULL,
    review_response varchar(500),
    CONSTRAINT PK_reviews PRIMARY KEY (review_id),
    CONSTRAINT FK_reviews_doctor FOREIGN KEY (doctor_id) REFERENCES users (user_id),
    CONSTRAINT FK_reviews_patient FOREIGN KEY (patient_id) REFERENCES users (user_id),
    CONSTRAINT FK_reviews_office_info FOREIGN KEY (office_id) REFERENCES office_info (office_id)
);


CREATE TABLE agenda (
    agenda_id SERIAL NOT NULL,
    doctor_id bigint NOT NULL,
    mon int[],
    tue int[],
    wen int[],
    thur int[],
    fri int[],
    sat int[],
    sun int[],
    CONSTRAINT PK_agenda PRIMARY KEY (agenda_id),
    CONSTRAINT FK_agenda_doctor FOREIGN KEY (doctor_id) REFERENCES users (user_id)
);

CREATE TABLE appointments (
    appointment_id SERIAL NOT NULL,
    doctor_id bigint NOT NULL,
    patient_id bigint NOT NULL,
    agenda_id bigint NOT NULL,
    start_time time NOT NULL,
    end_time time NOT NULL,
    appointment_date date NOT NULL,
    status varchar(9) NOT NULL,
    reason varchar(500) NOT NULL,
    CONSTRAINT PK_appointment PRIMARY KEY (appointment_id),
    CONSTRAINT FK_appointment_doctor FOREIGN KEY (doctor_id) REFERENCES users (user_id),
    CONSTRAINT FK_appointment_patient FOREIGN KEY (patient_id) REFERENCES users (user_id),
    CONSTRAINT FK_appointment_agenda FOREIGN KEY (agenda_id) REFERENCES agenda (agenda_id)
);

COMMIT TRANSACTION;
