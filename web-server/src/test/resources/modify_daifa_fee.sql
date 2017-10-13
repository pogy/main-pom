update order_constant set context='{"detail":"货品一件代发服务由星帮提供服务。","id":1,"name":"四季星座代发费","price":0,"marketId":621}' where id=1;
update order_constant set context='{"detail":"货品一件代发服务由星帮提供服务。","id":1,"name":"四季星座代发费","price":0,"marketId":-1}' where id=3;
INSERT INTO logistics_template_company(rule_id,company_id,template_id)
VALUES (9,66,6),(10,66,6),(11,66,6),(12,66,6);