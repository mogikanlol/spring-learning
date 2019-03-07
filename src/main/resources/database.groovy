import liquibase.integration.spring.SpringLiquibase
import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.jdbc.datasource.DriverManagerDataSource

import javax.sql.DataSource

beans {
    xmlns([mybatis:'http://mybatis.org/schema/mybatis-spring'])
    mybatis.scan('base-package': 'com.example.persistence')

    dataSource(DriverManagerDataSource) {
        url = "jdbc:h2:mem:db;DB_CLOSE_DELAY=-1"
        driverClassName = "org.h2.Driver"
        username = "sa"
        password = ""
    }

    sqlSessionFactory(SqlSessionFactoryBean) {
        dataSource = dataSource
    }

    liquibase(SpringLiquibase) {
        changeLog = "classpath:db/changelog/db_changelog_master.xml"
        dataSource = dataSource
    }



}