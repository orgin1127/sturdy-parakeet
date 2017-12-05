create table blackjack (
    accountNumber number primary Key
    , userId varchar2(25) unique
    , password varchar2(35) not null
    , createDate date default sysdate
    , levels number default 3
);

create sequence blackjack_seq;

create table gameInfo (
    gameResultNumber number primary key
    , accountNumber number not null
    , money number default 10000
    , winCount number default 0
    , loseCount number default 0
    , gameCount number default 0
    , constraint gameInfo_fk foreign key (accountNumber)
    references blackjack(accountNumber) on delete cascade
);

create sequence gameInfo_seq;