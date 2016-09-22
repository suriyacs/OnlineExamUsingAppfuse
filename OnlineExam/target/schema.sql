
    alter table Choice 
        drop 
        foreign key FK_7gwsowwor5d5co69y8upbnmj9;

    alter table Question 
        drop 
        foreign key FK_lna4oawephgqwlc8j9k0fgbp7;

    alter table user_role 
        drop 
        foreign key FK_it77eq964jhfqtu54081ebtio;

    alter table user_role 
        drop 
        foreign key FK_apcc8lxk2xnug8377fatvbn04;

    drop table if exists Choice;

    drop table if exists Question;

    drop table if exists QuestionType;

    drop table if exists app_user;

    drop table if exists role;

    drop table if exists user_role;

    create table Choice (
        choice_id integer not null auto_increment,
        choice_name varchar(255),
        is_correct integer,
        question_id integer,
        primary key (choice_id)
    ) ENGINE=InnoDB;

    create table Question (
        question_id integer not null auto_increment,
        question varchar(255),
        type_id integer,
        primary key (question_id)
    ) ENGINE=InnoDB;

    create table QuestionType (
        type_id integer not null auto_increment,
        type_name varchar(255),
        primary key (type_id)
    ) ENGINE=InnoDB;

    create table app_user (
        id bigint not null auto_increment,
        account_expired bit not null,
        account_locked bit not null,
        address varchar(150),
        city varchar(50),
        country varchar(100),
        postal_code varchar(15),
        province varchar(100),
        credentials_expired bit not null,
        email varchar(255) not null,
        account_enabled bit,
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        password varchar(255) not null,
        password_hint varchar(255),
        phone_number varchar(255),
        username varchar(50) not null,
        version integer,
        website varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table role (
        id bigint not null auto_increment,
        description varchar(64),
        name varchar(20),
        primary key (id)
    ) ENGINE=InnoDB;

    create table user_role (
        user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) ENGINE=InnoDB;

    alter table app_user 
        add constraint UK_1j9d9a06i600gd43uu3km82jw  unique (email);

    alter table app_user 
        add constraint UK_3k4cplvh82srueuttfkwnylq0  unique (username);

    alter table Choice 
        add constraint FK_7gwsowwor5d5co69y8upbnmj9 
        foreign key (question_id) 
        references Question (question_id);

    alter table Question 
        add constraint FK_lna4oawephgqwlc8j9k0fgbp7 
        foreign key (type_id) 
        references QuestionType (type_id);

    alter table user_role 
        add constraint FK_it77eq964jhfqtu54081ebtio 
        foreign key (role_id) 
        references role (id);

    alter table user_role 
        add constraint FK_apcc8lxk2xnug8377fatvbn04 
        foreign key (user_id) 
        references app_user (id);
