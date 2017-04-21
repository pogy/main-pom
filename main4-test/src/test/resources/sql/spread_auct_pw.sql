-- 广告进行派位

create procedure pro_spread_pw(spreadTypeId int,speradDraw int)
BEGIN
		DECLARE spreadScrenId BIGINT DEFAULT 0;
		DECLARE endTime TIMESTAMP;
		DECLARE nowTime TIMESTAMP;
		DECLARE drawstrids varchar(100);
		DECLARE maxShopInt BIGINT;
		DECLARE randomInt BIGINT;
		DECLARE randomWhiletj BIGINT;
		DECLARE drawid BIGINT;

		-- 查询当前正在活动的数据
		select s.id into spreadScrenId from spread_auct_scren s where s.spread_pm_id  = 1 and s.start_time < now() and s.end_time > now() limit 1;
		if spreadScrenId is not null THEN
				-- 进行随机派位
				-- 查出已经申请的最大数
				select count(s.id) into maxShopInt from spread_auct_shop s where s.scren_id = spreadScrenId and s.is_draw = 0;
				if speradDraw > maxShopInt THEN
				set speradDraw = maxShopInt;
				end if;
				-- 开始循环派位
				set randomWhiletj = 0;
				while(speradDraw > randomWhiletj) DO
					select FLOOR(1 + RAND() * (maxShopInt)) into randomInt;
					select s.id into drawid from spread_auct_shop s,(Select (@rowNum :=0) ) b
						where s.scren_id = spreadScrenId AND (@rowNum:=@rowNum+1) = randomInt and s.is_draw = 0 ORDER BY s.create_time DESC;
					update spread_auct_shop set is_draw = 1 where id = drawid;
					commit;
					set maxShopInt = maxShopInt - 1;
					set randomWhiletj = randomWhiletj  + 1;
				end WHILE;
		end if;
END;

CALL pro_spread_pw(1,2);

DROP procedure pro_spread_pw;