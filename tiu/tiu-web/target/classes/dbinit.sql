-- Sequence: seq_uzgps_poi_notification_id

-- DROP SEQUENCE seq_uzgps_poi_notification_id;

IF NOT EXISTS (SELECT 0 FROM pg_class where relname = 'seq_uzgps_poi_notification_id' )
THEN

	CREATE SEQUENCE seq_uzgps_poi_notification_id
	  INCREMENT 1
	  MINVALUE 1
	  MAXVALUE 9223372036854775807
	  START 5729
	  CACHE 1;
	ALTER TABLE seq_uzgps_poi_notification_id
	  OWNER TO uzgps;


END IF;


 -- Table: uzgps_poi_notification

-- DROP TABLE uzgps_poi_notification;

CREATE TABLE IF NOT EXISTS uzgps_poi_notification
(
  id bigint NOT NULL DEFAULT nextval('seq_uzgps_poi_notification_id'::regclass),
  gps_unit_id bigint,
  poi_id bigint,
  passtime timestamp without time zone,
  direction integer,
  status character varying(1) DEFAULT 'A'::character varying,
  geofence_id bigint,
  ntype integer,
  CONSTRAINT uzgps_poi_notification_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE uzgps_poi_notification
  OWNER TO uzgps;
