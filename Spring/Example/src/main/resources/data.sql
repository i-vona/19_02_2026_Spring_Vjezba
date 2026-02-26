INSERT INTO Category(name, description)
VALUES('CPU', 'New and used');

INSERT INTO Category(name, description)
VALUES('GPU', 'New and used');

INSERT INTO HARDWARE(name, description, price, categoryId)
VALUES('Corsair RM1000x PSU', 'CPU', 50000, 2);

INSERT INTO HARDWARE(name, description, price, categoryId)
VALUES('Samsung 990 Pro 2TB NVMe', 'CPU', 500000, 1);

INSERT INTO HARDWARE(name, description, price, categoryId)
VALUES('ASUS ROG Maximus Z790', 'GPU', 5000000, 1);

INSERT INTO HARDWARE(name, description, price, categoryId)
VALUES('NVIDIA GeForce RTX 4090', 'GPU', 100000, 2);