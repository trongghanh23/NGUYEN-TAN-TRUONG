package com.code.song.common;

import com.code.song.dto.SongDto;
import org.springframework.validation.Errors;

public class Validate {
    public static void checkNameSong(SongDto songDto, Errors errors) {
        if (!songDto.getName().matches("^[\\w\\s]+$")) {
            errors.rejectValue("name",
                    "not create.name",
                    "Tên không chứa kí tự đặc biệt");
        }


    }

    public static void checkNameArtist(SongDto songDto, Errors errors) {
        if (!songDto.getArtist().matches("^[\\w\\s]+$")) {
            errors.rejectValue("artist",
                    "not create.artist",
                    "Tên không chưa kí tự đặc biệt");
        }

    }

    public static void checkNameType(SongDto songDto, Errors errors) {
        if (!songDto.getType().matches("^[\\w\\s,]*$")) {
            errors.rejectValue("type",
                    "not create.type",
                    "Ngoại trừ dấu phẩy “,”,không được chưa kí tự đặc biệt");
        }

    }

}
