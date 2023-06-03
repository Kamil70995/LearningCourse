package com.learningcourse

import org.springframework.boot.Banner
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class Application /*: AbstractJavaFxApplicationSupport*/ {
  /*  override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(Application::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }*/
}

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
     SpringApplicationBuilder(Application::class.java)
       // .web(WebApplicationType.NONE)
        .bannerMode(Banner.Mode.OFF)
        .run(*args)

}