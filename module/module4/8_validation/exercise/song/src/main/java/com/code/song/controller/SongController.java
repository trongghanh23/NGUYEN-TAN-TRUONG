package com.code.song.controller;

import com.code.song.dto.SongDto;
import com.code.song.model.Song;
import com.code.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;
    @GetMapping("/")
    public String SongList(Model model){
        model.addAttribute("songList",this.iSongService.songList());
        return "/list";
    }
    @GetMapping("/song/showCreate")
    public String showSong(Model model){
        model.addAttribute("songDto",new SongDto());
        return "/create";
    }

    @PostMapping ("/create/save")
    public String ShowSong(@ModelAttribute("songDto") @Valid SongDto songDto,BindingResult bindingResult,
    RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "/create";
        }else {
            Song song=new Song();
            BeanUtils.copyProperties(songDto,song);
            this.iSongService.save(song);
            redirectAttributes.addFlashAttribute("message","successfully!");
            return "redirect:/";

        }

    }

    @GetMapping("/song/showEdit")
    public String showFormUpdate(@RequestParam Integer id, Model model) {
        model.addAttribute("songDto", iSongService.getId(id));
        return "edit";
    }

    @PostMapping("/update/save")
    public String updateSong(@ModelAttribute @Valid SongDto songDto,
                             BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("message","successfully!");

        return "redirect:/";
    }

}
