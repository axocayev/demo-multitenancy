create database application;
create schema tenanta;
create schema tenantb;
create schema tenantc;

create table tenanta.person
(
    id    integer primary key,
    name  varchar(64)  not null,
    age   integer      not null,
    email varchar(265) not null

);

create table tenantb.person
(
    id    integer primary key,
    name  varchar(64)  not null,
    age   integer      not null,
    email varchar(265) not null

);

create table tenantc.person
(
    id    integer primary key,
    name  varchar(64)  not null,
    age   integer      not null,
    email varchar(265) not null

);




create  sequence  tenanta.person_id_seq;
create  sequence  tenantb.person_id_seq;
create  sequence  tenantc.person_id_seq;
