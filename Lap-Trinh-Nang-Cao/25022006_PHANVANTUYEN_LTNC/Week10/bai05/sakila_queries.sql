USE sakila;

-- Câu 1: Top 5 thể loại phim có tổng doanh thu cao nhất
SELECT
    c.name AS category_name,
    SUM(p.amount) AS total_revenue
FROM category c
         JOIN film_category fc ON c.category_id = fc.category_id
         JOIN inventory i ON fc.film_id = i.film_id
         JOIN rental r ON i.inventory_id = r.inventory_id
         JOIN payment p ON r.rental_id = p.rental_id
GROUP BY c.category_id, c.name
ORDER BY total_revenue DESC
    LIMIT 5;


-- Câu 2: Khách hàng thuê hơn 30 bộ phim
SELECT
    CONCAT(c.first_name, ' ', c.last_name) AS customer_name,
    c.email,
    COUNT(r.rental_id) AS total_rentals
FROM customer c
         JOIN rental r ON c.customer_id = r.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name, c.email
HAVING COUNT(r.rental_id) > 30
ORDER BY total_rentals DESC;


-- Câu 3: Khách hàng có tổng chi tiêu lớn hơn mức chi tiêu trung bình
WITH customer_total AS (
    SELECT
        c.customer_id,
        CONCAT(c.first_name, ' ', c.last_name) AS customer_name,
        SUM(p.amount) AS total_spent
    FROM customer c
             JOIN payment p ON c.customer_id = p.customer_id
    GROUP BY c.customer_id, c.first_name, c.last_name
)
SELECT
    customer_name,
    total_spent
FROM customer_total
WHERE total_spent > (
    SELECT AVG(total_spent)
    FROM customer_total
)
ORDER BY total_spent DESC;


-- Câu 4: Xếp hạng phim trong từng thể loại theo thời lượng phim
SELECT
    f.title AS film_title,
    c.name AS category_name,
    f.length AS film_length,
    RANK() OVER (
        PARTITION BY c.name
        ORDER BY f.length DESC
    ) AS length_rank
FROM film f
         JOIN film_category fc ON f.film_id = fc.film_id
         JOIN category c ON fc.category_id = c.category_id
ORDER BY c.name, length_rank;