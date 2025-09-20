import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

extra["signingInMemoryKey"] = System.getenv("GPG_SIGNING_KEY")
extra["signingInMemoryKeyId"] = System.getenv("GPG_SIGNING_KEY_ID")
extra["signingInMemoryKeyPassword"] = System.getenv("GPG_SIGNING_PASSWORD")

configure<MavenPublishBaseExtension> {
    signAllPublications()
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    coordinates(project.group.toString(), project.name, project.version.toString())
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaJavadoc"),
            sourcesJar = true,
        )
    )

    pom {
        name.set("Nuntly REST API")
        description.set("Nuntly REST API definition")
        url.set("http://developers.nuntly.com")

        licenses {
            license {
                name.set("Apache-2.0")
            }
        }

        developers {
            developer {
                name.set("Nuntly")
                email.set("developers@nuntly.com")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/nuntly/nuntly-sdk-java.git")
            developerConnection.set("scm:git:git://github.com/nuntly/nuntly-sdk-java.git")
            url.set("https://github.com/nuntly/nuntly-sdk-java")
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
