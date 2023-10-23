drop table CelestialBody;
drop table CelestialEvent;
drop table CelestialLocation;
drop table CelestialObservation;
drop table Telescope;
drop table TelescopeType;

CREATE TABLE CelestialBody (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    location INTEGER
);

INSERT INTO CelestialBody (name, location) VALUES ('The North Star (Polaris)',1);
INSERT INTO CelestialBody (name, location) VALUES ('The Crab Nebula (M1)',2);
INSERT INTO CelestialBody (name, location) VALUES ('The Andromeda Galaxy (M31)',3);
INSERT INTO CelestialBody (name, location) VALUES ('The Virgo Cluster',4);
INSERT INTO CelestialBody (name, location) VALUES ('Sirius (the brightest star in the night sky)',5);
INSERT INTO CelestialBody (name, location) VALUES ('Betelgeuse (a red supergiant star in Orion)',6);
INSERT INTO CelestialBody (name, location) VALUES ('Milky Way center',7);
INSERT INTO CelestialBody (name, location) VALUES ('Cetus Ring Nebula',8);


CREATE TABLE CelestialEvent (
	id SERIAL PRIMARY KEY,
	event VARCHAR(50),
	location int
);

INSERT INTO CelestialEvent (event, location) VALUES ('Solar Eclipse',1);
INSERT INTO CelestialEvent (event, location) VALUES ('Lunar Eclipse',2);
INSERT INTO CelestialEvent (event, location) VALUES ('Meteor shower',3);
INSERT INTO CelestialEvent (event, location) VALUES ('Comet',4);
INSERT INTO CelestialEvent (event, location) VALUES ('Supernova',5);



CREATE TABLE CelestialLocation (
	id SERIAL PRIMARY KEY,
	celestialLongitude DOUBLE PRECISION,
	celestialLatitude DOUBLE PRECISION
);

INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (2.425656368, 89.233105469);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (5.575891879, 22.014201539);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (0.7034927881, 41.269897276);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (12.452145996, 12.741471277);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (6.871434065, -16.741061602);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (8.776453583, -5.224153657);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (266.425111092, -28.940447218);
INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) VALUES (22.976937784, -4.034066323);

CREATE TABLE CelestialObservation (
	id SERIAL PRIMARY KEY,
	observation VARCHAR(50),
	location int
);

INSERT INTO CelestialObservation (observation, location) VALUES ('The Crab Nebula', 1);
INSERT INTO CelestialObservation (observation, location) VALUES ('The Andromeda Galaxy', 2);
INSERT INTO CelestialObservation (observation, location) VALUES ('The Orion Nebula', 3);
INSERT INTO CelestialObservation (observation, location) VALUES ('The Pleiades star cluster', 4);
INSERT INTO CelestialObservation (observation, location) VALUES ('The Hubble Deep Field', 5);


CREATE TABLE Telescope (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	location INT,
	type INT,
	aperture DOUBLE PRECISION,
	fieldOfView DOUBLE PRECISION
);

INSERT INTO Telescope (name, location, type, aperture, fieldOfView) VALUES ('Hubble Space Telescope', 0, 1, 2.4, 5);
INSERT INTO Telescope (name, location, type, aperture, fieldOfView) VALUES ('James Webb Space Telescope', 0, 1, 6.5, 2.5);
INSERT INTO Telescope (name, location, type, aperture, fieldOfView) VALUES ('Keck Observatory', 1, 1, 10, 1.8);
INSERT INTO Telescope (name, location, type, aperture, fieldOfView) VALUES ('Very Large Telescope', 1, 1, 8.2, 1.4);
INSERT INTO Telescope (name, location, type, aperture, fieldOfView) VALUES ('Subaru Telescope', 1, 1, 8.2, 1.4);



CREATE TABLE TelescopeType (
	id SERIAL PRIMARY KEY,
	name VarChar(50)
);

INSERT INTO TelescopeType (name) VALUES ('UNKNOWN');
INSERT INTO TelescopeType (name) VALUES ('REFRACTOR');
INSERT INTO TelescopeType (name) VALUES ('REFLECTOR');
INSERT INTO TelescopeType (name) VALUES ('UNKNCATADIOPTRICOWN');