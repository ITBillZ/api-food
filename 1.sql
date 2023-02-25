drop table if exists home_swiper;

create table home_swiper
(
    id int primary key auto_increment,
    img varchar(500)
);

insert into home_swiper(img)
values
    ('https://img.tukuppt.com/preview/2269348/00/01/04/5b1730f3ed506.jpg-0.jpg!/fw/780/quality/90/unsharp/true/compress/true'),
    ('https://img.mianfeiwendang.com/pic/eda1a900bfbb3316de779842/1-1130-jpg_6_0_______-798-0-0-798.jpg'),
    ('https://img.tukuppt.com/preview/13911424/01/34/13/6300d5fa393051660999162.jpg-0.jpg!/fw/780/quality/90/unsharp/true/compress/true');

drop table if exists foods_detail;
CREATE TABLE `foods_detail`
(
    `food_id`         int(11) NOT NULL AUTO_INCREMENT,
    `food_name`       varchar(50)  DEFAULT NULL COMMENT '食品名称',
    `food_cate`       varchar(50)  DEFAULT NULL COMMENT '食品品类',
    `food_ent`        varchar(50)  DEFAULT NULL COMMENT '食品生产企业',
    `food_prod_date`  date         DEFAULT NULL COMMENT '食品生产日期',
    `food_valid_time` int(11)      DEFAULT NULL COMMENT '保质期(天)',
    `food_img`        varchar(500) DEFAULT 'https://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png' COMMENT '食品图片',
    PRIMARY KEY (`food_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 201
  DEFAULT CHARSET = utf8;

###################################################
drop table if exists foods;

create table foods
(
    food_id int primary key auto_increment,
    title varchar(50) not null comment '食品名称',
    category varchar(50) DEFAULT NULL COMMENT '食品品类',
    cook_id varchar(10) default null comment '厨师工号',
    prod_time datetime default null comment '生产日期',
    valid_time int default null comment '有效期',
    img varchar(200) default null comment '图片链接'
);

drop table if exists ingredients;
create table ingredients
(
    ingredient_id int primary key auto_increment,
    title varchar(50) not null comment '原料名称'
);

drop table if exists food_ingredient;
create table food_ingredient
(
    food_id int not null ,
    ingredient_id int not null,
    consumption varchar(10) comment '用量'
);

drop table if exists cooks;
create table cooks
(
    cook_id int primary key auto_increment,
    `cname` varchar(30) not null comment '厨师名字'
)
