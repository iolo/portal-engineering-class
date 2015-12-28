`UserService.java`
```
	@Autowired
	private DataSourceTransactionManager txManager;

	...

	public void deleteAndAddUser(String deleteUserId, User user, boolean throwException) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = txManager.getTransaction(def);
		try {
			
			userMapper.deleteUser(deleteUserId);
			if (throwException) {
				throw new RuntimeException("Unknown error.");
			}
			userMapper.addUser(user);

		}
		catch (RuntimeException ex) {
		  txManager.rollback(status);
		  throw ex;
		}
		txManager.commit(status);
	}
```

`root-context.xml`
```
        <bean id="txManager"
                class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                <property name="dataSource" ref="dataSource" />
        </bean>
```