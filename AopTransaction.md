`root-context.xml`
```
	<!-- the transactional advice (what 'happens'; see the <aop:advisor/> bean below) -->
	<tx:advice id="txAdvice" transaction-manager="txManager">
		<tx:attributes>
			<!-- all methods starting with 'find' are read-only -->
			<tx:method name="find*" read-only="true"/>
			<!-- other methods use the default transaction settings (see below) -->
			<tx:method name="*" />
		</tx:attributes>
	</tx:advice>

	<!-- ensure that the above transactional advice runs for any execution of 
		an operation defined by the UserService class -->
	<aop:config proxy-target-class="true">
		<aop:pointcut id="userServicePointCut"
			expression="execution(* *..*.service.UserService.*(..))" />
		<aop:advisor advice-ref="txAdvice" pointcut-ref="userServicePointCut" />
	</aop:config>

	<bean id="txManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
	</bean>
```