create table if not exists phones (
    type varchar(255) not null,
    number varchar(55) not null,
    applicant_id int
);

create table if not exists advisors (
     id serial primary key,
     first_name varchar(255) not null,
     last_name varchar(255) not null,
     email varchar(255) not null unique,
     cognito_user_name varchar(255) not null,
     role varchar(255)
);

create table if not exists applicants (
    id serial primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) not null unique,
    cognito_user_name varchar(255) not null,
    ssn varchar(255) not null,
    city varchar(255),
    street varchar(255),
    number varchar(55),
    apt int,
    zip int
);
alter table phones
drop constraint if exists fk_phones_applicants;
alter table phones add constraint fk_phones_applicants
foreign key (applicant_id) references applicants(id);

create table if not exists applications (
  id serial primary key,
  amount bigint not null,
  status varchar(255) not null,
  created timestamp not null default now(),
  assigned timestamp,
  resolved timestamp,
  applicant_id int not null references applicants(id),
  advisor_id int references advisors(id)
);