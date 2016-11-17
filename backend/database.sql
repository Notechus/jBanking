CREATE TABLE IF NOT EXISTS currency (
  id SERIAL PRIMARY KEY,
  currency_name VARCHAR(3) NOT NULL,
  buy_price DOUBLE,
  sell_price DOUBLE
);

CREATE TABLE IF NOT EXISTS location (
  id SERIAL PRIMARY KEY,
  streed_adress VARCHAR(30) NOT NULL ,
  postal_code VARCHAR(6) NOT NULL ,
  city VARCHAR(30) NOT NULL ,
  state_province VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS account (
  id SERIAL PRIMARY KEY ,
  owner_id BIGINT UNSIGNED NOT NULL,
  account_tumber VARCHAR(26) UNIQUE NOT NULL ,
  balance DOUBLE DEFAULT 0 NOT NULL ,
  creationtime TIMESTAMP DEFAULT now() NOT NULL,
  modificationtime TIMESTAMP DEFAULT now() NOT NULL
);

CREATE TABLE IF NOT EXISTS user (
  id SERIAL PRIMARY KEY ,
  account_id BIGINT UNSIGNED NOT NULL ,
  username VARCHAR(30) UNIQUE NOT NULL ,
  password VARCHAR(30) NOT NULL ,
  name VARCHAR(30) NOT NULL ,
  surname VARCHAR(30) NOT NULL ,
  location_id BIGINT UNSIGNED NOT NULL ,
  phone_number INT NOT NULL,
  email VARCHAR(30) NOT NULL,
  FOREIGN KEY (location_id) REFERENCES location(id)
);

CREATE TABLE IF NOT EXISTS transfer (
  id SERIAL PRIMARY KEY,
  sender_id BIGINT UNSIGNED NOT NULL ,
  receiver_id BIGINT UNSIGNED NOT NULL ,
  transactiontime TIMESTAMP DEFAULT now() NOT NULL ,
  currency_id BIGINT UNSIGNED NOT NULL ,
  amount DOUBLE NOT NULL ,
  description VARCHAR(150) NOT NULL,
  FOREIGN KEY (sender_id) REFERENCES account(id),
  FOREIGN KEY (receiver_id) REFERENCES account(id),
  FOREIGN KEY (currency_id) REFERENCES currency(id)
);

ALTER TABLE account
    ADD FOREIGN KEY (owner_id) REFERENCES user(id);

ALTER TABLE user
    ADD FOREIGN KEY (account_id) REFERENCES account(id);
