CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE users
(
    user_id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    email VARCHAR(255) NOT NULL ,
    password VARCHAR(255) NOT NULL ,
    profile_image VARCHAR(255)
);
CREATE TABLE categories
(
    category_id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR(255) NOT NULL ,
    description VARCHAR(255) NOT NULL ,
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE otps
(
    opt_id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    opt_code INT,
    issued_at  DATE,
    expiration DATE,
    verify BOOLEAN DEFAULT FALSE,
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE expenses
(
    expense_id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    amount DECIMAL(10, 2),
    description VARCHAR(255),
    date DATE,
    user_id UUID,
    category_id UUID,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE ON UPDATE CASCADE
);