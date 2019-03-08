package groovy

import com.example.domain.InjectRandomLevelAnnotationBeanPostProcessor
import com.example.domain.Player

beans {
    importBeans "groovy/ctx-one.groovy"
    importBeans "groovy/database.groovy"

    xmlns([ctx:'http://www.springframework.org/schema/context'])
    ctx.'component-scan'('base-package': 'com.example.service')

    player(Player, "Player")

    injectRandomLevel(InjectRandomLevelAnnotationBeanPostProcessor)
}