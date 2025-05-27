create database db;
use db;

create table category(
    category_id int auto_increment primary key,
    category_name varchar(50) not null unique,
    description text,
    status bit default 1
);

create table product(
    product_id int primary key auto_increment,
    product_name varchar(100) not null,
    description text,
    price decimal(10, 2) not null check ( price > 0 ),
    image_url varchar(255),
    status bit default 1,
    created_at datetime,
    category_id int not null,
    foreign key (category_id) references category(category_id)
);

DELIMITER //
create procedure get_all_categories()
begin
    select * from category;
end;

create procedure get_category_by_id(
    p_cat_id int
)
begin
    select * from category where category_id = p_cat_id;
end;

create procedure add_category(
    in p_category_name varchar(50),
    in p_description text,
    in p_status bit
)
begin
    insert into category (category_name, description, status)
    values (p_category_name, p_description, p_status);
end;

create procedure update_category(
    in p_category_id int,
    in p_category_name varchar(50),
    in p_description text,
    in p_status bit
)
begin
    update category
    set category_name = p_category_name,
        description = p_description,
        status = p_status
    where category_id = p_category_id;
end;

create procedure delete_category(
    in p_category_id int
)
begin
    delete from category
    where category_id = p_category_id;
end;

create procedure get_category_by_name(
    in p_category_name varchar(50)
)
begin
    select * from category
    where category_name like p_category_name;
end;
DELIMITER //

DELIMITER //
create procedure get_all_products()
begin
    select * from product;
end;

create procedure get_product_by_name(
    in p_product_name varchar(100)
)
begin
    select * from product
    where product_name like p_product_name;
end;

create procedure add_product(
    in p_product_name varchar(100),
    in p_description text,
    in p_price decimal(10, 2),
    in p_image_url varchar(255),
    in p_status bit,
    in p_created_at datetime,
    in p_category_id int
)
begin
    insert into product (product_name, description, price, image_url, status, created_at, category_id)
    values (p_product_name, p_description, p_price, p_image_url, p_status, p_created_at, p_category_id);
end;

create procedure update_product(
    in p_product_id int,
    in p_product_name varchar(100),
    in p_description text,
    in p_price decimal(10, 2),
    in p_image_url varchar(255),
    in p_status bit,
    in p_created_at datetime,
    in p_category_id int
)
begin
    update product
    set product_name = p_product_name,
        description = p_description,
        price = p_price,
        image_url = p_image_url,
        status = p_status,
        created_at = p_created_at,
        category_id = p_category_id
    where product_id = p_product_id;
end;

create procedure delete_product(
    in p_product_id int
)
begin
    delete from product
    where product_id = p_product_id;
end;
DELIMITER //