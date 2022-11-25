package com.imcd.evaluation.dto;

import com.imcd.evaluation.entity.Score;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ScoreDto {

    private Long scoreNo;
    private TargetDto target;
    private int passionScore;
    private int faithScore;
    private int responsibilityScore;
    private int harmonyScore;
    private int processingScore;
    private int customerScore;
    private int leadershipScore;
    private int expertScore;

    private String opinion;

    public static Score toEntity(ScoreDto scoreDto) {
        return Score.builder()
                .passionScore(scoreDto.getPassionScore())
                .faithScore(scoreDto.getFaithScore())
                .responsibilityScore(scoreDto.getResponsibilityScore())
                .harmonyScore(scoreDto.getHarmonyScore())
                .processingScore(scoreDto.getProcessingScore())
                .customerScore(scoreDto.getCustomerScore())
                .leadershipScore(scoreDto.getLeadershipScore())
                .expertScore(scoreDto.getExpertScore())
                .opinion(scoreDto.getOpinion())
                .build();
    }

    public static ScoreDto fromEntity(Score score) {
        return ScoreDto.builder()
//                .target(TargetDto.fromEntity(score.getTarget()))
                .passionScore(score.getPassionScore())
                .faithScore(score.getFaithScore())
                .responsibilityScore(score.getResponsibilityScore())
                .harmonyScore(score.getHarmonyScore())
                .processingScore(score.getProcessingScore())
                .customerScore(score.getCustomerScore())
                .leadershipScore(score.getLeadershipScore())
                .expertScore(score.getExpertScore())
                .opinion(score.getOpinion())
                .build();
    }
}
