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

### Activate Appium with Gestures Plugin

```bash
appium --use-plugins=gestures
```
