package com.youtubeDownloader;

import java.io.File;
import java.net.URL;

import com.github.axet.vget.VGet;
import org.springframework.stereotype.Service;

@Service
public class YTD
{
    public void downloadVideo(String link)
    {
        try
        {
            //String url = "https://www.youtube.com/watch?v=s10ARdfQUOY";
            String path = "D:\\test.mp4";
//            File file = new File("");
            VGet v = new VGet(new URL(link), new File(path));
            v.download();

        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}