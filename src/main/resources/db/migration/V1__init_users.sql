CREATE TABLE IF NOT EXISTS users (
    user_id UUID PRIMARY KEY,
    first_name VARCHAR(100),
    last_name  VARCHAR(100),
    email      VARCHAR(150) UNIQUE NOT NULL,
    active     BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_users_active ON users(active);
