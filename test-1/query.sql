SELECT dp.id, dp.fund_id, dp.status, dp.effective_date
FROM daily_unit_price dp
JOIN fund f ON dp.fund_id = f.id
WHERE f.status = 'verified' AND dp.status = 'verified'
ORDER BY dp.effective_date DESC, dp.id DESC
LIMIT 3;