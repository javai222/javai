# 📦 Java Calculator — Package & Project Structure

## 🗂️ Folder Tree

```
packages-and-organization-lab/
└── surname/                          ← your surname (e.g. delacruz)
    ├── build.gradle                  ← Gradle build file (or pom.xml for Maven)
    └── src/
        └── main/
            └── java/
                └── com/
                    └── calculator/
                        └── surname/  ← your surname (e.g. delacruz)
                            ├── model/       ⬛ OPTIONAL  — data classes
                            ├── service/     ✅ REQUIRED  — calculator logic
                            ├── exception/   ✅ REQUIRED  — custom exceptions
                            ├── util/        ⬛ OPTIONAL  — helper methods
                            └── main/        ✅ REQUIRED  — demo class
```

---

## 📋 Layer Responsibilities

| Package | Status | What goes here |
|---|---|---|
| `model` | Optional | Data holder classes (e.g. `CalculatorResult.java`) |
| `service` | **Required** | Calculator logic — add, subtract, divide, etc. |
| `exception` | **Required** | Custom exceptions (e.g. `DivisionByZeroException.java`) |
| `util` | Optional | Input validation, helper methods |
| `main` | **Required** | `CalculatorDemo_<Surname>.java` — entry point & demo |

---

## 📝 Package Declaration (per file)

Each `.java` file must declare its package at the top:

```java
// inside service/
package com.calculator.delacruz.service;

// inside exception/
package com.calculator.delacruz.exception;

// inside main/
package com.calculator.delacruz.main;
```

---

## ⚙️ Build Tool Setup

### Option A — Gradle (`build.gradle`)

```groovy
plugins {
    id 'java'
}

group = 'com.calculator'
version = '1.0'
```

Run:
```bash
gradle build
```

### Option B — Maven (`pom.xml`)

```xml
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.calculator</groupId>
  <artifactId>delacruz-calculator</artifactId>
  <version>1.0</version>
</project>
```

Run:
```bash
mvn clean install
```

---

## 🌿 Git Branch

```bash
git checkout -b packages-build-delacruz
```

---

## ✅ Checklist

- [ ] Created personal surname folder at the repo root
- [ ] `build.gradle` or `pom.xml` inside surname folder
- [ ] Correct folder path: `src/main/java/com/calculator/surname/`
- [ ] `package` declaration at the top of every `.java` file
- [ ] `service/` — calculator logic implemented
- [ ] `exception/` — at least one custom exception
- [ ] `main/` — `CalculatorDemo_<Surname>.java` created
- [ ] Demo triggers exceptions and shows output
- [ ] Project builds successfully
- [ ] Pushed to correct Git branch
