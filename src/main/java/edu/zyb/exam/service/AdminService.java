package edu.zyb.exam.service;

import edu.zyb.exam.beans.AdminUser;
/**
 * 切面事物管理,方法名称前缀必须符合一下写法，否则会出现当前线程出错问题
 * <!-- 通知 -->
	<tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<!-- 保存方法的前缀 -->
			<tx:method name="save*" propagation="REQUIRED" rollback-for="SQLException,Exception,RuntimeException"/>
			<!-- 保存方法的前缀 -->
			<tx:method name="add*" propagation="REQUIRED" rollback-for="SQLException,Exception,RuntimeException"/>
			<!-- 更新方法的前缀 -->
			<tx:method name="update*" propagation="REQUIRED" rollback-for="SQLException,Exception,RuntimeException"/>
			<!-- 删除方法的前缀 -->
			<tx:method name="del*" propagation="REQUIRED" rollback-for="SQLException,Exception,RuntimeException"/>
			<!-- 查询方法的前缀 -->
			<tx:method name="find*"   propagation="SUPPORTS" rollback-for="SQLException,Exception,RuntimeException"/>
			<tx:method name="query*"   propagation="SUPPORTS" rollback-for="SQLException,Exception,RuntimeException"/>
			<!-- 校验方法的前缀 -->
			<tx:method name="check*"   propagation="SUPPORTS" rollback-for="SQLException,Exception,RuntimeException"/>
			<tx:method name="get*"   propagation="SUPPORTS" rollback-for="SQLException,Exception,RuntimeException"/>
			<tx:method name="login*"   propagation="SUPPORTS" rollback-for="SQLException,Exception,RuntimeException"/>
		</tx:attributes>
	</tx:advice>
	<aop:config>
		<aop:pointcut expression="execution(* edu.zyb.exam.service.*.*(..))" id="servicePointcut"/>
		<aop:advisor advice-ref="txAdvice" pointcut-ref="servicePointcut"/>
	</aop:config>
 * @author Administrator
 *
 */
public interface AdminService {

	public AdminUser login(String username, String password);

}
