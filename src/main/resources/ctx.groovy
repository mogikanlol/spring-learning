import com.example.domain.InjectRandomLevelAnnotationBeanPostProcessor
import com.example.domain.Player

beans {
    importBeans("ctx-one.groovy")
    importBeans("database.groovy")

    xmlns([ctx:'http://www.springframework.org/schema/context'])
    ctx.'component-scan'('base-package': 'com.example.service')

    player(Player, "Player")

    injectRandomLevel(InjectRandomLevelAnnotationBeanPostProcessor)
}