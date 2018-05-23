# Junit5 Jupiter extension for RxJava2

Give a look at [RxExtension](RxExtension.kt) and [Example](example.kt).

```kotlin
@ExtendWith(value = [RxExtension::class])
class ExampleUnitTest() {

    /* ... */

}
```

```kotlin
class RxExtension : BeforeAllCallback, AfterAllCallback {

    override fun beforeAll(context: ExtensionContext) {
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    override fun afterAll(context: ExtensionContext) {
        RxJavaPlugins.reset()
        RxAndroidPlugins.reset()
    }

}
```