plugins {
    id("java")
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "com.vediastudios"
version = "${project.property("version")}"
var javaVersion = 21

repositories {
    mavenCentral()

    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:${project.property("mcVersion")}-R0.1-SNAPSHOT")
}

tasks {
    runServer {
        minecraftVersion("${project.property("mcVersion")}")
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(javaVersion))
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(javaVersion)

    }

    processResources {
        filesMatching("**/**plugin.yml") {
            expand(project.properties)
        }
    }

    compileJava.get().dependsOn(clean)
    // build.get().dependsOn(shadowJar)
}
