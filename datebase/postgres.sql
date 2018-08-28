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
VALUES ('admin', 'password');

CREATE TABLE IF NOT EXISTS video (
  id       SERIAL PRIMARY KEY,
  uploader TEXT NOT NULL REFERENCES users ON DELETE RESTRICT,
  name     TEXT NOT NULL
);

INSERT INTO video (uploader, name)
VALUES ('admin', 'one piece');

