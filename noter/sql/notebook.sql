CREATE TABLE `notebook` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '笔记本id',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '笔记本name',
  `description` varchar(200) DEFAULT '' COMMENT '笔记本描述',
  `uid` int(11) unsigned NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `notebook_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (1, '英语学习', '学习英语 day day up', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (2, '美食', '每天都要吃吃吃', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (3, '旅行', '沿途人文风景', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (4, '游戏', '每天都要玩玩玩', 2);


