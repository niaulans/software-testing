### Run emulator

```bash
# Check available emulators
emulator -list-avds

# Start an emulator
emulator -avd <emulator_name>

# Example: Start an emulator named "Pixel_3a_API_30"
emulator -avd Pixel_3a_API_30

# Install an APK on the emulator
adb install -r path/to/your/app.apk
```

### Check desired capabilities real devices

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

### Know the active app

```bash
# Check the current focused app
adb shell "dumpsys window | grep -E 'mCurrentFocus|mFocusedApp'"
```

### Activate appium with gestures plugin

```bash
appium --use-plugins=gestures
```

### Unlock android device

```bash
adb shell input keyevent [PIN_CODE]
```

### Toggle status bar

```bash
# Pull status bar down
adb shell service call statusbar 1

# Pull status bar up
adb shell service call statusbar 2
```

### Open and close app

```bash
# Open an app
adb shell am start -n com.example.myapp/.MainActivity

# Close an app
adb shell am force-stop com.example.myapp
```

### Tap in app

```bash
adb shell input tap <x> <y>

# Dump the current screen ui
adb shell uiautomator dump

# Copy the xml file to computer
adb pull sdcard/window_dump.xml ~/Desktop/

# Or use the following command to pull the file directly
adb pull $(adb shell uiautomator dump | grep -oP '[^ ]+.xml') /sdcard/window_dump.xml
```

### Install and uninstall app

```bash
# Install an APK
adb install -r path/to/your/app.apk

# Uninstall an app
adb uninstall com.example.myapp

# Define device name
adb -s <device_name> install -r path/to/your/app.apk
```
