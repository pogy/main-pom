# 多单下单改造
CREATE TABLE IF NOT EXISTS `shigu_mall`.`order_pay_apply_relation` (
  `relation_id` BIGINT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `apply_id` BIGINT(11) NULL COMMENT '申请ID',
  `oid` BIGINT(11) NULL COMMENT '订单ID',
  PRIMARY KEY (`relation_id`))
ENGINE = InnoDB