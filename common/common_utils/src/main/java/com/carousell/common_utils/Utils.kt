package com.carousell.common_utils

object Utils {
    fun getTimeAgo(epoch: Long): String {
        val currentTimeStamp = System.currentTimeMillis()
        val elapsedTimeSeconds = (currentTimeStamp - epoch).floorDiv(10000)
        val elapsedTimeMinutes = elapsedTimeSeconds.floorDiv(60)
        val elapsedTimeHours = elapsedTimeMinutes.floorDiv(60)
        val elapsedTimeDays = elapsedTimeHours.floorDiv(24)
        val elapsedTimeWeeks = elapsedTimeDays.floorDiv(7)
        val elapsedTimeMonths = elapsedTimeDays / 30
        val elapsedTimeYear = elapsedTimeDays / 365

        if (elapsedTimeYear > 0) {
            return if (elapsedTimeYear > 1) "$elapsedTimeYear years ago"
            else "1 year ago"
        }
        if (elapsedTimeMonths > 0) {
            return if (elapsedTimeMonths > 1) "$elapsedTimeMonths months ago"
            else "1 month ago"
        }
        if (elapsedTimeWeeks > 0) {
            return if (elapsedTimeWeeks > 1) "$elapsedTimeWeeks weeks ago"
            else "1 week ago"
        }
        if (elapsedTimeDays > 0) {
            return if (elapsedTimeDays > 1) "$elapsedTimeDays days ago"
            else "1 day ago"
        }
        if (elapsedTimeHours > 0) {
            return if (elapsedTimeHours > 1) "$elapsedTimeHours hours ago"
            else "1 hour ago"
        }
        if (elapsedTimeMinutes > 0) {
            return if (elapsedTimeMinutes > 1) "$elapsedTimeMinutes minutes ago"
            else "1 minute ago"
        }
        return if (elapsedTimeSeconds > 0) {
            if (elapsedTimeSeconds > 1) "$elapsedTimeSeconds seconds ago"
            else "1 second ago"
        } else "just now"

    }
}