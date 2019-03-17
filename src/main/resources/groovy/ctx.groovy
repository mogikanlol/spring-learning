package groovy

import com.example.domain.InjectRandomLevelAnnotationBeanPostProcessor
import com.example.domain.Player
import com.example.service.PlayerServiceImpl

boolean enableAnnotationConfiguration = false
def databaseConfiguration = DatabaseConfiguration.JPA

beans {
    xmlns([ctx: 'http://www.springframework.org/schema/context'])

    if (enableAnnotationConfiguration) {
        ctx.'component-scan'('base-package': 'com.example.service')
    }

    importBeans "groovy/ctx-one.groovy"

    switch (databaseConfiguration) {
        case DatabaseConfiguration.MYBATIS:
            importBeans "groovy/database-mybatis.groovy"

            playerService(PlayerServiceImpl, playerRepositoryMyBatis)
            println("MyBatis configuration enabled")
            break
        case DatabaseConfiguration.JPA:
            importBeans "groovy/database-hibernate.groovy"

            playerService(PlayerServiceImpl, playerRepositoryJpa)
            println("Jpa configuration enabled")
            break
        default:
            importBeans "groovy/database-hibernate.groovy"
    }

    player(Player, "Player")

    injectRandomLevel(InjectRandomLevelAnnotationBeanPostProcessor)

}

enum DatabaseConfiguration {
    JPA,
    MYBATIS
}