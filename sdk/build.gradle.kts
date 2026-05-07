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
version = "1.0.0-alpha.2"

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()
    coordinates("com.nuntly", "nuntly-java", version.toString())

    pom {
        name.set("Nuntly Java SDK")
        description.set("Official Java 21 SDK for Nuntly, the developer-first email platform.")
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

dependencies {
    api(project(":core"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.12.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs(
        "--add-opens", "java.base/java.lang=ALL-UNNAMED",
        "--add-opens", "java.base/java.util=ALL-UNNAMED",
    )
}
