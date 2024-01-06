plugins {
    id("java")
}

group = "${project.property("group")}"
version = "${project.property("version")}"

repositories {
    mavenCentral()

    // Paper Repo
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    // Paper MC
    compileOnly("io.papermc.paper:paper-api:${project.property("minecraftVersion")}-R0.1-SNAPSHOT")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks {
    processResources {
       filesMatching("**/plugin.yml") {
           expand(project.properties)
       }
    }
}