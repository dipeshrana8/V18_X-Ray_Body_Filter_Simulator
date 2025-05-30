# Material Components (libs.material)
-keep class com.google.android.material.** { *; }
-dontwarn com.google.android.material.**

# AndroidX Core KTX (libs.core.ktx)
-dontwarn androidx.core.**

# ssp (scaled size pixels) and sdp (scaled density pixels) libraries
# These are just utility libs, usually no rules needed, but safe to keep their classes:
-keep class com.intuit.ssp.** { *; }
-keep class com.intuit.sdp.** { *; }

# Firebase Remote Config (libs.firebase.config)
-keep class com.google.firebase.remoteconfig.** { *; }
-dontwarn com.google.firebase.remoteconfig.**

# AndroidX Browser (libs.browser)
-keep class androidx.browser.** { *; }
-dontwarn androidx.browser.**

# Glide (libs.glide)
# Glide requires specific rules to work with ProGuard:
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** { *; }
-keep class com.bumptech.glide.** { *; }
-dontwarn com.bumptech.glide.**

-keep class com.google.gson.stream.** { *; }
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }
-dontwarn com.google.gson.**

-keep class com.onesignal.** { *; }
-dontwarn com.onesignal.**

-keep class androidx.appcompat.** { *; }
-dontwarn androidx.appcompat.**

-keep class androidx.activity.** { *; }
-dontwarn androidx.activity.**

-keep class androidx.constraintlayout.** { *; }
-dontwarn androidx.constraintlayout.**

-keep class com.airbnb.lottie.** { *; }
-dontwarn com.airbnb.lottie.**


-keep public class * extends android.app.Activity

-keep public class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}



-keep class com.xraysim.bodyfilter.fun.foundation.** { *; }
