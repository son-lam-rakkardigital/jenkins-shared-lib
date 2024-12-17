# jenkins-shared-lib
## Q: **[POC - Jenkins - SharedLib] How to setup shared lib library with unitest for testing locally?**
* Using `gradle init` and choosing structure for library
* Refactor structures

```js
.
├── README.md
├── gradle
│  ├── libs.versions.toml
│  └── wrapper
│      ├── gradle-wrapper.jar
│      └── gradle-wrapper.properties
├── gradle.properties
├── gradlew
├── gradlew.bat
├── lib
│  ├── build.gradle
│  ├── src
│  │  └── org
│  │      └── example
│  │          ├── Library.groovy
│  │          └── MySharedLib.groovy
│  ├── test
│  │  └── org
│  │      └── example
│  │          ├── LibraryTest.groovy
│  │          └── MySharedLibTest.groovy
│  └── vars
│      └── mySharedLib.groovy
└── settings.gradle

```
* Update build.gradle for using custom configuration


```yaml
sourceSets {
    main {
        groovy {
            srcDirs = ['src'] // Custom location for Groovy files
        }

    }
    test {
        groovy {
            srcDirs = ['test'] // Custom location for test Groovy files
        }

    }
}
```

* How to test

```
gradle test
gradle build
```

* How to use it with Jenkins Pipeleine

```js
@Library('my-shared-lib') _

pipeline {
    agent any
    stages {
        stage('Example') {
            steps {
                script {
                    mySharedLib.greet('Jenkins')
                }
            }
        }
    }
}
```
