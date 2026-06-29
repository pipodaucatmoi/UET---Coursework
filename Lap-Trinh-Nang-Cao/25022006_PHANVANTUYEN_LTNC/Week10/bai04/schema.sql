CREATE DATABASE app;
USE chat_app;

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(100) NOT NULL UNIQUE,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE rooms (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       room_name VARCHAR(100) NOT NULL UNIQUE,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE room_members (
                              user_id INT NOT NULL,
                              room_id INT NOT NULL,
                              joined_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              PRIMARY KEY (user_id, room_id),
                              FOREIGN KEY (user_id) REFERENCES users(id),
                              FOREIGN KEY (room_id) REFERENCES rooms(id)
);

CREATE TABLE messages (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT NOT NULL,
                          room_id INT NOT NULL,
                          content TEXT NOT NULL,
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (user_id) REFERENCES users(id),
                          FOREIGN KEY (room_id) REFERENCES rooms(id)
);