# react-native-spinner-android
Android Spinner component for React Native

## Installation Android
* `npm install --save react-native-spinner-android`
* In `android/setting.gradle`

````java

include ':ReactNativeDropdownAndroid', ':app'
project(':ReactNativeDropdownAndroid').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-spinner-android/android')

````

* In `android/app/build.gradle`

````java

...
dependencies {
    ...
    compile project(':ReactNativeSpinnerAndroid')
}

````

* register module (in MainActivity.java)

````java

import com.webschik.reactnativedropdown.SpinnerPackage; // import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
  ......

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new SpinnerPackage())              // add here
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "ExampleRN", null);

    setContentView(mReactRootView);
  }
  ......
}

````

## Usage

````js

import Spinner from 'react-native-spinner-android';

...

  render() {
    return (
      <Spinner values={['--Choose--', '1', 2, 3.5]} 
               selected={1} 
               onChange={(data) => { console.log(data); }} />
    );
  }
  
````

### Props
#### onChange(data)
Callback with data in the form data = { selected: 1, value: '1' }