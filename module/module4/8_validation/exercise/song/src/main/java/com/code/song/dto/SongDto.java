package com.code.song.dto;

import com.code.song.common.Validate;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SongDto implements Validator {

    private Integer id;

    @NotBlank(message = "please input!")
    @Size(max = 800, message = "name <= 800 character")
    private String name;

    @NotBlank(message = "please input!")
    @Size(max = 300, message = "name <= 300 character")
    private String artist;

    @NotBlank(message = "please input!")
    @Size(max = 1000, message = "name <= 1000 character")
    private String type;

    public SongDto() {
    }

    public SongDto(Integer id, String name, String artist, String type) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;

        Validate.checkNameSong(songDto, errors);
        Validate.checkNameArtist(songDto, errors);
        Validate.checkNameType(songDto, errors);


    }


}
