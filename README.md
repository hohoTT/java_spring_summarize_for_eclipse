# java_spring_summarize_for_eclipse

IDE在eclipse的环境下针对java中有关spring内容的总结

#一、AOP 简介:
	AOP(Aspect-Oriented Programming, 面向切面编程): 是一种新的方法论, 
	是对传统 OOP(Object-Oriented Programming, 面向对象编程) 的补充.
	
	AOP 的主要编程对象是切面(aspect), 而切面模块化横切关注点.
	
	在应用 AOP 编程时, 仍然需要定义公共功能, 但可以明确的定义这个功能在哪里, 以什么
	方式应用, 并且不必修改受影响的类. 这样一来横切关注点就被模块化到特殊的对象(切面)里.
	
	AOP 的好处:
		每个事物逻辑位于一个位置, 代码不分散, 便于维护和升级
		业务模块更简洁, 只包含核心业务代码.
		
#二、AOP 术语:
	切面(Aspect):  横切关注点(跨越应用程序多个模块的功能)被模块化的特殊对象
	通知(Advice):  切面必须要完成的工作
	目标(Target): 被通知的对象
	代理(Proxy): 向目标对象应用通知之后创建的对象
	连接点(Joinpoint): 程序执行的某个特定位置：如类某个方法调用前、调用后、方法抛出异常后等。
		连接点由两个信息确定：方法表示的程序执行点；相对点表示的方位。
		例如 ArithmethicCalculator#add() 方法执行前的连接点，
		执行点为 ArithmethicCalculator#add()； 方位为该方法执行前的位置
	切点(pointcut): 每个类都拥有多个连接点：例如 ArithmethicCalculator 的所有方法
		实际上都是连接点，即连接点是程序类中客观存在的事务。AOP 通过切点定位到特定的连接点。
		类比：连接点相当于数据库中的记录，切点相当于查询条件。切点和连接点不是一对一的关系，
		一个切点匹配多个连接点，切点通过 org.springframework.aop.Pointcut 接口进行描述，
		它使用类和方法作为连接点的查询条件。
		
#三、 Spring  AOP:

	AspectJ：Java 社区里最完整最流行的 AOP 框架.

	1. 加入 jar 包
	com.springsource.net.sf.cglib-2.2.0.jar
	com.springsource.org.aopalliance-1.0.0.jar
	com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
  	spring-aspects-4.0.0.RELEASE.jar
	  
  	2. 在 Spring 的配置文件中加入 aop 的命名空间。 
	  
	3. 基于注解的方式来使用 AOP
	  3.1 在配置文件中配置自动扫描的包: <context:component-scan base-package="com.wt.aop.impl"></context:component-scan>
	  3.2 加入使 AspjectJ 注解起作用的配置: <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
	  为匹配的类自动生成动态代理对象. 
	  
	4. 编写切面类: 
	  4.1 一个一般的 Java 类
	  4.2 在其中添加要额外实现的功能. 
	 
	5. 配置切面
	  		需要把该类放入到 IOC 容器中，之后声明一个切面
	  5.1 切面必须是 IOC 中的 bean: 实际添加了 @Component 注解
	  5.2 声明是一个切面: 添加 @Aspect
	  5.3 声明通知: 即额外加入功能对应的方法. 
	  5.3.1 前置通知: @Before("execution(public int com.wt.aop.impl.ArithmetiCalculator.*(int, int))")
	  @Before 表示在目标方法执行之前执行 @Before 标记的方法的方法体. 
	  @Before 里面的是切入点表达式: 
	  
	6. 在通知中访问连接细节: 可以在通知方法中添加 JoinPoint 类型的参数, 从中可以访问到方法的签名和方法的参数. 
	  
	7. @After 表示后置通知: 在方法执行之后执行的代码. 
