package groovy

import com.example.domain.PlayerFactory

beans {
    playerFactory(PlayerFactory) { bean ->
        bean.factoryMethod = "createPlayer"
    }
}