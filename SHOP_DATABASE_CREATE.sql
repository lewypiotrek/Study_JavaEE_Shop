create database shop;
use shop;

-- drop table Product
----------------- TABLES -----------------
create table Product(
	idProduct int not null primary key auto_increment,
    ProductName varchar(50) not null,
    Price varchar(10),
    ShortDescription varchar(300),
    LongDescription varchar(500),
    onSale bool,
    ImageUrl varchar(300)
	);

-- drop table Customer
create table Customer(
	idCustomer int not null primary key auto_increment,
    First_Name varchar(50),
    Last_name varchar(50),
    Phone varchar(15),
    Email varchar(20),
    UserPassword varchar(50)
);

-- drop table Contact
create table Contact(
	idContact int not null primary key auto_increment,
    Message varchar(300),
    email varchar(300),
    phone varchar(50)
);
-- drop table Cart
create table Cart(
	idCart int not null primary key auto_increment,
    idProduct int not null,
     Email varchar(20),
    onOrder bool    
);
GO
----------------- PROCEDURES ---------------------
-- drop procedure GetOrder;
DELIMITER //
CREATE PROCEDURE GetOrder(in pemail varchar(50))
BEGIN
  select p.Productname,p.ShortDescription,p.Price 
  from Cart c
  inner join Product p on c.idProduct = p.idProduct
  where c.onOrder = 0 and c.email = pemail;
END //
DELIMITER ;

-- drop procedure GetPrice
DELIMITER //
CREATE PROCEDURE GetPrice(in pemail varchar(50))
BEGIN
  select SUM(p.Price) from Cart c
	inner join Product p on p.idProduct = c.idProduct
  where onOrder =1 and c.email = pemail;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetProductOnSale()
BEGIN
	select * from Product where onSale = true;
END //
DELIMITER ;

-- drop procedure AddProduct
DELIMITER //
CREATE PROCEDURE AddProduct(in pname varchar(50), in pprice varchar(10),in sdes varchar(100),in ldes varchar(300),in url varchar(300))
BEGIN
	insert into Product (ProductName,Price,ShortDescription,LongDescription,onSale,ImageUrl)
    values (pname, pprice,sdes,ldes,false,url);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE AddOrder(in email varchar(50), in id int)
BEGIN
	insert into Cart (idProduct,Email,onOrder) 
    values (id,email,0);
END //
DELIMITER ;

-- call AddProduct('Speakres Creative A110','99','Głośniki idealne do twojego domu!','Wysoką jakość dźwięku gwarantuje tutaj zespół dwóch wbudowanych głośników o mocy 5W każdy, pozwalających wypełnić przestrzeń czystym brzmieniem.','https://cdn.x-kom.pl/i/setup/images/prod/big/product-large,,pr_2016_1_12_10_39_14_805.jpg');

----------------- INSERT DATA -----------------

-- INSERT PRODUCT 
Insert into Product  (ProductName,Price,onSale,ShortDescription,LongDescription,ImageUrl) values 
	('Speakers MagicSound G34','30',true,'Advanced GX mechanical switches—engineered and 100% tested for performance, responsiveness, and durability. Customize the feel of your PRO X keyboard with three removable switch variants.','Natychmiastowy dostęp do elementów sterujących multimediami—muzyką, przeglądarką internetową, pocztą e-mail, odtwarzaniem/wstrzymywaniem odtwarzania, głośnością i nie tylko — wymaga tylko jednego naciśnięcia.','https://cdn.x-kom.pl/i/setup/images/prod/big/product-large,,2017/7/pr_2017_7_19_10_18_26_229.jpg'),
    ('Speakers CREATIVE','70',false,'Advanced GX mechanical switches—engineered and 100% tested for performance, responsiveness, and durability. Customize the feel of your PRO X keyboard with three removable switch variants., responsiveness, and durability','Pracuj lub baw się w większej liczbie miejsc. Połączenie bezprzewodowe praktycznie eliminuje opóźnienia, przerwy w łączności i zakłócenia, zapewniając zasięg do 10 metrów. Długa żywotność baterii — 24 miesiące','https://cdn.x-kom.pl/i/setup/images/prod/big/product-large,,2017/7/pr_2017_7_19_10_18_26_229.jpg');

-- INSERT CLIENTS
Insert into Customer  (First_name,Last_name,Phone,Email,UserPassword) values 
	('Piotr','Lewandowski','678678678','email1@email.com','piotr'),
	('Klaudia','Lewandowska','678328678','email2@email.com','klaudia'),
	('Robert','Robertowicz','678328678','email3@email.com','robert');
    
    select * from Cart
    
    call GetProductOnSale();

call AddProduct("test","30","test","test","test");
call AddProduct(" + Name + "," + price + "," + ShortDescription + "," + LongDescription + "," + ImageUrl + ")";

call ViewCart("piotr")


