-- MySQL schema
CREATE DATABASE IF NOT EXISTS blood_db;
USE blood_db;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(120) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(20) DEFAULT 'USER'
);

CREATE TABLE IF NOT EXISTS donors (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  blood_group VARCHAR(5) NOT NULL,
  city VARCHAR(80) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS blood_requests (
  id INT AUTO_INCREMENT PRIMARY KEY,
  patient_name VARCHAR(120) NOT NULL,
  blood_group VARCHAR(5) NOT NULL,
  city VARCHAR(80) NOT NULL,
  hospital VARCHAR(160) NOT NULL,
  contact VARCHAR(20) NOT NULL,
  status VARCHAR(20) DEFAULT 'OPEN',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Seed an admin (password: admin123)
INSERT INTO users(name,email,password,role)
VALUES ('Admin','admin@blood.org','admin123','ADMIN')
ON DUPLICATE KEY UPDATE email=email;
