# Architecture
The main philosphy behind the architecture of our app has been to follow the guidelines and best practices as presented by Google themselves. Android has in recent years introduces many new frameworks that try to unite the many ways of doing commons app tasks such as navigation between different parts of the app, persisting data to a database and updating views with the latest data. These parts are now all a part of the Android Architecture Components, also called JetPack. This [document](https://developer.android.com/jetpack/guide) has been used as a startingpoint. 

Perhaps most central to Android app architecture is the design pattern Model-View-ViewModel (MVVM).
## Directory Structure

```bash
.
└── changeit
    ├── db
    │   └── dao
    ├── model
    ├── ui
    │   ├── ad
    │   ├── contactinfo
    │   ├── favorites
    │   ├── home
    │   └── profile
    └── util
```
```bash
.
├── app
│   └── src
│       ├── androidTest 
│       │   └── java
│       ├── main
│       │   ├── java
│       │   └── res
│       └── test
│           └── java
└── gradle
    └── wrapper
```

