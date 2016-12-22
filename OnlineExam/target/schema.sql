
    alter table Choice 
        drop 
        foreign key FK_7gwsowwor5d5co69y8upbnmj9;

    alter table Exam_answer 
        drop 
        foreign key FK_dl27poadpg7cyrf139nb0q2i4;

    alter table Exam_answer 
        drop 
        foreign key FK_hw1lgrwxmey5nxaj5wa5yaqqi;

    alter table Examquestion 
        drop 
        foreign key FK_m5x1a4layj1pi4mivofjn8377;

    alter table Examquestion 
        drop 
        foreign key FK_bpdthv3c8rtuycia9vimvhqdi;

    alter table Question 
        drop 
        foreign key FK_lna4oawephgqwlc8j9k0fgbp7;

    alter table Userexam 
        drop 
        foreign key FK_d3a3iok9ehb7r4lqdlhmjoo7r;

    alter table Userexam 
        drop 
        foreign key FK_nqrn0h74qb6prnjin9lfchrar;

    alter table user_role 
        drop 
        foreign key FK_it77eq964jhfqtu54081ebtio;

    alter table user_role 
        drop 
        foreign key FK_apcc8lxk2xnug8377fatvbn04;

    drop table if exists Choice;

    drop table if exists Exam;

    drop table if exists Exam_answer;

    drop table if exists Examquestion;

    drop table if exists Question;

    drop table if exists QuestionType;

    drop table if exists Userexam;

    drop table if exists answer;

    drop table if exists app_user;

    drop table if exists result;

    drop table if exists role;

    drop table if exists user_role;

    create table Choice (
        choice_id integer not null auto_increment,
        choice_name varchar(255),
        is_correct integer,
        question_id integer,
        primary key (choice_id)
    ) ENGINE=InnoDB;

    create table Exam (
        exam_id integer not null auto_increment,
        duration integer,
        exam_name varchar(255),
        allocated_questions varchar(255),
        total_questions integer,
        primary key (exam_id)
    ) ENGINE=InnoDB;

    create table Exam_answer (
        Exam_exam_id integer not null,
        answers_answer_id integer not null
    ) ENGINE=InnoDB;

    create table Examquestion (
        exam_id integer not null,
        question_id integer not null
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

    create table Userexam (
        user_id bigint not null,
        exam_id integer not null,
        primary key (user_id, exam_id)
    ) ENGINE=InnoDB;

    create table answer (
        answer_id integer not null auto_increment,
        question_id integer,
        answer varchar(255),
        primary key (answer_id)
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

    create table result (
        result_id integer not null auto_increment,
        exam_name varchar(255),
        mark integer,
        user_name varchar(255),
        primary key (result_id)
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

    alter table Exam_answer 
        add constraint UK_dl27poadpg7cyrf139nb0q2i4  unique (answers_answer_id);

    alter table app_user 
        add constraint UK_1j9d9a06i600gd43uu3km82jw  unique (email);

    alter table app_user 
        add constraint UK_3k4cplvh82srueuttfkwnylq0  unique (username);

    alter table Choice 
        add constraint FK_7gwsowwor5d5co69y8upbnmj9 
        foreign key (question_id) 
        references Question (question_id);

    alter table Exam_answer 
        add constraint FK_dl27poadpg7cyrf139nb0q2i4 
        foreign key (answers_answer_id) 
        references answer (answer_id);

    alter table Exam_answer 
        add constraint FK_hw1lgrwxmey5nxaj5wa5yaqqi 
        foreign key (Exam_exam_id) 
        references Exam (exam_id);

    alter table Examquestion 
        add constraint FK_m5x1a4layj1pi4mivofjn8377 
        foreign key (question_id) 
        references Question (question_id);

    alter table Examquestion 
        add constraint FK_bpdthv3c8rtuycia9vimvhqdi 
        foreign key (exam_id) 
        references Exam (exam_id);

    alter table Question 
        add constraint FK_lna4oawephgqwlc8j9k0fgbp7 
        foreign key (type_id) 
        references QuestionType (type_id);

    alter table Userexam 
        add constraint FK_d3a3iok9ehb7r4lqdlhmjoo7r 
        foreign key (exam_id) 
        references Exam (exam_id);

    alter table Userexam 
        add constraint FK_nqrn0h74qb6prnjin9lfchrar 
        foreign key (user_id) 
        references app_user (id);

    alter table user_role 
        add constraint FK_it77eq964jhfqtu54081ebtio 
        foreign key (role_id) 
        references role (id);

    alter table user_role 
        add constraint FK_apcc8lxk2xnug8377fatvbn04 
        foreign key (user_id) 
        references app_user (id);
