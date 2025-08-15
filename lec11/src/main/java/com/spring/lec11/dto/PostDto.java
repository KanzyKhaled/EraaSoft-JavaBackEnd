package com.spring.lec11.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

        @NotNull
        @Size(min = 20)
        private String text;

        private String imagePath;
}


