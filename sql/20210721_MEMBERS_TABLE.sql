create table project.`Members`(
  idx int auto_increment,
  userid VARCHAR(14) NOT NULL,
  pw varchar(20) not null,
  name varchar(20) not null,
  joindate datetime DEFAULT current_timestamp,
  PRIMARY KEY (idx)
)


