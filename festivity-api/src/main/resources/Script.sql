
--Creation of the role
CREATE ROLE postgres LOGIN
  ENCRYPTED PASSWORD 'md53175bce1d3201d16594cebf9d7eb3f9d'
  SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;

--Create the user for the above described role
CREATE DATABASE postgres
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;

COMMENT ON DATABASE postgres
  IS 'default administrative connection database';
  
--Festivity table 
  CREATE TABLE festivity
(
  festivity_id character varying,
  festivity_name character varying(30) NOT NULL,
  festivity_place character varying(30) NOT NULL,
  festivity_start_date character varying(30) NOT NULL,
  festivity_end_date character varying(30) NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE festivity
  OWNER TO postgres;
  
  