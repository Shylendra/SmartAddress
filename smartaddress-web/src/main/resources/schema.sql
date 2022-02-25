DROP ALL OBJECTS;

CREATE TABLE SMART_ADDRESS (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  CUSTOMER_ID INT,
  ADDRESS_LINE1 VARCHAR(100),
  ADDRESS_LINE2 VARCHAR(100),
  CITY VARCHAR(100),
  STATE VARCHAR(100),
  COUNTRY VARCHAR(100),
  POSTAL_CODE VARCHAR(100)
);
