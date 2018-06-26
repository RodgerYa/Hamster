#记账本功能性需求

标签（空格分隔）： prd

---

## 用户

用户服务为【用户、角色、权限】三模块组成，角色拥有权限，用户拥有角色，通过角色的赋予动作赋予权限。

 1. 用户 `User`   用户属性：`id, name, password, phone, created, email`
 2. 权限 `Permission`   属性：`id, name`
  - 用户注册
  用户通过邮箱/手机号注册（可绑定微信/QQ/手机/邮箱），服务端端生成 `hamsterId` 唯一标识。
	输入：`userName, password，【phone， email选填】`
	输出：空，注册后直接为用户登陆，进入 Hamster 主页面
  - 用户登陆
  已经注册过的用户，通过userName/password （或者第三方账号进行登陆，暂时先不做第三方）登陆，进入主页面。
	输入：userName, password 【后续新增第三方】
	输出：验证成功，进入主页面，验证失败，输入框下方提示错误，重新登陆
  - 用户组创建
  预留功能，新增实体 `userGroup: groupId,groupName`

## 账户

#### 1. 账户 `Account`: 
`accountId`, `accountName`, `isProperty`(资产/负债 Boolean), `balance`，`created`, `creator`, `modifier`, `modified`, `statementDate`, `RepaymentDate`

  - 添加账户
  用户添加账户，一个用户可新增多个账户，家庭组内共享账户，新增账户后，同步更新用户/用户组资产
	输入：`accountName, isProperty, balance, created(服务器时间），created(当前登陆用户），modifier（当前操作用户），modified（服务器时间）`
	输出：Account
  - 修改账户
  用户修改，可修改余额，修改后同步更新用户/用户组资产，记录新余额、修改人、修改时间
  - 删除账户
  用户删除账户，保留记录一个月/直接删除账户，只保存删除记录

2.记账款项 `billItem`: `id, userid, created, accountId, costType, amount`
  用户通过【记账】动作添加【款项】，款项拥有【用户、创建时间、支付账户、支出类型、消费金额（分）】，后续根据款项的【创建时间】统计为【日账单、月账单、年账单】，根据【支出类型】统计为【消费占比】，【支付账户】统计为【支付习惯】。
帐期账单: `id, expenditure, income, List<BillItem>`


3.资产(统计值）`property`
账户余额累计为用户/用户组资产。账户修改/记账动作发生，同步更新用户/用户组资产

4.负债（统计值）`debt`
  借贷金额累计为用户/用户组负债

5.还款动作
负债账户还款日前需进行还款，根据`balance`是否为负判断是否已经还款，进行还款动作后，根据还款金额，累加至balance。
【问题：类似与花呗这种，每月还款金额与使用金额可以不等，如果延伸，则负债账户单独作为一个实体与资产账户分开】

6.出账日/还款日提醒
负债账户到出账日/还款日后推送消息提醒。
