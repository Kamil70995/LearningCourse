plugins {
    id 'java'
    id 'application'
    id 'org.jetbrains.kotlin.jvm' version '1.6.20'
    id 'org.openjfx.javafxplugin' version '0.0.13'
    id 'org.beryx.jlink' version '2.25.0'
}

group 'com.larningcourse'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

ext {
    junitVersion = '5.8.2'
}

sourceCompatibility = '11'
targetCompatibility = '11'

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}

application {
    mainModule = 'com.larningcourse.learningcourse'
    mainClass = 'com.larningcourse.learningcourse.HelloApplication'
}

[compileKotlin, compileTestKotlin].forEach {
    it.kotlinOptions {
        jvmTarget = '11'
    }
}

javafx {
    version = '17.0.2'
    modules = ['javafx.controls', 'javafx.fxml', 'javafx.web', 'javafx.media']
}

dependencies {
    implementation('org.controlsfx:controlsfx:11.1.1')
    implementation('com.dlsc.formsfx:formsfx-core:11.5.0') {
        exclude(group: 'org.openjfx')
    }
    implementation('net.synedra:validatorfx:0.3.1') {
        exclude(group: 'org.openjfx')
    }
    implementation('org.kordamp.ikonli:ikonli-javafx:12.3.1')
    implementation('org.kordamp.bootstrapfx:bootstrapfx-core:0.4.0')
    implementation('eu.hansolo:tilesfx:17.1.9') {
        exclude(group: 'org.openjfx')
    }
    implementation('com.github.almasb:fxgl:11.17') {
        exclude(group: 'org.openjfx')
    }

    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

test {
    useJUnitPlatform()
}

jlink {
    imageZip = project.file("${buildDir}/distributions/app-${javafx.platform.classifier}.zip")
    options = ['--strip-debug', '--compress', '2', '--no-header-files', '--no-man-pages']
    launcher {
        name = 'app'
    }
}

jlinkZip {
    group = 'distribution'
}