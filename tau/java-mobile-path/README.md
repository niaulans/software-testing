# Java Mobile Path

## Setting a Foundation for Successful Test Automation

### What is your goal for test automation?

- Reduce the time it takes to execute regression tests
- Reduce technical debt by closing sprints with test automation in place for the new features
- Enable continuous testing as part of build process

### Who is participating in the test automation effort?

- Developers
- Testers
- Business Analysts

### Which tests are you automating?

- Regression tests
- Smoke tests
- Sanity tests
- New feature tests
- Performance tests
- Security tests

### Test Automation Strategy

- Test Automation Pyramid: UI, Service, Unit
  - Unit: Close to the production code, quick to write and execute, low maintenance
  - Service: Middle layer, tests the business logic, faster than UI tests, less flaky
  - UI: Top layer, tests the user interface, slower to write and execute, more flaky

## Mobile Testing with Appium and Java

### Native vs. Cross-Platform Apps Mobile Testing Tools

- **Cross-platform** -> support all mobile platforms, including iOS, Android, and Windows such as Appium
- **Native** -> developed, released, and support one single mobile platform such as Espresso for Android and XCUITest for iOS. You can only use Java or Kotlin for Espresso and Swift or Objective-C for XCUITest.

### Virtual vs. Real Devices

- **Emulators**
  - Are usually virtualized mobile devices
  - A good emulator runs exactly the same OS as the physical device that it is emulating, and is therefore a really good option for mobile device testing.
  - The disadvantage to using an emulator is that emulators have limitations include hardware component such as bluetooth receivers, GPS receivers, and cameras.
- **Physical devices**
  - Testing on physical devices is a good idea when yu need test results to be as accurate as possible
  - Testing on physical devices gives you the most accurate test results because, simply put, you are testing on the actual device on which your software will run.

### What is Appium?

- **Appium** is an **open-source** tool for automating native, mobile web, and hybrid applications on iOS, mobile, Android, and Windows desktop platforms.
- **Appium** is **cross-platform** -> it allows you to write tests againts multiple platforms such as (iOS, Android, Windows) using the same API.
- You can write **Appium** tests with different programming languages such as Java, Python, Ruby, C#, JavaScript, and PHP.

#### Appium Philosophy

1. Rule 1:

- You should not have to recompile your app or modify it in any way in order to automate it.

2. Rule 2:

- You shouldn't be locked into a specific language or framework to write and run your tests

3. Rule 3:
   - A mobile automation framework shouldn't reinvent the wheel when it comes to automation APIs.
4. Rule 4:
   - A mobile automation framework should be open source, in spirit and practice as as in name.

#### Appium Concepts

- **Client/Server Architecture**: Contains a client library and a server component.
- **Session**: A session is a connection between the Appium server and the client.
- **Desired Capabilities**: A set of key-value pairs that are sent to the Appium server to configure the session.
- **Driver**: A driver is a client-side component that communicates with the Appium server to execute commands on the mobile device.
- Appium client (script, using protocol webdriver (HTTP)) -> Appium server (Node.js) -> Appium driver (UiAutomator2, XCUITest, etc.) -> Mobile device (Android, iOS)/ Emulator/Simulator

<br>

#### **Desired Capabilities**

- Keys and values encoded in a JSON object (map or hash), sent by Appium clients to the server when a new automation session is started.
- Tell the Appium drivers all kinds of important things about how you want your test to work
- Each Appium client buildscapabilities in a way specific to the client's languages
- Desired capabilities can be scripted in the webdriver test or set within the Appium Server GUI

```python
desired_caps = {
  "platformName": "Android",
  "deviceName": "emulator-5554",
  "app": "D:\Pemrograman\software-testing\tau\java-mobile-path\appium-demo\apps\ApiDemos.apk",
  "automationName": "UiAutomator2",
  "appPackage": "com.example.myapp",
  "appActivity": ".MainActivity"
}
```

#### Check desired capabilities real devices

```bash
# Check active devices
adb devices

# Check desired capabilities of a real device
adb shell getprop ro.build.version.release
adb shell getprop ro.product.model
adb shell getprop ro.product.brand

# Check installed packages and activities
adb shell pm list packages
adb shell dumpsys package com.example.myapp | grep -i activity
```

#### Need to run Appium

1. Java Development Kit (JDK)
2. Android Software Development Kit (SDK)
3. Node.js
4. Appium Server
5. Appium Doctor (optional but recommended)
6. Appium Inspector (optional but recommended)
7. Android Emulator or Physical Device
8. Integrated Development Environment (IDE) (e.g., IntelliJ IDEA, Eclipse)
9. Build Tool (e.g., Maven, Gradle)
10. Test Framework (e.g., JUnit, TestNG)
11. WebDriver Manager (optional but recommended)

### Android App Key Concepts

- Apk file -> A file with the extension .apk is an Android Package file, which is the package file format used by the Android operating system for the distribution and installation of mobile apps.
- AppActivityName -> Different functions of the app are defined in the app's activity. The activity is a single, focused thing that the user can do. It is like a screen in an app. Example `.MainActivity`.
- AppPackage -> The package name of the app, which is a unique identifier for the app. Example `com.example.android.youtube`.

### iOS App Key Concepts

- IPA file -> A file with the extension .ipa is an iOS App Store Package file, which is the package file format used by the iOS operating system for the distribution and installation of mobile apps.
- AppBundleId -> The bundle identifier of the app, which is a unique identifier for the app. Example `com.example.myapp`.
- AppName -> The name of the app, which is used to identify the app in the App Store. Example `MyApp`.

### Run emulator

```bash
# Check available emulators
emulator -list-avds

# Start an emulator
emulator -avd <emulator_name>

# Example: Start an emulator named "Pixel_3a_API_30"
adb devices
emulator -avd Pixel_3a_API_30

# Install an APK on the emulator
adb install -r path/to/your/app.apk
```

### Android and iOS Locator Strategies

- **Accessibility ID** -> A unique identifier for an element that is used by assistive technologies such as screen readers.
- **ClassName** -> The class name of the element, which is used to identify the element in the DOM.
- **ID** -> A unique identifier for an element that is used in the HTML DOM.
- **XPath** -> A query language for selecting nodes from an XML document, which can be used to locate elements in the DOM.
- **UIAutomator** -> A UI testing framework for Android that allows you to interact with the UI of an app.
- **iOS Predicate** -> A query language for selecting nodes from an XML document, which can be used to locate elements in the DOM on iOS.

### Mobile Gestures

- Mobile gestures are the movements made by a user to activate a specific control within a mobile interface
- The majority of gestures are performed by the user's fingers (tap, swipe, drag, slide, pinch, zoom, long press, double tap, etc.) but can also involve hand movements (shaking, tilting, moving, and rotating the device).

#### Touch Actions for Mobile Gestures

- Appium implements a new TouchAction /MultiAction API
- Tehre APis allow you to build up arbitrary gestures with multiple actuators.
- In all the Appium client libraries, touch objects are created and are given a chain of events.
- The available events from the spec are:
  - press
  - release
  - moveTo
  - tap
  - longPress
  - perform
