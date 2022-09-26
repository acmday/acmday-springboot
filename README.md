# acmday-springboot
- springboot的一些实践.
- 功能入口在test目录下.
- Springboot版本是2.7.4.

## DDL
```sql
CREATE TABLE `student` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL DEFAULT '""' COMMENT '姓名',
  `address` varchar(45) NOT NULL DEFAULT '""' COMMENT '家庭住址',
  `age` tinyint(4) NOT NULL DEFAULT '1' COMMENT '年龄',
  PRIMARY KEY (`id`),
  KEY `name_idx` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

### 插入数据
```sql
insert student values(1,'acmday','wangjing.Beijing','18');
```
