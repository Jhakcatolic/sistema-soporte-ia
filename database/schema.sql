
CREATE DATABASE sistema_soporte;

CREATE TABLE rol (
    id_rol SERIAL PRIMARY KEY,
    nombre VARCHAR(50)
);

CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    id_rol INT REFERENCES rol(id_rol)
);

CREATE TABLE estado (
    id_estado SERIAL PRIMARY KEY,
    nombre VARCHAR(50)
);

CREATE TABLE ticket (
    id_ticket SERIAL PRIMARY KEY,
    titulo VARCHAR(100),
    descripcion TEXT,
    fecha_creacion TIMESTAMP,
    id_estado INT REFERENCES estado(id_estado),
    id_usuario INT REFERENCES usuario(id_usuario)
);

CREATE TABLE asignacion (
    id_asignacion SERIAL PRIMARY KEY,
    id_ticket INT REFERENCES ticket(id_ticket),
    id_tecnico INT REFERENCES usuario(id_usuario),
    fecha_asignacion TIMESTAMP
);

CREATE TABLE historial (
    id_historial SERIAL PRIMARY KEY,
    id_ticket INT REFERENCES ticket(id_ticket),
    accion VARCHAR(255),
    fecha TIMESTAMP
);