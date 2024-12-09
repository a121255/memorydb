package com.example.memorydb.user.model;

import com.example.memorydb.entity.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)    // 이건 뭐지
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends Entity {
    private String name;
    private int score;
}
