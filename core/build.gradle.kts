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
version = "1.0.0-alpha.16"

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()
    coordinates("com.nuntly", "nuntly-java-core", version.toString())

    pom {
        name.set("Nuntly Java SDK Core")
        description.set("HTTP client and shared infrastructure for the Nuntly Java SDK.")
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
    api("com.google.code.gson:gson:2.13.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.12.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

// Generate Version.java with the SDK_VERSION constant pulled from this module's
// `version` field. The fanout-release.ts postSync rewrites this value at
// release time so the wire User-Agent always matches the published artifact.
val generateVersion by tasks.registering {
    val outputDir = layout.buildDirectory.dir("generated/sources/version/java/main")
    outputs.dir(outputDir)
    val ver = project.version.toString()
    doLast {
        val file = outputDir.get().file("com/nuntly/sdk/Version.java").asFile
        file.parentFile.mkdirs()
        file.writeText(
            """
            package com.nuntly.sdk;

            // Auto-generated. Do not edit manually.
            // Source of truth: build.gradle.kts (version field).
            public final class Version {
              public static final String SDK_VERSION = "$ver";

              private Version() {}
            }
            """.trimIndent() + "\n"
        )
    }
}

sourceSets.main.get().java.srcDir(generateVersion)
tasks.named("compileJava") { dependsOn(generateVersion) }
tasks.named("spotlessJava") { dependsOn(generateVersion) }
spotless {
    java {
        targetExclude("build/generated/**")
    }
}
