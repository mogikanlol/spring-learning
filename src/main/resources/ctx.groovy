import com.example.domain.InjectRandomLevelAnnotationBeanPostProcessor
import com.example.domain.Player

beans {
    importBeans("ctx-one.groovy")

    player(Player, "Player")

    injectRandomLevel(InjectRandomLevelAnnotationBeanPostProcessor)
}