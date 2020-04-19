use blog;
drop table user;
CREATE table blog.user(
id bigint(20) primary key auto_increment,
userName varchar(50) not null unique,
password varchar(32) not null,
firstName varchar(50) null default null,
lastName varchar(50) null default null,
mobile varchar(15) unique null,
email varchar(50) unique null,
registeredAt DATETIME not null,
lastLogin DATETIME null default null,
intro text null default null,
profile text null default null,
index idx_username (userName asc)
);
drop table post;
CREATE table blog.post(
id bigint primary key auto_increment,
authorId bigint(20) not null,
parentId bigint(20) not null,
title varchar(75) not null unique,
summary text null,
publishedStatus tinyint(1) not null default 0,
createdAt datetime not null,
updatedAt datetime null default null,
content text null default null,
index (authorId asc),
constraint fk_post_user foreign key (authorId) references blog.user(id) 
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

drop table post_meta;
CREATE TABLE `blog`.`post_meta` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `postId` BIGINT NOT NULL,
  `key` VARCHAR(50) NOT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_meta_post` (`postId` ASC),
  UNIQUE INDEX `uq_post_meta` (`postId` ASC, `key` ASC),
  CONSTRAINT `fk_meta_post`
    FOREIGN KEY (`postId`)
    REFERENCES `blog`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
   
drop table post_comment;
create table blog.post_comment(
id bigint(20) primary key auto_increment,
userId bigint(20) not null,
postId bigint(20) not null,
parentId bigint(20) null default null,
createdAt datetime not null,
updatedAt datetime null default null,
content text null default null,
index idx_comment_post(postId asc),
index idx_comment_parent (parentId asc),
constraint fk_comment_post foreign key (postId) references blog.post (id)
on delete no action
on update no action,
constraint fk_comment_user foreign key (userId) references blog.user (id)
on delete no action
on update no action);
ALTER table blog.post_comment add CONSTRAINT fk_comment_parent
  FOREIGN KEY (parentId)
  REFERENCES blog.post_comment (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
 
 
 drop table category;
create table blog.category(
id bigint(20) primary key auto_increment,
parentId bigint(20) null default null,
title varchar(75) not null unique,
metaTitle varchar(100) null default null,
index idx_category_parentId (parentId asc),
constraint fk_category_parent foreign key (parentId) references blog.category (id)
on delete no action
on update no action
);
 drop table post_category;
create table blog.post_category(
postId bigint not null,
categoryId bigint not null,
primary key (postId,categoryId),
index idx_pc_category (categoryId asc),
index idx_pc_post (postId asc),
constraint fk_pc_post foreign key (postId) references blog.post (id) 
on delete no action 
on update no action,
constraint fk_pc_category foreign key (categoryId) references blog.category (id) 
on delete no action 
on update no action
);

 drop table Friendship;
CREATE TABLE Friendship ( -- Stands for an associative entity type.
    RequesterId     bigint      NOT NULL,
    AddresseeId     bigint      NOT NULL, -- Fixed with a well-delimited data type.
    CreatedDateTime DATETIME NOT NULL,
    CONSTRAINT Friendship_PK            PRIMARY KEY (RequesterId, AddresseeId), -- Composite PRIMARY KEY.
    CONSTRAINT FriendshipToRequester_FK FOREIGN KEY (RequesterId)
        REFERENCES blog.user (id) 
        on delete no action 
        on update no action,
    CONSTRAINT FriendshipToAddressee_FK FOREIGN KEY (AddresseeId)
        REFERENCES blog.user (id) 
        on delete no action 
        on update no action
);

drop table avatar;
create table blog.avatar(
id bigint primary key auto_increment,
userId bigint not null,
srcAvatar varchar(100) not null unique,
constraint fk_avatar_user foreign key (userId) references blog.user (id)
	on delete no action 
    on update no action,
index idx_userId (userId asc)
);

create table img(
id bigint primary key auto_increment,
srcImg varchar(100) not null unique,
userId bigint not null,
postId bigint null default null,
constraint fk_img_user foreign key (userId) references blog.user (id)
	on delete no action 
    on update no action,
constraint fk_img_post foreign key (postId) references blog.post (id)
	on delete no action 
    on update no action
);

