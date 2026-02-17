Here is a complete, production-ready `README.md` for your project. It includes the architecture note you liked, a detailed tech stack, and a clear explanation of how the project is built.

---

# 📦 Behdaung - Product Showcase App

Behdaung is a modern Android application built using **Clean Architecture** and the latest Android development tools. It fetches product data from the DummyJSON API and displays it using a reactive, state-driven UI.

## 🚀 Tech Stack

* **UI**: [Jetpack Compose]() (100% Declarative UI)
* **Architecture**: MVVM (Model-View-ViewModel) + Clean Architecture
* **Dependency Injection**: [Hilt]() (Dagger)
* **Networking**: [Retrofit]() + OKHttp
* **JSON Parsing**: Gson
* **Async Programming**: Kotlin Coroutines & Flow
* **Build System**: Gradle Kotlin DSL (`.kts`) with Version Catalog (`libs.versions.toml`)

---

## 🏗️ Project Structure

The project is organized into layers to separate concerns and make the code testable and scalable:

```text
dev.raksmey.behdaung/
├── core/
│   ├── util/
│   │   └── Resource.kt          <-- (Loading, Success, Error state wrapper)
│   └── common/
│       └── Constants.kt         <-- (Base URL and global constants)
│
├── di/
│   ├── NetworkModule.kt         <-- (Hilt: Provides Retrofit & API instances)
│   ├── RepositoryModule.kt      <-- (Hilt: Binds Interfaces to Implementations)
│   └── AppModule.kt             <-- (Hilt: General app dependencies)
│
├── data/
│   ├── remote/
│   │   ├── ProductApi.kt        <-- (Retrofit endpoint definitions)
│   │   └── dto/
│   │       ├── ProductDto.kt    <-- (Data Transfer Objects / API Models)
│   │       └── ProductResponse.kt
│   ├── repository/
│   │   └── ProductRepositoryImpl.kt <-- (Logic to fetch and handle data)
│   └── mapper/
│       └── ProductMapper.kt     <-- (Converts DTOs to Clean Domain Models)
│
├── domain/
│   ├── model/
│   │   └── Product.kt           <-- (Pure Kotlin UI Models)
│   └── repository/
│       └── ProductRepository.kt <-- (Interface/Contract for the Data layer)
│
├── ui/
│   ├── products/                <-- (Product Feature Folder)
│   │   ├── ProductViewModel.kt  <-- (Logic and State management)
│   │   ├── ProductUiState.kt    <-- (Immutable UI State representation)
│   │   └── ProductScreen.kt     <-- (Compose UI Layout)
│   ├── theme/                   <-- (Material3 Design System setup)
│   └── MainActivity.kt          <-- (Entry point with @AndroidEntryPoint)
│
└── BehdaungApp.kt               <-- (Main Application class for Hilt)

```

---

## 🔄 Data Flow

The application follows a unidirectional data flow (UDF):

1. **UI** triggers an action in the **ViewModel**.
2. **ViewModel** calls the **Repository** (Domain layer).
3. **Repository** fetches data from the **API** (Data layer).
4. Data is mapped from **DTOs** to **Domain Models**.
5. **Repository** returns a `Flow<Resource<T>>` back to the **ViewModel**.
6. **ViewModel** updates the `UiState`, which the **UI** observes and displays.

---

## 🛠️ Installation & Setup

1. **Clone the repository**:
```bash
git clone https://github.com/your-username/behdaung.git

```


2. **Open in Android Studio**:
   Use **Android Studio Ladybug (2024.2.1)** or newer.
3. **Sync Gradle**:
   The project uses **SDK 36**. Ensure you have the Android 15 (VanillaIceCream) SDK installed in your SDK Manager.
4. **Run**:
   Press `Shift + F10` to run on an emulator or physical device.

---

## 📝 Configuration Note

This project uses **Kotlin 2.0.21** and the new **Compose Compiler Gradle Plugin**. Note that the `kotlin.android` plugin is omitted in the app module to avoid extension name conflicts with the `kotlin.compose` plugin.

---

**Would you like me to add a "Features" section or "API Endpoints" section to this README?**