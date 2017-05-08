CREATE DATABASE demo_hr;

USE demo_hr;

/*候选人*/
CREATE TABLE person (
	id INT(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL COMMENT '姓名',
	pwd VARCHAR(50) NULL DEFAULT '',
	post VARCHAR(30) NULL DEFAULT '' COMMENT '应聘岗位',
	mobile VARCHAR(11) NULL DEFAULT '' COMMENT '手机',
	email VARCHAR(50) NULL DEFAULT '' COMMENT '邮箱',
	cs_time DATETIME NULL  COMMENT '初试时间',
	fs_time DATETIME NULL  COMMENT '复试时间',
	cs_result TINYINT(3) NOT NULL DEFAULT 0  COMMENT '初试结果 0:暂无 1 复试 2存档备选 3 不合格',
	fs_result TINYINT(3) NOT NULL DEFAULT 0  COMMENT '初试结果 0:暂无 1 复试 2存档备选 3 不合格',
	origin TINYINT(3) NOT NULL DEFAULT 0  COMMENT '应聘渠道 0 无 1-10各种',
	way TINYINT(3) NOT NULL DEFAULT 0  COMMENT '简历获取方式 0 主动投递 1 简历下载 2推荐人',
	way_info VARCHAR(100) NULL COMMENT 'way=1时为简历下载地址 way=2时为推荐人姓名',
	pre_info TINYINT(3) NOT NULL DEFAULT 0 COMMENT '电话预约情况，1电话淘汰，2 待候选人考虑 3候选人不考虑',
	note VARCHAR(100) COMMENT '备注',
	note2 VARCHAR(100) COMMENT '扩展备注',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	modify_time DATETIME NOT NULL DEFAULT NOW() COMMENT '修改时间',
	PRIMARY KEY (id),
	UNIQUE INDEX mobile (mobile)
)COMMENT '候选人表' COLLATE='utf8_general_ci' ENGINE=InnoDB;

/*面试邀请*/
CREATE TABLE interview (
	id INT(11) NOT NULL AUTO_INCREMENT,
	person_id INT(11) NOT NULL COMMENT '候选人ID',
	name VARCHAR(30) NOT NULL COMMENT '姓名',
	post VARCHAR(30) NULL DEFAULT '' COMMENT '应聘岗位',
	post_link VARCHAR(100) NULL DEFAULT '' COMMENT '应聘岗位连接',
	mobile VARCHAR(11) NULL DEFAULT '' COMMENT '联系电话',
	email VARCHAR(50) NULL DEFAULT '' COMMENT '邮箱',
	origin TINYINT(3) NOT NULL DEFAULT 0  COMMENT '应聘渠道 0 无 1-10各种',
	way TINYINT(3) NOT NULL DEFAULT 0  COMMENT '简历获取方式 0 主动投递 1 简历下载 2推荐人',
	way_info VARCHAR(100) NULL COMMENT 'way=1时为简历下载地址 way=2时为推荐人姓名',
	ms_time DATETIME NULL  COMMENT '面试时间',
	ms_address VARCHAR(100) NULL  COMMENT '面试地址',
	ms_type TINYINT(3) NOT NULL DEFAULT 0 COMMENT '0 初试 1复试',
	hr_id INT(11) NOT NULL COMMENT '联系的HR',
	hr_name VARCHAR(30) NOT NULL COMMENT 'HR姓名',
	hr_mobile VARCHAR(11) NULL DEFAULT '' COMMENT 'hr联系电话',
	hr_email VARCHAR(50) NOT NULL COMMENT 'hr邮箱',
	note VARCHAR(100) COMMENT '备注',
	ms_result TINYINT(3) NOT NULL DEFAULT 0 COMMENT '面试官反馈结果 0 无 1通过 2存档备选 3不通过',
	hr_result TINYINT(3) NOT NULL DEFAULT 0 COMMENT 'HR反馈结果 0 无 1通过 2存档备选 3不通过',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	PRIMARY KEY (id),
	INDEX mobile (mobile),
	INDEX name (name),
	INDEX person_id (person_id)
)COMMENT '面试邀请' COLLATE='utf8_general_ci' ENGINE=InnoDB;

/*面试邀请的面试官信息*/
CREATE TABLE interviewer (
	id INT(11) NOT NULL AUTO_INCREMENT,
	interview_id INT(11) NOT NULL COMMENT '面试邀请ID',
	person_id INT(11) NOT NULL COMMENT '候选人ID',
	staff_id INT(11) NOT NULL COMMENT '面试官员工ID',
	staff_name VARCHAR(30) NOT NULL COMMENT '面试官姓名',
	email VARCHAR(30) NOT NULL COMMENT '面试官邮箱',
	need_nofity TINYINT(3) NOT NULL DEFAULT 0 COMMENT '面试官需要填写面试反馈意见 0不需要 1需要',
	notify_flag TINYINT(3) NOT NULL DEFAULT 0 COMMENT '面试官是否已经填写面试反馈意见，0 没写 1写了',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	modify_time DATETIME NOT NULL DEFAULT NOW() COMMENT '修改时间',
	PRIMARY KEY (id),
	INDEX interview_id (interview_id),
	INDEX person_id (person_id)
)COMMENT '面试对应的面试官列表' COLLATE='utf8_general_ci' ENGINE=InnoDB;

CREATE TABLE staff (
	id INT(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL COMMENT '姓名',
	pwd VARCHAR(50) NULL DEFAULT '',
	mobile VARCHAR(11) NULL DEFAULT '' COMMENT '手机',
	email VARCHAR(50) NULL DEFAULT '' COMMENT '工作邮箱',
	wechat VARCHAR(50) NULL DEFAULT '' COMMENT '微信',
	department VARCHAR(30) NULL DEFAULT '' COMMENT '部门',
	major VARCHAR(30) NULL DEFAULT '' COMMENT '专业',
	status TINYINT(3) NOT NULL DEFAULT 1 COMMENT '1状态有效，0离职无效',
	type TINYINT(3) NOT NULL DEFAULT 0 COMMENT '0 面试官 1 HR角色的面试官',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	PRIMARY KEY (id),
	UNIQUE INDEX email (email)
)COMMENT 'HR和面试官信息表' COLLATE='utf8_general_ci' ENGINE=InnoDB;

/*候选人简历中基础信息*/
CREATE TABLE person_base_info (
	id INT(11) NOT NULL AUTO_INCREMENT,
	person_id INT(11) NOT NULL COMMENT '候选人ID',
	post VARCHAR(30) NULL DEFAULT '' COMMENT '应聘岗位',
	name VARCHAR(30) NOT NULL DEFAULT '' COMMENT '姓名',
	sex char(2) NOT NULL DEFAULT '' COMMENT '性别，男女',
	jiguan VARCHAR(20) NOT NULL DEFAULT ''COMMENT '籍贯',
	minzu VARCHAR(20) NOT NULL DEFAULT ''COMMENT '民族',
	birthday VARCHAR(20) NOT NULL DEFAULT ''COMMENT '出生日期',
	now_address VARCHAR(30) NOT NULL DEFAULT ''COMMENT '现居地址',
	marray_flag TINYINT(1) NOT NULL DEFAULT 0 COMMENT '婚姻状态 0未婚 1已婚',
	peiou_name VARCHAR(30) NOT NULL DEFAULT ''COMMENT '配偶姓名',
	work_company VARCHAR(30) NOT NULL DEFAULT ''COMMENT '配偶工作单位',
	babys TINYINT(3) NOT NULL DEFAULT 0 COMMENT '子女数量',
	dispute TINYINT(3) NOT NULL DEFAULT 0 COMMENT '是否与之前就职公司存在法律纠纷 0 无 1有',
	year_salary VARCHAR(20) NOT NULL DEFAULT ''COMMENT '税前年薪',
	month_salary VARCHAR(20) NOT NULL DEFAULT ''COMMENT '税前月薪',
	work_time VARCHAR(20) NOT NULL DEFAULT ''COMMENT '到岗时间',
	promisee VARCHAR(30) NOT NULL DEFAULT '' COMMENT '承诺人',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	modify_time DATETIME NOT NULL DEFAULT NOW() COMMENT '修改时间',
	PRIMARY KEY (id),
	INDEX person_id (person_id)
)COMMENT '候选人简历中基础信息' COLLATE='utf8_general_ci' ENGINE=InnoDB;


CREATE TABLE education_info (
	id INT(11) NOT NULL AUTO_INCREMENT,
	person_id INT(11) NOT NULL COMMENT '候选人ID',
	begin_date VARCHAR(20) NULL DEFAULT '' COMMENT '开始时间',
	end_date VARCHAR(20) NOT NULL DEFAULT '' COMMENT '结束时间',
	school VARCHAR(30) NOT NULL DEFAULT '' COMMENT '学校',
	major VARCHAR(30) NOT NULL DEFAULT ''COMMENT '专业',
	xueli VARCHAR(30) NOT NULL DEFAULT ''COMMENT '学历',
	way VARCHAR(30) NOT NULL DEFAULT ''COMMENT '就读方式',
	num TINYINT(3) NOT NULL DEFAULT 0 COMMENT '展示顺序',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	modify_time DATETIME NOT NULL DEFAULT NOW() COMMENT '修改时间',
	PRIMARY KEY (id),
	INDEX person_id (person_id)
)COMMENT '候选人简历中教育信息' COLLATE='utf8_general_ci' ENGINE=InnoDB;

/*候选人简历中工作信息*/
CREATE TABLE work_experience_info (
	id INT(11) NOT NULL AUTO_INCREMENT,
	person_id INT(11) NOT NULL COMMENT '候选人ID',
	begin_date VARCHAR(20) NULL DEFAULT '' COMMENT '开始时间',
	end_date VARCHAR(20) NOT NULL DEFAULT '' COMMENT '结束时间',
	company VARCHAR(30) NOT NULL DEFAULT '' COMMENT '公司',
	title VARCHAR(30) NOT NULL DEFAULT ''COMMENT '职位',
	reason VARCHAR(50) NOT NULL DEFAULT ''COMMENT '离职原因',
	salary VARCHAR(20) NOT NULL DEFAULT ''COMMENT '当时薪资',
	num TINYINT(3) NOT NULL DEFAULT 0 COMMENT '展示顺序',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	modify_time DATETIME NOT NULL DEFAULT NOW() COMMENT '修改时间',
	PRIMARY KEY (id),
	INDEX person_id (person_id)
)COMMENT '候选人简历中工作信息' COLLATE='utf8_general_ci' ENGINE=InnoDB;


/*候选人简历中背景信息*/
CREATE TABLE reference_info (
	id INT(11) NOT NULL AUTO_INCREMENT,
	person_id INT(11) NOT NULL COMMENT '候选人ID',
	hr_name VARCHAR(30) NULL DEFAULT '' COMMENT '证明人姓名',
	hr_com_title VARCHAR(50) NOT NULL DEFAULT '' COMMENT '单位名称及职务',
	hr_link VARCHAR(20) NOT NULL DEFAULT '' COMMENT '联系方式',
	hr_email VARCHAR(50) NOT NULL DEFAULT ''COMMENT '邮箱',
	
	leader_name VARCHAR(30) NOT NULL DEFAULT ''COMMENT '证明人姓名',
	ld_com_title VARCHAR(50) NOT NULL DEFAULT ''COMMENT '单位名称及职务',
	ld_link VARCHAR(20) NOT NULL DEFAULT '' COMMENT '联系方式',
	ld_email VARCHAR(50) NOT NULL DEFAULT ''COMMENT '邮箱',
	has_yy TINYINT(3) NOT NULL DEFAULT 0 COMMENT '是否有用友成员公司及本公司亲属/朋友信息，0:无 1:有',
	yy_name VARCHAR(30) NOT NULL DEFAULT ''COMMENT '员工姓名',
	yygx VARCHAR(50) NOT NULL DEFAULT ''COMMENT '与员工的关系',
	yy_title VARCHAR(30) NOT NULL DEFAULT '' COMMENT '员工职务',
	yy_email VARCHAR(50) NOT NULL DEFAULT ''COMMENT '员工邮箱',
	
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	modify_time DATETIME NOT NULL DEFAULT NOW() COMMENT '修改时间',
	PRIMARY KEY (id),
	INDEX person_id (person_id)
)COMMENT '候选人简历中背景信息' COLLATE='utf8_general_ci' ENGINE=InnoDB;



/*面试评估发送任务*/
CREATE TABLE feedback_task (
	id INT(11) NOT NULL AUTO_INCREMENT,
	interview_id INT(11) NOT NULL DEFAULT 0 COMMENT '对应的面试邀请ID',
	person_id INT(11) NOT NULL DEFAULT 0 COMMENT '对应的候选人ID',
	ms_type TINYINT(3) NOT NULL DEFAULT 0 COMMENT '0 初试 1复试',
	ms_time DATETIME NULL  COMMENT '面试时间',
	status TINYINT(3) NOT NULL DEFAULT 0 COMMENT '发送状态 0 未发送 1 已发送',
	notify_time DATETIME NOT NULL COMMENT '通知时间,面试之后2小时',
	notify_end_time DATETIME NULL COMMENT '通知完成时间',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	type TINYINT(3) NOT NULL DEFAULT 0 COMMENT '通知对象 0 HR 1 面试官',
	staff_id INT(11) NOT NULL DEFAULT 0 COMMENT '通知对象ID,对应staff表',
	staff_email VARCHAR(50) NOT NULL COMMENT '通知对象的邮箱',
	staff_name VARCHAR(30) NOT NULL COMMENT '通知对象姓名',
	PRIMARY KEY (id),
	INDEX interview_id (interview_id)
)COMMENT '面试评估发送任务' COLLATE='utf8_general_ci' ENGINE=InnoDB;


/*面试评估发送历史表*/
CREATE TABLE feedback_history (
	id INT(11) NOT NULL AUTO_INCREMENT,
	interview_id INT(11) NOT NULL DEFAULT 0 COMMENT '对应的面试邀请ID',
	person_id INT(11) NOT NULL DEFAULT 0 COMMENT '对应的候选人ID',
	ms_type TINYINT(3) NOT NULL DEFAULT 0 COMMENT '0 初试 1复试',
	ms_time DATETIME NULL  COMMENT '面试时间',
	status TINYINT(3) NOT NULL DEFAULT 0 COMMENT '发送状态 0 未发送 1 已发送',
	notify_time DATETIME NOT NULL COMMENT '通知时间',
	notify_end_time DATETIME NOT NULL COMMENT '通知完成时间',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	type TINYINT(3) NOT NULL DEFAULT 0 COMMENT '通知对象 0 HR 1 面试官',
	staff_id INT(11) NOT NULL DEFAULT 0 COMMENT '通知对象ID,对应staff表',
	staff_email VARCHAR(50) NOT NULL COMMENT '通知对象的邮箱',
	staff_name VARCHAR(30) NOT NULL COMMENT '通知对象姓名',
	PRIMARY KEY (id),
	UNIQUE INDEX interview_id (interview_id)
)COMMENT '面试评估发送历史表' COLLATE='utf8_general_ci' ENGINE=InnoDB;

/*面试反馈内容*/
CREATE TABLE feedback (
	id INT(11) NOT NULL AUTO_INCREMENT,
	feedback_id INT(11) NOT NULL COMMENT '反馈通知ID',
	interview_id INT(11) NOT NULL COMMENT '面试邀请ID',
	person_id INT(11) NOT NULL COMMENT '候选人ID',
	person_name VARCHAR(30) NOT NULL COMMENT '候选人姓名',
	staff_id INT(11) NOT NULL COMMENT '反馈员工ID',
	staff_name VARCHAR(30) NOT NULL COMMENT '反馈员工姓名',
	ms_type TINYINT(3) NOT NULL DEFAULT 0 COMMENT '0 初试 1复试',
	type TINYINT(3) NOT NULL DEFAULT 0 COMMENT '类型 0 hr 1面试官的反馈',
	result TINYINT(3) NOT NULL DEFAULT 0 COMMENT '面试官反馈结果 0 无 1通过 2存档备选 3不通过',
	content VARCHAR(255) COMMENT '反馈内容',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	PRIMARY KEY (id)
)COMMENT '面试反馈内容表' COLLATE='utf8_general_ci' ENGINE=InnoDB;

create table interview_failure(
	id INT(11) NOT NULL AUTO_INCREMENT,
	interview_id INT(11) NOT NULL COMMENT '面试邀请ID',
	feedback_id INT(11) NOT NULL COMMENT '反馈通知ID',
	person_id INT(11) NOT NULL COMMENT '候选人ID',
	email VARCHAR(50) NULL DEFAULT '' COMMENT '候选人邮箱',
	name VARCHAR(30) NOT NULL COMMENT '姓名',
	post VARCHAR(30) NULL DEFAULT '' COMMENT '应聘岗位',
	staff_id INT(11) NOT NULL DEFAULT 0 COMMENT '淘汰你的面试官,对应staff表',
	notify_time DATETIME NOT NULL COMMENT '通知时间,面试开始时间后2个工作日',
	notify_end_time DATETIME NULL DEFAULT NULL COMMENT '通知完成时间',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	status TINYINT(3) NOT NULL DEFAULT 0 COMMENT '通知状态 0 未通知 1 已通知',
	PRIMARY KEY (id),
	INDEX interview_id (interview_id)
)COMMENT '面试淘汰记录' COLLATE='utf8_general_ci' ENGINE=InnoDB;

/*招聘岗位*/
CREATE TABLE post (
	id INT(11) NOT NULL AUTO_INCREMENT,
	post VARCHAR(30) NULL DEFAULT '' COMMENT '应聘岗位',
	post_link VARCHAR(100) NULL DEFAULT '' COMMENT '应聘岗位连接',
	create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
	modify_time DATETIME NOT NULL DEFAULT NOW() COMMENT '修改时间',
	status TINYINT(3) NOT NULL DEFAULT 1 COMMENT '1 在线，0下线',
	PRIMARY KEY (id)
)COMMENT '招聘岗位' COLLATE='utf8_general_ci' ENGINE=InnoDB;