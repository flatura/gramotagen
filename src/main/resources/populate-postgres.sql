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
  id                      uuid                    DEFAULT uuid_generate_v4 (),
  serial                  varchar(8)              ,
  number                  INTEGER                 ,
  type                    varchar(15)             NOT NULL,
  competition_theme_short varchar(30)             NOT NULL,
  competition_theme       varchar(85)             NOT NULL,
  discipline              varchar(40)             NOT NULL,
  competition_date        DATE                    ,
  name                    varchar(15)             NOT NULL,
  middle_name             varchar(15)             ,
  surname                 varchar(15)             NOT NULL,
  birth_date              DATE                    ,
  class                   varchar(5)              ,
  actual_class            varchar(5)              ,
  school                  varchar(15)             ,
  points                  INTEGER                 ,
  place                   varchar(15)             ,
  status                  varchar(15)             NOT NULL,
  issued                  TIMESTAMP DEFAULT now() NOT NULL,
  created                 TIMESTAMP DEFAULT now() NOT NULL,
  modified                TIMESTAMP DEFAULT now() ,
  printed_count           INTEGER                 DEFAULT 0,
  statgrad_login          varchar(40)             ,
  decree                  varchar(40)             ,
  template                varchar(40)             DEFAULT 'default',
  CONSTRAINT unique_diploma_idx UNIQUE (name, middle_name, surname, issued, competition_theme_short)
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

INSERT INTO diploma (type, competition_theme_short, competition_theme, discipline, name, middle_name, surname, class, school, status, decree) VALUES
('Грамота', 'russia-olympiad-engl-2020-1', 'Всероссийская олимпиада школьников по предмету Английский язык', 'Английский язык', 'Алла', 'Сергеевна', 'Александрова', '9', 'sch771507', 'победитель', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-biol-2020-1', 'Всероссийская олимпиада школьников по предмету Биология', 'Биология', 'Алла', 'Сергеевна', 'Александрова', '9', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-russ-2020-1', 'Всероссийская олимпиада школьников по предмету Русский язык', 'Русский язык', 'Алла', 'Сергеевна', 'Александрова', '9', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-phys-2020-1', 'Всероссийская олимпиада школьников по предмету Физика', 'Физика', 'Алла', 'Сергеевна', 'Александрова', '9', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-ekol-2020-1', 'Всероссийская олимпиада школьников по предмету Экология', 'Экология', 'Алла', 'Сергеевна', 'Александрова', '9', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-engl-2020-1', 'Всероссийская олимпиада школьников по предмету Английский язык', 'Английский язык', 'Алекей', 'Витальевич', 'Алёхин', '8', 'sch771507', 'победитель', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-russ-2020-1', 'Всероссийская олимпиада школьников по предмету Русский язык', 'Русский язык', 'Алекcей', 'Витальевич', 'Алёхин', '8', 'sch771507', 'победитель', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-engl-2020-1', 'Всероссийская олимпиада школьников по предмету Английский язык', 'Английский язык', 'Анна', 'Витальевна', 'Алехина', '5', 'sch771507', 'победитель', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-russ-2020-1', 'Всероссийская олимпиада школьников по предмету Русский язык', 'Русский язык', 'Анна', 'Витальевна', 'Алехина', '5', 'sch771507', 'победитель', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-soci-2020-1', 'Всероссийская олимпиада школьников по предмету Обществознание', 'Обществознание', 'Самира', 'Хайдаровна', 'Алимханова', '10', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-russ-2020-1', 'Всероссийская олимпиада школьников по предмету Русский язык', 'Русский язык', 'Самира', 'Хайдаровна', 'Алимханова', '10', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-russ-2020-1', 'Всероссийская олимпиада школьников по предмету Русский язык', 'Русский язык', 'Нина', 'Геннадиевна', 'Андреева', '7', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-pcul-2020-1', 'Всероссийская олимпиада школьников по предмету Физическая культура', 'Физическая культура', 'Нина', 'Генадьевна', 'Андреева', '7', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-biol-2020-1', 'Всероссийская олимпиада школьников по предмету Биология', 'Биология', 'Екатерина', 'Константиновна', 'Андрианова', '9', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-russ-2020-1', 'Всероссийская олимпиада школьников по предмету Русский язык', 'Русский язык', 'Галина', 'Константиновна', 'Андрианова', '4', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-russ-2020-1', 'Всероссийская олимпиада школьников по предмету Русский язык', 'Русский язык', 'Екатерина', 'Константиновна', 'Андрианова', '9', 'sch771507', 'победитель', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-ekol-2020-1', 'Всероссийская олимпиада школьников по предмету Экология', 'Экология', 'Екатерина', 'Константиновна', 'Андрианова', '9', 'sch771507', 'победитель', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-engl-2020-1', 'Всероссийская олимпиада школьников по предмету Английский язык', 'Английский язык', 'Вероника', 'Сергеевна', 'Аникина', '8', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-soci-2020-1', 'Всероссийская олимпиада школьников по предмету Обществознание', 'Обществознание', 'Вероника', 'Сергеевна', 'Аникина', '8', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-russ-2020-1', 'Всероссийская олимпиада школьников по предмету Русский язык', 'Русский язык', 'Вероника', 'Сергеевна', 'Аникина', '8', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-engl-2020-1', 'Всероссийская олимпиада школьников по предмету Английский язык', 'Английский язык', 'Евдокия', 'Александровна', 'Анисина', '6', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-engl-2020-1', 'Всероссийская олимпиада школьников по предмету Английский язык', 'Английский язык', 'Егор', 'Евгеньевич', 'Антипов', '7', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20'),
('Грамота', 'russia-olympiad-bsvf-2020-1', 'Всероссийская олимпиада школьников по предмету Основы безопасности жизнедеятельности', 'Основы безопасности жизнедеятельности', 'Кирилл', 'Денисович', 'Антоненко', '8', 'sch771507', 'призёр', 'Приказ №33 от 07.09.20');