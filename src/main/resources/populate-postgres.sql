DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS diploma;
DROP SEQUENCE IF EXISTS users_seq;
DROP SEQUENCE IF EXISTS users_roles_seq;
DROP SEQUENCE IF EXISTS diploma_seq;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SEQUENCE users_seq START WITH 100000;
CREATE SEQUENCE users_roles_seq START WITH 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('users_seq'),
  name             VARCHAR(45)                 NOT NULL,
  email            VARCHAR(255)                 NOT NULL,
  password         VARCHAR(60)                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL,
  CONSTRAINT unique_user_idx UNIQUE (email)
);

CREATE TABLE users_roles
(
  user_role_id     INTEGER PRIMARY KEY DEFAULT nextval('users_roles_seq'),
  user_id          INTEGER                 NOT NULL,
  role             VARCHAR(20),
  CONSTRAINT users_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE diploma (
  id                  uuid                    DEFAULT uuid_generate_v4 (),
  serial              varchar(8)              ,
  number              INTEGER                 ,
  type                varchar(15)             NOT NULL,
  issued              TIMESTAMP DEFAULT now() NOT NULL,
  created             TIMESTAMP DEFAULT now() NOT NULL,
  modified            TIMESTAMP DEFAULT now() ,
  printed_count       INTEGER                 DEFAULT 0,
  competition         varchar(40)             NOT NULL,
  discipline          varchar(15)             NOT NULL,
  competition_address varchar(255)            NOT NULL,
  competition_date    DATE                    NOT NULL,
  name                varchar(15)             NOT NULL,
  surname             varchar(15)             NOT NULL,
  middle_name         varchar(15)             ,
  class               varchar(5)              NOT NULL,
  birth_date          DATE                    NOT NULL,
  school              varchar(15)             ,
  place               varchar(15)             ,
  CONSTRAINT unique_diploma_idx UNIQUE (name, surname, middle_name, issued, competition, birth_date)
);

ALTER SEQUENCE users_seq RESTART WITH 100000;
ALTER SEQUENCE users_roles_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
('user', 'user1@yandex.ru', '$2a$10$23.P3eLizBkROvHC.IdsNezdusKHow7Uhrhaa0ceVC5degwI2DdXO'), --100000 password
('User2', 'user2@yandex.ru', '$2a$10$23.P3eLizBkROvHC.IdsNezdusKHow7Uhrhaa0ceVC5degwI2DdXO'), --100001 password
('Admin', 'admin@gmail.com', '$2a$10$23.P3eLizBkROvHC.IdsNezdusKHow7Uhrhaa0ceVC5degwI2DdXO'); --100002 password
INSERT INTO users_roles (role, user_id) VALUES
('ROLE_USER', 100000),
('ROLE_USER', 100001),
('ROLE_USER', 100002),
('ROLE_ADMIN', 100002);

INSERT INTO diploma (type, issued, competition, discipline, competition_address, competition_date, name, middle_name, surname, class, birth_date, school, place) VALUES
('Грамота', '2019-05-10', 'Всероссийская олимпиада по химии', 'Химия', 'Школа 1507', '2019-05-10', 'Василий', 'Васильевич','Мазаев', '11А', '2003-04-03', 'Школа 1507', 'Победитель'),
('Грамота', '2019-05-10', 'Всероссийская олимпиада по химии', 'Химия', 'Школа 1507', '2019-05-10', 'Петр', 'Петрович','Пак', '11К', '2002-09-09', 'Школа 1507', 'Участник'),
('Грамота', '2019-05-10', 'Всероссийская олимпиада по химии', 'Химия', 'Школа 1507', '2019-05-10', 'Наталья', 'Петровна', 'Лебедева', '10Б', '2004-12-09', 'Школа 1507', 'Победитель'),
('Грамота', '2019-05-10', 'Всероссийская олимпиада по химии', 'Химия', 'Школа 1507', '2019-05-10', 'Марина', 'Евгеньевна','Селезнева', '10В', '2002-11-04', 'Школа 1507', 'Участник'),
('Грамота', '2020-03-01', 'Фестиваль MadSkillz  2020', 'Информатика', 'Школа 1532', '2020-03-01', 'Василий', 'Васильевич','Мазаев', '11А', '2003-04-03', 'Школа 1507', 'Победитель'),
('Грамота', '2020-03-01', 'Фестиваль MadSkillz  2020', 'Информатика', 'Школа 1532', '2020-03-01', 'Наталья', 'Петровна', 'Лебедева', '10Б', '2004-12-09', 'Школа 1507', 'Участник'),
('Грамота', '2020-03-01', 'Фестиваль MadSkillz  2020', 'Информатика', 'Школа 1532', '2020-03-01', 'Петр', 'Петрович','Пак', '10В', '2004-05-01', 'Школа 1507', 'Участник'),
('Грамота', '2020-03-01', 'Фестиваль MadSkillz  2020', 'Информатика', 'Школа 1532', '2020-03-01', 'Александра', 'Дмитриевна', 'Любезнина', '11А', '2003-04-3', 'Школа 1507', 'Участник'),
('Грамота', '2020-03-01', 'Фестиваль MadSkillz  2020', 'Информатика', 'Школа 1532', '2020-03-01', 'Юлия', 'Александровна','Кухнечихина', '11А', '2003-04-3', 'Школа 1507', 'Участник'),
('Свидетельство', '2020-03-01', 'Олимпиада по русском языку', 'Русский язык', 'Школа 1507', '2020-03-01', 'Наталья', 'Петровна', 'Лебедева', '10Б', '2004-12-09', 'Школа 1507', 'Победитель'),
('Свидетельство', '2020-03-01', 'Олимпиада по русском языку', 'Русский язык', 'Школа 1507', '2020-03-01', 'Василий', 'Васильевич','Мазаев', '11А', '2003-04-03', 'Школа 1507', 'Участник'),
('Свидетельство', '2020-03-02', 'Олимпиада по русском языку', 'Русский язык', 'Школа 1507', '2020-03-01', 'Ангелина', 'Дмитриевна', 'Федосеева', '11А', '2003-04-03', 'Школа 1507', 'Участник'),
('Свидетельство', '2020-03-03', 'Олимпиада по русском языку', 'Русский язык', 'Школа 1507', '2020-03-01', 'Максим', 'Максимович','Максимов', '11А', '2003-04-3', 'Школа 1507', 'Участник');
