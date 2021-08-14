package com.example.tinswaterreminderapp.util.alarm

import android.app.*
import android.app.AlarmManager.ELAPSED_REALTIME
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.os.SystemClock
import androidx.core.app.NotificationCompat
import com.example.tinswaterreminderapp.R
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class AlarmReceiver @Inject constructor() : BroadcastReceiver() {

    private var alarmManager: AlarmManager? = null
    private var pendingIntent: PendingIntent? = null

    override fun onReceive(context: Context, intent: Intent) {
        val receiveId = intent.getStringExtra(EXTRA_REMINDER_ID)?.toInt()
        Timber.v("Notification Received with id $receiveId")

        val notificationBuilder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Minum Air")
            .setContentText("Jangan Lupa Minum Air")
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setVibrate(longArrayOf(1000))
            .setDefaults(Notification.DEFAULT_ALL)

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "waterReminder"
            val channel = NotificationChannel(
                channelId, "Minum Air", NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Jangan Lupa Minum Air"
            }
            notificationManager.createNotificationChannel(channel)
            notificationBuilder.setChannelId(channelId)
        }

        receiveId?.let {
            notificationManager.notify(it, notificationBuilder.build())
        }
    }

    fun setAlarm(context: Context, calendar: Calendar, id: Int) {
        alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(context, AlarmReceiver::class.java).also {
            it.putExtra(EXTRA_REMINDER_ID, id.toString())
        }
        pendingIntent = PendingIntent.getBroadcast(context, id, intent, PendingIntent.FLAG_CANCEL_CURRENT)

        val current = Calendar.getInstance()
        val currentTime = current.timeInMillis
        val diffTime = calendar.timeInMillis - currentTime

        alarmManager?.set(ELAPSED_REALTIME, SystemClock.elapsedRealtime() + diffTime, pendingIntent)
    }

    fun setRepeatAlarm(context: Context, calendar: Calendar, id: Int, repeatTime: Long) {
        alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java).also {
            it.putExtra(EXTRA_REMINDER_ID, id.toString())
        }
        pendingIntent = PendingIntent.getBroadcast(context, id, intent, PendingIntent.FLAG_CANCEL_CURRENT)

        val current = Calendar.getInstance()
        val currentTime = current.timeInMillis
        val diffTime = calendar.timeInMillis - currentTime

        alarmManager?.setRepeating(ELAPSED_REALTIME, SystemClock.elapsedRealtime() + diffTime, repeatTime, pendingIntent)
    }

    companion object {
        private const val EXTRA_REMINDER_ID = "EXTRA_REMINDER_ID"
        private const val NOTIFICATION_CHANNEL_ID = "NOTIFICATION_CHANNEL_ID"
    }
}
