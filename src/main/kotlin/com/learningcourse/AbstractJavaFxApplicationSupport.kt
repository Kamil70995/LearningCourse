/*
package com.larningcourse.learningcourse

import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext

abstract class AbstractJavaFxApplicationSupport {

    private var savedArgs: Array<String>? = null

    protected var context: ConfigurableApplicationContext? = null

    @Throws(Exception::class)
    open fun init() {
        context = SpringApplication.run(javaClass, *AbstractJavaFxApplicationSupport.savedArgs)
        context.getAutowireCapableBeanFactory().autowireBean(this)
    }

    @Throws(Exception::class)
    open fun stop() {
        super.stop()
        context!!.close()
    }
    protected open fun launchApp(appClass: Class<out AbstractJavaFxApplicationSupport?>?, args: Array<String?>) {
        AbstractJavaFxApplicationSupport.savedArgs = args
        Application.launch(appClass, args)
    }
}*/
