package developer.essiorh.exchangerates.domain.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

class DateHelper {
    private static final int ONE_DAY_TIME = 24 * 60 * 60 * 1000;
    private static final int DAY_COUNT = 7;

    static List<String> getListOfLatestDates() {
        Calendar calendar = Calendar.getInstance();
        List<String> dateList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        for (int i = 0; i < DAY_COUNT; i++) {
            calendar.setTimeInMillis(calendar.getTimeInMillis() - ONE_DAY_TIME);
            String date = format.format(calendar.getTime());
            dateList.add(date);
        }
        return dateList;
    }
}
