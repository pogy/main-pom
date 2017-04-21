CREATE
VIEW `spread_type1`AS

			SELECT
				s.id
			FROM
				spread_auct_scren s
			WHERE
				s.spread_pm_id = 1
			AND s.start_time < now()
			AND s.end_time > now()
			LIMIT 1
;
CREATE
VIEW `spread_type2`AS

			SELECT
				s.id
			FROM
				spread_auct_scren s
			WHERE
				s.spread_pm_id = 2
			AND s.start_time < now()
			AND s.end_time > now()
			LIMIT 1
;
CREATE
VIEW `spread_type3`AS

			SELECT
				s.id
			FROM
				spread_auct_scren s
			WHERE
				s.spread_pm_id = 3
			AND s.start_time < now()
			AND s.end_time > now()
			LIMIT 1
;
CREATE
VIEW `spread_type4`AS

			SELECT
				s.id
			FROM
				spread_auct_scren s
			WHERE
				s.spread_pm_id = 4
			AND s.start_time < now()
			AND s.end_time > now()
			LIMIT 1
;
CREATE
VIEW `spread_type5`AS

			SELECT
				s.id
			FROM
				spread_auct_scren s
			WHERE
				s.spread_pm_id = 5
			AND s.start_time < now()
			AND s.end_time > now()
			LIMIT 1
;
CREATE
VIEW `spread_type6`AS

			SELECT
				s.id
			FROM
				spread_auct_scren s
			WHERE
				s.spread_pm_id = 6
			AND s.start_time < now()
			AND s.end_time > now()
			LIMIT 1
;
CREATE
VIEW `首页 A区广告（首焦轮转播区）`AS
SELECT
	m.parent_market_name AS '市场',
	m.market_name AS '楼层',
	s.is_draw AS '中奖',
	p.shop_num AS '档口号',
	s.contacts_name AS '联系人',
	s.contacts_phone AS '联系号码'
FROM
	spread_auct_shop s inner join shigu_shop p on s.shop_id = p.shop_id
	inner join shigu_market m  on p.floor_id = m.market_id
	inner  join spread_type1 a on a.id = s.scren_id;
CREATE
VIEW `首页 A区广告（首焦下方区）`AS
SELECT
	m.parent_market_name AS '市场',
	m.market_name AS '楼层',
	s.is_draw AS '中奖',
	p.shop_num AS '档口号',
	s.contacts_name AS '联系人',
	s.contacts_phone AS '联系号码'
FROM
	spread_auct_shop s inner join shigu_shop p on s.shop_id = p.shop_id
	inner join shigu_market m  on p.floor_id = m.market_id
	inner  join spread_type2 a on a.id = s.scren_id;
CREATE
VIEW `首页B区广告（热销商品区）`AS
SELECT
	m.parent_market_name AS '市场',
	m.market_name AS '楼层',
	s.is_draw AS '中奖',
	p.shop_num AS '档口号',
	s.contacts_name AS '联系人',
	s.contacts_phone AS '联系号码'
FROM
	spread_auct_shop s inner join shigu_shop p on s.shop_id = p.shop_id
	inner join shigu_market m  on p.floor_id = m.market_id
	inner  join spread_type3 a on a.id = s.scren_id;
CREATE
VIEW `首页 C区广告（风格馆）`AS
SELECT
	m.parent_market_name AS '市场',
	m.market_name AS '楼层',
	s.is_draw AS '中奖',
	p.shop_num AS '档口号',
	s.contacts_name AS '联系人',
	s.contacts_phone AS '联系号码'
FROM
	spread_auct_shop s inner join shigu_shop p on s.shop_id = p.shop_id
	inner join shigu_market m  on p.floor_id = m.market_id
	inner  join spread_type4 a on a.id = s.scren_id;
CREATE
VIEW `首页 D区广告（元素馆）`AS
SELECT
	m.parent_market_name AS '市场',
	m.market_name AS '楼层',
	s.is_draw AS '中奖',
	p.shop_num AS '档口号',
	s.contacts_name AS '联系人',
	s.contacts_phone AS '联系号码'
FROM
	spread_auct_shop s inner join shigu_shop p on s.shop_id = p.shop_id
	inner join shigu_market m  on p.floor_id = m.market_id
	inner  join spread_type5 a on a.id = s.scren_id;
CREATE
VIEW `首页 E 区广告（推荐档口区）`AS
SELECT
	m.parent_market_name AS '市场',
	m.market_name AS '楼层',
	s.is_draw AS '中奖',
	p.shop_num AS '档口号',
	s.contacts_name AS '联系人',
	s.contacts_phone AS '联系号码'
FROM
	spread_auct_shop s inner join shigu_shop p on s.shop_id = p.shop_id
	inner join shigu_market m  on p.floor_id = m.market_id
	inner  join spread_type6 a on a.id = s.scren_id;

