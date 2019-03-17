package groovy

import com.example.persistence.PlayerRepositoryMyBatisGroovy
import liquibase.integration.spring.SpringLiquibase
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.mapper.MapperFactoryBean
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.DriverManagerDataSource

boolean enableAnnotationConfiguration = false

beans {
    //  Enable annotation configuration
    if (enableAnnotationConfiguration) {
        xmlns([mybatis: 'http://mybatis.org/schema/mybatis-spring'])
        mybatis.scan('base-package': 'com.example.persistence')
    }

    xmlns([ctx: 'http://www.springframework.org/schema/context'])
    xmlns([tx: 'http://www.springframework.org/schema/tx'])

    ctx.'property-placeholder'('location': 'classpath:database.properties')
    tx.'annotation-driven'()

    dataSource(DriverManagerDataSource) {
        url = '${jdbc.url}'
        driverClassName = '${jdbc.driverClassName}'
        username = '${jdbc.username}'
        password = '${jdbc.password}'
    }

    sqlSessionFactory(SqlSessionFactoryBean) {
        dataSource = dataSource
    }

    liquibase(SpringLiquibase) {
        changeLog = "classpath:db/changelog/db_changelog_master.xml"
        dataSource = dataSource
    }

    playerRepositoryMyBatis(MapperFactoryBean) {
        sqlSessionFactory = sqlSessionFactory
        mapperInterface = PlayerRepositoryMyBatisGroovy
    }

    transactionManager(DataSourceTransactionManager) {
        dataSource = dataSource
    }

}