
buildscript {
  extra.apply {
    set("nav_version", "2.5.3")
    set("room_version", "2.5.2")
  }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  //  alias(libs.plugins.android.application) apply false
  //  alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.android.application") version "8.1.1" apply false
    id("com.android.library") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

