plugins {
    id("nuntly.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":nuntly-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :nuntly-java-example:run` to run `Main`
    // Use `./gradlew :nuntly-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.nuntly.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
