# Kotlin DSL for Android notification creation.

You just have to describe the notification instead of creating it.

Give a look at [DSL](notification.dsl.kt) and [Example](example.kt).  

```kotlin
        notification(context) {
            channel(CHANNEL_ID) {
                group(GROUP_ID, "Group name")

                name = "Channel name"
                description = "Channel description"
                lockscreenVisibility = NotificationCompat.VISIBILITY_PUBLIC
                importance = NotificationManager.IMPORTANCE_LOW
                lights = false
                vibration = false
                bypassDnd = false
            }

            intent(context, MyActivity::class.java, /* requestCode */ 0, PendingIntent.FLAG_UPDATE_CURRENT)

            id = /* Id of the notification */ 0
            smallIcon = R.drawable.ic_notif
            autoCancel = true
            priority = NotificationCompat.PRIORITY_DEFAULT
            title = "Notification title"
            text = "Notification text"
        }
```
