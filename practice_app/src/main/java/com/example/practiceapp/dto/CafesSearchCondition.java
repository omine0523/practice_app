package com.example.practiceapp.dto;

import lombok.Data;

/**
 * カフェリスト検索条件DTO
 */
@Data
public class CafesSearchCondition {
    
    /** エリアコード（未選択時は null or 空） */
    private int areaCode;

    /** ジャンルコード（未選択時は null or 空） */
    private int genreCode;
}
