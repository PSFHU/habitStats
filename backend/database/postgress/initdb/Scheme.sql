CREATE TABLE IF NOT EXISTS users (
  id            SERIAL NOT NULL PRIMARY KEY,
  username      VARCHAR(255) NOT NULL,
  password      VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS roles (
  id            SERIAL NOT NULL PRIMARY KEY,
  role_name     VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS unit_type (
  id                SERIAL NOT NULL PRIMARY KEY,
  unit_type_name    VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS stat_category (
  id                    SERIAL NOT NULL PRIMARY KEY,
  stat_category_name    VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS goal (
  id                SERIAL NOT NULL PRIMARY KEY,
  title             VARCHAR(255) NOT NULL,
  goal_value        NUMERIC NOT NULL,
  goal_logic        VARCHAR(255) NOT NULL,
  goal_completed    BOOLEAN NOT NULL DEFAULT FALSE
);

-- Foreign Key tables

CREATE TABLE IF NOT EXISTS stat (
  id                SERIAL NOT NULL PRIMARY KEY,
  stat_name         VARCHAR(255) NOT NULL,
  unit_type_id      BIGINT NOT NULL REFERENCES unit_type (id),
  stat_category_id  BIGINT NOT NULL REFERENCES stat_category (id),
  user_id           BIGINT REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS progress (
  id                    SERIAL NOT NULL PRIMARY KEY,
  stat_id               BIGINT NOT NULL REFERENCES stat (id),
  progress_value        NUMERIC NOT NULL,
  progress_timestamp    TIMESTAMP NOT NULL DEFAULT current_timestamp
);

-- Many to Many tables

CREATE TABLE IF NOT EXISTS goal_stat (
  id            SERIAL NOT NULL PRIMARY KEY,
  goal_id       BIGINT NOT NULL REFERENCES goal (id),
  stat_id       BIGINT NOT NULL REFERENCES stat (id)
);

CREATE TABLE IF NOT EXISTS user_role (
  id            SERIAL NOT NULL PRIMARY KEY,
  user_id       BIGINT NOT NULL REFERENCES users (id),
  role_id       BIGINT NOT NULL REFERENCES roles (id)
);
