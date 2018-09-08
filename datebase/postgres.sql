DO $$ DECLARE
  r RECORD;
BEGIN
  -- if the schema you operate on is not "current", you will want to
  -- replace current_schema() in query with 'schematodeletetablesfrom'
  -- *and* update the generate 'DROP...' accordingly.
  FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = current_schema()) LOOP
    EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE';
  END LOOP;
END $$;

CREATE TABLE IF NOT EXISTS users (
  username TEXT PRIMARY KEY,
  password TEXT NOT NULL
);

INSERT INTO users
VALUES ('demo', 'demo123');

CREATE TABLE IF NOT EXISTS resource (
  id   SERIAL PRIMARY KEY,
  name TEXT        NOT NULL,
  uri  TEXT UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS video (
  id       INTEGER PRIMARY KEY REFERENCES resource ON DELETE CASCADE,
  uploader TEXT NOT NULL REFERENCES users ON DELETE RESTRICT
);

INSERT INTO resource (name, uri)
VALUES ('one piece', '');

INSERT INTO video (id, uploader)
VALUES ((SELECT id FROM resource WHERE name = 'one piece'), 'demo');

