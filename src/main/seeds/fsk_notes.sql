DROP DATABASE IF EXISTS fsk_notes;
CREATE DATABASE fsk_notes;
USE fsk_notes;

CREATE TABLE users (
  user_id INTEGER NOT NULL AUTO_INCREMENT,
  user_name CHAR(64) NOT NULL,
  password CHAR(64) NOT NULL,
  firstname CHAR(64) NOT NULL,
  lastname CHAR(64) NOT NULL,

  PRIMARY KEY(user_id)
);

CREATE TABLE notes (
  note_id INTEGER NOT NULL AUTO_INCREMENT,
  content VARCHAR(200) NOT NULL,
  user_id INTEGER NOT NULL,

  PRIMARY KEY(note_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);
