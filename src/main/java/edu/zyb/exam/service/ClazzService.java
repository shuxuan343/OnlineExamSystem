package edu.zyb.exam.service;

import java.util.List;

import edu.zyb.exam.beans.BJ;
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
public interface ClazzService {

	public boolean addCla(BJ bj);

	public Integer findAllCount();

	public List<BJ> getList(int i, int j);

	public boolean updateOneCla(BJ bj);

	public BJ findOneCla(Integer bjid);

	public boolean delCla(Integer sid);

	public List<BJ> findAllCla();

}
