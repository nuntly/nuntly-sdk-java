import com.vanniktech.maven.publish.SonatypeHost

plugins {
    `java-library`
    id("com.diffplug.spotless") version "6.25.0"
    id("com.vanniktech.maven.publish") version "0.30.0"
}

spotless {
    java {
        target("src/**/*.java")
        googleJavaFormat("1.27.0").reflowLongStrings()
        removeUnusedImports()
        trimTrailingWhitespace()
        endWithNewline()
    }
}

group = "com.nuntly"
version = "1.0.0-alpha.20"

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()
    coordinates("com.nuntly", "nuntly-java-spring", version.toString())

    pom {
        name.set("Nuntly Java SDK Spring Boot Starter")
        description.set("Spring Boot auto-configuration for the Nuntly Java SDK.")
        url.set("https://nuntly.com")
        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }
        developers {
            developer {
                id.set("nuntly")
                name.set("Nuntly")
                email.set("support@nuntly.com")
            }
        }
        scm {
            url.set("https://github.com/nuntly/nuntly-sdk-java")
            connection.set("scm:git:git://github.com/nuntly/nuntly-sdk-java.git")
            developerConnection.set("scm:git:ssh://github.com:nuntly/nuntly-sdk-java.git")
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

val springBootVersion = "3.4.0"

dependencies {
    api(project(":sdk"))
    implementation("org.springframework.boot:spring-boot-autoconfigure:$springBootVersion")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$springBootVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
    testImplementation("org.springframework.boot:spring-boot-test-autoconfigure:$springBootVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
