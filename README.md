DbusJavaOverNetworkExample
==========================

[![Build Status](https://travis-ci.org/rynkowsg/DbusJavaOverNetworkExample.svg?branch=master)](https://travis-ci.org/rynkowsg/DbusJavaOverNetworkExample)

This project shows how to use `dbus-java` library over network.

Before you build and run the example, you need to:

 * configure your system to publish session bus over network,
 * change hardcoded session bus' address and port to your own.



dbus-java
-----------------

A library that enables using D-Bus in Java applications and provides some tools to use D-Bus from command line.
You can find more information in [documentation](http://dbus.freedesktop.org/doc/dbus-java/) of dbus-java.

The library is avaliable on
[freedesktop page about DBusBindings](http://www.freedesktop.org/wiki/Software/DBusBindings/#java).

I used that library in Android application and it needed some modifications.
I published them in [this repository](https://github.com/rynkowsg/dbus-java).



Local Development
-----------------
Here are some Gradle commands for executing this example:

 * `./gradlew clean build` - Build the entire example.
 * `./gradlew run` - Execute the example.



License
-------

    Copyright (C) 2015 Grzegorz Rynkowski

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
