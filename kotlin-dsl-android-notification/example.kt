class RemiderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        /* ... */
    }

    private fun displayNotification(context: Context, hoursRequiredPerDay: Int, totalHoursForToday: Int) {
        notification(context) {
            channel(CHANNEL_ID) {
                group(GROUP_ID, context.getString(R.string.notification_channel_group))

                name = context.getString(R.string.notification_channel_title)
                description = context.getString(R.string.notification_channel_description)
                lockscreenVisibility = NotificationCompat.VISIBILITY_PUBLIC
                importance = NotificationManager.IMPORTANCE_LOW
                lights = false
                vibration = false
                bypassDnd = false
            }

            intent(context, MainActivity::class.java, Const.REQUEST_CODE_REMINDER_NOTIFICATION, PendingIntent.FLAG_UPDATE_CURRENT)

            id = today().time.toInt()
            smallIcon = R.drawable.ic_notif_reminder
            autoCancel = true
            priority = NotificationCompat.PRIORITY_DEFAULT

            if (totalHoursForToday > 0) {
                title = context.getString(R.string.reminder_complete_your_logged_time)
                text = context.resources.getQuantityString(R.plurals.reminder_x_hours_on_x_required, totalHoursForToday, totalHoursForToday, hoursRequiredPerDay)
            } else {
                title = context.getString(R.string.reminder_you_have_logged_anything)
            }
        }
    }

    companion object {
        const val GROUP_ID = "REMINDERS"
        const val CHANNEL_ID = "DAILY_REMINDER"
    }

}