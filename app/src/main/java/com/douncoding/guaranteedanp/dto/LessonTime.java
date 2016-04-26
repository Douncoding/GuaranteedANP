package com.douncoding.guaranteedanp.dto;

/**
 * 강의시간 또는 수업일자 DTO (예. 2016-4-30 20:00 ~ 12:00)
 */
public class LessonTime implements Model{

    //int refLessonId;
    Day day;
    String start;   // 시작시간 (Date Format)
    String end;     // 종료시간 (Date Format)

    public LessonTime(int day, String start, String end) {
        setDay(day);
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    enum Day {
        Monday("월"), Tuesday("화"), Wednesday("수"), Thursday("목"),
        Friday("금"), Saturday("토"), Sunday("일");

        String ko;
        Day(String day) {
            ko = day;
        }

        public String getKo() {
            return ko;
        }
    }

    public String getDay() {
        return day.getKo();
    }

    /**
     * 자연수 값을 Day 로 변환하여 사용하기 위함.
     * @param dayOfWeek 월=0; 화=1 .... 일=6
     */
    public void setDay(int dayOfWeek) {
        Day[] week = Day.values();
        this.day = week[dayOfWeek];
    }

    @Override
    public void serialization() {

    }

    @Override
    public void deserialization() {

    }
}
