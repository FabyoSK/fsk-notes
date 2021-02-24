DROP DATABASE IF EXISTS fsk_notes;
CREATE DATABASE fsk_notes;
USE fsk_notes;

CREATE TABLE users (
  user_id INTEGER NOT NULL AUTO_INCREMENT,
  user_name CHAR(15) NOT NULL, 

  PRIMARY KEY(user_id)
);
CREATE TABLE notes (
  note_id INTEGER NOT NULL AUTO_INCREMENT,
  content VARCHAR(200) NOT NULL,
  user_id INTEGER NOT NULL,

  PRIMARY KEY(note_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

insert into users(user_name) values ("fsk");
insert into users(user_name) values ("nox");

insert into notes(content, user_id) values ("Loli is LOVEEEEEE", 1);
insert into notes(content, user_id) values ("FSK On the DB", 1);
insert into notes(content, user_id) values ("Nox, Fox, Rox, GigiNox, iNox", 2);