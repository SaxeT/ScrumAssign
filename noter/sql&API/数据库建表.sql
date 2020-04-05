CREATE TABLE `notebook` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '笔记本id',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '笔记本name',
  `description` varchar(200) DEFAULT '' COMMENT '笔记本描述',
  `uid` int(11) unsigned NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `notebook_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (1, '英语学习', '学习英语 day day up', 3);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (2, '美食记', '骗吃骗喝', 3);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (3, '旅行', '沿途人文风景', 3);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (4, '游戏', '每天都要玩玩玩', 3);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (5, '追剧', '我剧荒了', 3);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (6, '推理小说', '凶手就是你', 3);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (10, '食谱', '开心小厨房 每天炒炒菜 每天都在进步', 3);

CREATE TABLE `note` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(256) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `category` varchar(32) DEFAULT 'default',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `uid` int(11) unsigned NOT NULL,
  `nbid` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_note_user` (`uid`),
  KEY `fk_note_notebook` (`nbid`),
  CONSTRAINT `note_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `note_ibfk_2` FOREIGN KEY (`nbid`) REFERENCES `notebook` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

INSERT INTO `note` VALUES
(1,'English Note','something just like this','学习','2020-02-15 08:46:57',1,1),
(2,'厨师长农国栋','蛋炒饭','生活','2020-02-15 08:46:57',1,2),
(3,'日本','旅行计划','生活','2020-02-15 08:46:57',1,3),
(5,'刺激战场','我有98K','娱乐','2020-02-15 08:46:57',2,4),
(6,'华农兄弟','烤竹鼠','美食','2020-02-15 08:47:05',2,4),
(15,'qv','<p>re</p>','学习','2020-03-30 15:17:32',1,1),
(16,'eqf','<p>fqereqrfe</p>','学习','2020-03-30 15:19:23',1,1),
(17,'we','<p>dwe</p>','学习','2020-03-30 15:22:17',1,1),
(18,'q fe q f','<p>反而丰富</p>','学习','2020-03-30 15:23:59',1,1),
(19,'q fe q f','<p><b>ef</b>q<i>eqegr</i>q4<u>grqergko</u>rn<strike>ognergnoernge</strike></p>','学习','2020-03-30 15:25:28',1,1),
(20,'试一试','<blockquote><p>成功保存把！</p></blockquote>','学习','2020-03-30 16:12:07',1,1),
(21,'wdwd','<p>dqwdw</p>','学习','2020-03-30 16:12:51',1,1),
(22,'wdw','<p>dwdwdewde</p>','学习','2020-03-30 16:15:06',1,1),
(23,'dwd','<p>wd22d</p>','学习','2020-03-30 16:16:34',1,1),
(24,'reqr','<p>fqe</p>','学习','2020-03-30 16:17:49',1,1);
