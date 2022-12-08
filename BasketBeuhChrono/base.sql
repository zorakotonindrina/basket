CREATE database basket;
\c basket;

CREATE table Team(
    id_Team int CONSTRAINT PK_Team PRIMARY KEY,
    nom_Team VARCHAR 
);

CREATE table Gameur(
    id_Gameur int CONSTRAINT PK_Gameur PRIMARY KEY,
    nom VARCHAR ,
    id_Team int CONSTRAINT FK_Id_Team REFERENCES Team
);

CREATE table Match(
    id_Match int CONSTRAINT PK_Match PRIMARY KEY,
    id_Team1 int CONSTRAINT FK_Id_Team1 REFERENCES Team,
    id_Team2 int CONSTRAINT FK_Id_Team2 REFERENCES Team,
    date_match date

);

CREATE table Movement(
    id_Movement int CONSTRAINT PK_Movement PRIMARY KEY,
    id_Gameur int CONSTRAINT FK_Id_Gameur REFERENCES Gameur,
    type VARCHAR,
    level int,
    temps float,  
    id_Match int CONSTRAINT FK_Id_id_Match REFERENCES Match
);

CREATE table Pass(
    id_Pass int CONSTRAINT PK_Pass PRIMARY KEY,
    id_Gameur1 int CONSTRAINT FK_Id_Gameur1 REFERENCES Gameur,
    id_Gameur2 int CONSTRAINT FK_Id_Gameur2 REFERENCES Gameur,
    temps float,
    id_Match int CONSTRAINT FK_Id_id_Match REFERENCES Match
);

