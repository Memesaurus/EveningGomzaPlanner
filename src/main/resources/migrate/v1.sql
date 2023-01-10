create table users (
    id identity not null primary key,
	username varchar_ignorecase(50) not null unique,
	email varchar_ignorecase(80) not null unique,
	telegram varchar_ignorecase(50) unique,
	password varchar_ignorecase(500) not null,
	enabled boolean not null
);

create table authorities (
    id identity not null primary key,
	userid BIGINT not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(userid) references users(id)
);
create unique index ix_auth_username on authorities (userid, authority);

create table eveningplans (
id identity not null primary key,
userid bigint not null,
mood varchar(50),
plans varchar(50),
submitted date not null,
constraint fk_eveningplans_users foreign key(userid) references users(id));