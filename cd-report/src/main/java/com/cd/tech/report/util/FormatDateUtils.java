package com.cd.tech.report.util;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 类描述
 *
 * @version 1.0.0
 */
public final class FormatDateUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormatDateUtils.class);

    private static final int INSTANCE_COUNT = 20;

    public static final SimpleDateFormat[] formatYYYYMMDD = createDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat[] formatLong = createDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat[] insureFormat = createDateFormat("yyyy-MM-dd|HH:mm:ss");
    private static final SimpleDateFormat[] formatShort = createDateFormat("yyyyMMdd");
    private static final SimpleDateFormat[] formatTime = createDateFormat("HH:mm:ss");
    private static final SimpleDateFormat[] formatYYYYMMDDSSS = createDateFormat("yyMMddHHmmssSSS");
    private static final SimpleDateFormat[] formatYYYYMMDDHHMMSS = createDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat[] formatYYYYMMDDHHMMSSS = createDateFormat("yyyyMMddHHmmsss");
    private static final SimpleDateFormat[] formatMMDD = createDateFormat("MMdd");
    private static final SimpleDateFormat[] formatYYYYMMDDHHMM = createDateFormat("yyyy-MM-dd HH:mm");

    private static int currentIndex = 0; // 不需要考虑多线程问题，节省性能开销。


    private FormatDateUtils() {
    }


    private static SimpleDateFormat[] createDateFormat(String fmt) {
        SimpleDateFormat[] ret = new SimpleDateFormat[INSTANCE_COUNT];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = new SimpleDateFormat(fmt);
            ret[i].setLenient(false);
        }
        return ret;
    }


    private static int getIndex() {
        int n = currentIndex++;
        if (n < 0) { // 处理溢出
            currentIndex = 0;
            n = 0;
        }
        return n % INSTANCE_COUNT;
    }

    public synchronized static String formatYYYYMMDDHHMM() {
        SimpleDateFormat fmt = formatYYYYMMDDHHMM[getIndex()];
        synchronized (fmt) {
            return fmt.format(new Date());
        }
    }

    public synchronized static Date paseYYYYMMDDHHMM(String strDate) {
        if (strDate == null || strDate.indexOf("null") >= 0)
            return null;

        Date date = null;
        try {
            SimpleDateFormat fmt = formatYYYYMMDDHHMM[getIndex()];
            synchronized (fmt) {
                date = fmt.parse(strDate);
            }
        } catch (Exception e) {
            LOGGER.error("formatYYYYMMDDHHMM error: date=" + strDate, e);
            return null;
        }

        return date;
    }

    public synchronized static String formatMMDD() {
        SimpleDateFormat fmt = formatMMDD[getIndex()];
        synchronized (fmt) {
            return fmt.format(new Date());
        }
    }

    public synchronized static String formatCurTime() {
        SimpleDateFormat fmt = formatYYYYMMDDSSS[getIndex()];
        synchronized (fmt) {
            return fmt.format(new Date());
        }
    }

    public synchronized static String formatCurTimeLong() {
        SimpleDateFormat fmt = formatYYYYMMDDHHMMSS[getIndex()];
        synchronized (fmt) {
            return fmt.format(new Date());
        }
    }

    public synchronized static String formatYYYYMMDDHHMMSS(Date date) {
        SimpleDateFormat fmt = formatYYYYMMDDHHMMSS[getIndex()];
        synchronized (fmt) {
            return fmt.format(date);
        }
    }

    public synchronized static String formatYYYYMMDDHHMMSSS(Date date) {
        SimpleDateFormat fmt = formatYYYYMMDDHHMMSSS[getIndex()];
        synchronized (fmt) {
            return fmt.format(date);
        }
    }

    public synchronized static Date convertYYYYMMDDHHMMSS(String strDate) {
        if (strDate == null || strDate.indexOf("null") >= 0)
            return null;

        Date date = null;
        try {
            SimpleDateFormat fmt = formatYYYYMMDDHHMMSS[getIndex()];
            synchronized (fmt) {
                date = fmt.parse(strDate);
            }
        } catch (Exception e) {
            LOGGER.error("convertYYYYMMDDHHMMSS error: date=" + strDate, e);
            return null;
        }

        return date;
    }

    public synchronized static Date convertYYYYMMDD(String strDate) {
        if (strDate == null || strDate.indexOf("null") >= 0)
            return null;

        Date date = null;
        try {
            SimpleDateFormat fmt = formatYYYYMMDD[getIndex()];
            synchronized (fmt) {
                date = fmt.parse(strDate);
            }
        } catch (Exception e) {
            LOGGER.error("convertYYYYMMDD error: date=" + strDate, e);
            return null;
        }

        return date;
    }

    public synchronized static Date convertShort(String strDate) {
        if (strDate == null || strDate.indexOf("null") >= 0)
            return null;

        Date date = null;
        try {
            SimpleDateFormat fmt = formatShort[getIndex()];
            synchronized (fmt) {
                date = fmt.parse(strDate);
            }
        } catch (Exception e) {
            LOGGER.error("convertShort error: date=" + strDate, e);
            return null;
        }

        return date;
    }

    public synchronized static Date convertLong(String strDate) {
        if (strDate == null || strDate.indexOf("null") >= 0)
            return null;

        Date date = null;
        try {
            SimpleDateFormat fmt = formatLong[getIndex()];
            synchronized (fmt) {
                date = fmt.parse(strDate);
            }
        } catch (Exception e) {
            LOGGER.error("convertLong error: date=" + strDate, e);
            return null;
        }

        return date;
    }

    public synchronized static String formatYYYYMMDD(Date date) {
        SimpleDateFormat fmt = formatYYYYMMDD[getIndex()];
        synchronized (fmt) {
            return fmt.format(date);
        }
    }

    public synchronized static String insureFormat(Date date) {
        SimpleDateFormat fmt = insureFormat[getIndex()];
        synchronized (fmt) {
            return fmt.format(date).replaceAll("\\|", "T");
        }
    }


    public synchronized static String formatTime(Date date) {
        SimpleDateFormat fmt = formatTime[getIndex()];
        synchronized (fmt) {
            return fmt.format(date);
        }
    }


    public synchronized static String formatShort(Date date) {
        SimpleDateFormat fmt = formatShort[getIndex()];
        synchronized (fmt) {
            return fmt.format(date);
        }
    }

    public synchronized static String formatLong(Date date) {
        SimpleDateFormat fmt = formatLong[getIndex()];
        synchronized (fmt) {
            return fmt.format(date);
        }
    }

    public synchronized static String formatDDMMMYY(Date date) {
        return String.format(Locale.US, "%1$td%1$tb%1$ty", date);
    }

    public synchronized static String convertYYYYMMDDToDDMMMYY(String date) {
        Date d = convertYYYYMMDD(date);
        return null == d ? "" : formatDDMMMYY(d);
    }

    public synchronized static String formatTodyDate(String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date());
    }

    public synchronized static String formatDate(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public synchronized static Date parse(String date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            LOGGER.error("pase error: date=" + date + ", pattern=" + pattern, e);
            return null;
        }
    }

    /**
     * 取得两个日期的时间间隔,相差的天数
     *
     * @param d1
     * @param d2
     * @return
     */
    public synchronized static int getDayBetween(Date d1, Date d2) {
        Calendar before = Calendar.getInstance();
        Calendar after = Calendar.getInstance();
        if (d1.before(d2)) {
            before.setTime(d1);
            after.setTime(d2);
        } else {
            before.setTime(d2);
            after.setTime(d1);
        }
        int days = 0;

        int startDay = before.get(Calendar.DAY_OF_YEAR);
        int endDay = after.get(Calendar.DAY_OF_YEAR);

        int startYear = before.get(Calendar.YEAR);
        int endYear = after.get(Calendar.YEAR);
        before.clear();
        before.set(startYear, 0, 1);

        while (startYear != endYear) {
            before.set(startYear++, Calendar.DECEMBER, 31);
            days += before.get(Calendar.DAY_OF_YEAR);
        }
        return days + endDay - startDay;
    }

    /**
     * 取得两个日期的时间间隔,相差的天数,后面减前面，可能为负
     *
     * @param d1
     * @param d2
     * @return
     */
    public synchronized static int getDayBetweenD(Date d1, Date d2) {
        if (d1.before(d2)) {
            return getDayBetween(d1, d2);
        } else {
            return -getDayBetween(d1, d2);
        }
    }

    /**
     * 取得时间间隔,相差的时间，XX小时XX分钟
     *
     * @param time1
     * @param time2
     * @return 不会超过24小时
     */
    public synchronized static String getTimeBetween(String time1, String time2) {
        String[] t1 = time1.split(":");
        String[] t2 = time2.split(":");

        int minute = Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]);
        int hour = Integer.parseInt(t2[0]) - Integer.parseInt(t1[0]);

        if (minute < 0) {
            minute += 60;
            hour -= 1;
        }
        if (hour < 0) {
            hour += 24;
        }

        if (hour == 0) {
            return minute + "分钟";
        }
        if (minute == 0) {
            return hour + "小时";
        }
        return hour + "小时" + minute + "分钟";
    }

    /**
     * 取得时间间隔,和当前时间相差的时间，XX小时
     *
     * @param time1
     * @return 不会超过24小时
     */
    public synchronized static long getTimeBetween(Date time1) {
        Date currentTime = new Date();
        long interval = (currentTime.getTime() - time1.getTime()) / 1000;//秒
        long hour = interval % (24 * 3600) / 3600;//小时
        return hour;
    }

    /**
     * 取得时间间隔,和当前时间相差的时间，XX小时
     *
     * @param time1
     * @return 可以超过24小时
     */
    public synchronized static long getTimeBetweenOverDay(Date time1) {
        Date currentTime = new Date();
        long interval = (currentTime.getTime() - time1.getTime()) / 1000;//秒
        long hour = interval / 60 / 60;//秒/60/60
        return hour;
    }

    public synchronized static Date addDay(Date myDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.DAY_OF_MONTH, amount);
        return cal.getTime();
    }

    public synchronized static Date addMinute(Date myDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.MINUTE, amount);
        return cal.getTime();
    }

    public synchronized static Date addYear(Date myDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.YEAR, amount);
        return cal.getTime();
    }

    public synchronized static Date addMonth(Date myDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.MONTH, amount);
        return cal.getTime();
    }

    public synchronized static String dateFormatStr(String dateByyyyyMMddStr) {
        if (dateByyyyyMMddStr != null && dateByyyyyMMddStr.length() == 8) {
            String year = dateByyyyyMMddStr.substring(0, 4);
            String month = dateByyyyyMMddStr.substring(4, 6);
            String day = dateByyyyyMMddStr.substring(6, 8);
            return year + "-" + month + "-" + day;
        } else {
            return "";
        }
    }

    public synchronized static String long2DateStr(long msec, String pattern) {
        Date date = new Date();
        date.setTime(msec);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    public synchronized static Date getBeforeNowDays(int days) {
        return DateUtils.add(new Date(), Calendar.DAY_OF_YEAR, days);
    }
}
