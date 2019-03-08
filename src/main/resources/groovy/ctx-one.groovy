package groovy

import com.example.domain.PlayerFactory

beans {
    factoryPlayer(PlayerFactory) { bean ->
        bean.factoryMethod = "createPlayer"
    }
}