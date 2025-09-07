This is a beginner level Android project- A calculator. I made this to get a basic understanding of MVVM architecture and Jetpack Compose.
 
# Features-

* Clean UI built with Jetpack Compose
* Implemented arithmetic operations:

  * Addition (`+`)
  * Subtraction (`–`)
  * Multiplication (`×`)
  * Division (`÷`)
  * Modulo (`%`)
    
* MVVM architecture for separation of concerns:

  * ViewModels handle logic and state
  * UI stays stateless and reactive
* Built entirely in Kotlin


# Project Structure

```
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/            // Kotlin source code with MVVM ViewModel
│   │   │   └── res/             // UI resources (if any)
│   └── build.gradle.kts         // Project-level Gradle config
├── README.md                    // Project overview
└── settings.gradle.kts          // Gradle settings
```

---

# Architecture Overview (MVVM)

* UI Layer: Built using Compose — observes ViewModel and renders UI based on state.
* ViewModel: Manages user inputs, performs calculations, maintains current result.
* Model: (Optional for this small project) Could include business logic for arithmetic in more complex apps.



# How It Works

1. User clicks buttons for numbers or operations.
2. Events are passed to the *ViewModel*, updating the state.
3. ViewModel processes logic (e.g., performing calculation on “=”) and updates the UI state.
4. Compose observes this state and re-renders the display accordingly.

Thank you for going through this project. :)
