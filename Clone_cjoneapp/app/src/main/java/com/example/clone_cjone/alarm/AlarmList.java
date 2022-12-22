package com.example.clone_cjone.alarm;

import java.util.ArrayList;

public class AlarmList {

    public ArrayList<AlarmDTO> alarm(){

        ArrayList<AlarmDTO> list_a = new ArrayList<>();
        list_a.add(new AlarmDTO("매일 룰렛돌리고 포인트 받고", "(광고)룰렛 포인트에 추가 8000포인트까지!",
                "놓치지 마세요.", "9시간 전"));

        list_a.add(new AlarmDTO("골드바와 23만 P의 조합", "(광고)100% 담청 이벤트에 참여하고 대박 포인트",
                "받아가세요.", "2일 전"));

        list_a.add(new AlarmDTO("뱃지 ONE정대 마감임박", "(광고)포인트가 곧 사라진다구요!",
                "추가로 발금된 티겟 있는지 확인하러 GO", "2일 전"));

        list_a.add(new AlarmDTO("오늘 마지막", "(광고)빈센트 발 전시가 0원?",
                "동반 1인까지 무료로 감상 할 수 있는 찬스 놓치지 마세요.", "4일 전"));

        list_a.add(new AlarmDTO("크리스마스 미션 스타트", "(광고)CJ ONE오락실에서 게임하고 최대 1만P",
                "받아가세요.", "4일 전"));

        list_a.add(new AlarmDTO("무료 영화 예매권 100매 도착", "(광고)오리지널 뮤지컬 영화 영웅! CJ ONE이 쏜다",
                "퀴즈 풀고 무료 예매권 응모", "5일 전"));

        list_a.add(new AlarmDTO("만료 예정 쿠폰 안내", "유효기간 만료가 7일 이하로 남은 미사용 쿠폰이 ",
                "존재합니다.", "7일 전"));

        list_a.add(new AlarmDTO("골드바 포인트 100% 당첨", "CJ고객님께 드리는 행복한 연말 선물",
                "", "10일 전"));

        list_a.add(new AlarmDTO("11P 적립 완료 + 포인트선물 도착", "지금 클릭하고 추가 포인트 받기! ",
                "", "11일 전"));

        list_a.add(new AlarmDTO("뱃지 모를수록 포인트가 와르르", "뱃지 다 모으면 최대 10만P 증정! ",
                "뱃지를 모를 수록 늘어나는 뽑기 기회", "11일 전"));


        return list_a;
    }
}
