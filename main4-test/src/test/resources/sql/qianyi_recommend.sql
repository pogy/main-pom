
-- 迁移店铺推荐商品数据

update shigu_goods_tiny_hz set is_Showcase = 0 where is_Showcase = 1;
update shigu_goods_tiny_bb set is_Showcase = 0 where is_Showcase = 1;
update shigu_goods_tiny_bj set is_Showcase = 0 where is_Showcase = 1;
update shigu_goods_tiny_cs set is_Showcase = 0 where is_Showcase = 1;
update shigu_goods_tiny_gz set is_Showcase = 0 where is_Showcase = 1;
update shigu_goods_tiny_jf set is_Showcase = 0 where is_Showcase = 1;
update shigu_goods_tiny_jx set is_Showcase = 0 where is_Showcase = 1;
update shigu_goods_tiny_ss set is_Showcase = 0 where is_Showcase = 1;
update shigu_goods_tiny_wa set is_Showcase = 0 where is_Showcase = 1;
update shigu_goods_tiny_xh set is_Showcase = 0 where is_Showcase = 1;
commit;

-- 创建存储过程

create procedure pro_store_recommend_qy()
begin
		-- 定义变量
		DECLARE goodsId BIGINT;
		DECLARE done INT DEFAULT FALSE;
		DECLARE recommedlist_cur CURSOR FOR SELECT goods_id as goodsId FROM shigu_store_recommend_hz;
		DECLARE recommedlist_curbb CURSOR FOR SELECT goods_id as goodsId FROM shigu_store_recommend_bb;
		DECLARE recommedlist_curbj CURSOR FOR SELECT goods_id as goodsId FROM shigu_store_recommend_bj;
		DECLARE recommedlist_curcs CURSOR FOR SELECT goods_id as goodsId FROM shigu_store_recommend_cs;
		DECLARE recommedlist_curgz CURSOR FOR SELECT goods_id as goodsId FROM shigu_store_recommend_gz;
		DECLARE recommedlist_curjf CURSOR FOR SELECT goods_id as goodsId FROM shigu_store_recommend_jf;
		DECLARE recommedlist_curjx CURSOR FOR SELECT goods_id as goodsId FROM shigu_store_recommend_jx;
		DECLARE recommedlist_curss CURSOR FOR SELECT goods_id as goodsId FROM shigu_store_recommend_ss;
		DECLARE recommedlist_curwa CURSOR FOR SELECT goods_id as goodsId FROM shigu_store_recommend_wa;
		DECLARE recommedlist_curxh CURSOR FOR SELECT goods_id as goodsId FROM shigu_store_recommend_xh;
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

		-- 打开光标
		OPEN recommedlist_cur;
				read_loop: LOOP
				FETCH recommedlist_cur INTO goodsId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				update shigu_goods_tiny_hz set is_Showcase = 1 where goods_id = goodsId;
				END LOOP;
		CLOSE recommedlist_cur;

		set done = false;
		-- 打开光标
		OPEN recommedlist_curbb;
				read_loop: LOOP
				FETCH recommedlist_curbb INTO goodsId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				update shigu_goods_tiny_bb set is_Showcase = 1 where goods_id = goodsId;
				END LOOP;
		CLOSE recommedlist_curbb;
		set done = false;
		-- 打开光标
		OPEN recommedlist_curbj;
				read_loop: LOOP
				FETCH recommedlist_curbj INTO goodsId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				update shigu_goods_tiny_bj set is_Showcase = 1 where goods_id = goodsId;
				END LOOP;
		CLOSE recommedlist_curbj;
		set done = false;
		-- 打开光标
		OPEN recommedlist_curcs;
				read_loop: LOOP
				FETCH recommedlist_curcs INTO goodsId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				update shigu_goods_tiny_cs set is_Showcase = 1 where goods_id = goodsId;
				END LOOP;
		CLOSE recommedlist_curcs;
		set done = false;
		-- 打开光标
		OPEN recommedlist_curgz;
				read_loop: LOOP
				FETCH recommedlist_curgz INTO goodsId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				update shigu_goods_tiny_gz set is_Showcase = 1 where goods_id = goodsId;
				END LOOP;
		CLOSE recommedlist_curgz;
		set done = false;
		-- 打开光标
		OPEN recommedlist_curjf;
				read_loop: LOOP
				FETCH recommedlist_curjf INTO goodsId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				update shigu_goods_tiny_jf set is_Showcase = 1 where goods_id = goodsId;
				END LOOP;
		CLOSE recommedlist_curjf;
		set done = false;
		-- 打开光标
		OPEN recommedlist_curjx;
				read_loop: LOOP
				FETCH recommedlist_curjx INTO goodsId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				update shigu_goods_tiny_jx set is_Showcase = 1 where goods_id = goodsId;
				END LOOP;
		CLOSE recommedlist_curjx;
		set done = false;
		-- 打开光标
		OPEN recommedlist_curss;
				read_loop: LOOP
				FETCH recommedlist_curss INTO goodsId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				update shigu_goods_tiny_ss set is_Showcase = 1 where goods_id = goodsId;
				END LOOP;
		CLOSE recommedlist_curss;
		set done = false;
		-- 打开光标
		OPEN recommedlist_curwa;
				read_loop: LOOP
				FETCH recommedlist_curwa INTO goodsId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				update shigu_goods_tiny_wa set is_Showcase = 1 where goods_id = goodsId;
				END LOOP;
		CLOSE recommedlist_curwa;
		set done = false;
		-- 打开光标
		OPEN recommedlist_curxh;
				read_loop: LOOP
				FETCH recommedlist_curxh INTO goodsId;
				IF done THEN
					LEAVE read_loop;
				END IF;
				update shigu_goods_tiny_xh set is_Showcase = 1 where goods_id = goodsId;
				END LOOP;
		CLOSE recommedlist_curxh;

		commit;
end;

-- 调用存储过程
call pro_store_recommend_qy();

-- 删除存储过程
drop procedure pro_store_recommend_qy;