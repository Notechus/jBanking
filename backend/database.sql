CREATE TABLE IF NOT EXISTS currency (
  currency_id SERIAL PRIMARY KEY,
  currency_name VARCHAR(3) NOT NULL,
  buy_price DOUBLE,
  sell_price DOUBLE
);

CREATE TABLE IF NOT EXISTS location (
  location_id SERIAL PRIMARY KEY,
  streed_adress VARCHAR(30) NOT NULL ,
  postal_code VARCHAR(6) NOT NULL ,
  city VARCHAR(30) NOT NULL ,
  state_province VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS account (
  account_id SERIAL PRIMARY KEY ,
  owner_id BIGINT UNSIGNED NOT NULL,
  account_tumber VARCHAR(26) NOT NULL ,
  balance DOUBLE DEFAULT 0 NOT NULL ,
  creation_time TIMESTAMP DEFAULT now() NOT NULL,
  modification_time TIMESTAMP DEFAULT now() NOT NULL
);

CREATE TABLE IF NOT EXISTS user (
  user_id SERIAL PRIMARY KEY ,
  account_id BIGINT UNSIGNED NOT NULL ,
  username VARCHAR(30) NOT NULL ,
  password VARCHAR(30) NOT NULL ,
  name VARCHAR(30) NOT NULL ,
  surname VARCHAR(30) NOT NULL ,
  location_id BIGINT UNSIGNED NOT NULL ,
  phone_number INT NOT NULL,
  email VARCHAR(30) NOT NULL,
  FOREIGN KEY (location_id) REFERENCES location(location_id)
);

CREATE TABLE IF NOT EXISTS transaction (
  transaction_id SERIAL PRIMARY KEY,
  sender_id BIGINT UNSIGNED NOT NULL ,
  receiver_id BIGINT UNSIGNED NOT NULL ,
  transaction_time TIMESTAMP DEFAULT now() NOT NULL ,
  currency_id BIGINT UNSIGNED NOT NULL ,
  amount DOUBLE NOT NULL ,
  description VARCHAR(150) NOT NULL,
  FOREIGN KEY (sender_id) REFERENCES user(user_id),
  FOREIGN KEY (receiver_id) REFERENCES user(user_id),
  FOREIGN KEY (currency_id) REFERENCES currency(currency_id)
);

ALTER TABLE account
    ADD FOREIGN KEY (owner_id) REFERENCES user(user_id);

ALTER TABLE user
    ADD FOREIGN KEY (account_id) REFERENCES account(account_id);
