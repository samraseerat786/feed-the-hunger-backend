package com.youtubeDownloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/youtube")
public class YTDController
{
    @Autowired
    YTD ytd;

    @PostMapping("/download")
    public void downloadVideo(@RequestParam("link") String link)
    {
        ytd.downloadVideo(link);
    }
}
