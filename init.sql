create table "user"(
                       id serial primary key,
                       username varchar(50) not null unique ,
                       password varchar(50) not null ,
                       status int not null default 1,
                       role int not null default 1
);

create table client(
                       id serial primary key ,
                       user_id int not null unique ,
                       first_name varchar(50),
                       last_name varchar(50),
                       foreign key (user_id)
                           references "user"(id) on delete cascade
);

create table client_params(
                              id serial primary key ,
                              client_id int not null unique ,
                              weight int not null ,
                              height int not null ,
                              age int not null,
                            foreign key (client_id)
                          references client(id) on delete cascade
);

create table wardrobe(
                         id serial primary key ,
                         client_id int not null unique ,
                         name varchar(30),
                         volume int default 20,
                         foreign key (client_id)
                             references client(id) on delete cascade
);

create table item_type(
                          id serial primary key ,
                          name varchar(40)
);

create table item(
                     id serial primary key ,
                     wardrobe_id int not null,
                     color varchar(50),
                     type_id int not null default 1,
                     size varchar(30),
                     creator varchar(50),
                     foreign key (type_id)
                         references item_type(id),
                        foreign key (wardrobe_id)
                 references wardrobe(id) on delete cascade
);