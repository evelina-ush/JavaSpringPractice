INSERT INTO "AmountIn" ("metric") VALUES 
('kg'),
('pcs'),
('l');

INSERT INTO "Suppliers" ("name", "inn", "country", "city", "street", "phone", "email") VALUES 
('ООО "МолокоПром"', '123456789012', 'Россия', 'Москва', 'Ленинградский пр-т, 45', '+74951234567', 'info@molokoprom.ru'),
('ИП Иванов А.С.', '987654321098', 'Россия', 'Санкт-Петербург', 'Невский пр-т, 78', '+78121234567', 'ivanov@supply.ru');

INSERT INTO "Customer" ("name", "country", "city", "street", "house", "inn") VALUES 
('АО "Торговый Дом"', 'Россия', 'Москва', 'Тверская', '12', '7707083893'),
('ООО "СеверМаг"', 'Россия', 'Санкт-Петербург', 'Проспект Просвещения', '45', '7812345678');

INSERT INTO "Product" ("name", "price", "metric_id", "supplier_id") VALUES 
('Молоко 3.2% ультрапастеризованное', 89.50, 1, 1),
('Хлеб "Бородинский"', 45.00, 2, 2),
('Масло подсолнечное рафинированное', 110.00, 3, 1);

INSERT INTO "DeliveryItself" 
("customer_id", "contract_date", "start_date", "end_date", "total_amount_of_money", "description", "status", "created_at", "updated_at") 
VALUES 
(1, '2026-06-01', '2026-06-05', '2026-06-10', 12500.00, 'Первая поставка молока и хлеба', 'completed', '2026-05-28 10:00:00', '2026-06-11 14:30:00'),
(2, '2026-06-15', '2026-06-20', '2026-06-25', 8700.00, 'Поставка масла', 'active', '2026-06-10 09:15:00', NULL);

INSERT INTO "DeliveryItems" ("product_id", "delivery_id", "amount_of_product", "price_paid") VALUES 
(1, 1, 120.5, 89.50),
(2, 1, 80.0, 45.00),
(3, 2, 75.0, 110.00);