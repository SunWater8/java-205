create table project.`Members`(
  idx int auto_increment,
  userID VARCHAR(14) NOT NULL,
  password varchar(20) not null,
  NAME varchar(20) not null,
  JOINDATE datetime DEFAULT current_timestamp,
  PRIMARY KEY (idx)
)


