package groovy

import liquibase.integration.spring.SpringLiquibase
import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter

import javax.sql.DataSource

boolean enableAnnotationConfiguration = false

beans {

    if (enableAnnotationConfiguration) {
        xmlns([mybatis: 'http://mybatis.org/schema/mybatis-spring'])
        mybatis.scan('base-package': 'com.example.persistence')
    }

    xmlns([ctx: 'http://www.springframework.org/schema/context'])
    xmlns([tx: 'http://www.springframework.org/schema/tx'])
    xmlns([jpa: 'http://www.springframework.org/schema/data/jpa'])

    ctx.'property-placeholder'('location': 'classpath:database.properties')

    ctx.'component-scan'('base-package': 'com.example.persistence')
    jpa.'repositories'('base-package': 'com.example.persistence')

    tx.'annotation-driven'()

    dataSource(DriverManagerDataSource) {
        url = '${jdbc.url}'
        driverClassName = '${jdbc.driverClassName}'
        username = '${jdbc.username}'
        password = '${jdbc.password}'
    }

    entityManagerFactory(LocalContainerEntityManagerFactoryBean) {
        dataSource = dataSource
        packagesToScan = 'com.example.domain'
        jpaVendorAdapter = new HibernateJpaVendorAdapter()
        jpaProperties =
                [
                        'hibernate.dialect'                     : '${hibernate.dialect}',
                        'hibernate.show_sql'                    : '${hibernate.show_sql}',
                        'hibernate.hbm2ddl.auto'                : '${hibernate.hbm2ddl.auto}',
                        'hibernate.cache.use_second_level_cache': '${hibernate.cache.use_second_level_cache}',
                        'hibernate.cache.use_query_cache'       : '${hibernate.cache.use_query_cache}'
                ]
    }

    transactionManager(JpaTransactionManager) {
        entityManagerFactory = entityManagerFactory
    }

    liquibase(SpringLiquibase) {
        changeLog = "classpath:db/changelog/db_changelog_master.xml"
        dataSource = dataSource
    }

}