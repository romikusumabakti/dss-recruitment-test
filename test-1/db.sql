CREATE TABLE fund (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    status VARCHAR(50)
);

INSERT INTO fund (id, name, status) VALUES
(1, 'Equity Fund', 'verified'),
(2, 'Money Market Fund', 'verified'),
(3, 'Fixed Income Fund', 'verified'),
(4, 'Surat Utang Negara', 'not verified');

CREATE TABLE daily_unit_price (
    id INT PRIMARY KEY,
    fund_id INT,
    status VARCHAR(50),
    effective_date DATE,
    FOREIGN KEY (fund_id) REFERENCES fund(id)
);

INSERT INTO daily_unit_price (id, fund_id, status, effective_date) VALUES
(1, 1, 'verified', '2019-10-05'),
(2, 2, 'verified', '2019-10-05'),
(3, 3, 'verified', '2019-10-05'),
(4, 1, 'verified', '2019-10-06'),
(5, 2, 'verified', '2019-10-06'),
(6, 3, 'verified', '2019-10-06'),
(7, 4, 'not verified', '2019-10-06');