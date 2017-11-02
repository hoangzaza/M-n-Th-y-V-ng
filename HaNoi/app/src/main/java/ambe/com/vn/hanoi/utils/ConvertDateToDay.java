package ambe.com.vn.hanoi.utils;

import ambe.com.vn.hanoi.R;

/**
 * Created by AMBE on 17/10/2017.
 */

public class ConvertDateToDay {

    public ConvertDateToDay() {
    }

    public String convert(int ngay, int thang, int nam) {
        String day = "";

        if (thang < 3) {
            thang = thang + 12;
            nam = nam - 1;
        }
        int thu = (Math.abs(ngay + 2 * thang + 3 * (thang + 1) / 5 + nam + nam / 4) % 7);
        switch (thu) {
            case 1:
                day += "Thứ Hai";
                break;
            case 2:
                day += "Thứ Ba";
                break;
            case 3:
                day += "Thứ Tư";
                break;
            case 4:
                day += "Thứ Năm";
                break;
            case 5:
                day += "Thứ Sáu";
                break;
            case 6:
                day += "Thứ Bảy";
                break;
            case 0:
                day += "Chủ Nhật";
                break;
        }
        return day;
    }

}
