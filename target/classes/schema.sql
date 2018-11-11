create table account
(
   id bigint not null,
   email varchar(255) not null,
   nome varchar(255),
   cep varchar(255),
   primary key(id,email)
);

CREATE SEQUENCE SEQ_ACCOUNT; 

INSERT INTO account(id,email,nome,cep) VALUES (SEQ_ACCOUNT.NEXTVAL,'admin@admin.com','admin','03332-099');

INSERT INTO account(id,email,nome,cep) VALUES (SEQ_ACCOUNT.NEXTVAL,'ricartealan@hotmail.com','Alan','06330-000');