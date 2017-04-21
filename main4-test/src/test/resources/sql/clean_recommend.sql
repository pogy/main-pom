

-- 清理店铺商品推荐数据
DELETE
FROM
	shigu_store_recommend_hz
WHERE
	store_recommend_id IN (
		SELECT
			s.id
		FROM
			(
				SELECT
					r.store_recommend_id AS id
				FROM
					shigu_store_recommend_hz r
				LEFT JOIN shigu_goods_tiny_hz h ON r.goods_id = h.goods_id
				WHERE
					(
						h.goods_id IS NULL
						OR h.goods_id = ''
					)
			) s
	);
DELETE
FROM
	shigu_store_recommend_bb
WHERE
	store_recommend_id IN (
		SELECT
			s.id
		FROM
			(
				SELECT
					r.store_recommend_id AS id
				FROM
					shigu_store_recommend_bb r
				LEFT JOIN shigu_goods_tiny_bb h ON r.goods_id = h.goods_id
				WHERE
					(
						h.goods_id IS NULL
						OR h.goods_id = ''
					)
			) s
	);
DELETE
FROM
	shigu_store_recommend_bj
WHERE
	store_recommend_id IN (
		SELECT
			s.id
		FROM
			(
				SELECT
					r.store_recommend_id AS id
				FROM
					shigu_store_recommend_bj r
				LEFT JOIN shigu_goods_tiny_bj h ON r.goods_id = h.goods_id
				WHERE
					(
						h.goods_id IS NULL
						OR h.goods_id = ''
					)
			) s
	);
DELETE
FROM
	shigu_store_recommend_cs
WHERE
	store_recommend_id IN (
		SELECT
			s.id
		FROM
			(
				SELECT
					r.store_recommend_id AS id
				FROM
					shigu_store_recommend_cs r
				LEFT JOIN shigu_goods_tiny_cs h ON r.goods_id = h.goods_id
				WHERE
					(
						h.goods_id IS NULL
						OR h.goods_id = ''
					)
			) s
	);
DELETE
FROM
	shigu_store_recommend_gz
WHERE
	store_recommend_id IN (
		SELECT
			s.id
		FROM
			(
				SELECT
					r.store_recommend_id AS id
				FROM
					shigu_store_recommend_gz r
				LEFT JOIN shigu_goods_tiny_gz h ON r.goods_id = h.goods_id
				WHERE
					(
						h.goods_id IS NULL
						OR h.goods_id = ''
					)
			) s
	);
DELETE
FROM
	shigu_store_recommend_jf
WHERE
	store_recommend_id IN (
		SELECT
			s.id
		FROM
			(
				SELECT
					r.store_recommend_id AS id
				FROM
					shigu_store_recommend_jf r
				LEFT JOIN shigu_goods_tiny_jf h ON r.goods_id = h.goods_id
				WHERE
					(
						h.goods_id IS NULL
						OR h.goods_id = ''
					)
			) s
	);
DELETE
FROM
	shigu_store_recommend_jx
WHERE
	store_recommend_id IN (
		SELECT
			s.id
		FROM
			(
				SELECT
					r.store_recommend_id AS id
				FROM
					shigu_store_recommend_jx r
				LEFT JOIN shigu_goods_tiny_jx h ON r.goods_id = h.goods_id
				WHERE
					(
						h.goods_id IS NULL
						OR h.goods_id = ''
					)
			) s
	);
DELETE
FROM
	shigu_store_recommend_ss
WHERE
	store_recommend_id IN (
		SELECT
			s.id
		FROM
			(
				SELECT
					r.store_recommend_id AS id
				FROM
					shigu_store_recommend_ss r
				LEFT JOIN shigu_goods_tiny_ss h ON r.goods_id = h.goods_id
				WHERE
					(
						h.goods_id IS NULL
						OR h.goods_id = ''
					)
			) s
	);
DELETE
FROM
	shigu_store_recommend_wa
WHERE
	store_recommend_id IN (
		SELECT
			s.id
		FROM
			(
				SELECT
					r.store_recommend_id AS id
				FROM
					shigu_store_recommend_wa r
				LEFT JOIN shigu_goods_tiny_wa h ON r.goods_id = h.goods_id
				WHERE
					(
						h.goods_id IS NULL
						OR h.goods_id = ''
					)
			) s
	);
DELETE
FROM
	shigu_store_recommend_xh
WHERE
	store_recommend_id IN (
		SELECT
			s.id
		FROM
			(
				SELECT
					r.store_recommend_id AS id
				FROM
					shigu_store_recommend_xh r
				LEFT JOIN shigu_goods_tiny_xh h ON r.goods_id = h.goods_id
				WHERE
					(
						h.goods_id IS NULL
						OR h.goods_id = ''
					)
			) s
	);
commit;
create procedure pro_clean_store_recommend_qy()
BEGIN
		DECLARE storeId BIGINT;

		DECLARE done INT DEFAULT FALSE;

		DECLARE clean_recommend_hz CURSOR FOR select h.store_id as storeId from shigu_store_recommend_hz h GROUP BY h.store_id HAVING count(h.goods_id) > 10;
		DECLARE clean_recommend_bb CURSOR FOR select h.store_id as storeId from shigu_store_recommend_bb h GROUP BY h.store_id HAVING count(h.goods_id) > 10;
		DECLARE clean_recommend_bj CURSOR FOR select h.store_id as storeId from shigu_store_recommend_bj h GROUP BY h.store_id HAVING count(h.goods_id) > 10;
		DECLARE clean_recommend_cs CURSOR FOR select h.store_id as storeId from shigu_store_recommend_cs h GROUP BY h.store_id HAVING count(h.goods_id) > 10;
		DECLARE clean_recommend_gz CURSOR FOR select h.store_id as storeId from shigu_store_recommend_gz h GROUP BY h.store_id HAVING count(h.goods_id) > 10;
		DECLARE clean_recommend_jf CURSOR FOR select h.store_id as storeId from shigu_store_recommend_jf h GROUP BY h.store_id HAVING count(h.goods_id) > 10;
		DECLARE clean_recommend_jx CURSOR FOR select h.store_id as storeId from shigu_store_recommend_jx h GROUP BY h.store_id HAVING count(h.goods_id) > 10;
		DECLARE clean_recommend_ss CURSOR FOR select h.store_id as storeId from shigu_store_recommend_ss h GROUP BY h.store_id HAVING count(h.goods_id) > 10;
		DECLARE clean_recommend_wa CURSOR FOR select h.store_id as storeId from shigu_store_recommend_wa h GROUP BY h.store_id HAVING count(h.goods_id) > 10;
		DECLARE clean_recommend_xh CURSOR FOR select h.store_id as storeId from shigu_store_recommend_xh h GROUP BY h.store_id HAVING count(h.goods_id) > 10;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

		OPEN clean_recommend_hz;
				read_loop: LOOP
				FETCH clean_recommend_hz INTO storeId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				delete from shigu_store_recommend_hz where store_id = storeId and store_recommend_id not in (
					select s.id from (select z.store_recommend_id as id from shigu_store_recommend_hz z ,shigu_goods_tiny_hz h
							where z.store_id = storeId and h.goods_id = z.goods_id order by z.last_modify_time desc limit 10 ) s
				);
				END LOOP;
		CLOSE clean_recommend_hz;

		set done = false;

		OPEN clean_recommend_bb;
				read_loop: LOOP
				FETCH clean_recommend_bb INTO storeId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				delete from shigu_store_recommend_bb where store_id = storeId and store_recommend_id not in (
					select s.id from (select z.store_recommend_id as id from shigu_store_recommend_hz z ,shigu_goods_tiny_bb h
							where z.store_id = storeId and h.goods_id = z.goods_id order by z.last_modify_time desc limit 10 ) s
				) ;
				END LOOP;
		CLOSE clean_recommend_bb;
		set done = false;
		OPEN clean_recommend_bj;
				read_loop: LOOP
				FETCH clean_recommend_bj INTO storeId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				delete from shigu_store_recommend_bj where store_id = storeId and store_recommend_id not in (
					select s.id from (select z.store_recommend_id as id from shigu_store_recommend_bj z ,shigu_goods_tiny_bj h
							where z.store_id = storeId and h.goods_id = z.goods_id order by z.last_modify_time desc limit 10 ) s
				) ;
				END LOOP;
		CLOSE clean_recommend_bj;

		set done = false;
		OPEN clean_recommend_cs;
				read_loop: LOOP
				FETCH clean_recommend_cs INTO storeId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				delete from shigu_store_recommend_cs where store_id = storeId and store_recommend_id not in (
					select s.id from (select z.store_recommend_id as id from shigu_store_recommend_cs z ,shigu_goods_tiny_cs h
							where z.store_id = storeId and h.goods_id = z.goods_id order by z.last_modify_time desc limit 10 ) s
				) ;
				END LOOP;
		CLOSE clean_recommend_cs;
		set done = false;
		OPEN clean_recommend_gz;
				read_loop: LOOP
				FETCH clean_recommend_gz INTO storeId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				delete from shigu_store_recommend_gz where store_id = storeId and store_recommend_id not in (
					select s.id from (select z.store_recommend_id as id from shigu_store_recommend_gz z ,shigu_goods_tiny_gz h
							where z.store_id = storeId and h.goods_id = z.goods_id order by z.last_modify_time desc limit 10 ) s
				) ;
				END LOOP;
		CLOSE clean_recommend_gz;
		set done = false;
		OPEN clean_recommend_jf;
				read_loop: LOOP
				FETCH clean_recommend_jf INTO storeId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				delete from shigu_store_recommend_jf where store_id = storeId and store_recommend_id not in (
					select s.id from (select z.store_recommend_id as id from shigu_store_recommend_jf z ,shigu_goods_tiny_jf h
							where z.store_id = storeId and h.goods_id = z.goods_id order by z.last_modify_time desc limit 10 ) s
				)  ;
				END LOOP;
		CLOSE clean_recommend_jf;
		set done = false;
		OPEN clean_recommend_jx;
				read_loop: LOOP
				FETCH clean_recommend_jx INTO storeId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				delete from shigu_store_recommend_jx where store_id = storeId and store_recommend_id not in (
					select s.id from (select z.store_recommend_id as id from shigu_store_recommend_jx z ,shigu_goods_tiny_jx h
							where z.store_id = storeId and h.goods_id = z.goods_id order by z.last_modify_time desc limit 10 ) s
				) ;
				END LOOP;
		CLOSE clean_recommend_jx;
		set done = false;
		OPEN clean_recommend_ss;
				read_loop: LOOP
				FETCH clean_recommend_ss INTO storeId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				delete from shigu_store_recommend_ss where store_id = storeId and store_recommend_id not in (
					select s.id from (select z.store_recommend_id as id from shigu_store_recommend_ss z ,shigu_goods_tiny_ss h
							where z.store_id = storeId and h.goods_id = z.goods_id order by z.last_modify_time desc limit 10 ) s
				)  ;
				END LOOP;
		CLOSE clean_recommend_ss;
		set done = false;
		OPEN clean_recommend_wa;
				read_loop: LOOP
				FETCH clean_recommend_wa INTO storeId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				delete from shigu_store_recommend_wa where store_id = storeId and store_recommend_id not in (
					select s.id from (select z.store_recommend_id as id from shigu_store_recommend_wa z ,shigu_goods_tiny_wa h
							where z.store_id = storeId and h.goods_id = z.goods_id order by z.last_modify_time desc limit 10 ) s
				) ;
				END LOOP;
		CLOSE clean_recommend_wa;
		set done = false;
		OPEN clean_recommend_xh;
				read_loop: LOOP
				FETCH clean_recommend_xh INTO storeId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				delete from shigu_store_recommend_xh where store_id = storeId and store_recommend_id not in (
					select s.id from (select z.store_recommend_id as id from shigu_store_recommend_xh z ,shigu_goods_tiny_xh h
							where z.store_id = storeId and h.goods_id = z.goods_id order by z.last_modify_time desc limit 10 ) s
				) ;
				END LOOP;
		CLOSE clean_recommend_xh;

		commit;
END;


CALL pro_clean_store_recommend_qy();
drop procedure pro_clean_store_recommend_qy;


